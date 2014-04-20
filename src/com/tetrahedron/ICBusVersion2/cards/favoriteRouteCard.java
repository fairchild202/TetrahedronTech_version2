package com.tetrahedron.ICBusVersion2.cards;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.Card.OnCardClickListener;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tetrahedron.ICBusVersion2.R;

public class favoriteRouteCard extends Card{

	protected TextView routeNameView;
    
    private String routeName;

	public favoriteRouteCard(Context context) {
        this(context, R.layout.favorite_route_card);
    }
	
	public favoriteRouteCard(Context context, int layout){
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
				Toast.makeText(getContext(), "Route "+card.getId()+" clicked", Toast.LENGTH_SHORT).show();
			}
        });
    }
	
	@Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        //Retrieve elements
        routeNameView = (TextView) parent.findViewById(R.id.route_list_view_routeName);


        if (routeName!=null)
            routeNameView.setText(routeName);
    }
	
	public void setContent(String routeName){
		this.routeName=routeName;
	}
}

