package com.example.intentsimplicitos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn1:
                //Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8712830015"));
                //startActivity(i1);
                break;
            case R.id.btn2:
                Intent i2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
                startActivity(i2);
                break;
            case R.id.btn3:
                Intent i3 = new Intent(Intent.ACTION_WEB_SEARCH);
                i3.putExtra(SearchManager.QUERY, "Hola");
                startActivity(i3);
                break;
            case R.id.btn4:
                Intent intWhats = new Intent();
                intWhats.setPackage("com.whatsapp");
                startActivity(intWhats);
                break;
            case R.id.btn5:
                Intent intCamara = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intCamara);
                break;
            case R.id.btn6:
                Intent intCorreo = new Intent(Intent.ACTION_SENDTO);
                intCorreo.setData(Uri.parse("mailto:")); // only email apps should handle this
                intCorreo.putExtra(Intent.EXTRA_EMAIL, "susetha@outlook.com");
                intCorreo.putExtra(Intent.EXTRA_SUBJECT, "Hola");
                startActivity(intCorreo);
                break;
            case R.id.btn7:
                Intent intSend = new Intent();
                intSend.putExtra("Mensaje", "Hola");
                intSend.setType("text/plain");
                startActivity(Intent.createChooser(intSend, "Elige la aplicacion"));
                break;
        }
    }
}

