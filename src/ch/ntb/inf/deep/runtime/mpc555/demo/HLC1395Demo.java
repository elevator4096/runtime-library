/*
 * Copyright 2011 - 2013 NTB University of Applied Sciences in Technology
 * Buchs, Switzerland, http://www.ntb.ch/inf
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package ch.ntb.inf.deep.runtime.mpc555.demo;

import java.io.PrintStream;

import ch.ntb.inf.deep.runtime.mpc555.Task;
import ch.ntb.inf.deep.runtime.mpc555.driver.HLC1395Pulsed;
import ch.ntb.inf.deep.runtime.mpc555.driver.SCI1;

/* CHANGES:
 * 22.02.2011	NTB/Zueger	OutT replaced by System.out
 * 09.02.2011	NTB/Zueger	creation
 */

/**
 * Demo application for the HLC1395Plused driver.
 * The application reads periodically the values of four sensors
 * and print them every second to the SCI1.
 * Connecting diagram:
 * <pre> Address Pin A  -- MPIOB6
 * Address Pin B  -- MPIOB7
 * Trigger Pin    -- MPIOB5
 * Sensor out pin -- AN59</pre>
 */
public class HLC1395Demo extends Task {
	
	/* (non-Javadoc)
	 * @see ch.ntb.inf.deep.runtime.mpc555.Task#action()
	 */
	public void action() {
		for(int i = 0; i < 4; i++) {
			System.out.print(HLC1395Pulsed.read(i));
			System.out.print('\t');
		}
		System.out.println();
	}
	
	static {
		// Initialize HLC1395Pulsed driver for 4 sensors and start reading values
		HLC1395Pulsed.init(4, 0x50076, 59); // initialize 4 sensors (addrPin0 = MPIOB6, addrPin1 = MPIOB7, trgPin = MPIOB5, analogInPin = AN59)
		HLC1395Pulsed.start();
		
		// Initialize SCI1 and set stdout to SCI1
		SCI1.start(9600, SCI1.NO_PARITY, (short)8);
		System.out = new PrintStream(SCI1.out);
		
		System.out.println("HLC1295-Demo");
		
		// Create and install demo task
		Task demoTask = new HLC1395Demo();
		demoTask.period = 1000;
		Task.install(demoTask);
	}
}
