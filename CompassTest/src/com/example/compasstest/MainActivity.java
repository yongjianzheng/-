package com.example.compasstest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

	
	private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        
        Sensor magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        
        sensorManager.registerListener(listener, magneticSensor,sensorManager.SENSOR_DELAY_GAME);
        
        sensorManager.registerListener(listener, accelerometerSensor,sensorManager.SENSOR_DELAY_GAME);
       
    }
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	if(sensorManager!= null){
    		sensorManager.unregisterListener(listener);
    	}
    }
    private SensorEventListener listener = new SensorEventListener() {
    	
    	float[] accelerometerValues = new float[3];
    	float[] magneticValues = new float[3];
		
		@Override
		public void onSensorChanged(SensorEvent event) {
			if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
			    magneticValues = event.values.clone();
			}
			else if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				accelerometerValues=event.values.clone();
			}
			
//			Log.d("Mainactivity", "s"+Math.toDegrees(accelerometerValues[0]));
//			Log.d("Mainactivity", "s"+Math.toDegrees(magneticValues[0]));
			float[] R = new float [9];
			float[] values = new float [3];
			SensorManager.getRotationMatrix(R, null, accelerometerValues, magneticValues);
		//	Log.d("Mainactivity", "s"+Math.toDegrees(R[0]));
			SensorManager.getOrientation(R, values);
			
			Log.d("Mainactivity", "values[0] is "+ Math.toDegrees(values[0]));
			
		}
		
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub
			
		}
	};


}
