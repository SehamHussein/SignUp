package com.example.systemlife.signup;

import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.Gson;

import static com.example.systemlife.signup.MainActivity.SHARED_PREF_NAME;


public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    EditText userName ;
    EditText pass ;
    Button logIn;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
userName= (EditText) findViewById(R.id.userName);
        pass= (EditText) findViewById(R.id.passWord);
        logIn= (Button) findViewById(R.id.log);

        Intent intent = getIntent();

        logIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.log) {

            SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
            String userData=sharedPreferences2.getString("userData",null);
            User userFromshared=new Gson().fromJson(userData,User.class);

            SharedPreferences sharedPreferences3 = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
            String userData1=sharedPreferences3.getString("userData1",null);
            User userFromshared1=new Gson().fromJson(userData1,User.class);

            if (userName.getText().toString().equals(userFromshared.getName())&&
                    pass.getText().toString().equals(userFromshared.getPassword())) {
                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                String mess = "Hello\n" + userName.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, mess);
                startActivity(intent);

            }else if (userName.getText().toString().equals(userFromshared1.getName())&&
                    pass.getText().toString().equals(userFromshared1.getPassword())){
                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                String mess = "Hello\n" + userName.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, mess);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "User name is wrong", Toast.LENGTH_LONG).show();
        }
    }

}
