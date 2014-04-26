package com.tetrahedron.ICBusVersion2;
/*favorite part contain two part: favorite stop and favorite route, favorite stop is the main part,
customers will go this page directly y click on favorite button on other pages
*/
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardListView;

import com.tetrahedron.ICBusVersion2.cards.favoriteStopCard;
import com.tetrahedron.ICBusVersion2.cards.favoriteStopCardExpand;
import com.tetrahedron.ICBusVersion2.cards.stopListCard;
import com.tetrahedron.ICBusVersion2.cards.stopListRouteCardExpand;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class FavoriteStopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);		
		setContentView(R.layout.activity_favorite_stop);
        //layout from res.layout.activity_favorite_stops//

		ArrayList<Card> cards = new ArrayList<Card>();
		cards =setListItem();
		
		CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this,cards);
	    //find all stops, convert them into cards and return an array list of them//
		CardListView listView = (CardListView) findViewById(R.id.favoritestopListView);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);}
        }
		//this part I use allstop.txt which is same as in stop page, you can change this part to fit the favorite stop//
    	private ArrayList<Card> setListItem(){
    		ArrayList<Card> result=new ArrayList<Card>();
    		try{
    			AssetManager am=this.getAssets();
    			InputStream in = am.open("allStops.txt");
    			InputStreamReader isr = new InputStreamReader(in);
    			BufferedReader br= new BufferedReader(isr);
    			String line = br.readLine();
    			String data[];
    			while (line != null){
    				Card temp=new favoriteStopCard(this);
    				data=line.split(",");
    				((favoriteStopCard) temp).setContent(data[0],data[1]);
    				temp.setId(data[0]);
    				line=br.readLine();
    				favoriteStopCardExpand  expand = new favoriteStopCardExpand (this);
    				expand.setInnerLayout(R.layout.favorite_stop_expand_layout);
    				temp.addCardExpand(expand);
    				ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupCardElement(ViewToClickToExpand.CardElementUI.CARD);
    	            temp.setViewToClickToExpand(viewToClickToExpand);
    	            
    				result.add(temp);
    	    	}
    		}
    		catch (Exception e){}
    		return result;

    	}
	/*	Card temp=new favoriteStopCard(this);
		favoriteStopCardExpand expand = new favoriteStopCardExpand(this);
		expand.setInnerLayout(R.layout.favorite_stop_expand_layout);
		temp.addCardExpand(expand);
		ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupCardElement(ViewToClickToExpand.CardElementUI.CARD);
        temp.setViewToClickToExpand(viewToClickToExpand);
        temp.setExpanded(true);
	}*/

    //set a link on nearby button to nearby page on favorite main page// 
    public void onClickNearMe(View view){
    	startActivity(new Intent("android.intent.action.NearMeActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);   
		}
    //set a link on stop button to stop page on favorite main page// 
    public void onClickStop(View view){
    	startActivity(new Intent("android.intent.action.StopsActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);  
		}
    //set a link on route button to route page on favorite main page// 
    public void onClickRoute(View view){
    	startActivity(new Intent("android.intent.action.RoutesActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}
    //set a link on favorite route button to favorite route page on favorite main page// 
    public void onClickfavoriteRoute(View view){
    	startActivity(new Intent("android.intent.action.FavoriteRouteActivity"));
		overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_in_from_right);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stops, menu);
		return true;
	}
	
	
}
