package ch.ntb.inf.deep.runtime.ppc32;

import ch.ntb.inf.deep.unsafe.US;

/*changes:
 * 12.3.2014	NTB/Urs Graf	creation
 */

public class ProgramExc extends PPCException implements Ippc32 {
	public static int nofProgExceptions;
	static int nextOpCode;

	static void programExc(Exception e) {
		nofProgExceptions++;
		int addr = US.GETSPR(SRR0);
		e = findException(e, addr);	// call to method, as there is not enough space in the exception table
		e.addr = addr;

		US.PUTGPR(R2, US.REF(e));	// copy to volatile register
		US.PUTGPR(R3, addr);	// copy to volatile register
	}

	private static Exception findException(Exception e, int addr) {
		int instr = US.GET4(addr);
		int opCode = instr >> 21;
		if (opCode == 0x3ff) {	// tw, TOalways -> user defined exception
		} else if (opCode == 0x3e5) {	// tw, TOifgeU -> ArrayIndexOutOfBounds
			e = new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
		} else if (opCode == 0x64) {	// twi, TOifequal
			int nextInstr = US.GET4(addr + 4);
			nextOpCode = nextInstr;
			if ((nextInstr & 0xfc0003fe) == 0x7c0003d6) {	// divw -> ArithmeticException
				e = new ArithmeticException("ArithmeticException");
			} else {	// NullPointer
				e = new NullPointerException("NullPointerException");
			}
		} else if (opCode == 0x3f8) {	// tw, TOifnequal
			e = new ClassCastException("ClassCastException");
		} else {	
			e = new ClassCastException("UnknownException");
		}
		return e;
	}

}
