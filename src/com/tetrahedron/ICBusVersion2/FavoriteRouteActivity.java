package com.tetrahedron.ICBusVersion2;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardListView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.tetrahedron.ICBusVersion2.cards.favoriteRouteCard;
import com.tetrahedron.ICBusVersion2.cards.favoriteRouteCardExpand;
import com.tetrahedron.ICBusVersion2.cards.routeListCard;
import com.tetrahedron.ICBusVersion2.cards.routeListStopCardExpand;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class FavoriteRouteActivity extends Activity {


	private ArrayList<Card> routeListCoralville=new ArrayList<Card>();
	private ArrayList<Card> routeListIC=new ArrayList<Card>();
	private ArrayList<Card> routeListCambus=new ArrayList<Card>();
	private ArrayList<Card> routeListAll=new ArrayList<Card>();
	
	private String[] routeAgencies=new String[]{"Show All","Cambus","Iowa-City","Coralville"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);		
		setContentView(R.layout.activity_favorite_route);

		initRouteList();
		setList(routeListAll);
		
		/*
		//create a key-value bundle and pass the bundle to the fragment
		Bundle bd = new Bundle();
		bd.putStringArrayList("key", data);
		f.setArguments(bd);*/
	}

	
	private void initRouteList(){
		try{
			AssetManager am=this.getAssets();
			InputStream in = am.open("allRoutes.txt");
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br= new BufferedReader(isr);
			String line = br.readLine();
			String data[];
			
			while (line != null){
				Card temp=new favoriteRouteCard(this);
				data=line.split(",");
				((favoriteRouteCard) temp).setContent(data[0]);
				temp.setId(data[0]);
				
				if (data[2].equals("coralville")){
					temp.setBackgroundResourceId(R.drawable.favorite_background);
					favoriteRouteCardExpand expand= new favoriteRouteCardExpand(this);
					expand.setInnerLayout(R.layout.favorite_route_expand_layout);
					temp.addCardExpand(expand);
					ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupCardElement(ViewToClickToExpand.CardElementUI.CARD);
					temp.setViewToClickToExpand(viewToClickToExpand);					
					routeListCoralville.add(temp);
				}
				else if(data[2].equals("iowa-city")){
					temp.setBackgroundResourceId(R.drawable.favorite_background);
					favoriteRouteCardExpand expand= new favoriteRouteCardExpand(this);
					expand.setInnerLayout(R.layout.favorite_route_expand_layout);
					temp.addCardExpand(expand);
					ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupCardElement(ViewToClickToExpand.CardElementUI.CARD);
					temp.setViewToClickToExpand(viewToClickToExpand);					
					routeListIC.add(temp);
				}
				else{
					temp.setBackgroundResourceId(R.drawable.favorite_background);
					favoriteRouteCardExpand expand= new favoriteRouteCardExpand(this);
					expand.setInnerLayout(R.layout.favorite_route_expand_layout);
					temp.addCardExpand(expand);
					ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupCardElement(ViewToClickToExpand.CardElementUI.CARD);
					temp.setViewToClickToExpand(viewToClickToExpand);					
					routeListCambus.add(temp);
				}
				routeListAll.add(temp);
				line=br.readLine();
			}
		}
		catch (Exception e){}
		
		
	}
	
	private void setList(ArrayList<Card> routeList){
		CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this,routeList);
		CardListView listView = (CardListView) findViewById(R.id.routeListView);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }
	}

    public void onClickNearMe(View view){
    	startActivity(new Intent("android.intent.action.NearMeActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);   
		}
    public void onClickStop(View view){
    	startActivity(new Intent("android.intent.action.StopsActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);  
		}
    public void onClickRoute(View view){
    	startActivity(new Intent("android.intent.action.RoutesActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}
    public void onClickfavoriteStop(View view){
    	startActivity(new Intent("android.intent.action.FavoriteStopActivity"));
		overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_in_from_left);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stops, menu);
		return true;
	}
	
	
}
