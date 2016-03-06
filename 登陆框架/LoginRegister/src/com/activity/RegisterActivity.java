package com.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.domain.User;
import com.service.UserService;

public class RegisterActivity extends Activity {
	EditText username;
	EditText password;
	EditText age;
	RadioGroup sex;	
	Button register;
	ImageView regToLogin;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		findViews();
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=username.getText().toString().trim();
				String pass=password.getText().toString().trim();
				String agestr=age.getText().toString().trim();
				String sexstr=((RadioButton)RegisterActivity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
				
				Log.i("TAG",name+"_"+pass+"_"+agestr+"_"+sexstr);
				UserService uService=new UserService(RegisterActivity.this);
				User user=new User();
				user.setUsername(name);
				user.setPassword(pass);
				user.setAge(Integer.parseInt(agestr));
				user.setSex(sexstr);
				uService.register(user);
				Toast.makeText(RegisterActivity.this, "×¢²á³É¹¦", Toast.LENGTH_LONG).show();
				Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
				startActivity(intent);
				finish();
			
			}
		});
		
		regToLogin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
			    Intent intent=new Intent(RegisterActivity.this,SignUp.class);
				startActivity(intent);
				finish();
			}
		});
		
		
	}
	private void findViews() {
		username=(EditText) findViewById(R.id.usernameRegister);
		password=(EditText) findViewById(R.id.passwordRegister);
		age=(EditText) findViewById(R.id.ageRegister);
		sex=(RadioGroup) findViewById(R.id.sexRegister);
		register=(Button) findViewById(R.id.Register);
		regToLogin=(ImageView) findViewById(R.id.regToLogin);
	}

}
