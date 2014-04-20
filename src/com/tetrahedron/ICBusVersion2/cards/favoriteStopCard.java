package com.tetrahedron.ICBusVersion2.cards;


	import com.tetrahedron.ICBusVersion2.R;

	import android.content.Context;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.TextView;
	import android.widget.Toast;
	import it.gmariotti.cardslib.library.internal.Card;
	import it.gmariotti.cardslib.library.internal.Card.OnCardClickListener;

	public class favoriteStopCard  extends Card{
		protected TextView stopIdView;
	    protected TextView stopNameView;
	    
	    private String stopId;
	    private String stopName;

		public favoriteStopCard(Context context) {
	        this(context, R.layout.favorite_stop_card);
	    }
		
		public favoriteStopCard(Context context, int layout){
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

	        //Retrieve elements
	        stopIdView = (TextView) parent.findViewById(R.id.stop_list_view_stopId);
	        stopNameView=(TextView) parent.findViewById(R.id.stop_list_view_stopName);
	        //mSecondaryTitle = (TextView) parent.findViewById(R.id.carddemo_myapps_main_inner_secondaryTitle);


	        if (stopId!=null && stopName!=null)
	            stopIdView.setText(stopId);
	        	stopNameView.setText(stopName);
	    }
		
		public void setContent(String stopId, String stopName){
			this.stopId=stopId;
			this.stopName=stopName;
		}

	}