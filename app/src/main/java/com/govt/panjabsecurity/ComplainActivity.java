package com.govt.panjabsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ComplainActivity extends AppCompatActivity {
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);

        Button submit = findViewById(R.id.informPolice);
        Button btnCamera = findViewById(R.id.btnCamera);
        imgView = findViewById(R.id.imgView);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showComplainId();
            }
        });


        btnCamera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            }
        });
    }

    public void showComplainId(){
        TextView text = (TextView)findViewById(R.id.complainId);
        text.setText("Your Complain is sent to Police. The Complain id: 123456. Check status from main home page");
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("9916644572",null,"Text",null,null);
  }
  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imgView.setImageBitmap(bitmap);
    }
}

