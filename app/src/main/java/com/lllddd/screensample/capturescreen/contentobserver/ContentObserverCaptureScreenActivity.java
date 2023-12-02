package com.lllddd.screensample.capturescreen.contentobserver;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.lllddd.screensample.R;

import java.lang.ref.WeakReference;

public class ContentObserverCaptureScreenActivity extends AppCompatActivity {
    private ScreenCaptureObserver mObserver;

    private MyHandler mHandler;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_observer_capture_screen);

        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            mHandler = new MyHandler(Looper.getMainLooper(), this);

            mObserver = new ScreenCaptureObserver(ContentObserverCaptureScreenActivity.this, mHandler);
            mObserver.start();
        } else {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
        }
    }

    @Override
    protected void onDestroy() {
        mObserver.start();
        super.onDestroy();
    }

    static class MyHandler extends Handler {
        private WeakReference<ContentObserverCaptureScreenActivity> mReference;

        public MyHandler(Looper looper, ContentObserverCaptureScreenActivity activity) {
            super(looper);
            mReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mReference.get() == null) {
                return;
            }

            if (msg.what == 1000) {
                Toast.makeText(mReference.get(), "监听到用户截屏", Toast.LENGTH_LONG).show();
            }
        }
    }
}