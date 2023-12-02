package com.lllddd.screensample.capturescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lllddd.screensample.R;
import com.lllddd.screensample.capturescreen.contentobserver.ContentObserverCaptureScreenActivity;

public class CaptureScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_screen);
    }

    public void onClickContentObserver(View view) {
        Intent intent = new Intent(this, ContentObserverCaptureScreenActivity.class);
        startActivity(intent);
    }
}