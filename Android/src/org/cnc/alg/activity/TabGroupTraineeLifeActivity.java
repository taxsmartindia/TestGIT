package org.cnc.alg.activity;


import android.content.Intent;
import android.os.Bundle;

public class TabGroupTraineeLifeActivity extends  TabGroupActivity {
           
	  @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		startChildActivity("TraineeLife", new Intent(this, TraineeExperienceActivity.class));
	}
}
