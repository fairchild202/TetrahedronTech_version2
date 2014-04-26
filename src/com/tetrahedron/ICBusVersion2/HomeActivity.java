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
//set a link on stop button to stop page on main page// 
    public void onClickStop(View view){
    	startActivity(new Intent("android.intent.action.StopsActivity"));
    	//animation of enter stop page//
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
    }
//set a link on nearme button to nearme page on main page//    	
    public void onClickNearMe(View view){
    	startActivity(new Intent("android.intent.action.NearMeActivity"));
    	//animation of enter NearMe page//
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
		}
//set a link on route button to route page on main page//  
    public void onClickRoute(View view){
    	startActivity(new Intent("android.intent.action.RoutesActivity"));
    	//animation of enter route page//
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
		}	
//set a link on favorite button to favorite page on main page//    
    public void onClickFavoriteStop(View view){
    	startActivity(new Intent("android.intent.action.FavoriteStopActivity"));
    	//animation of enter favorite page//
		overridePendingTransition(R.anim.combine2_in, R.anim.combine2_out);
		}	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
}
