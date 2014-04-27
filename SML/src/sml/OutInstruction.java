package sml;


/**
 * This class ....
 * 
 * @author someone
 */

public class OutInstruction extends Instruction {
	private int register;
	private int value;



	public OutInstruction(String label, int register) {
		super(label, "out");
		this.register = register;
	}

	@Override
	public void execute(MachineInterface m) {
		value = m.getRegisters().getRegister(register);
		System.out.println(value);
	}

	@Override
	public String toString() {
		return super.toString() + " print register: " + register;
	}
}
