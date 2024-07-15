package main.java.org.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import main.java.org.model.DuplicateNameException;
import main.java.org.model.ListManager;
import main.java.org.model.MissingNameException;
import main.java.org.model.ShoppingList;
import main.java.org.view.GraphicUserInterface;

@SuppressWarnings({ "unused" })



public class Controller {

	//campi
	private GraphicUserInterface gui;
	private ListManager manager;
	
	//costruttore
	public Controller(GraphicUserInterface gui) {
		this.gui = gui;
	}

	public void runInterface() {
		gui.runInterface();

	       gui.getListAddButton().addActionListener(new ActionListener() {
	    	   
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String listName = gui.getListName();
	                if (!listName.isEmpty()) {
	                    try {
							manager.addShoppingList(listName);
						} catch (DuplicateNameException dnException) {
							System.out.println(dnException.getMessage());
						}
	                    gui.getListModel().addElement(listName);
	                }
	            }
	        });

	}
}

