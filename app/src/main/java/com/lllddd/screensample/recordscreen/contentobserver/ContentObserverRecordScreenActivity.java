package com.lllddd.screensample.recordscreen.contentobserver;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lllddd.screensample.R;

public class ContentObserverRecordScreenActivity extends AppCompatActivity {
    private static final String LOG_TAG = "ScreenRecording";

    private ContentObserver mediaObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_observer_record_screen);

        mediaObserver = new ContentObserver(new Handler()) {
            @Override
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                if (uri != null && uri.toString().contains(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
                    // /storage/emulated/0/DCIM/Screenshots/Screenrecording_20231201_150750.mp4
                    String filePath = getRealPathFromUri(uri);
                    if (filePath.contains("Screenshots") && filePath.endsWith(".mp4")) {
                        Toast.makeText(ContentObserverRecordScreenActivity.this, "监听到用户录屏", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };

        ContentResolver contentResolver = getContentResolver();
        contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, mediaObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ContentResolver contentResolver = getContentResolver();
        contentResolver.unregisterContentObserver(mediaObserver);
    }

    private String getRealPathFromUri(Uri contentUri) {
        String[] proj = {MediaStore.Video.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            String filePath = cursor.getString(column_index);
            cursor.close();
            return filePath;
        }
    }
}