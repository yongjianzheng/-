package com.example.acclerometersensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        
        sensorManager.registerListener(listener, sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	if(sensorManager!=null){
    		sensorManager.unregisterListener(listener);
    	}
    }
    SensorEventListener listener = new SensorEventListener() {
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			// TODO Auto-generated method stub
			float xValue = Math.abs(event.values[0]);
			float yValue =  Math.abs(event.values[1]);
			float zValue = Math.abs(event.values[2]);
			if(xValue>15|| yValue>15|| zValue>15){
				Toast.makeText(MainActivity.this, "摇一摇", Toast.LENGTH_SHORT).show();
			}
			
		}
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};


    }

