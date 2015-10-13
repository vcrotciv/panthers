package com.gsu.dogtracker.dao;


import com.gsu.dogtracker.core.Dog;

public interface DogDao {
	
	public abstract Dog getDog(String name);

	public abstract void addDog(Dog dog);

}
