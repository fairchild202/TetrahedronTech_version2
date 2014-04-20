package com.tetrahedron.ICBusVersion2;

import com.tetrahedron.ICBusVersion2.R;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.content.Intent;
import android.view.View;


public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        
    }
    
    public void onClickStop(View view){
    	startActivity(new Intent("android.intent.action.StopsActivity"));
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
    }
    	
    public void onClickNearMe(View view){
    	startActivity(new Intent("android.intent.action.NearMeActivity"));
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
		}
   
    public void onClickRoute(View view){
    	startActivity(new Intent("android.intent.action.RoutesActivity"));
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
		}	
    
    public void onClickFavoriteStop(View view){
    	startActivity(new Intent("android.intent.action.FavoriteStopActivity"));
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
		}	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
}
