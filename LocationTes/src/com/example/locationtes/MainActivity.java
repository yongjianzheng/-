package com.example.locationtes;

import java.util.List;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.http.*;


public class MainActivity extends Activity {
	
	
	private TextView positionTextView;
	
	private LocationManager locationManager;
	
	private String provider;
	
	public  static final int SGOW_LOCATION =0; 
  	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        positionTextView = (TextView)findViewById(R.id.position_text_view);
        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
        List<String> providerList = locationManager.getProviders(true);
        
        if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
        	provider = LocationManager.NETWORK_PROVIDER;
			
		}else if (providerList.contains(LocationManager.GPS_PROVIDER)) {
			provider =LocationManager.GPS_PROVIDER;
			
		}else {
			Toast.makeText(this, "No location provider to use", Toast.LENGTH_SHORT).show();
			return;
		}
   
        
        Location location = locationManager.getLastKnownLocation(provider);
        if(location!= null){
        	showLocation(location);
        	
        }
        locationManager.requestLocationUpdates(provider, 5000, 1, locationListener);
    }
    @Override
    protected void onDestroy() {
    	// TODO Auto-generated method stub
    	super.onDestroy();
    	if(locationManager!= null){
    		locationManager.removeUpdates(locationListener);
    	}
    }
    LocationListener locationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			showLocation(location);
			
		}
	};


	private void showLocation(final Location location) {
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//			try {
//				StringBuilder url =new StringBuilder();
//				url.append("http://maps.googleapis.com/maps/api/geocode/json?latlng=");
//				url.append(location.getLatitude()).append(",");
//				url.append(location.getLongitude());
//				url.append("&sensor = false");
//				HttpClient httpclient = new DefaultHttpClient();
//				HttpGet = new HttpGet(url.toString());
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			}
//		}).start();
		String currentPosition = "latitudes is :"+location.getLatitude()+"\n"+"longitude is "+location.getLongitude();
		positionTextView.setText(currentPosition);
		// TODO Auto-generated method stub
		
	}

}
