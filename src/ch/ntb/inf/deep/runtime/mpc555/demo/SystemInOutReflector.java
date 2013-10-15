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

import ch.ntb.inf.deep.runtime.mpc555.Task;
import ch.ntb.inf.deep.runtime.mpc555.driver.SCI1;


/**
 * Demo for System.out and System.in using SCI2.
 */
public class SystemInOutReflector extends Task {
	
	/* (non-Javadoc)
	 * @see ch.ntb.inf.deep.runtime.mpc555.Task#action()
	 */
	public void action() {
		// reflect input on stdin to stdout
		if (SCI1.availToRead() > 0)
			SCI1.write((byte)SCI1.read());
	}

	static {
		// Initialize SCI2 (9600 8N1)
		SCI1.start(9600, SCI1.NO_PARITY, (short)8);
		SCI1.write((byte)'x');
		SCI1.write((byte)'1');
		
		// Create and install the demo task
		Task t = new SystemInOutReflector();
		t.period = 0;
		Task.install(t);
	}
}
