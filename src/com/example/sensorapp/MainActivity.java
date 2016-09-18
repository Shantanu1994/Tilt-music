package com.example.sensorapp;

import android.os.Bundle;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
	SensorManager sensorManager;
    Sensor sensor,sensor1;
    RelativeLayout r;
    TextView t1,t2,t3;
    MediaPlayer mp,mp1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensor1= sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		t1 = (TextView)findViewById(R.id.textView1);
		t2 = (TextView)findViewById(R.id.textView4);
		t3 = (TextView)findViewById(R.id.textView3);
		r= (RelativeLayout) findViewById(R.id.r1);
		
		mp = MediaPlayer.create(MainActivity.this, R.raw.a);
		mp1 = MediaPlayer.create(MainActivity.this, R.raw.b);
		/*ArrayAdapter<Sensor> adapter = new ArrayAdapter<Sensor>(MainActivity.this,android.R.layout.simple_list_item_1,list);
		setListAdapter(adapter);*/
														}

                      @Override
                     protected void onResume() {
	                       // TODO Auto-generated method stub
	                       super.onResume();
	                       sensorManager.registerListener(MainActivity.this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
                                               }

                      @Override
                      protected void onPause() {
                     // TODO Auto-generated method stub
                      super.onPause();
                      sensorManager.unregisterListener(this);
                      							}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}




	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float[] values = event.values;
		float x = values[0];
		int x1= (int) x;		
		float y = values[1];
		int y1 = (int) y;
		float z = values[2];
		int z1 = (int) z;
		
		
		
		if(x<-3)
		{   t1.setText("song is a");
			mp.start();
			r.setBackgroundColor(Color.RED);
	         if(mp1.isPlaying())
	         {
	        	 mp1.pause();
	         }
			
		}
		
	    if (x>3) 
		{t3.setText("song is b");
			mp1.start();
			r.setBackgroundColor(Color.GREEN);
			if(mp.isPlaying())
			{
				mp.pause();
			}
		}
		
			
		/*if(x>0 && x<2)
		{
			r.setBackgroundColor(Color.RED);
		
		}
		if (y>2 && y<4)
		{
			r.setBackgroundColor(Color.YELLOW);
		}
		if(z>1 && z<3)
		{
			r.setBackgroundColor(Color.GREEN);
		}*/
	}

}
