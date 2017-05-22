package com.fallingstone2;

import android.app.Activity;
import android.os.Bundle;

public class StartGame extends Activity{
	DrawingTheBall v;
	MainActivity ma = new MainActivity();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 
	v = new DrawingTheBall(this);
	
	
		
		setContentView(v);
		
	}
}
