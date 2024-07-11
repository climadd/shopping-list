package main.java.org.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.org.model.ListManager;
import main.java.org.model.ShoppingList;
import main.java.org.view.GraphicUserInterface;

public class Controller {
	
	//campi
	private ListManager manager;
	private GraphicUserInterface gui;

	//costruttore
	public Controller(ListManager manager, GraphicUserInterface gui) {
		this.manager = manager;
		this.gui = gui;
	}
}   
