package com.example.systemlife.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.Gson;

import org.junit.experimental.categories.Category;

import butterknife.OnClick;

import static android.R.attr.category;
import static android.R.attr.name;
import static android.R.attr.x;
import static com.example.systemlife.signup.MainActivity.EXTRA_MESSAGE;
import static com.example.systemlife.signup.MainActivity.SHARED_PREF_NAME;
import static com.example.systemlife.signup.R.id.email;
import static com.example.systemlife.signup.R.id.log;
import static com.example.systemlife.signup.R.id.userName;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    EditText userName = (EditText) findViewById(R.id.userName);
    EditText pass = (EditText) findViewById(R.id.passWord);
    Button logIn = (Button) findViewById(R.id.log);
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

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
//        if (id == R.id.log) {
//            User user=new User(userName.getText().toString(),pass.getText().toString());
//            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//            SharedPreferences.Editor editor=sharedPreferences.edit();
//            //String x = sharedPreferences.getString(SHARED_PREF_NAME, null);
//            Gson gson=new Gson();
//            String theUser=gson.toJson(user);
//            //Toast.makeText(Main4Activity.this, theUser, Toast.LENGTH_LONG).show();
//            editor.putString("currentU",theUser);
//            editor.apply();
//
//            if (userName.getText().toString().equals(user.getName().toString())&&
//                    pass.getText().toString().equals(user.getPassword().toString())) {
//                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);
//                String mess = "Hello\n" + userName.getText().toString();
//                intent.putExtra(EXTRA_MESSAGE, mess);
//                startActivity(intent);
//            } else
//                Toast.makeText(this, "User name is wrong", Toast.LENGTH_LONG).show();
//        }
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
