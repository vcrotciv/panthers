package com.gsu.dogtracker.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gsu.dogtracker.controller.DogGuiController;
import com.gsu.dogtracker.core.Dog;

// This is our GUI Implementation
// I get it, no one likes swing.
//
// Did you know that in swing you can take a panel and put it in a scrollable panel,
// then you can put that in a resizeable panel. You can do that in reverse order, you add others features,
// yet every time you call a function on the outer panel, it will keep drilling down until it finds the 
// correct panel to use. It does this by using the decorator pattern. So even if its a bit windows 95 looking, 
// the way its built is worth looking at.
public class DogGuiSwingImpl extends JFrame implements DogGui {

	private static final long serialVersionUID = 1L;
	JTextField nameText;
	JTextField breedText;
	JTextField ageText;

	JButton lookupButton;
	JButton storeButton;
	JButton clearButton;

	public DogGuiSwingImpl() {
		Container c = getContentPane();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		panel.add(new JLabel("Name:"));
		nameText = new JTextField(20);
		panel.add(nameText);
		panel.add(new JLabel("Breed:"));
		breedText = new JTextField(20);
		panel.add(breedText);
		panel.add(new JLabel("Age:"));
		ageText = new JTextField(20);
		panel.add(ageText);

		c.add(panel, BorderLayout.CENTER);

		panel = new JPanel();
		lookupButton = new JButton("Search");
		storeButton = new JButton("Add");
		clearButton = new JButton("Reset");

		panel.add(lookupButton);
		panel.add(storeButton);
		panel.add(clearButton);

		c.add(panel, BorderLayout.SOUTH);

		start();

	}

	@Override
	public Dog getDog() {
		Dog dog = new Dog();
		dog.setName(nameText.getText());
		dog.setBreed(breedText.getText());
		dog.setAge(Integer.parseInt(ageText.getText()));
		return dog;
	}

	@Override
	public String getName() {
		return nameText.getText();
	}

	@Override
	public void clear() {
		nameText.setText("");
		breedText.setText("");
		ageText.setText("");
	}

	@Override
	public void setDog(Dog dog) {
		nameText.setText(dog.getName());
		breedText.setText(dog.getBreed());
		ageText.setText(Integer.toString(dog.getAge()));
	}

	@Override
	public void start() {
		pack();
		setLocation(300, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void setController(DogGuiController controller) {
		lookupButton.addActionListener(controller);
		storeButton.addActionListener(controller);
		clearButton.addActionListener(controller);

	}

}
