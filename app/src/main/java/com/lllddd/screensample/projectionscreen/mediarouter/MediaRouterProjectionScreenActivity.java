package com.lllddd.screensample.projectionscreen.mediarouter;

import android.content.Context;
import android.media.MediaRouter;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lllddd.screensample.R;

public class MediaRouterProjectionScreenActivity extends AppCompatActivity {
    private MediaRouter mMediaRouter;

    private MediaRouter.Callback mMediaRouterCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_router_projection_screen);

        mMediaRouter = (MediaRouter) getSystemService(Context.MEDIA_ROUTER_SERVICE);

        mMediaRouterCallback = new MediaRouter.Callback() {
            @Override
            public void onRouteSelected(MediaRouter router, int type, MediaRouter.RouteInfo info) {
                Toast.makeText(MediaRouterProjectionScreenActivity.this, "投屏开始***", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRouteUnselected(MediaRouter router, int type, MediaRouter.RouteInfo info) {
                Toast.makeText(MediaRouterProjectionScreenActivity.this, "投屏结束***", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRouteAdded(MediaRouter router, MediaRouter.RouteInfo info) {

            }

            @Override
            public void onRouteRemoved(MediaRouter router, MediaRouter.RouteInfo info) {

            }

            @Override
            public void onRouteChanged(MediaRouter router, MediaRouter.RouteInfo info) {

            }

            @Override
            public void onRouteGrouped(MediaRouter router, MediaRouter.RouteInfo info, MediaRouter.RouteGroup group, int index) {

            }

            @Override
            public void onRouteUngrouped(MediaRouter router, MediaRouter.RouteInfo info, MediaRouter.RouteGroup group) {

            }

            @Override
            public void onRouteVolumeChanged(MediaRouter router, MediaRouter.RouteInfo info) {

            }

        };

        mMediaRouter.addCallback(MediaRouter.ROUTE_TYPE_LIVE_VIDEO, mMediaRouterCallback);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaRouter != null) {
            mMediaRouter.removeCallback(mMediaRouterCallback);
        }
    }
}