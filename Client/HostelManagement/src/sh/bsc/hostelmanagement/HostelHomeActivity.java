package sh.bsc.hostelmanagement;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HostelHomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hostel_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hostel_home, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		
		return super.onMenuItemSelected(featureId, item);
	}
public void createH(View v)
{
	Intent in=new Intent(this,CreateHostelActivity.class);
	startActivity(in);
}
public void createR(View v)
{
	Intent in=new Intent(this,CreateRoomtypeActivity.class);
	startActivity(in);
}
public void createRo(View v)
{
	Intent in=new Intent(this,CreateRoomActivity.class);
	startActivity(in);
}
public void createreview(View v)
{
	Intent in=new Intent(this,CreateReviewActivity.class);
	startActivity(in);
}
public void createbooking(View v)
{
	Intent in=new Intent(this,BookingActivity.class);
	startActivity(in);
}

}
