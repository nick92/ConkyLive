package com.example.conkylive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;

public class AnimationWallpaper extends WallpaperService {

	@Override
	public Engine onCreateEngine() {
		return new AnimationEngine();
	}

	protected class AnimationEngine extends Engine {
		private Handler mHandler = new Handler();

		private Runnable mIteration = new Runnable() {
			public void run() {
				iteration();
				drawFrame();
			}
		};
		
		private boolean mVisible;
		private int offsetX;
		private int offsetY;
		private int height;
		private int width;
		private int visibleWidth;
		private Paint paint = new Paint();
		private int iterationCount;
		int x = (int) (width * Math.random());
		int y = (int) (height * Math.random());
		String text;
		IntentFilter filter;
		Intent it;
		Resources res = getResources();
		getInfo info = new getInfo();

		public AnimationEngine() {
			paint.setAntiAlias(true);
			paint.setColor(Color.BLUE);
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeJoin(Paint.Join.ROUND);
			paint.setStrokeWidth(10f);
			mHandler.post(mIteration);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
			// stop the animation
			mHandler.removeCallbacks(mIteration);
		}

		@Override
		public void onVisibilityChanged(boolean visible) {
			mVisible = visible;
			if (visible) {
				iteration();
				drawFrame();
			} else {
				// stop the animation
				mHandler.removeCallbacks(mIteration);
			}
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			this.height = height;
			this.width = width;
			iteration();
			drawFrame();
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
			mVisible = false;
			// stop the animation
			mHandler.removeCallbacks(mIteration);
		}

		@Override
		public void onOffsetsChanged(float xOffset, float yOffset,
				float xOffsetStep, float yOffsetStep, int xPixelOffset,
				int yPixelOffset) {
			iteration();
			drawFrame();
		}

		protected void iteration() {
			// Reschedule the next redraw in 40ms
			mHandler.removeCallbacks(mIteration);
			if (mVisible) {
				mHandler.postDelayed(mIteration, 1000 / 25);
			}
		}

		protected void drawFrame() {
			SurfaceHolder holder = getSurfaceHolder();

			Canvas c = null;
			try {
				c = holder.lockCanvas();
				if (c != null) {
					c.drawBitmap(BitmapFactory.decodeResource(getResources(),
							R.drawable.image1), 0, 0, null);
					draw(c);
				}
			} finally {
				if (c != null)
					holder.unlockCanvasAndPost(c);
			}
		}

		private void draw(Canvas c) {
			c.save();
			TypedArray a = obtainStyledAttributes(R.styleable.ColorMixer);  
			String string = a.getString(R.styleable.ColorMixer_colorString);
			
			Typeface tf = Typeface.create("Helvetica", Typeface.BOLD);
			paint.setAntiAlias(true);
			Date d = new Date();
			filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
			it = registerReceiver(null, filter);
			int level = it.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
			int temperature = it.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
			
			String cpu = info.getCPUInfo();
			String mem = info.getMemInfo();
			int sdcard = info.getSDInfo();
			String time = String.format(res.getString(R.string.time_string), level);
			// paint the fill
			paint.setColor(Color.BLACK);
			paint.setTextSize(20);
			paint.setStyle(Paint.Style.FILL);
			
			paint.setTypeface(tf);
			c.drawText("SDCard: "+sdcard+"MB",width/2,300,paint);
			c.drawText(
					"Time: " + d.getHours() + ":" + d.getMinutes() + ":"
							+ d.getSeconds(), width / 2, 180, paint);
			c.drawText("Battery: "+level+"%", width/2, 200, paint);
			// c.drawText(time, width/2, 200, paint);
			c.drawText("Health: " + temperature, width / 2, 240, paint);
			c.drawText("CPU: " + cpu, width / 2, 260, paint);
			c.drawText(mem, width / 2, 280, paint);
			paint.setColor(Color.argb(127, 0, 0, 200));
			paint.setStyle(Paint.Style.FILL_AND_STROKE);
			c.drawCircle(100, 150, 50, paint);
			paint.setColor(Color.argb(127, 255, 0, 255));
			paint.setStyle(Paint.Style.STROKE);
			paint.setStrokeWidth(3.0f);
			c.drawCircle(100, 150, 50, paint);
			c.restore();
			a.recycle();
		}
	}
}