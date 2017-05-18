package com.example.kravets.sqlauthentificator;

import android.app.Activity;
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

			if(!password.equals(passwordConfirm))
			{
				// popup message
				Toast pass = Toast.makeText(RegisterUserActivity.this, "Passwords don't match", Toast.LENGTH_SHORT);
				pass.show();
			}

			else
			{
				// insert users to database
				User user = new User();
				user.setEmail(username);
				user.setPassword(password);

				helper.addUser(user);

			}
		}
	}
		/*Button registerBtn = (Button)findViewById(R.id.bRegister);
		registerBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText tUNAME = (EditText)findViewById(R.id.TFUserName);
				EditText tUPWD 	= (EditText)findViewById(R.id.TFPassword);
				
				String username = tUNAME.getText().toString();
				String password = tUPWD.getText().toString();
				
				String encryptedPassword = "";
				try {
					encryptedPassword = encrypt(password).toString();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				boolean isRegistered = false; */
			/*	try {
				//	isRegistered = new UserManager().execute(username, encryptedPassword).get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(isRegistered){
					Toast.makeText(getApplicationContext(), "YOU ARE REGISTERED SUCCESSEFULY", Toast.LENGTH_LONG).show();
				
				}else{
					Toast.makeText(getApplicationContext(), "YOU ARE NOT REGISTERED", Toast.LENGTH_LONG).show();
				}
			}

		});   */


	//Encrypt using SHA1 algorithm. You are free to salt it
	public static byte[] encrypt(String x) throws Exception {
	    java.security.MessageDigest d = null;
	    d = java.security.MessageDigest.getInstance("SHA-1");
	    d.reset();
	    d.update(x.getBytes());
	    return d.digest();
	  }
}
