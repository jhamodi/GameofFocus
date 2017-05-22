package com.fallingstone2;

import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	Button btnstart, btnhighscore, btnquit, btnhowtoplay;
	SoundPool sp;
	int soundscore;
	MediaPlayer logomusic;
	CheckBox cb;
	Vibrator vib;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	logomusic = MediaPlayer.create(MainActivity.this,
				R.raw.logomusic);

		logomusic.setLooping(true);
		logomusic.start();
        
		
		vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		soundscore = sp.load(this, R.raw.scoresound, 1);

		btnstart = (Button) findViewById(R.id.button1);
		
		cb = (CheckBox) findViewById(R.id.checkBox1);
		cb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(cb.isChecked()==true){
					
						logomusic.start();
						vib.vibrate(500);
					
				}else{
					logomusic.pause();
					vib.vibrate(500);
				}
				
			}
		});

		btnstart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sp.play(soundscore, 1, 1, 0,0, 1);
				Intent intent = new Intent(MainActivity.this, StartGame.class);
				startActivity(intent);
				vib.vibrate(500);
				
				
				

			}
		});

		btnhighscore = (Button) findViewById(R.id.button2);

		btnhighscore.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sp.play(soundscore, 1, 1, 0, 0, 1);
				Intent intent = new Intent(MainActivity.this, HighScore.class);
				startActivity(intent);
				vib.vibrate(500);
				

			}
		});
		btnquit = (Button) findViewById(R.id.button3);

		btnquit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sp.play(soundscore, 1, 1, 0, 0, 1);
				logomusic.stop();
				System.exit(0);

			}
		});
		btnhowtoplay = (Button) findViewById(R.id.button4);

		btnhowtoplay.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sp.play(soundscore, 1, 1, 0, 0, 1);
				Intent intent = new Intent(MainActivity.this, HowToPlay.class);
				startActivity(intent);
				vib.vibrate(500);
			}

			
		});
		


	}

}
