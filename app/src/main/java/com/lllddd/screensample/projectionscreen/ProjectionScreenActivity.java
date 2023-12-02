package com.lllddd.screensample.projectionscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.lllddd.screensample.R;
import com.lllddd.screensample.projectionscreen.displaymanager.DisplayManagerProjectionScreenActivity;
import com.lllddd.screensample.projectionscreen.mediarouter.MediaRouterProjectionScreenActivity;

public class ProjectionScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projection_screen);
    }

    public void onClickMediaRouter(View view) {
        Intent intent = new Intent(this, MediaRouterProjectionScreenActivity.class);
        startActivity(intent);
    }

    public void onClickDisplayManager(View view) {
        Intent intent = new Intent(this, DisplayManagerProjectionScreenActivity.class);
        startActivity(intent);
    }
}