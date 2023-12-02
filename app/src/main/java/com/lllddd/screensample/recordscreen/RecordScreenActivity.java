package com.lllddd.screensample.recordscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lllddd.screensample.R;
import com.lllddd.screensample.recordscreen.contentobserver.ContentObserverRecordScreenActivity;

public class RecordScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_screen);
    }

    public void onClickMediaProjection(View view) {

    }

    public void onClickContentObserver(View view) {
        Intent intent = new Intent(this, ContentObserverRecordScreenActivity.class);
        startActivity(intent);
    }
}