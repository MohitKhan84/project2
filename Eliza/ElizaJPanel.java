package Eliza;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ElizaJPanel extends JPanel implements ActionListener{
	
	
	private int count = 0;
	private static JLabel label;
	private JTextField response;
	private JTextArea view;
	private JTextArea lw;
	private JButton submit;
	private JButton start;
	private JButton request;
	private JButton reset;
	private JButton longword;
	
	
	
	
	public ElizaJPanel() {
		setLayout (new GridLayout (6,1));
		label = new JLabel ("Welcome to Eliza therapy session. Press Start to begin the Session"); 
		response = new JTextField(50);
		view = new JTextArea(15,20);
		lw = new JTextArea(15,20);
		
		add (label);
	    add (response);
	    
		
		start = new JButton ("Start");	
		submit = new JButton ("Next Question >>>");
		request = new JButton ("View all Q/A");
		reset = new JButton ("Start Again");
		longword = new JButton ("Longest Word");
		
		add (start);
		add (submit);
		add (request);
		add (reset);
		add (longword);
		add (view);
		add (lw);
		
		start.addActionListener(this);
		submit.addActionListener(this);
		request.addActionListener(this);
		reset.addActionListener(this);
		longword.addActionListener(this);
		
	}
	

	
	public static String getTxtFInfo(JTextField input) throws Exception{

		String text="";
		try{
			text = input.getText();
			return text;
		}
		catch(Exception e1){
			throw new Exception("This sentence was invalid"+ e1.getMessage());
		}
	}
//	public String FindLongestWord(String a){
//		String [] sentence;//created to place in the passed in sentence
//		sentence = a.split(" ");//used to grab each word and put it in each box of the "sentence" array
//		String temp = sentence[0];//take word at index 0 to compare to the index 1
//		for(int i = 1; i < sentence.length; i++){
//			if(temp.length() < sentence[i].length()){
//				temp = sentence[i];
//			}
//		}
//		return temp;
//	}
//
//	public static String getLongestString(String[] array) {
//		String bigword = "";
//		for(int i =0;i< array.length; i++){
//			if(array[i].length() > bigword.length()){
//				bigword = array[i];
//			}
//		}
//		return bigword;
//	}
//	
	
	public void appendToFile(String fileName, String text) {
		System.out.println("inside appendToFile fileName= "+fileName);
		PrintWriter outStr = null;
		try {
			System.out.println("i entered here");
			//outStr = new PrintWriter(fileName);//create a new empty file
			outStr = new PrintWriter(new FileOutputStream(fileName, true));//create a new file if necessary
			outStr.println(text);//write the text to the file
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			if(outStr !=null){
				outStr.close();
			}
			System.out.println("end of appendToFile fileName= "+fileName);
		}
	}
	
	public String readFromFile(String fileName) {
		System.out.println("Start of readFromFile method file name is "+fileName);
		Scanner inStr = null;
		String fileContent = "";
		try{
		File theFile = new File(fileName);
			if(theFile.exists() && theFile.canRead()){
				inStr = new Scanner(theFile);//connect my stream to the file
				int lineNum = 0;
				while(inStr.hasNextLine()){//as long as the file has another line
					lineNum++;
					fileContent +=  lineNum+" "+ inStr.nextLine() +"\n";//read line by line
				}
			}
		}
		catch(FileNotFoundException fnfe){
			System.err.println("PROBLEM! inside readFromFile method "+fileName+
					"Message is: "+fnfe.getMessage());
		}
		finally{
			if(inStr != null){
				inStr.close();
			}
			System.out.println("END of readFromFile method file name was "+fileName);
		}
		return fileContent;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		String usersText= "nothing here";
		QuestionBank firstBank= new QuestionBank();
		
		if(actCmd.equalsIgnoreCase("start")){
			label.setText(firstBank.questions[count]);
			//label.setText(" "+count);
			count++;
		

		}
		
		if(actCmd.equalsIgnoreCase("Next Question >>>")){
			usersText= response.getText();
			appendToFile("test.txt", usersText);
			
			
			response.setText("");
			if(count<10) {
				label.setText(firstBank.questions[count]);
				
				count++;
			}
			else {
				
				label.setText("Sorry, there we have no more questions!");
				}
		
			
		}
		
		if(actCmd.equalsIgnoreCase("View all Q/A")) {
			
			view.setText(readFromFile("test.txt"));
		}
		
		
		if(actCmd.equalsIgnoreCase("Longest Word")) {
			
			
			lw.setText("Help! Help!! Help!!!");
		}
		
		
		
		if(actCmd.equalsIgnoreCase("Start Again")) {
			response.setText("");
			label.setText("Welcome to Eliza therapy session. Press Start to begin");
			
		}
			
		
	}
	
	
	

	private void setLayout(GridLayout gridLayout) {
		// TODO Auto-generated method stub
		
	}

}
