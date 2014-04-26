package com.tetrahedron.ICBusVersion2.cards;
/*this is the class after click on each card on favorite route page, which will contain stop name in this route
you can add all stop as cards, and click on stop name go to stop page*/
import it.gmariotti.cardslib.library.internal.CardExpand;
import android.content.Context;

import com.tetrahedron.ICBusVersion2.R;

public class favoriteRouteCardExpand extends CardExpand{

	public favoriteRouteCardExpand(Context context) {
	super(context, R.layout.route_detail_expand_layout);
	}


}