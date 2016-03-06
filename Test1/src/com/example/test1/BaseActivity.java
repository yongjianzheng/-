package com.example.test1;


import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		ActivityCollector.addActivity(this);
		
	}
	protected void onDestory(){
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}

}
