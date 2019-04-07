package sh.bsc.hostelmanagement;

import stech.server.ServerConnection;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class SearchHostelActivity extends Activity {
	TableLayout ugrid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_hostel);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		ugrid = (TableLayout)findViewById(R.id.grid);
        try{
        String []cap ={
        		"Name", "Address","Place","Description","Book"
        };
        
        ServerConnection con = new ServerConnection();
        String dts[][] = null;
        String data = con.doPost("customer/hostels.jsp", dts);
        //System.err.println("Full : " + data);
        TableRow tr = new TableRow(this);
        tr.setBackgroundColor(Color.BLACK);
        for(String x: cap){
        	TextView td = new TextView(this);
			td.setPadding(5, 5, 5, 5);
			td.setText(x);
			td.setBackgroundColor(Color.BLUE);
			td.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tr.addView(td);
        }
        ugrid.addView(tr);
        String []recs = data.split("`");
       
        
        for(String d : recs){
        	System.err.println("Row : " + d);
        	String []rec = d.split("~");
	      tr = new TableRow(this);
	      for(int i=0;i<rec.length;i++){
	    	  if(i==0 || i==2 || i==3 ){
	    		  continue;
	    	  }
	    	  String y = rec[i];
	    	  System.err.println("Col : " + y);
	    	  TextView td = new TextView(this);
		      td.setPadding(5, 5, 5, 5);
		      td.setText(y);
		      td.setBackgroundColor(Color.LTGRAY);
		      tr.addView(td);
	      }
	      ImageView bookImg = new ImageView(this);
	      bookImg.setImageResource(R.drawable.booking_1);
	      final String bid = rec[0];
	      bookImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				go(bid);
			}
		});
	      tr.addView(bookImg);
	      ugrid.addView(tr);
        }
        }catch (Exception e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
		}
 	}
	void go(String hid){
		Intent in = new Intent(this,CreateBookingActivity.class);
		in.putExtra("hid", hid);
		startActivity(in);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_hostel, menu);
		return true;
	}

}
