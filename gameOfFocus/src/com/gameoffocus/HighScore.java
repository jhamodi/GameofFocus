package com.fallingstone2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HighScore extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highscore);
	
	TextView tv= (TextView) findViewById(R.id.tv2);
	
	DatabaseSql info = new DatabaseSql(this);
	info.open();
	String data =info.getData();
	info.close();
	tv.setText(data);

	
	
	
	
	
	
	}
	
	
	
}
