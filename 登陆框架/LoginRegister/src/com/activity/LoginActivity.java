package com.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.service.UserService;


public class LoginActivity extends Activity {
	EditText username;
	EditText password;
	Button login,register;
	ImageView log;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.login);
		findViews();
	}
	private void findViews() {
		log=(ImageView) findViewById(R.id.log);
		username=(EditText) findViewById(R.id.username);
		password=(EditText) findViewById(R.id.password);
		login=(Button) findViewById(R.id.login);
		register=(Button) findViewById(R.id.register);
		login.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String name=username.getText().toString();
				String pass=password.getText().toString();
				Log.i("TAG",name+"_"+pass);
				UserService uService=new UserService(LoginActivity.this);
				boolean flag=uService.login(name, pass);
				if(flag){
					Log.i("TAG","��¼�ɹ�");
					Toast.makeText(LoginActivity.this, "��¼�ɹ�", Toast.LENGTH_LONG).show();
					Intent intent=new Intent(LoginActivity.this,Mylogin.class);
					startActivity(intent);
					finish();
				}else{
					Log.i("TAG","��¼ʧ��");
					Toast.makeText(LoginActivity.this, "��¼ʧ��", Toast.LENGTH_LONG).show();
				}
			}
		});
		register.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
				finish();
			}
		});
		log.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent=new Intent(LoginActivity.this,SignUp.class);
				startActivity(intent);
				finish();
			}
		});
	}

}
