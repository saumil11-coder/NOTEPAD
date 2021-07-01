package text;

public class Function_Edit {
	texteditor gui;
	public Function_Edit(texteditor gui)
	{
		this.gui=gui;
		
	}

	public void undo()
	{
		gui.um.undo();
	}
	public void redo()
	{
		gui.um.redo();
	}
}
