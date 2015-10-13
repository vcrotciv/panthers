package com.gsu.dogtracker.gui;

import com.gsu.dogtracker.controller.DogGuiController;
import com.gsu.dogtracker.core.Dog;



public interface DogGui {
	
	public abstract Dog getDog();

	public abstract String getName();

	public abstract void clear();

	public abstract void setDog(Dog dog);

	public abstract void start();

	public abstract void setController(DogGuiController controller);

}
