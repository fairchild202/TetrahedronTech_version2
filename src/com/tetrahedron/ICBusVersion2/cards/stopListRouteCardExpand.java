package com.tetrahedron.ICBusVersion2.cards;

import com.tetrahedron.ICBusVersion2.R;

import it.gmariotti.cardslib.library.internal.CardExpand;
import android.content.Context;



public class stopListRouteCardExpand extends CardExpand {
	
	private String routeName="";
	private String min="";
	private int stopId=-1;
	private int upperBound=-1;

	public stopListRouteCardExpand(Context context) {
	super(context, R.layout.stop_detail_expand_layout);
	}
}
