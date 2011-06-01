package ch.ntb.inf.deep.runtime.mpc555.driver;

import ch.ntb.inf.deep.runtime.mpc555.ntbMpc555HB;
import ch.ntb.inf.deep.unsafe.US;

/*
 * changes:
 * 22.02.2011 NTB/MZ, renamed to TPUA
 * 07.12.2010 NTB/UG, adapted to the new board interface file
 * 25.11.2010 NTB/UG, ported to deep
 * 18.02.2008 NTB/SP, assigned to java
 */

/**
 * Driver for the TPU B.
 */
public class TPUB implements ntbMpc555HB {

	/**
	 * Returns the TCR1 cycle time.
	 * 
	 * @return The current TCR1 cycle time.
	 */
	public static int getCycleTime() {
		int prescale = 1;
		short value;
		short s = US.GET2(TPUMCR3_B);
		if((s & (1 << 6)) != 0){
			value = (short) (s & 0x1F);
			prescale = prescale * (value + 1) * 2;
		}else{
			s = US.GET2(TPUMCR_B);
			if((s & (1 << 6)) != 0) prescale *= 4;
			else prescale *= 32;
		}
		
		//TCR1 prescaler
		s = US.GET2(TPUMCR_B);
		value = (short) (s & 0x6000);
		value = (short) (value >> 12);
		prescale = prescale * (1 << value);
		
		//DIV2
		s = US.GET2(TPUMCR2_B);
		if((s & (1 << 8)) != 0) prescale *= 2;
		
		//40 MHz => cycle time = 25ns
		return 25 * prescale;
	}
	
	/**
	 * If you use the TCR1, call this method to initialize the pre-scaler.
	 */
	public static void init(){}
	
	static{
		US.PUT2(TPUMCR3_B,0x0);
		
		//SYS.PUT2(TPUMCR,0x000); //IMB Clock not divided for TCR1, 1 cycle = 0.8us
		//SYS.PUT2(TPUMCR,0x050); //IMB Clock divided by 4 instead of 32, 1 cycle = 0.1us
		//SYS.PUT2(TPUMCR3,0x40); // Enable the enhanced pre-scaler, 1 cycle = 0.05us
		
		/*
		 * CAUTION:
		 * If you change the cycle time, you have to adapt the TpuTimeUnit in the PWM.java file
		 */
		
	}

}