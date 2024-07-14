package main.java.org.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import main.java.org.model.ListManager;

import java.awt.*;

public class GraphicUserInterface extends JFrame{

	//campi List
	private JTextField listName;
	private JButton listAdd;
	private JButton listRemove;
	private DefaultListModel<String> listModel;
	private JList<String> listView;

	//campi Category
	private JTextField categoryName;
	private JButton categoryAdd;
	private JButton categoryRemove;
	private JList<String> categoryView;
	
	//campi Article
	private JTextField articleFromList;
	private JTextField articleName;
	private JTextField articleCost;
	private JTextField articleCategory;
	private JTextField articleQuantity;
	private JButton articleAdd;
	private JButton articleRemove;
	private JList<String> articleView;
	
	//costruttore
	public GraphicUserInterface() {	
		
	}

	//metodo
	public void runInterface() {

		setTitle("GUI SHOPPING LIST MANAGER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setLayout(new BorderLayout());

		//List Column
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(0,1));
		listPanel.setBorder(new TitledBorder("SHOPPING LISTS"));
		listPanel.add(listName = new JTextField("Name of the List"));
		listPanel.add(listAdd = new JButton("Add a new List"));
		listPanel.add(listRemove = new JButton("Remove an existing List"));
		listModel = new DefaultListModel<>();
		listPanel.add(listView = new JList<String>(listModel));
		
		//Category Column
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new GridLayout(0,1));
		categoryPanel.setBorder(new TitledBorder("CATEGORIES"));
		categoryPanel.add(categoryName = new JTextField("Name of the Category"));
		categoryPanel.add(categoryAdd = new JButton("Add a new Category"));
		categoryPanel.add(categoryRemove = new JButton("Remove an existing Category"));
		categoryPanel.add(categoryView = new JList<String>());

		//Article Column
		JPanel articlePanel = new JPanel();
		articlePanel.setLayout(new GridLayout(0,1));
		articlePanel.setBorder(new TitledBorder("CATEGORIES"));
		articlePanel.add(articleName = new JTextField("Name of the Article"));
		articlePanel.add(articleCost = new JTextField("Cost of the Article"));
		articlePanel.add(articleCategory = new JTextField("Category of the Article"));
		articlePanel.add(articleQuantity = new JTextField("Quantity of the Article"));
		articlePanel.add(articleAdd = new JButton("Add a new Article"));
		articlePanel.add(articleRemove = new JButton("Remove an existing Article"));
		articlePanel.add(articleView = new JList<String>());

		add(listPanel, BorderLayout.WEST);
		add(categoryPanel, BorderLayout.CENTER);
		add(articlePanel, BorderLayout.EAST);
		setVisible(true);
	}

	// Getters
	public String getListName() {
		return listName.getText();
	}

	public JButton getListAddButton() {
		return listAdd;
	}
	
	public JButton getListRemoveButton() {
		return listRemove;
	}
	public DefaultListModel<String> getListModel(){
		return listModel;
	}
}
