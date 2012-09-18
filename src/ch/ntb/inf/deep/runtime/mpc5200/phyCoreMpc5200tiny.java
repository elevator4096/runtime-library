package ch.ntb.inf.deep.runtime.mpc5200;

// Auto generated file (2012-09-18 17:58:25)

public interface phyCoreMpc5200tiny {

	// System constants of CPU MPC5200
	public static final int SRAM_BaseAddr = 0xf0008000;
	public static final int SRAM_Size = 0x4000;
	public static final int MemBaseAddr = 0xf0000000;
	public static final int PSC1Base = 0xf0002000;
	public static final int PSC2Base = 0xf0002200;
	public static final int PSC3Base = 0xf0002400;
	public static final int PSC4Base = 0xf0002600;
	public static final int PSC5Base = 0xf0002800;
	public static final int PSC6Base = 0xf0002c00;
	public static final int MSCAN1Base = 0xf0000900;
	public static final int MSCAN2Base = 0xf0000980;

	// System constants of board phyCoreMpc5200tiny
	public static final int extRamBase = 0x0;
	public static final int extRamSize = 0x8000000;
	public static final int extFlashBase = 0xff000000;
	public static final int extFlashSize = 0x1000000;
	public static final int excpCodeFlashBase = 0xff000000;
	public static final int excpCodeRamBase = 0x0;
	public static final int excpCodeSize = 0x4000;
	public static final int sysTabBaseAddr = 0x4000;
	public static final int stackSize = 0x2000;
	public static final int heapSize = 0x40000;
	public static final int SRR1init = 0x3802;

	// Registermap GPR
	public static final int R0 = 0x0;
	public static final int R1 = 0x1;
	public static final int R2 = 0x2;
	public static final int R3 = 0x3;
	public static final int R4 = 0x4;
	public static final int R5 = 0x5;
	public static final int R6 = 0x6;
	public static final int R7 = 0x7;
	public static final int R8 = 0x8;
	public static final int R9 = 0x9;
	public static final int R10 = 0xa;
	public static final int R11 = 0xb;
	public static final int R12 = 0xc;
	public static final int R13 = 0xd;
	public static final int R14 = 0xe;
	public static final int R15 = 0xf;
	public static final int R16 = 0x10;
	public static final int R17 = 0x11;
	public static final int R18 = 0x12;
	public static final int R19 = 0x13;
	public static final int R20 = 0x14;
	public static final int R21 = 0x15;
	public static final int R22 = 0x16;
	public static final int R23 = 0x17;
	public static final int R24 = 0x18;
	public static final int R25 = 0x19;
	public static final int R26 = 0x1a;
	public static final int R27 = 0x1b;
	public static final int R28 = 0x1c;
	public static final int R29 = 0x1d;
	public static final int R30 = 0x1e;
	public static final int R31 = 0x1f;

	// Registermap FPR
	public static final int FPR0 = 0x0;
	public static final int FPR1 = 0x1;
	public static final int FPR2 = 0x2;
	public static final int FPR3 = 0x3;
	public static final int FPR4 = 0x4;
	public static final int FPR5 = 0x5;
	public static final int FPR6 = 0x6;
	public static final int FPR7 = 0x7;
	public static final int FPR8 = 0x8;
	public static final int FPR9 = 0x9;
	public static final int FPR10 = 0xa;
	public static final int FPR11 = 0xb;
	public static final int FPR12 = 0xc;
	public static final int FPR13 = 0xd;
	public static final int FPR14 = 0xe;
	public static final int FPR15 = 0xf;
	public static final int FPR16 = 0x10;
	public static final int FPR17 = 0x11;
	public static final int FPR18 = 0x12;
	public static final int FPR19 = 0x13;
	public static final int FPR20 = 0x14;
	public static final int FPR21 = 0x15;
	public static final int FPR22 = 0x16;
	public static final int FPR23 = 0x17;
	public static final int FPR24 = 0x18;
	public static final int FPR25 = 0x19;
	public static final int FPR26 = 0x1a;
	public static final int FPR27 = 0x1b;
	public static final int FPR28 = 0x1c;
	public static final int FPR29 = 0x1d;
	public static final int FPR30 = 0x1e;
	public static final int FPR31 = 0x1f;

	// Registermap SPR
	public static final int SPR1 = 0x1;
	public static final int XER = 0x1;
	public static final int SPR8 = 0x8;
	public static final int LR = 0x8;
	public static final int SPR9 = 0x9;
	public static final int CTR = 0x9;
	public static final int SPR18 = 0x12;
	public static final int DSISR = 0x12;
	public static final int SPR19 = 0x13;
	public static final int DAR = 0x13;
	public static final int SPR22 = 0x16;
	public static final int DEC = 0x16;
	public static final int SPR26 = 0x1a;
	public static final int SRR0 = 0x1a;
	public static final int SPR27 = 0x1b;
	public static final int SRR1 = 0x1b;
	public static final int SPR268 = 0x10c;
	public static final int TBLread = 0x10c;
	public static final int SPR269 = 0x10d;
	public static final int TBUread = 0x10d;
	public static final int SPR272 = 0x110;
	public static final int SPRG0 = 0x110;
	public static final int SPR273 = 0x111;
	public static final int SPRG1 = 0x111;
	public static final int SPR274 = 0x112;
	public static final int SPRG2 = 0x112;
	public static final int SPR275 = 0x113;
	public static final int SPRG3 = 0x113;
	public static final int SPR284 = 0x11c;
	public static final int TBLwrite = 0x11c;
	public static final int SPR285 = 0x11d;
	public static final int TBUwrite = 0x11d;
	public static final int SPR287 = 0x11f;
	public static final int PVR = 0x11f;
	public static final int SPR528 = 0x210;
	public static final int MI_GRA = 0x210;
	public static final int SPR536 = 0x218;
	public static final int L2U_GRA = 0x218;
	public static final int SPR560 = 0x230;
	public static final int BBCMCR = 0x230;
	public static final int SPR568 = 0x238;
	public static final int L2U_MCR = 0x238;
	public static final int SPR630 = 0x276;
	public static final int DPDR = 0x276;

