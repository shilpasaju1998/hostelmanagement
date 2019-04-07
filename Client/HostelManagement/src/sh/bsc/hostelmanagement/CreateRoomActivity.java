package sh.bsc.hostelmanagement;

import stech.server.ServerConnection;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateRoomActivity extends Activity {
Spinner hid,rtid;
EditText price,availability;
Button b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_room);
		hid=(Spinner)findViewById(R.id.hid);
		rtid=(Spinner)findViewById(R.id.rtid);
		price=(EditText)findViewById(R.id.price);
		availability=(EditText)findViewById(R.id.availability);
		b3=(Button)findViewById(R.id.b3);
		try{
			ServerConnection conn = new ServerConnection();
			String path = "customer/hostels.jsp";
			String h = conn.doPost(path, null);
			String []hostels=h.split("`");
			for(int i=0;i<hostels.length;i++){
				String []tmp = hostels[i].split("~");
				hostels[i] = tmp[0] + "-" + tmp[1];
			}
			
			path = "hosteladmin/roomtypes.jsp";
			String r = conn.doPost(path, null);
			String []roomtypes=r.split("`");
			for(int i=0;i<roomtypes.length;i++){
				String []tmp = roomtypes[i].split("~");
				roomtypes[i] = tmp[0] + "-" + tmp[1];
			}
			ArrayAdapter<String> adpt1 = new ArrayAdapter<String>
		        (this,android.R.layout.simple_spinner_item,hostels);
			 ArrayAdapter<String> adpt2 = new ArrayAdapter<String>
		        (this,android.R.layout.simple_spinner_item,roomtypes);
			 hid.setAdapter(adpt1);
			 rtid.setAdapter(adpt2);
		}catch(Exception exc){
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
			Log.e("Err: ", exc.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_room, menu);
		return true;
	}
	@Override
		public boolean onMenuItemSelected(int featureId, MenuItem item) {
		String tit=item.getTitle().toString();
		if(tit.equals("Select Room")){
			Intent in = new Intent(this,CreateRoomActivity.class);
			startActivity(in);
		}
			return super.onMenuItemSelected(featureId, item);
		}
	public void createroom(View v)
	{
		
		String p=price.getText().toString();
		String a=availability.getText().toString();
		String path="hosteladmin/room.jsp";
		String hi = hid.getSelectedItem().toString();
		String ri = rtid.getSelectedItem().toString();
		
		String[][]datas={
				{"price",p},
				{"availability",a},
				{"hid",hi},
				{"rtid",ri},
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
