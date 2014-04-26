package com.tetrahedron.ICBusVersion2.cards;

import com.tetrahedron.ICBusVersion2.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.Card.OnCardClickListener;
//This class is for displaying the stop list, under the stop tab
//stopListCard has two components and it looks like this:
//***********************************
//* 1051(stopId)                    *
//* Communication Center(stopName)  *
//***********************************

public class stopListCard extends Card{
	//the view of stopId and stopName//
	protected TextView stopIdView;
    protected TextView stopNameView;
    //the value of stopId and stopName//
    private String stopId;
    private String stopName;
    //constructor, use custom layout in res.layout.stop_list_card//
	public stopListCard(Context context) {
        this(context, R.layout.stop_list_card);
    }
	
	public stopListCard(Context context, int layout){
		super(context, layout);
        init();
	}
	
	private void init(){

        //No Header

        //Set a OnClickListener listener
        setOnClickListener(new OnCardClickListener() {
			@Override
			public void onClick(Card card, View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getContext(), "Stop "+card.getId()+" clicked", Toast.LENGTH_SHORT).show();
			}
        });
    }
	
	@Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
		/*set stopIdView and stopNameView as the style in stop_list card by call stop_list_view_stopId and
		 stop_list view_stopName
		 */
        stopIdView = (TextView) parent.findViewById(R.id.stop_list_view_stopId);
        stopNameView=(TextView) parent.findViewById(R.id.stop_list_view_stopName);


        if (stopId!=null && stopName!=null)
            stopIdView.setText(stopId);
        	stopNameView.setText(stopName);
    }
	//this methods receive data from outside of the class//
	public void setContent(String stopId, String stopName){
		this.stopId=stopId;
		this.stopName=stopName;
	}

}