	// Registermap IOR
	public static final int MBAR = 0xf0000000;
	public static final int CS0START = 0xf0000004;
	public static final int CS0STOP = 0xf0000008;
	public static final int SDRAMCS0 = 0xf0000034;
	public static final int SDRAMCS1 = 0xf0000038;
	public static final int IPBICR = 0xf0000054;
	public static final int SDRAMMR = 0xf0000100;
	public static final int SDRAMCR = 0xf0000104;
	public static final int SDRAMCR1 = 0xf0000108;
	public static final int SDRAMCR2 = 0xf000010c;
	public static final int SDRAMSCDR = 0xf0000190;
	public static final int CS0CR = 0xf0000300;
	public static final int CS1CR = 0xf0000304;
	public static final int CS2CR = 0xf0000308;
	public static final int CS3CR = 0xf000030c;
	public static final int CS4CR = 0xf0000310;
	public static final int CS5CR = 0xf0000314;
	public static final int CS6CR = 0xf0000320;
	public static final int CS7CR = 0xf0000324;
	public static final int CSCR = 0xf0000318;
	public static final int CSSR = 0xf000031c;
	public static final int CSBCR = 0xf0000328;
	public static final int ICTLPIMR = 0xf0000500;
	public static final int ICTLPPR1 = 0xf0000504;
	public static final int ICTLPPR2 = 0xf0000508;
	public static final int ICTLPPR3 = 0xf000050c;
	public static final int ICTLEER = 0xf0000510;
	public static final int ICTLPISAR = 0xf0000530;
	public static final int GPSPCR = 0xf0000b00;
	public static final int GPWER = 0xf0000c00;
	public static final int GPWDDR = 0xf0000c08;
	public static final int GPWOUT = 0xf0000c0c;
	public static final int GPWIN = 0xf0000c20;
	public static final int XLBACR = 0xf0001f40;
	public static final int PSCMR1 = 0x0;
	public static final int PSCMR2 = 0x0;
	public static final int PSCSR = 0x4;
	public static final int PSCCSR = 0x4;
	public static final int PSCCR = 0x8;
	public static final int PSCRxBuf = 0xc;
	public static final int PSCTxBuf = 0xc;
	public static final int PSCCTUR = 0x18;
	public static final int PSCCTLR = 0x1c;
	public static final int PSCSICR = 0x40;
	public static final int PSCTFNUM = 0x5c;
	public static final int PSCTFCNTL = 0x88;
	public static final int CANCTL0 = 0x0;
	public static final int CANCTL1 = 0x1;
	public static final int CANBTR0 = 0x4;
	public static final int CANBTR1 = 0x5;
	public static final int CANRFLG = 0x8;
	public static final int CANRIER = 0x9;
	public static final int CANTFLG = 0xc;
	public static final int CANTIER = 0xd;
	public static final int CANTARQ = 0x10;
	public static final int CANTAAK = 0x11;
	public static final int CANTBSEL = 0x14;
	public static final int CANIDAC = 0x15;
	public static final int CANRXERR = 0x1c;
	public static final int CANTXERR = 0x1d;
	public static final int CANIDAR0 = 0x20;
	public static final int CANIDAR1 = 0x21;
	public static final int CANIDAR2 = 0x24;
	public static final int CANIDAR3 = 0x25;
	public static final int CANIDMR0 = 0x28;
	public static final int CANIDMR1 = 0x29;
	public static final int CANIDMR2 = 0x2c;
	public static final int CANIDMR3 = 0x2d;
	public static final int CANIDAR4 = 0x30;
	public static final int CANIDAR5 = 0x31;
	public static final int CANIDAR6 = 0x34;
	public static final int CANIDAR7 = 0x35;
	public static final int CANIDMR4 = 0x38;
	public static final int CANIDMR5 = 0x39;
	public static final int CANIDMR6 = 0x3c;
	public static final int CANIDMR7 = 0x3d;
	public static final int CANRXFG = 0x40;
	public static final int CANTXFG = 0x60;
	public static final int CANTXIR0 = 0x60;
	public static final int CANTXIR1 = 0x61;
	public static final int CANTXIR2 = 0x64;
	public static final int CANTXIR3 = 0x65;
	public static final int CANTXDSR0 = 0x68;
	public static final int CANTXDSR1 = 0x69;
	public static final int CANTXDSR2 = 0x6c;
	public static final int CANTXDSR3 = 0x6d;
	public static final int CANTXDSR4 = 0x70;
	public static final int CANTXDSR5 = 0x71;
	public static final int CANTXDSR6 = 0x74;
	public static final int CANTXDSR7 = 0x75;
	public static final int CANTXDLR = 0x78;
	public static final int CANTXTBPR = 0x79;
}