package com.example.systemlife.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.systemlife.signup.Adapter.ChatAdapter;
import com.example.systemlife.signup.DataModel.ChatModel;
import com.google.gson.Gson;

import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.Locale;

import static com.example.systemlife.signup.MainActivity.SHARED_PREF_NAME;
import static com.example.systemlife.signup.R.id.addBtn;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    TextView infoTxt;
    EditText noteText;
    Button add_btn;
    ListView listView;
    ArrayList<ChatModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //data on infoTxt by intent
        Intent intent = getIntent();
        String text = intent.getStringExtra(Main4Activity.EXTRA_MESSAGE);
        infoTxt = (TextView) findViewById(R.id.infoTxt);
        infoTxt.setText(text);

        noteText = (EditText) findViewById(R.id.notesTxt);

        listView = (ListView) findViewById(R.id.listView);
        items = new ArrayList<>();

//        for (int i = 0; i < 5; i++) {
//            // items.add(new ChatModel(noteText.getText().toString()));
//            items.add(new ChatModel("seham"));
//        }

        ChatAdapter chat = new ChatAdapter(this, items);
        listView.setAdapter(chat);

//rewrite add_btn
        add_btn = (Button) findViewById(R.id.addBtn);
        add_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.addBtn:
                final String s = noteText.getText().toString();
                items.add(new ChatModel(s));
                ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
                //test database
                //Main4Activity.Notes notes=new Main4Activity.Notes(s);
                User user1 = new User(noteText.getText().toString());
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String theUser = gson.toJson(user1);
                editor.putString("Notes", theUser);
                editor.apply();

                noteText.setText(null);

        }

    }


}
