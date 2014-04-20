package com.tetrahedron.ICBusVersion2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.content.Intent;
import android.view.View;

public class NearMeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_near_me);
	}

    public void onClickStop(View view){
    	startActivity(new Intent("android.intent.action.StopsActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}
    public void onClickRoute(View view){
    	startActivity(new Intent("android.intent.action.RoutesActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}	
    public void onClickFavoriteStop(View view){
    	startActivity(new Intent("android.intent.action.FavoriteStopActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.near_me, menu);
		return true;
	}

}