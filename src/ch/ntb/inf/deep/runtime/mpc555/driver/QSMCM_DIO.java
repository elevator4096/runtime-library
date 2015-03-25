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

package ch.ntb.inf.deep.runtime.mpc555.driver;

import ch.ntb.inf.deep.unsafe.US;

/**
 * Digital I/O on the PortQS.<br>
 * <b>Important:</b> This drivers uses the same pins as the QSPI.<br>
 * The following pins can be used.
 * <ul>
 * <li> {@link #QDMISO}</li>
 * <li> {@link #QDMOSI}</li>
 * <li> {@link #QDPCS0}</li>
 * <li> {@link #QDPCS1}</li>
 * <li> {@link #QDPCS2}</li>
 * <li> {@link #QDPCS3}</li>
 * </ul>
 * 
 */
public class QSMCM_DIO {
	
	public static final int QDMISO = 0;
	public static final int QDMOSI = 1;
	public static final int QDPCS0 = 3;
	public static final int QDPCS1 = 4;
	public static final int QDPCS2 = 5;
	public static final int QDPCS3 = 6;
	
	
	/**
	 * Initializes a pin as an input or output.<br>
	 * Each pin must be initialized prior to using it.
	 * 
	 * @param channel
	 *            PortQS pin to initialize
	 * @param out
	 *            <code>true</code>: pin will be output,
	 *            <code>false</code>: pin will be input
	 */
	public static void init(int channel, boolean out) {
		byte s = US.GET1(QSMCM.PQSPAR);
		s &= ~(1 << channel);
		US.PUT1(QSMCM.PQSPAR, s);
		s = US.GET1(QSMCM.DDRQS);
		if(out) s |= (1 << channel);
		else s &= ~(1 << channel);
		US.PUT1(QSMCM.DDRQS,s);
	}

	/**
	 * Reads the state on a pin.<br>
	 * 
	 * @param channel PortQS pin to read
	 * @return State of the pin
	 */
	public static boolean in(int channel) {
		return (US.GET1(QSMCM.PORTQS + 1) & (1 << channel)) != 0;
	}

	/**
	 * Sets the state of a pin.
	 * 
	 * @param channel PortQS pin to write
	 * @param val State to be written
	 */
	public static void out(int channel, boolean val) {
		short s = US.GET1(QSMCM.PORTQS + 1);
		if(val) s |= (1 << channel);
		else s &= ~(1 << channel);
		US.PUT1(QSMCM.PORTQS + 1, s);
	}
}
