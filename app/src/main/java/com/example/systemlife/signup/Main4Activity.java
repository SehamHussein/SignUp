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
//        ActiveAndroid.initialize(this);
//        Configuration dbConfiguration = new Configuration.Builder(this).setDatabaseName("xxx.db").create();
//        ActiveAndroid.initialize(dbConfiguration);

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
        int id = view.getId();
        if (id == R.id.log) {

            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
           String s=sharedPreferences.getString("phoneNumber",null);
            SharedPreferences sharedPreferences2 = getSharedPreferences("xyz",MODE_PRIVATE);
            String userData=sharedPreferences2.getString("userData",null);
            User userFromshared=new Gson().fromJson(userData,User.class);
            if (userName.getText().toString().equals(userFromshared.getName())&&
                    pass.getText().toString().equals(userFromshared.getPassword())) {
                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
                String mess = "Hello\n" + userName.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, mess);
                startActivity(intent);
            } else
                Toast.makeText(this, "User name is wrong", Toast.LENGTH_LONG).show();
        }
    }

//    // testing table
//    @Table(name = "Notes")
//    public static class Notes extends Model {
//        @Column(name = "Name")
//        public String name;
//        @Column(name = "password")
//        public String password;
//        @Column(name = "email")
//        public String email;
//        @Column(name = "notes")
//        public String  notes;
//
//        public Notes() {
//            super();
//        }
//        public Notes(String name, String password,String email ) {
//            super();
//            this.name = name;
//            this.password = password;
//            this.email=email;
//        }
//        public Notes(String notes){
//            super();
//            this.notes=notes;
//        }
//
//    }
}
