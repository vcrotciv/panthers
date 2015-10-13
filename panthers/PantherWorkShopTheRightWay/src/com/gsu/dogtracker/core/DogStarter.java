package com.gsu.dogtracker.core;

import com.gsu.dogtracker.controller.DogGuiController;
import com.gsu.dogtracker.controller.DogGuiControllerActionListenerImpl;
import com.gsu.dogtracker.dao.DogDao;
import com.gsu.dogtracker.dao.DogDaoInMemoryImpl;
import com.gsu.dogtracker.gui.DogGui;
import com.gsu.dogtracker.gui.DogGuiSwingImpl;




public class DogStarter {
	
	// Here is where our program starts. 
	public static void main(String[] args) {
		// Once again, keeping our references as interfaces.
		DogGui gui = new DogGuiSwingImpl();
	    DogDao dao = new DogDaoInMemoryImpl();
		DogGuiController controller = new DogGuiControllerActionListenerImpl();
		
		// Connecting our pieces
		gui.setController(controller);
		controller.setDao(dao);
		controller.setGui(gui);

		gui.start();

	}

}
