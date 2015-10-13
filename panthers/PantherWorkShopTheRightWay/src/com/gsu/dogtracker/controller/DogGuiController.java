package com.gsu.dogtracker.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gsu.dogtracker.dao.DogDao;
import com.gsu.dogtracker.gui.DogGui;

// I didn't make this interface. I wrote the class and used eclipse's "extract interface" tool. 
// That way I get to write the thing that does stuff, and I use my IDE to make it maintainable afterwards.
public interface DogGuiController extends ActionListener {
	
	// Using the keyword abstract is optional in an interface.
	public abstract void actionPerformed(ActionEvent e);

	public abstract void badButton();

	public abstract void add();

	public abstract void reset();

	public abstract void search();

	public abstract void setGui(DogGui gui);

	public abstract void setDao(DogDao dao);

}
