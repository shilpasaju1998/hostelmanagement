package sh.bsc.hostelmanagement;

import java.util.Calendar;

import stech.server.ServerConnection;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
//
public class CreateBookingActivity extends Activity {

	EditText fd,td,reason,idproof;
	Spinner rt1,rinf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_booking);
		fd=(EditText)findViewById(R.id.fd);
		td=(EditText)findViewById(R.id.td);
		fd.setKeyListener(null);
		td.setKeyListener(null);
		rt1=(Spinner)findViewById(R.id.rt1);
		rinf=(Spinner)findViewById(R.id.rinf);
//		reason=(EditText)findViewById(R.id.reason);
//		idproof=(EditText)findViewById(R.id.idproof);
//		
		try{
			ServerConnection conn = new ServerConnection();
			
			
			String path = "hosteladmin/roomtypes.jsp";
			String r = conn.doPost(path, null);
			String []roomtypes=r.split("`");
			for(int i=0;i<roomtypes.length;i++){
				String []tmp = roomtypes[i].split("~");
				roomtypes[i] = tmp[0] + "-" + tmp[1];
			}
			
			 ArrayAdapter<String> adpt1 = new ArrayAdapter<String>
		        (this,android.R.layout.simple_spinner_item,roomtypes);
			 rt1.setAdapter(adpt1);
			
		}catch(Exception exc){
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
			Log.e("Err: ", exc.toString());
		}
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
		
//		String p=price.getText().toString();
//		String a=availability.getText().toString();
//		String path="hosteladmin/room.jsp";
//		String hi = hid.getSelectedItem().toString();
//		String ri = rtid.getSelectedItem().toString();
//		
//		String[][]datas={
//				{"price",p},
//				{"availability",a},
//				{"hid",hi},
//				{"rtid",ri},
//		};
//		try{
//			ServerConnection conn = new ServerConnection();
//			String msg = conn.doPost(path, datas);
//			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
//			
//			
//		}catch(Exception exc){
//			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
//		}
//		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_booking, menu);
		return true;
	}

	public void fdate(View v){
		setDate(fd);
	}
	public void tdate(View v){
		setDate(td);
	}
	void setDate(final EditText txt){
		Calendar cdt = Calendar.getInstance();
    	int y = cdt.get(Calendar.YEAR);
    	int m = cdt.get(Calendar.MONTH)+1;
    	int d = cdt.get(Calendar.DATE);
    	DatePickerDialog dt = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				txt.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
				
			}
		},y,m,d);
    	
    	dt.show();
    }
   
}
