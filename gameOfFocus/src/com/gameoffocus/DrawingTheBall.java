package com.fallingstone2;

import java.util.ArrayList;
import java.util.Random;

import android.R.array;
import android.R.drawable;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.app.AlertDialog;


public class DrawingTheBall extends View {

	Bitmap bball;

	static int x, y, y1, x1, y2, x2, x3, y3, x4, y4;

	int score;
	boolean Gameover = false;
	MainActivity ma = new MainActivity();
	
	
	
	public DrawingTheBall(Context context) {
		
		
		

		

		super(context);

		// TODO Auto-generated constructor stub

		bball = BitmapFactory.decodeResource(getResources(), R.drawable.stone);

		x = 0;
		y = 0;

		x1 = 200;
		y1 = 0;

		x2 = 400;
		y2 = 0;

	}

	@Override
	protected void onDraw(Canvas canvas) {
		
	
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		if (y < canvas.getHeight()) {
			// y += 10;
			y = (y + 10) + (score / 100);

		} else if (y > canvas.getHeight()) {
			// y = 0;
			Gameover = true;

		}
		if (y1 < canvas.getHeight()) {
			// y1 += 12;
			y1 = (y1 + 12) + (score / 100);
		} else if (y1 > canvas.getHeight()) {
			// y1 = 0;
			Gameover = true;

		}
		if (y2 < canvas.getHeight()) {
			// y2 += 14;
			y2 = (y2 + 14) + (score / 100);
		} else if (y2 > canvas.getHeight()) {
			// y2 = 0;
			Gameover = true;

		}
	

		canvas.drawBitmap(bball, x, y, new Paint());

		canvas.drawBitmap(bball, x1, y1, new Paint());

		canvas.drawBitmap(bball, x2, y2, new Paint());

		Paint textPaint = new Paint();
		textPaint.setARGB(200, 254, 0, 0);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		if (Gameover == false) {

			canvas.drawText("Score: " + score, canvas.getWidth() / 2,
					(canvas.getHeight() - 200), textPaint);

			score++;
		} else {
			
			
			textPaint.setTextSize(40);

			canvas.drawText("Game over", canvas.getWidth() / 2,
					(canvas.getHeight() - 300), textPaint);

			canvas.drawText("your score is : " + score, canvas.getWidth() / 2,
					(canvas.getHeight() - 200), textPaint);

			DatabaseSql dbs = new DatabaseSql(getContext());
			dbs.open();
			dbs.createEntry(score);
			dbs.close();
			
			
			
			

		}

		invalidate();

		setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {

				Random randGen = new Random(); 
				int random = randGen.nextInt(400) ;
				

				if (event.getX() >= x && event.getY() >= y
						&& event.getX() <= x + 100 && event.getY() <= y + 80) {

					
					y = 0;
					x = random;
					


				}

				if (event.getX() >= x1 && event.getY() >= y1
						&& event.getX() <= x1 + 100 && event.getY() <= y1 + 80) {
					
					y1 = 0;
					x1 = random;
					

				}

				if (event.getX() >= x2 && event.getY() >= y2
						&& event.getX() <= x2 + 100 && event.getY() <= y2 + 80) {
					
					y2 = 0;
					x2 = random;
					

				}

				return true;
			}
		});

	}

}
