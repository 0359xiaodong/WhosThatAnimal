package com.example.animaldb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends Activity {
	
	Button imgBtnList, imgBtnAdd;
	DatabaseHandler db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		imgBtnList = (Button)findViewById(R.id.imageButton1);
		imgBtnAdd = (Button)findViewById(R.id.imageButton2);
		
		db = new DatabaseHandler(this);
		db.addContact(new Contact("cat", "cat", "Cat", "A small, usually furry, domesticated, and carnivorous mammal"));
		db.addContact(new Contact("dog", "dog", "Dog", "A domesticated carnivorous mammal that typically has a long snout, an acute sense of smell, and a barking, howling, or whining voice. It is widely kept as a pet or for work or field sports."));
		db.addContact(new Contact("horse", "horse", "Horse", "A solid-hoofed plant-eating domesticated mammal with a flowing mane and tail, used for riding, racing, and to carry and pull loads."));
		db.addContact(new Contact("lion", "lion", "Lion", "A large tawny-colored cat that lives in prides, found in Africa and northwestern India. "));
		db.addContact(new Contact("chicken", "chicken", "Chicken", "A domestic fowl kept for its eggs or meat, especially a young one."));
		//db.addContact(new Co)
		
		imgBtnList.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainMenu.this, AllItems.class);
				startActivity(intent);
			}
		});
		
		imgBtnAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainMenu.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}

	
}
