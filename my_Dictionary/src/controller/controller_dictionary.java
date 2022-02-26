package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import data.data_Dictionary;
import view.viewDictionary;

public class controller_dictionary implements DocumentListener,ActionListener{
	private viewDictionary c_vc;
	private data_Dictionary d_D= new data_Dictionary();
	private int c_count=0;
	private Set<String> listSuggestWord= new HashSet<String>();
	private int c_sizeList=this.listSuggestWord.size();
	public controller_dictionary(viewDictionary c_vc) {
		this.c_vc = c_vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Translate") {
			this.c_vc.showWord(this.c_vc.getWord());
			this.c_vc.showTranslatedWord(this.d_D.translate(this.c_vc.getWord()));			
		}else {
			Scanner scanner = new Scanner(System.in);
			String key,value;
			System.out.println("Write english word");
			key=scanner.nextLine();
			System.out.println("Write its mean");
			value=scanner.nextLine();
			System.out.println("thanks");
			this.d_D.addAWord(key,value);
		}
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		listSuggestWord=this.d_D.suggestWord(this.c_vc.getWord());
		this.c_vc.showSuggestWord(listSuggestWord);
		this.c_count++;
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		if(this.c_count==0)this.c_count=0;
		else this.c_count--;
		this.c_vc.clearSuggestWord();
		this.d_D.isRemovedDocument();
		if(this.c_count>0) {
			listSuggestWord=this.d_D.suggestWord(this.c_vc.getWord());
			this.c_vc.showSuggestWord(listSuggestWord);
		}
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
