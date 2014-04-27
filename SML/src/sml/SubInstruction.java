package sml;

/**
 * This class subtract  the content of register S2 from the content of S1 and store result in register R
 * 
 * @author Ludo
 */


public class SubInstruction extends Instruction {

	private int result;
	private int op1;
	private int op2;
	
	
	public SubInstruction(String label, int result, int op1, int op2) {
		super(label, "sub");
		this.result = result;
		this.op1 = op1;
		this.op2 = op2;
	}

	@Override
	public void execute(MachineInterface m) {
		int value1 = m.getRegisters().getRegister(op1);
		int value2 = m.getRegisters().getRegister(op2);
		m.getRegisters().setRegister(result, value1 - value2);
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + op1 + " - " + op2 + " to " + result;
	}

}
