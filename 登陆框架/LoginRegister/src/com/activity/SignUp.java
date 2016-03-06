package com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SignUp extends Activity {
	ImageView signup;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.signup);
		signup=(ImageView)findViewById(R.id.sign);
	
	
	signup.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			
		    Intent intent=new Intent(SignUp.this,LoginActivity.class);
			startActivity(intent);
			finish();
		}
	});
}
}
