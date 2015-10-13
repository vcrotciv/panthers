package com.gsu.dogtracker.dao;

import java.util.ArrayList;
import java.util.List;

import com.gsu.dogtracker.core.Dog;


// This is our DAO implementation.
// DAO stands for data access object,
// or to put that backwards, it's an object used to access data.
public class DogDaoInMemoryImpl implements DogDao {

	private List<Dog> dogs;

	public DogDaoInMemoryImpl() {
		dogs = new ArrayList<Dog>();
		dogs.add(new Dog("Dexter", "Mini-Schnauzer", 4));
		dogs.add(new Dog("Doakes", "Mini-Schnauzer", 3));
		dogs.add(new Dog("Cooper", "French Bulldog", 3));
		dogs.add(new Dog("Leo", "Yellow Lab", 7));
		dogs.add(new Dog("Baxter", "Black Lab", 5));
	}

	@Override
	public Dog getDog(String name) {
		for (Dog dog : dogs) {
			if (name.equals(dog.getName())) {
				return dog;
			}
		}
		return null;
	}

	@Override
	public void addDog(Dog dog) {
		if (getDog(dog.getName()) != null) {
			System.out.println("Dog already exists in our system.");

		} else {
			dogs.add(dog);
		}
	}



}
