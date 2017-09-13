package com.example.systemlife.signup.DataModel;

import android.widget.EditText;

import com.example.systemlife.signup.Main3Activity;

/**
 * Created by System.Life on 9/12/2017.
 */

public class ChatModel {
    String body;

    @Override
    public String toString() {
        return "ChatModel{" +
                ", body='" + body + '\'' +
                '}';
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ChatModel(String body) {
        this.body = body;
    }

}
