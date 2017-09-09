package com.example.systemlife.signup;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.photo)
    Button takePhoto;
    @BindView(R.id.gallery)
    Button fromGallery;
    @BindView(R.id.send)
    Button sendMail;
    @BindView(R.id.call)
    Button callNumber;
    @BindView(R.id.share)
    Button shareWhatsApp;
    @BindView(R.id.signup)
    Button sign;
    @BindView(R.id.firstname)
    EditText first;
    @BindView(R.id.lastname)
    EditText last;
    @BindView(R.id.email)
    EditText mail;
    @BindView(R.id.phone)
    EditText phoneNumber;
    @BindView(R.id.msg)
    EditText message;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String contentMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this)
                ;
        takePhoto.setOnClickListener(this);
        contentMail="Hellow Seham\n"+"i am "+first.getText()+" "+last.getText()+" \n and my mail is "+mail.getText()
                +"\n you can call me on "+phoneNumber.getText()+"\n and i agree to take the course";

    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.photo:
               dispatchTakePictureIntent();
                break;
            case R.id.call:
                Uri number = Uri.parse("tell:"+phoneNumber.getText());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
                break;
            case R.id.signup:
                Toast.makeText(this,"cfgcfcgv",Toast.LENGTH_SHORT).show();
                break;
            case R.id.send:
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"+mail.getText()}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, first.getText()+" "+last.getText());
                emailIntent.putExtra(Intent.EXTRA_TEXT, contentMail+"\n"+message.getText());
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris
                startActivity(emailIntent);
                break;
            case R.id.gallery:
                Intent photoIntent=new Intent(Intent.CATEGORY_APP_GALLERY);
                startActivity(photoIntent);
                break;
            case R.id.share:
                break;
        }
    }
}
