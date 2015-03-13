package gpa.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

import android.widget.TextView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//FADE_IN VIEWS
		TextView logo1 = (TextView) findViewById(R.id.textView1);
		TextView logo2 = (TextView) findViewById(R.id.textView3);
		
		Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
		fade2.setAnimationListener(new AnimationListener() {
			//TRANSITION TO MENU
			public void onAnimationEnd(Animation animation) {
			startActivity(new Intent(SplashActivity.this,
			LoginActivity.class));
			SplashActivity.this.finish();
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			});
		
		logo1.startAnimation(fade1);
		logo2.startAnimation(fade2);
		
	}
	@Override
	protected void onPause() {
	super.onPause();
	// Stop the animation
	TextView logo1 = (TextView) findViewById(R.id.textView1);
	logo1.clearAnimation();
	TextView logo2 = (TextView) findViewById(R.id.textView3);
	logo2.clearAnimation();
	// ... stop other animations
}
	
	
	
}
	


