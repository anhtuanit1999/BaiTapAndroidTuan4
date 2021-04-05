package com.example.baitapandroidtuan4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitapandroidtuan4.ui.main.MainFragment;
import com.example.baitapandroidtuan4.ui.main.SendingInteface;

public class MainActivity extends AppCompatActivity implements SendingInteface {
    private Fragment fragmentCenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
//        fragmentCenter = findViewById(R.id.fragment);
        Intent intent = getIntent();
        String giaTien = intent.getStringExtra("giatien");

        Bundle bundle = new Bundle();
        bundle.putString("giatien", giaTien);
    }

    @Override
    public void sendData(String data) {
//        TextView textView = setText(data);
    }
}