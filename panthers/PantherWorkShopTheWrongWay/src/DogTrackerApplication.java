import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//
// --------The Task---------
// Two new requirements have come in, and the application is to get the dogs from a properties file upon startup
// and store them into a HashMap instead of a List, using the dog's name as the key. 
//
// The method for taking in a property file and returning a map has already been created in the DogMapUtil class
//
// step 1 :  ctrl + shift + f
//
// 
public class DogTrackerApplication extends JFrame {
	private static final long serialVersionUID = 3710670639267411444L;
	ArrayList<Dog> dogs = new ArrayList<Dog>();
	JTextField textBoxOne;
	JTextField textBoxTwo;
	JTextField textBoxThree;
	JButton buttonOne;
	JButton buttonTwo;
	JButton buttonThree;
	public void runApp() {
	dogs.add(new Dog("Dexter", "Mini-Schnauzer", 4));
	dogs.add(new Dog("Doakes", "Mini-Schnauzer", 3));
	dogs.add(new Dog("Cooper", "French Bulldog", 3));
	dogs.add(new Dog("Leo", "Yellow Lab", 7));
	dogs.add(new Dog("Baxter", "Black Lab", 5));
	Container c = getContentPane();
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(3, 2));
	panel.add(new JLabel("Name:"));
	textBoxOne = new JTextField(20);
	panel.add(textBoxOne);
	panel.add(new JLabel("Breed:"));
	textBoxTwo = new JTextField(20);
	panel.add(textBoxTwo);
	panel.add(new JLabel("Age:"));
	textBoxThree = new JTextField(20);
	panel.add(textBoxThree);
	c.add(panel, BorderLayout.CENTER);
	panel = new JPanel();
	buttonOne = new JButton("Search");
	buttonTwo = new JButton("Add");
	buttonThree = new JButton("Reset");
	panel.add(buttonOne);
	panel.add(buttonTwo);
	panel.add(buttonThree);
	c.add(panel, BorderLayout.SOUTH);
	buttonOne.addActionListener(new ButtonListener());
	buttonTwo.addActionListener(new ButtonListener());
	buttonThree.addActionListener(new ButtonListener());
	pack();
	setLocation(300, 400);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setVisible(true);
	}
	private class ButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	if ("Search".equals(e.getActionCommand())) {
	System.out.println("Hit Search");
	String temp = textBoxOne.getText();
	Dog dog = null;
	for (Dog d : dogs) {
	if (temp.equals(d.getName())) {
	dog = d;
	}
	}
	if (dog != null) {
	textBoxOne.setText(dog.getName());
	textBoxTwo.setText(dog.getBreed());
	textBoxThree.setText(Integer.toString(dog.getAge()));
	}else{
	System.out.println("No match found.");
	}
	} else if ("Reset".equals(e.getActionCommand())) {
	System.out.println("Hit Reset");
	textBoxOne.setText("");
	textBoxTwo.setText("");
	textBoxThree.setText("");
	} else if ("Add".equals(e.getActionCommand())) {
	System.out.println("Hit Add");
	Dog dog = new Dog(textBoxOne.getText(), textBoxTwo.getText(),
	Integer.parseInt(textBoxThree.getText()));
	boolean duplicateDog = false;
	for (Dog d : dogs) {
	if (dog.getName().equals(d.getName())) {
	duplicateDog = true;
	}
	}
	if (!duplicateDog) {
	dogs.add(dog);
	} else {
	System.out.println("Dog already exists in our system.");
	}
	textBoxOne.setText("");
	textBoxTwo.setText("");
	textBoxThree.setText("");
	} else {
	System.out.println("Bad button");
	}
	}
	}

}
