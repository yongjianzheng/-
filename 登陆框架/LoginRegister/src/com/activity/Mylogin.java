package com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class Mylogin extends Activity {
	
	TextView loginout;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.mynews);
		loginout=(TextView) findViewById(R.id.loginout);
		loginout.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(Mylogin.this,SignUp.class);
				startActivity(intent);
				finish();
			}
		});
	}
}
