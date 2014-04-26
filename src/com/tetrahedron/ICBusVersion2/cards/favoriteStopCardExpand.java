package com.tetrahedron.ICBusVersion2.cards;
/*this is the class after click on each card on favorite stop page, which will 
contain the prediction of every route passing this stop*/
import it.gmariotti.cardslib.library.internal.CardExpand;
import android.content.Context;

import com.tetrahedron.ICBusVersion2.R;


public class favoriteStopCardExpand extends CardExpand {
	
	private String routeName="";
	private String min="";
	private int stopId=-1;
	private int upperBound=-1;

	public favoriteStopCardExpand(Context context) {
	super(context, R.layout.favorite_stop_expand_layout);
	}
}
