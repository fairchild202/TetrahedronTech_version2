package com.tetrahedron.ICBusVersion2.cards;
/*this is the class after click on each card on stop page, which will 
contain the prediction of every route passing this stop*/
import com.tetrahedron.ICBusVersion2.R;

import it.gmariotti.cardslib.library.internal.CardExpand;
import android.content.Context;



public class stopListRouteCardExpand extends CardExpand {
	
	private String routeName="";
	private String min="";
	private int stopId=-1;
	private int upperBound=-1;

	public stopListRouteCardExpand(Context context) {
	//layout from res.layout.stop_detail_expand_layout//
	super(context, R.layout.stop_detail_expand_layout);
	}
}
