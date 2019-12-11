package com.trunghtluu.selfchattingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        Intent intent = null;

        switch (view.getId()) {

            case R.id.green_button:
                intent = new Intent(this, GreenActivity.class);
                break;

            case R.id.blue_button:
                intent = new Intent(this, BlueActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
