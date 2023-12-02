package com.lllddd.screensample.projectionscreen.displaymanager;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lllddd.screensample.R;

public class DisplayManagerProjectionScreenActivity extends AppCompatActivity {
    private DisplayManager mDisplayManager;

    private DisplayManager.DisplayListener mDisplayListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_manager_projection_screen);

        mDisplayManager = (DisplayManager) getSystemService(Context.DISPLAY_SERVICE);

        mDisplayListener = new DisplayManager.DisplayListener() {
            @Override
            public void onDisplayAdded(int displayId) {
                Toast.makeText(DisplayManagerProjectionScreenActivity.this, "投屏开始***", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDisplayRemoved(int displayId) {
                Toast.makeText(DisplayManagerProjectionScreenActivity.this, "投屏结束***", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDisplayChanged(int displayId) {
                Toast.makeText(DisplayManagerProjectionScreenActivity.this, "投屏状态变化***", Toast.LENGTH_SHORT).show();
            }
        };

        mDisplayManager.registerDisplayListener(mDisplayListener, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisplayManager != null){
            mDisplayManager.unregisterDisplayListener(mDisplayListener);
        }
    }
}