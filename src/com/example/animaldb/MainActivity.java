package com.example.animaldb;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button btnPickImage, btnPickAudio, btnSave;
	private static int RESULT_LOAD_IMAGE = 1;
	final int ACTIVITY_CHOOSE_FILE = 2;
	DatabaseHandler db;
	String picturePath, filePath;
	EditText txtName, txtDesc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnPickImage = (Button)findViewById(R.id.btnImage);
		btnPickImage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(
						Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
						 
						startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		
		btnPickAudio = (Button)findViewById(R.id.btnAudio);
		btnPickAudio.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent chooseFile;
		        Intent intent;
		        chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
		        chooseFile.setType("file/*");
		        intent = Intent.createChooser(chooseFile, "Choose a file");
		        startActivityForResult(intent, ACTIVITY_CHOOSE_FILE);
			}
		});
		
		db = new DatabaseHandler(this);
		txtName = (EditText)findViewById(R.id.editText1);
		txtDesc = (EditText)findViewById(R.id.editText2);
		
		btnSave = (Button)findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Log.d("Insert: ", "Inserting ..");
				//Log.d("Files: ", filePath);
		        //db.addContact(new Contact("Ravi", "9100000000"));
				db.addContact(new Contact(picturePath, filePath, txtName.getText().toString(), txtDesc.getText().toString()));
				Intent intent = new Intent(MainActivity.this, AllItems.class);
				startActivity(intent);
			}
		});

	}

	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
            cursor.close();
             
            //ImageView imageView = (ImageView) findViewById(R.id.imgView);
            //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
         
        } else if (requestCode == ACTIVITY_CHOOSE_FILE) {
        	if (resultCode == RESULT_OK){
                Uri uri = data.getData();
                filePath = uri.getPath();
		} 
  	   
  	  }
     
     
    }

}
