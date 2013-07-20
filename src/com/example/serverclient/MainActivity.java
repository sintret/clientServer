package com.example.serverclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.*;

public class MainActivity extends Activity {
	public String url = "http://mbahaleh.com/android_php/user.php";
	public Button login;
	public EditText username, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		login = (Button) findViewById(R.id.login);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);

		login.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				AsyncHttpClient client = new AsyncHttpClient();
				RequestParams params = new RequestParams();
				params.put("username", username.getText().toString());
				params.put("password", password.getText().toString());
				client.post(url, params, new AsyncHttpResponseHandler() {
					@Override
					public void onSuccess(String response) {
						// System.out.println(response);
						Toast.makeText(getBaseContext(), response,
								Toast.LENGTH_LONG).show();
					}
				});

			}

		});

	}

}
