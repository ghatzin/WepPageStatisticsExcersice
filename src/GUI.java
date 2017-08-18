import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.util.*;



public class GUI extends JFrame
{

	 
	 
	 private JButton btnStatistics;
	 private JLabel labelURL;
	 private JTextField	txtURL;
	 private WebPage webPage;
	 private Document document;
	 private JTable table;
	 private Label lblLongestWord;
	 private JTextField txtLongestWord;
	 private Label lblCommonLetter; 
	 private JTextField txtCommonLetter;
	 
	 
	 public GUI()
	 {
		 setLayout(new FlowLayout());
		 
		 labelURL=new JLabel("Give URL:");
		 add(labelURL);
		 txtURL=new JTextField(20);
		 add(txtURL); 
		 btnStatistics=new JButton("Get Statistics");
		 add(btnStatistics);
		 lblLongestWord=new Label("The Longest Word is:");
		 add(lblLongestWord);
		 txtLongestWord=new JTextField(20);
		 add(txtLongestWord);
		 lblCommonLetter=new Label("Common Letter is:");
		 add(lblCommonLetter);
		 txtCommonLetter=new JTextField(20);
		 add(txtCommonLetter);
		 		 		 
		 String[] columnNames={"Word","Frequency"};
		 table=new JTable();
		 JScrollPane scrollPane=new JScrollPane(table); 
		 add(scrollPane);
		
		 event e=new event();
		 btnStatistics.addActionListener(e);
		 
		 
		 
		  
	 }
	 
	 
	 public class event implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
			 try
			 {
			 	webPage= new WebPage(txtURL.getText());
			 	document=new Document(webPage.getPlainText());
			 	
			 	txtLongestWord.setText(document.longestWord(document.getWords()));
			 	String commonLetter=String.valueOf(document.getCommonLetter(document.getWords()));
			 	txtCommonLetter.setText(commonLetter);
			 	Map<String,Integer> wordFreq=new HashMap<String,Integer>();
			 	wordFreq=document.getWordfrequency(document.getWords());	
			 	table.setModel(tableModel(wordFreq));
			 }
			 catch (Exception ex)
			 {
				 ex.printStackTrace();
			 }
		 }
		 
	 }
	 
	 
	 public TableModel tableModel(Map<String, Integer> wordFreq)
	 {
		 DefaultTableModel model=new DefaultTableModel(new Object[]{"Word","Frequency"},0);
		 
		 for (Map.Entry<String,Integer> entry : wordFreq.entrySet()) {
		        model.addRow(new Object[] { entry.getKey(), entry.getValue() });
		    }
		    return model;
		 
	 }
	 
	
	public static void main(String args[])
	{
		GUI gui=new GUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gui.setSize(800,600);
		gui.setVisible(true);
	}
	
}
