package com.lllddd.screensample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lllddd.screensample.capturescreen.CaptureScreenActivity;
import com.lllddd.screensample.projectionscreen.ProjectionScreenActivity;
import com.lllddd.screensample.recordscreen.RecordScreenActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickProjectionScreen(View view) {
        Toast.makeText(this, "投屏部分", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ProjectionScreenActivity.class);
        startActivity(intent);
    }

    public void onClickRecordScreen(View view) {
        Toast.makeText(this, "录屏部分", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, RecordScreenActivity.class);
        startActivity(intent);
    }

    public void onClickCaptureScreen(View view) {
        Toast.makeText(this, "截屏部分", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, CaptureScreenActivity.class);
        startActivity(intent);
    }
}