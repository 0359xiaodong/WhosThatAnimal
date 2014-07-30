package com.example.animaldb;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AllItems extends Activity {
	
	DatabaseHandler db;
	ListView listView;
	List<String> list = new ArrayList<String>();
	List<String> audio = new ArrayList<String>();
	List<String> name = new ArrayList<String>();
	List<String> desc = new ArrayList<String>();
	
	private MediaPlayer mp;
	private double startTime = 0;
	private double finalTime = 0;
	private Handler myHandler = new Handler();;
	private int forwardTime = 5000; 
	private int backwardTime = 5000;
	public static int oneTimeOnly = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_items);
		
		db = new DatabaseHandler(this);
		
		 // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();       
 
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber() + cn.getAnimalName()
            		+ cn.getAnimalDesc();
                // Writing Contacts to log
            list.add(cn.getName());
            audio.add(cn.getPhoneNumber());
            name.add(cn.getAnimalName());
            desc.add(cn.getAnimalDesc());
        Log.d("Name: ", log);
        
        }
        
        String[] stockArr = new String[list.size()];
        stockArr = list.toArray(stockArr);
        for(String s : stockArr)
            //System.out.println(s);
        
        listView = (ListView)findViewById(R.id.listView1);
        
        try {
        	listView.setAdapter(new MobileArrayAdapter(this, stockArr));
        	
        	listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                	
                	
                	 try {
                		 
                		 Toast.makeText(getApplicationContext(), "Playing sound", 
        						   Toast.LENGTH_SHORT).show();
                		 
                		 
                		 mp = new MediaPlayer();
                		 String selectedFromList =(String) (listView.getItemAtPosition(position));
                		 Toast.makeText(getApplicationContext(), selectedFromList, 
      						   Toast.LENGTH_SHORT).show();
                		 
                		 if (selectedFromList.equals("cat")) {
                			 if (mp.isPlaying()) {
 								mp.stop();
 							}
                			 
                			 mp = MediaPlayer.create(getApplicationContext(), R.raw.cat_sound);
                			 
                			 
                			 
                			 		 mp.start();
          						      finalTime = mp.getDuration();
          						      startTime = mp.getCurrentPosition();
          						      if(oneTimeOnly == 0){
          						         oneTimeOnly = 1;
          						      } 

          						     

          						      myHandler.postDelayed(UpdateSongTime,100);
						} else if (selectedFromList.equals("dog")) {
							
							if (mp.isPlaying()) {
								mp.stop();
							}
							
							 mp = MediaPlayer.create(getApplicationContext(), R.raw.dog_sound);
        			 		 mp.start();
  						      finalTime = mp.getDuration();
  						      startTime = mp.getCurrentPosition();
  						      if(oneTimeOnly == 0){
  						         oneTimeOnly = 1;
  						      } 

  						     

  						      myHandler.postDelayed(UpdateSongTime,100);
						} else if (selectedFromList.equals("horse")) {
							if (mp.isPlaying()) {
								mp.stop();
							}
							
							 mp = MediaPlayer.create(getApplicationContext(), R.raw.horse_sound);
        			 		 mp.start();
  						      finalTime = mp.getDuration();
  						      startTime = mp.getCurrentPosition();
  						      if(oneTimeOnly == 0){
  						         oneTimeOnly = 1;
  						      } 

  						     

  						      myHandler.postDelayed(UpdateSongTime,100);
						}  else if (selectedFromList.equals("chicken")) {
							
							if (mp.isPlaying()) {
								mp.stop();
							}
							
							 mp = MediaPlayer.create(getApplicationContext(), R.raw.chicken_sound);
        			 		 mp.start();
  						      finalTime = mp.getDuration();
  						      startTime = mp.getCurrentPosition();
  						      if(oneTimeOnly == 0){
  						         oneTimeOnly = 1;
  						      } 

  						     

  						      myHandler.postDelayed(UpdateSongTime,100);
						} else if (selectedFromList.equals("lion")) {
							
							if (mp.isPlaying()) {
								mp.stop();
							}
							 mp = MediaPlayer.create(getApplicationContext(), R.raw.lion_sound);
        			 		 mp.start();
  						      finalTime = mp.getDuration();
  						      startTime = mp.getCurrentPosition();
  						      if(oneTimeOnly == 0){
  						         oneTimeOnly = 1;
  						      } 

  						     

  						      myHandler.postDelayed(UpdateSongTime,100);
						} else {
							
							if (mp.isPlaying()) {
								mp.stop();
							}
			                   
		                        mp.setDataSource(audio.get(position));
		                        mp.prepare();
		                        
		                         
		                        
		                        mp.start();
						}
                		 
                		
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
              });
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(getApplicationContext(), "Ooops! Add some data!", Toast.LENGTH_SHORT).show();
		}
        
        
        
        
	}
	
	private Runnable UpdateSongTime = new Runnable() {
	      public void run() {
	         startTime = mp.getCurrentPosition();

	         myHandler.postDelayed(this, 100);
	      }
	   };

	public class MobileArrayAdapter extends ArrayAdapter<String> {
		private final Context context;
		private final String[] values;
	 
		public MobileArrayAdapter(Context context, String[] values) {
			super(context, R.layout.list_item, values);
			this.context = context;
			this.values = values;
		}
	 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
			View rowView = inflater.inflate(R.layout.list_item, parent, false);
			TextView textView = (TextView) rowView.findViewById(R.id.label);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
			//textView.setText(audio.get(position));
			textView.setText(name.get(position) + "\n" + desc.get(position));
	 
			// Change icon based on name
			String s = values[position];
			
			if (list.get(position).equals("cat")) {
				imageView.setImageResource(R.drawable.cat);
			} else if (list.get(position).equals("dog")) {
				imageView.setImageResource(R.drawable.dog);
			} else if (list.get(position).equals("chicken")) {
				imageView.setImageResource(R.drawable.chicken);
			} else if (list.get(position).equals("lion")) {
				imageView.setImageResource(R.drawable.lion);
			} else if (list.get(position).equals("horse")) {
				imageView.setImageResource(R.drawable.horse);
			} else {
				Bitmap scaledBitmap = scaleDown(BitmapFactory.decodeFile(list.get(position)), 50, true);
				
				//imageView.setImageBitmap(BitmapFactory.decodeFile(values[position]));
				imageView.setImageBitmap(scaledBitmap);	 
			}
	 
			/*System.out.println(s);
	 
			if (s.equals("WindowsMobile")) {
				//imageView.setImageResource(R.drawable.windowsmobile_logo);
			} else if (s.equals("iOS")) {
				//imageView.setImageResource(R.drawable.ios_logo);
			} else if (s.equals("Blackberry")) {
				//imageView.setImageResource(R.drawable.blackberry_logo);
			} else {
				//imageView.setImageResource(R.drawable.android_logo);
			}*/
			
			///Bitmap scaledBitmap = scaleDown(BitmapFactory.decodeFile(list.get(position)), 50, true);
			
			//imageView.setImageBitmap(BitmapFactory.decodeFile(values[position]));
			//imageView.setImageBitmap(scaledBitmap);	 
			return rowView;
		}
	}
	
	public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
	        boolean filter) {
	    float ratio = Math.min(
	            (float) maxImageSize / realImage.getWidth(),
	            (float) maxImageSize / realImage.getHeight());
	    int width = Math.round((float) ratio * realImage.getWidth());
	    int height = Math.round((float) ratio * realImage.getHeight());

	    Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
	            height, filter);
	    return newBitmap;
	}
}
