package com.tetrahedron.ICBusVersion2;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.ViewToClickToExpand;
import it.gmariotti.cardslib.library.view.CardListView;
import it.gmariotti.cardslib.library.internal.CardExpand;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.tetrahedron.ICBusVersion2.cards.routeListCard;
import com.tetrahedron.ICBusVersion2.cards.stopListRouteCardExpand;
import com.tetrahedron.ICBusVersion2.cards.routeListStopCardExpand;
import com.tetrahedron.ICBusVersion2.R;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class RoutesActivity extends Activity{
	
	private ArrayList<Card> routeListCoralville=new ArrayList<Card>();
	private ArrayList<Card> routeListIC=new ArrayList<Card>();
	private ArrayList<Card> routeListCambus=new ArrayList<Card>();
	private ArrayList<Card> routeListAll=new ArrayList<Card>();
	
	private String[] routeAgencies=new String[]{"Show All","Cambus","Iowa-City","Coralville"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //layout from res.layout.activity_routes//
		setContentView(R.layout.activity_routes);

		initRouteList();
		setList(routeListAll);		
	}

	//create route list//
	private void initRouteList(){
		try{
			AssetManager am=this.getAssets();
			InputStream in = am.open("allRoutes.txt");
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br= new BufferedReader(isr);
			String line = br.readLine();
			String data[];
			
			while (line != null){
				Card temp=new routeListCard(this);
				data=line.split(",");
				((routeListCard) temp).setContent(data[0]);
				temp.setId(data[0]);
				//seperate to three different part by name//
				//set card inner layout of res.layout.route_detail_expand_layout//
				if (data[2].equals("coralville")){
					temp.setBackgroundResourceId(R.drawable.card_selector_green);
					routeListStopCardExpand expand= new routeListStopCardExpand(this);
					expand.setInnerLayout(R.layout.route_detail_expand_layout);
					temp.addCardExpand(expand);
					ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupCardElement(ViewToClickToExpand.CardElementUI.CARD);
					temp.setViewToClickToExpand(viewToClickToExpand);					
					routeListCoralville.add(temp);
				}
				else if(data[2].equals("iowa-city")){
					temp.setBackgroundResourceId(R.drawable.card_selector_green);
					routeListStopCardExpand expand= new routeListStopCardExpand(this);
					expand.setInnerLayout(R.layout.route_detail_expand_layout);
					temp.addCardExpand(expand);
					ViewToClickToExpand viewToClickToExpand = ViewToClickToExpand.builder().setupCardElement(ViewToClickToExpand.CardElementUI.CARD);
					temp.setViewToClickToExpand(viewToClickToExpand);					
					routeListIC.add(temp);
				}
				else{
					temp.setBackgroundResourceId(R.drawable.card_selector_green);
					routeListStopCardExpand expand= new routeListStopCardExpand(this);
					expand.setInnerLayout(R.layout.route_detail_expand_layout);
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
	//set card array list//
	private void setList(ArrayList<Card> routeList){
		CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this,routeList);
		CardListView listView = (CardListView) findViewById(R.id.routeListView);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }
	}
	
    //set a link on nearme button to nearme page on route page// 
    public void onClickNearMe(View view){
    	startActivity(new Intent("android.intent.action.NearMeActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}
    //set a link on stop button to stop page on route page// 
    public void onClickStop(View view){
    	startActivity(new Intent("android.intent.action.StopsActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}
    //set a link on favorite button to favorite page on route page// 
    public void onClickFavoriteStop(View view){
    	startActivity(new Intent("android.intent.action.FavoriteStopActivity"));
		overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
		}	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stops, menu);
		return true;
	}
	
	
}