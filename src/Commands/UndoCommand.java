package Commands;

public class UndoCommand implements ICommand {

	@Override
	public void run() {
		CommandHistory.undo();
	}

}
