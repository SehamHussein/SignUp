package com.example.systemlife.signup.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.systemlife.signup.DataModel.ChatModel;
import com.example.systemlife.signup.MainActivity;
import com.example.systemlife.signup.R;

import java.util.List;

import static android.R.id.button1;
import static com.example.systemlife.signup.R.id.item;

/**
 * Created by System.Life on 9/12/2017.
 */

public class ChatAdapter extends ArrayAdapter<ChatModel>{

List<ChatModel> chatModelLis;

    public ChatAdapter(@NonNull Context context, @NonNull List<ChatModel> Objects) {
        super(context, 0, Objects);
        chatModelLis=Objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ChatModel chatModel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_row, parent, false);
        }
        final TextView PenTxt;
        TextView textView;
        final CheckBox agreeCheck;
        textView = convertView.findViewById(R.id.bodyTxt);
        PenTxt = convertView.findViewById(R.id.PendingTxt);

        agreeCheck = convertView.findViewById(R.id.doneCheck);

        Button popup=convertView.findViewById(R.id.popup);

        agreeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (agreeCheck.isChecked()){
                    PenTxt.setText("Done");
                }
                else{
                    PenTxt.setText("Pending");
                }
            }
        });
        textView.setText(chatModel.getBody());
        return convertView;

    }



}



