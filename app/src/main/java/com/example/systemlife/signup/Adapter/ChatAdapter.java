package com.example.systemlife.signup.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.systemlife.signup.DataModel.ChatModel;
import com.example.systemlife.signup.R;

import java.util.List;

/**
 * Created by System.Life on 9/12/2017.
 */

public class ChatAdapter extends ArrayAdapter<ChatModel> implements View.OnClickListener {

    Button addButton;
    TextView textView;
    CheckBox agreeCheck;

    public ChatAdapter(@NonNull Context context, @NonNull List<ChatModel> Objects) {
        super(context, 0, Objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ChatModel chatModel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_row, parent, false);
        }

        textView = convertView.findViewById(R.id.textView);
        addButton = convertView.findViewById(R.id.button);
        agreeCheck = convertView.findViewById(R.id.checkBox2);
        textView.setText(chatModel.getBody());
        return convertView;

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.checkBox2) {
            agreeCheck.setOnClickListener(this);
            if (agreeCheck.isChecked())
                addButton.setText("Done");
            else
                addButton.setText("Pending");
        }
    }

}



