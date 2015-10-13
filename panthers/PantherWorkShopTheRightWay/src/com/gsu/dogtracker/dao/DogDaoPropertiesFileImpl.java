package com.gsu.dogtracker.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.gsu.dogtracker.core.Dog;



public class DogDaoPropertiesFileImpl implements DogDao{

	private Map<String, Dog> dogs;
	
	 public DogDaoPropertiesFileImpl() {
		dogs = new HashMap<String, Dog>();
		dogs = getDogsFromPropertiesFile("dogs.properties");
	}
	


	@Override
	public Dog getDog(String name) {
		return dogs.get(name);
	}

	@Override
	public void addDog(Dog dog) {
		if (dogs.get(dog.getName()) == null){
			dogs.put(dog.getName(), dog);
		}else{
			System.out.println("Dog already exists in our system.");
		}
	}


	private Map<String, Dog> getDogsFromPropertiesFile(String propertiesFile) {
		Map<String, Dog> tempMap = new HashMap<String, Dog>();
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(propertiesFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] names = prop.getProperty("names").split(",");
		String[] breeds = prop.getProperty("breeds").split(",");
		String[] ages = prop.getProperty("ages").split(",");
		
		for (int i = 0; i < names.length ; i++){
			tempMap.put(names[i], new Dog(names[i], breeds[i], Integer.parseInt(ages[i])));
		}
		
		
		return tempMap;
	}
	

}
