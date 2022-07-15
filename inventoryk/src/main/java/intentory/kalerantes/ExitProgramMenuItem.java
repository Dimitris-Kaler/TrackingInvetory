package intentory.kalerantes;

public class ExitProgramMenuItem extends MenuItem {

	public ExitProgramMenuItem(String code, String description) {
		super(code, description);
	}

	public void execute() {
		System.out.println("BYE BYE!!!");
		System.exit(0);
	}

}
