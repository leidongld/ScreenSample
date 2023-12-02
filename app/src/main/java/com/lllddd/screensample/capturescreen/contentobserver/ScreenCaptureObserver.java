package com.lllddd.screensample.capturescreen.contentobserver;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;

import androidx.annotation.NonNull;

/**
 * author: lllddd
 * created on: 2023/12/1 10:14
 * description:截屏观察者
 */
public class ScreenCaptureObserver extends ContentObserver {
    /**
     * 这个路径不同的手机不知道是否一致，我测试的时候用的VIVO NEX机型
     */
    private static final String SCREENSHOTS_DIR = Environment.getExternalStorageDirectory().toString() + "/DCIM/Screenshots/";
    private final Context mContext;

    private final ContentObserverCaptureScreenActivity.MyHandler mHandler;

    public ScreenCaptureObserver(@NonNull Context context, @NonNull ContentObserverCaptureScreenActivity.MyHandler hander) {
        super(null);
        this.mContext = context;
        this.mHandler = hander;
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange);
        if (uri.toString().matches(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString() + "/[0-9]+")) {
            try (Cursor cursor = mContext.getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                    if (index == -1) {
                        return;
                    }
                    String path = cursor.getString(index);
                    if (path != null && path.startsWith(SCREENSHOTS_DIR)) {
                        Message msg = Message.obtain();
                        msg.what = 1000;
                        mHandler.sendMessage(msg);
                    }
                }
            }
        }
    }

    public void start() {
        ContentResolver contentResolver = mContext.getContentResolver();
        contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
    }

    public void stop() {
        ContentResolver contentResolver = mContext.getContentResolver();
        contentResolver.unregisterContentObserver(this);
    }
}
