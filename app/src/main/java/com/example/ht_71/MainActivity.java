package com.example.ht_71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    Button syncButton;
    LocalTime sixAM = LocalTime.of(6, 0);
    LocalTime fourteenAM = LocalTime.of(14, 0);
    LocalTime fifteenAM = LocalTime.of(15, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        syncButton = findViewById(R.id.syncButton);
        syncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocalTime time = LocalTime.now();
                Intent intent = new Intent(Intent.ACTION_SYNC);
                if (time.isAfter(sixAM) && time.isBefore(fourteenAM))
                    intent.setData(Uri.parse("http://morning"));
                else if (time.isAfter(fourteenAM) && time.isBefore(fifteenAM))
                    intent.setData(Uri.parse("http://afternoon"));
                else if (time.isAfter(fifteenAM) && time.isBefore(sixAM))
                    intent.setData(Uri.parse("http://evening"));
                startActivity(intent);
            }
        });
    }
}