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
/**
 * 		NOTE: UNFINISHED: i am not able to make this class work for the deadline. The only other Java Class this is affecting is
 * 					the GraphicUserInterface one, which is possible to launch from the main, but won't handle Events like Button Clicks yet.
 * 
 *The Controller class holds the Event Listeners required for the GUI to work properly. The main creates an object GraphicUserInterface
 *and it passes it as a parameter to the constructor of Controller. once the object is created, the method .runInterface() is invoked
 *for every component of the GUI to be fully launched.
 */
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

//	the following code is just an attempt of understanding the ActionListener interface,
//	i'm leaving this here just to have something to brainstorm with the next time i get to fix this class
		
//	       gui.getListAddButton().addActionListener(new ActionListener() {
//	    	   
//	            @Override
//	            public void actionPerformed(ActionEvent e) {
//	                String listName = gui.getListName();
//	                if (!listName.isEmpty()) {
//	                    try {
//							manager.addShoppingList(listName);
//						} catch (DuplicateNameException dnException) {
//							System.out.println(dnException.getMessage());
//						}
//	                    gui.getListModel().addElement(listName);
//	                }
//	            }
//	        });

	}
}

