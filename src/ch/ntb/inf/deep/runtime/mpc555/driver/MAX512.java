/*
 * Copyright (c) 2011 NTB Interstate University of Applied Sciences of Technology Buchs.
 * All rights reserved.
 *
 * http://www.ntb.ch/inf
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 * Neither the name of the project's author nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package ch.ntb.inf.deep.runtime.mpc555.driver;

import ch.ntb.inf.deep.runtime.mpc555.ntbMpc555HB;
import ch.ntb.inf.deep.unsafe.US;

/* CHANGES:
 * 14.04.2009	NTB/SP	creation
 */

/**
 * Driver for the Maxim512 Digital to Analog Converter.<br>
 * PCS0 is used.
 * 
 */
public class MAX512 implements ntbMpc555HB {
	
	public final static int chnA = 0;
	public final static int chnB = 1;
	public final static int chnC = 2;
	
	private static short disDACs = 0;

	
	/**
	 * Disable one channel.
	 * @param ch the desired channel ({@link chnA}, {@link chnB}, {@link chnC})
	 */
	public static void disable(int ch){
		disDACs |= 0x0800 << ch;
		US.PUT2(TRANRAM + 2 * ch,disDACs);
	}
	
	/**
	 * Enable a disabled channel.
	 * @param ch the desired channel ({@link chnA}, {@link chnB}, {@link chnC})
	 */
	public static void enable(int ch){
		disDACs &=  ~(0x0800 << ch);
		US.PUT2(TRANRAM + 2 * ch,disDACs);
	}
	
	/**
	 * Write a value to the DAC.
	 * @param ch the desired channel ({@link chnA}, {@link chnB}, {@link chnC})
	 * @param val the desired output value
	 */
	public static void write(int ch, byte val){
		US.PUT2(TRANRAM + 2 * ch, (disDACs | (0x0100  << ch)| (0xFF & val))); // Write data to transmit ram
	}
	
	/**
	 * Initializes the SPI.
	 */
	public static void init(){
		US.PUT2(SPCR1, 0x0); 	//disable QSPI 
		US.PUT1(PQSPAR, 0x0B); // use PCS0, MOSI, MISO for QSPI 
		US.PUT1(DDRQS, 0x0E); 	//SCK, MOSI, PCS's outputs; MISO is input 
		US.PUT2(PORTQS, 0xFF); 	//all Pins, in case QSPI disabled, are high 
		US.PUT2(SPCR0, 0x8014); // QSPI is master, 16 bits per transfer, inactive state of SCLK is high (CPOL=1), data changed on leading edge (CPHA=1), clock = 1 MHz 
		US.PUT2(SPCR2, 0x4200); 	// no interrupts, wraparound mode, NEWQP=0, ENDQP=7 		
		US.PUT1(COMDRAM, 0x6E); //Cont off, BITS of SPCR0, DT from SPCR1, CS0 low
		US.PUT1(COMDRAM + 1, 0x6E); //Cont off, BITS of SPCR0, DT from SPCR1, CS0 low
		US.PUT1(COMDRAM + 2, 0x6E); //Cont off, BITS of SPCR0, DT from SPCR1, CS0 low
		US.PUT2(SPCR1, 0x08010);	//enable QSPI, delay 13us after transfer
	}
	
}
