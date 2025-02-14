package sh.bsc.hostelmanagement;

import stech.server.ServerConnection;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class CreateReviewActivity extends Activity {
	EditText hstlid,descri;
	RatingBar rating;
	Button submit;
	String user="shilpa";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_review);
		hstlid=(EditText)findViewById(R.id.hstlid);
		descri=(EditText)findViewById(R.id.descri);
		rating=(RatingBar)findViewById(R.id.rating);
		submit=(Button)findViewById(R.id.submit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_review, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		String tit=item.getTitle().toString();
		if(tit.equals("Review")){
			Intent in = new Intent(this,CreateReviewActivity.class);
			startActivity(in);
		}
		return super.onMenuItemSelected(featureId, item);
	}
	public void review(View v){
		String hlid=hstlid.getText().toString();
		String d=descri.getText().toString();
		String ra = String.valueOf(rating.getRating());
		if(hlid.length()== 0){
			Toast.makeText(this,"Hostel Id can't be blank!" , Toast.LENGTH_SHORT).show();
			return;
		}
		if(d.length()== 0){
			Toast.makeText(this,"Please, mention your description!" , Toast.LENGTH_SHORT).show();
			return;
		}
		if(rating.getRating()== 0){
			Toast.makeText(this,"Please,rate our services!" , Toast.LENGTH_SHORT).show();
			return;
		}
		String path="customer/review.jsp";
		String[][]datas={
				{"hstlid",hlid},
				{"descri",d},
				{"rating",ra},
				{"uname",user}
	};
		try{
			ServerConnection conn = new ServerConnection();
			String msg = conn.doPost(path, datas);
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
			
			
		}catch(Exception exc){
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
		}
	}

}
