package com.bigfatgradient.watchswitch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.wearable.watchface.CanvasWatchFaceService;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;


/**
 * Created by rockefeller on 12/13/14.
 * @author ericguzman
 */
public class DynamicWatchFaceService extends CanvasWatchFaceService {

    @Override
    public Engine onCreateEngine() {
        /* provide your watch face implementation */
        return new Engine();
    }

    /* implement service callback methods */
    private class Engine extends CanvasWatchFaceService.Engine {

        private Bitmap mBackgroundScaledBitmap;
        private Bitmap defaultWatchFaceImage;
        private static final String LOG_TAG = "DynamicWatchFaceEngine";

        @Override
        public void onCreate(SurfaceHolder holder) {
            /* initialize your watch face */
            defaultWatchFaceImage = BitmapFactory.decodeResource(
                    getResources(), R.drawable.gwd_logo);
            Log.i(LOG_TAG, "Creating the WatchFace engine.");
        }

        @Override
        public void onPropertiesChanged(Bundle properties) {
            /* get device features (burn-in, low-bit ambient) */
        }

        @Override
        public void onTimeTick() {
            /* the time changed */
        }

        @Override
        public void onAmbientModeChanged(boolean inAmbientMode) {
            /* the wearable switched between modes */
        }

        @Override
        public void onDraw(Canvas canvas, Rect bounds) {
            int width = bounds.width();
            int height = bounds.height();

            /* draw your watch face */
            if (mBackgroundScaledBitmap == null
                    || mBackgroundScaledBitmap.getWidth() != width
                    || mBackgroundScaledBitmap.getHeight() != height) {
                mBackgroundScaledBitmap = Bitmap.createScaledBitmap(defaultWatchFaceImage,
                        width, height, true /* filter */);
            }
            canvas.drawBitmap(mBackgroundScaledBitmap, 0, 0, null);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            /* the watch face became visible or invisible */
        }
    }
}
