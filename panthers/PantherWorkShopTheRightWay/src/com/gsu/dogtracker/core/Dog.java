package com.gsu.dogtracker.core;

// Simple Dog object. I wrote lines 6-8 and made eclipse do the rest.
public class Dog {
	
	private String name;
	private String breed;
	private int age;
	
	public Dog(){
		
	}
	
	public Dog(String name, String breed, int age){
		setName(name);
		setBreed(breed);
		setAge(age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + ", age=" + age + "]";
	}
	
	
	
	
 

}
