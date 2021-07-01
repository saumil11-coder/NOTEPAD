package text;

import java.awt.MenuBar;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class texteditor implements ActionListener {
	JFrame window;
	static JTextArea textArea;
	JScrollPane scrollPane;
	 boolean wordWrapOn=false;
	JMenuBar menuBar;
	JMenu menuFile,menuEdit,menuFormat,menuColor;
	JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
	JMenuItem iUndo,iRedo;
	 JMenuItem iWrap;
	JMenuItem iFontArial;
	JMenuItem IFontCSMS;
	JMenuItem IFontTNR;
	JMenuItem iFontSize8;
	JMenuItem iFontSize12;
	JMenuItem iFontSize16;
	JMenuItem iFontSize20;
	JMenuItem iFontSize24;
	JMenuItem iFontSize28;
	JMenuItem menuFont,menuFontSize;
	JMenuItem iColor1,iColor2,iColor3;
	
	
	Function_File file= new Function_File(this);
Function_Format format=new Function_Format(this);
Function_Color color= new Function_Color(this);
Function_Edit edit=new Function_Edit(this);
UndoManager um=new UndoManager();
public static void main(String[] args) {
		new texteditor();
	}
public texteditor()
{
	createwindow();
	createTextArea();
	createMenuBar();
	createFileMenu();
	creatFormatMenu();
	createColorMenu();
	createEditMenu();
	
	format.selectedFont ="Arial";
	format.createFont(16);
	format.wordWrap();
	color.changeColor("White");
 window.setVisible(true);
}
public void createwindow()
{
	window=new JFrame("NOTEPAD");
	window.setSize(900,700);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
public void createTextArea()
{
	textArea=new JTextArea();
	textArea.getDocument().addUndoableEditListener(
			 (UndoableEditListener) new UndoableEditListener(){
				public void undoableEditHappened(UndoableEditEvent e) {
					um.addEdit(e.getEdit());
				}
			}
			);
	scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setBorder(BorderFactory.createEmptyBorder());
	window.add(scrollPane);
}
public void createMenuBar()
{
	menuBar=new JMenuBar();
	window.setJMenuBar(menuBar);
	
	menuFile= new JMenu("File");
	menuBar.add(menuFile);
	
	menuEdit= new JMenu("Edit");
	menuBar.add(menuEdit);
	
	menuFormat= new JMenu("Format");
	menuBar.add(menuFormat);
	
	menuColor= new JMenu("Color");
	menuBar.add(menuColor);
}
public void createFileMenu()
{
	iNew=new  JMenuItem("New");
iNew.addActionListener(this);
iNew.setActionCommand("New");
menuFile.add(iNew);

	iOpen=new  JMenuItem("Open");
	iOpen.addActionListener(this);
	iOpen.setActionCommand("Open");
	menuFile.add(iOpen);
	
	iSave=new  JMenuItem("Save");
	iSave.addActionListener(this);
	iSave.setActionCommand("Save");
	menuFile.add(iSave);
	
	iSaveAs=new  JMenuItem("SaveAs");
	iSaveAs.addActionListener(this);
	iSaveAs.setActionCommand("SaveAs");
	menuFile.add(iSaveAs);
	
	
	iExit=new  JMenuItem("Exit");
	iExit.addActionListener(this);
	iExit.setActionCommand("iExit ");
	menuFile.add(iExit);
}
public void createEditMenu()
{
	iUndo=new JMenuItem("Undo");
	iUndo.addActionListener(this);
	iUndo.setActionCommand("Undo");
	menuEdit.add(iUndo);
	
	iRedo=new JMenuItem("Redo");
	iRedo.addActionListener(this);
	iRedo.setActionCommand("Undo");
	menuEdit.add(iRedo);
}
public void creatFormatMenu()
{
	iWrap=new JMenuItem("Word Wrap: Off");
	iWrap.addActionListener(this);
	iWrap.setActionCommand("Word Wrap");
	menuFormat.add(iWrap);
	
	menuFont=new JMenu("Font");
	menuFormat.add(menuFont);
	iFontArial=new JMenuItem("Arial");
	iFontArial.addActionListener(this);
	iFontArial.setActionCommand("Arial");
	menuFont.add(iFontArial);
	
	IFontCSMS=new JMenuItem("Comic Sans MS");
	IFontCSMS.addActionListener(this);
	IFontCSMS.setActionCommand("Comic Sans MS");
	menuFont.add(IFontCSMS);
	
	IFontTNR=new JMenuItem("Times New Roman");
	IFontTNR.addActionListener(this);
	IFontTNR.setActionCommand("Times New Roman");
	menuFont.add(IFontTNR);
	
	
	
	menuFontSize=new JMenu("Font Size");
	menuFormat.add(menuFontSize); 
	
	iFontSize8=new JMenuItem("8");
 iFontSize8.addActionListener(this);
	iFontSize8.setActionCommand("size8");
	menuFontSize.add(iFontSize8);
	

	iFontSize12=new JMenuItem("12");
 iFontSize12.addActionListener(this);
 iFontSize12.setActionCommand("size12");
	menuFontSize.add(iFontSize12);
	

	iFontSize16=new JMenuItem("16");
	iFontSize16.addActionListener(this);
	iFontSize16.setActionCommand("size16");
	menuFontSize.add(iFontSize16);
	

	iFontSize20=new JMenuItem("20");
	iFontSize20.addActionListener(this);
	iFontSize20.setActionCommand("size20");
	menuFontSize.add(iFontSize20);
	

	iFontSize24=new JMenuItem("24");
	iFontSize24.addActionListener(this);
	iFontSize24.setActionCommand("size24");
	menuFontSize.add(iFontSize24);
	

	iFontSize28=new JMenuItem("28");
	iFontSize28.addActionListener(this);
	iFontSize28.setActionCommand("size28");
	menuFontSize.add(iFontSize28);
}
public void createColorMenu()
{
	iColor1=new JMenuItem("White");
	iColor1.addActionListener(this);
	iColor1.setActionCommand("White"); 
	menuColor.add(iColor1);
	
	iColor2=new JMenuItem("Black");
	iColor2.addActionListener(this);
	iColor2.setActionCommand("Black"); 
	menuColor.add(iColor2);

	iColor3=new JMenuItem("Blue");
	iColor3.addActionListener(this);
	iColor3.setActionCommand("Blue"); 
	menuColor.add(iColor3);

}

@Override
public void actionPerformed(ActionEvent e) {
String command=e.getActionCommand();
switch(command) {
case "New":
	file.newFile();
	break;
case "Open":
	file.open();
	break;
case "Save":
	file.save();
	break;
case "SaveAs":
     file.saveAs();
	break;
case "Exit":
	file.exit();
	break;
case "Word Wrap":
	format.wordWrap();
	break;
case "Undo":edit.undo();break;
case"Redo":edit.redo();break;
case "Arial":format.setFont(command);break;
case "Times New Roman":format.setFont(command);break;
case "Comic Sans MS":format.setFont(command);break;
case "size8": format.createFont(8);break;
case "size12":format.createFont(12);break;
case "size16":format.createFont(16);break;
case "size20":format.createFont(20);break;
case "size24":format.createFont(24);break;
case "size28":format.createFont(28);break;
case "White":color.changeColor(command);break;
case "Black":color.changeColor(command);break;
case "Blue":color.changeColor(command);break; 

}
	
}
}
