package com.example.animaldb;

public class Contact {
	
	//private variables
	int _id;
	String _name;
	String _phone_number;
	String _animal_name;
	String _animal_desc;
	
	// Empty constructor
	public Contact(){
		
	}
	// constructor
	public Contact(int id, String name, String _phone_number, String animal_name, String animal_desc){
		this._id = id;
		this._name = name;
		this._phone_number = _phone_number;
		this._animal_name = animal_name;
		this._animal_desc = animal_desc;
	}
	
	// constructor
	public Contact(String name, String _phone_number, String animal_name, String animal_desc){
		this._name = name;
		this._phone_number = _phone_number;
		this._animal_name = animal_name;
		this._animal_desc = animal_desc;
	}
	// getting ID5
	public int getID(){
		return this._id;
	}
	
	// setting id
	public void setID(int id){
		this._id = id;
	}
	
	// getting name
	public String getName(){
		return this._name;
	}
	
	// setting name
	public void setName(String name){
		this._name = name;
	}
	
	// getting phone number
	public String getPhoneNumber(){
		return this._phone_number;
	}
	
	// setting phone number
	public void setPhoneNumber(String phone_number){
		this._phone_number = phone_number;
	}
	
	public String getAnimalName(){
		return this._animal_name;
	}
	
	// setting phone number
	public void setAnimalName(String animal_name){
		this._animal_name = animal_name;
	}
	
	public String getAnimalDesc(){
		return this._animal_desc;
	}
	
	// setting phone number
	public void setAnimalDesc(String animal_desc){
		this._animal_desc = animal_desc;
	}
}
