package com.gsu.dogtracker.controller;

import java.awt.event.ActionEvent;

import com.gsu.dogtracker.core.Dog;
import com.gsu.dogtracker.dao.DogDao;
import com.gsu.dogtracker.gui.DogGui;

// This is our controller implementation.
// Notice that is has references to the DogGui and DogDao interfaces,
// but not any particular implementation.
public class DogGuiControllerActionListenerImpl implements DogGuiController {

	private DogGui gui;
	private DogDao dao;

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Search".equals(e.getActionCommand())) {
			search();
		} else if ("Reset".equals(e.getActionCommand())) {
			reset();
		} else if ("Add".equals(e.getActionCommand())) {
			add();
		} else {
			// Is it worth the time to make a function that is just printing one
			// line to the console?
			badButton();
		}

	}

	@Override
	public void badButton() {
		System.out.println("Bad button");
	}

	@Override
	public void add() {
		System.out.println("Hit Add");
		Dog dog = gui.getDog();
		dao.addDog(dog);
		gui.clear();
	}

	@Override
	public void reset() {
		System.out.println("Hit Reset");
		gui.clear();
	}

	@Override
	public void search() {
		System.out.println("Hit Search");
		String name = gui.getName();
		Dog dog = dao.getDog(name);
		if (dog != null) {
			gui.setDog(dog);
		} else {
			System.out.println("No match found.");
		}
	}

	@Override
	public void setGui(DogGui gui) {
		this.gui = gui;

	}

	@Override
	public void setDao(DogDao dao) {
		this.dao = dao;

	}

}
