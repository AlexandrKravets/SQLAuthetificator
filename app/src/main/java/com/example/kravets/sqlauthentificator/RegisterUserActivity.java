package com.example.kravets.sqlauthentificator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class RegisterUserActivity extends Activity {

	MySQLiteHelper helper = new MySQLiteHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_user);
	}

	public void onSignUpClick(View v){
		if (v.getId()==R.id.bSignup)
		{
			EditText mail = (EditText) findViewById(R.id.regName);
			EditText pass1 = (EditText) findViewById(R.id.regPassword);
			EditText pass2 = (EditText) findViewById(R.id.regConPassword);
			String username = mail.getText().toString();
			String password = pass1.getText().toString();
			String passwordConfirm = pass2.getText().toString();


			if(validate(username, password, passwordConfirm)){

			}
			else
			{
				// insert users to database
				User user = new User();
				user.setEmail(username);

				String encryptedPassword = "";
				try {
					encryptedPassword = Util.md5(password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				user.setPassword(encryptedPassword);
				helper.addUser(user);
				Toast msg = Toast.makeText(getApplicationContext(), "YOU ARE REGISTERED SUCCESSEFULLY", Toast.LENGTH_SHORT);
				msg.show();

				Intent i = new Intent(RegisterUserActivity.this, MainActivity.class);
				startActivity(i);


			}
		}
	}

	public  boolean validate (String username, String password, String passwordConfirm){
		Boolean bool = false;
		if(!password.equals(passwordConfirm))
		{
			// popup message
			Toast pass = Toast.makeText(RegisterUserActivity.this, "Passwords don't match", Toast.LENGTH_SHORT);
			pass.show();
			bool=true;
		}
		else if (username.length() < 6) {
			// popup message
			Toast pass = Toast.makeText(RegisterUserActivity.this, "Email must be over 6 characters.", Toast.LENGTH_SHORT);
			pass.show();
			bool=true;
		}

		else if (password.length() < 4) {
			// popup message
			Toast pass = Toast.makeText(RegisterUserActivity.this, "Password must be over 4 characters.", Toast.LENGTH_SHORT);
			pass.show();
			bool=true;
		}


		return bool;
	}

}




