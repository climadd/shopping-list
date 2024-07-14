package main.java.org.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.org.model.DuplicateNameException;
import main.java.org.model.ListManager;
import main.java.org.model.ShoppingList;
import main.java.org.view.GraphicUserInterface;

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
		gui.getListAddButton().addActionListener(e -> {
			try {
				manager.addShoppingList(gui.getListName());
			} catch (DuplicateNameException dnException) {
				System.out.println(dnException.getMessage() + "\n");
			}
		});


	}
}

