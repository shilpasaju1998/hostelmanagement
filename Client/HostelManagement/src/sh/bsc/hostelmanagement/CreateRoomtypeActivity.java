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
import android.widget.Toast;

public class CreateRoomtypeActivity extends Activity {
	EditText rtype,nob,des;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_roomtype);
		rtype=(EditText)findViewById(R.id.rtype);
		nob=(EditText)findViewById(R.id.nob);
		des=(EditText)findViewById(R.id.des);
		b1=(Button)findViewById(R.id.b1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_roomtype, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		String tit=item.getTitle().toString();
		if(tit.equals("Select Roomtype")){
			Intent in = new Intent(this,CreateRoomtypeActivity.class);
			startActivity(in);
		}
		return super.onMenuItemSelected(featureId, item);
	}
	public void creatertype(View v){
		String roomtype=rtype.getText().toString();
		String nobeds=nob.getText().toString();
		String description=des.getText().toString();
		
		if (roomtype.length() == 0){
			Toast.makeText(this, "Room Type can't be blank!!", Toast.LENGTH_SHORT).show();
			return;
			}
		if (nobeds.length() == 0){
			Toast.makeText(this, " Please, specify no of beds!!", Toast.LENGTH_SHORT).show();
			return;
			}
		
		String path="hosteladmin/roomtype.jsp";
		String[][]datas={
				{"rtype",roomtype},
				{"nob",nobeds},
				{"des",description},
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
