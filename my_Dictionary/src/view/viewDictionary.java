package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import controller.controller_dictionary;

public class viewDictionary extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField j_t1= new JTextField();
	private JTextField j_t2= new JTextField();
	private JTextField j_t3= new JTextField();
	private JTextArea j_t4= new JTextArea();
	private JPanel j_p1=new JPanel();
	private JPanel j_p2=new JPanel();
	private JPanel j_p3= new JPanel();
	private JLabel j_l1= new JLabel("input the word need translate");
	private JLabel j_l2= new JLabel("Your Word");
	private JLabel j_l3= new JLabel("Your Translated Word");
	private JLabel j_l4=new JLabel("Suggest word");
	private JButton j_b1=new JButton("Translate");
	private JButton j_b2=new JButton("add new word");
	private controller_dictionary d_event=  new controller_dictionary(this);
	public viewDictionary() {
		controller_dictionary event= new controller_dictionary(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.j_p1.setLayout(new GridLayout(2,1));
		this.j_p1.add(j_l1);
		this.j_p1.add(j_t1);
		this.j_t1.getDocument().addDocumentListener(d_event);
		this.j_p2.setLayout(new GridLayout(2,2,0,10));
		this.j_p2.add(j_l2);
		this.j_p2.add(j_l3);
		this.j_p2.add(j_t2);
		this.j_t2.setEditable(false);
		this.j_p2.add(j_t3);
		this.j_t3.setEditable(false);
		this.j_p3.setLayout(new GridLayout(1,2,0,0));
		this.j_p3.add(j_l4);
		this.j_p3.add(j_t4);
		this.setLayout(new BorderLayout(0,5));
		this.add(j_p1,BorderLayout.NORTH);
		this.add(j_b1,BorderLayout.EAST);
		this.add(j_p3,BorderLayout.CENTER);
		this.add(j_p2,BorderLayout.SOUTH);
		this.j_b2.addActionListener(event);
		this.add(j_b2,BorderLayout.WEST);
		this.j_t4.setSize(0, 0);
		this.j_b1.addActionListener(event);
		this.setVisible(true);
		this.setSize(600, 200);
		this.setLocationRelativeTo(null);
	}
	public String getWord() {
		String s=this.j_t1.getText().toLowerCase();
		return s;
	}
//	public void highligt(String s) {
//		this.j_t4.getComponentAt(s);
//		this.hilig.addHighlight(ALLBITS, ABORT, painter)
//	}
	public void showWord(String s) {
		this.j_t2.setText(s);
	}
	public void showTranslatedWord(String s) {
		this.j_t3.setText(s);
	}
	public void showSuggestWord(Set<String> s) {
		this.clearSuggestWord();
			for (String string : s) {
				this.j_t4.setText(this.j_t4.getText()+"-"+string+"\n");
			}
	}
	public void clearSuggestWord() {
		this.j_t4.setText("");
	}
}
