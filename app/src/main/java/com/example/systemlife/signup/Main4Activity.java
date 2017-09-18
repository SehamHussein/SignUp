package com.example.systemlife.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.OnClick;

import static android.R.attr.name;
import static com.example.systemlife.signup.MainActivity.EXTRA_MESSAGE;
import static com.example.systemlife.signup.R.id.email;
import static com.example.systemlife.signup.R.id.log;
import static com.example.systemlife.signup.R.id.userName;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{

    EditText user=(EditText) findViewById(R.id.userName);
    EditText pass=(EditText) findViewById(R.id.passWord);
    Button logIn=(Button) findViewById(R.id.log);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();


        logIn.setOnClickListener(this);

//        logIn.setOnClickListener((View.OnClickListener) this);
//        logIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (user.getText().toString().equals(getSharedPreferences(String.valueOf(name),0))){
//                Intent i= new Intent(Main4Activity.this, Main3Activity.class);
////                String text = "Hello\n" + "i am " + user.getText() + "\n and my notes are: ";
////                i.putExtra(EXTRA_MESSAGE, text);
//                startActivity(i);
//                }
//                else {
//                    Toast.makeText(Main4Activity.this, "User Name is Wrong", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if (id==R.id.log){
            SharedPreferences sharedPreferences=getSharedPreferences(user.toString(),0);
            String x=sharedPreferences.getString("fsdfsd",null);
            if (user.getText().toString().equals(x)){
                Intent intent=new Intent(this,Main3Activity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(this,"User name is wrong",Toast.LENGTH_LONG).show();
        }
    }
}
