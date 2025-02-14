package sh.bsc.hostelmanagement;

//Descrption
import stech.server.ServerConnection;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BookingDetailsActivity extends Activity {
	String bid="";
	TextView bookingid,fdate,tdate,nme,hidd,roomid,roomtype,nbeds,price,avail,idprf,status;
	//EditText description;
	Button accept,reject;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booking_details);
		bookingid=(TextView)findViewById(R.id.bookingid);
		fdate=(TextView)findViewById(R.id.fdate);
		tdate=(TextView)findViewById(R.id.tdate);
		nme=(TextView)findViewById(R.id.nme);
		hidd=(TextView)findViewById(R.id.hidd);
		roomid=(TextView)findViewById(R.id.roomid);
		roomtype=(TextView)findViewById(R.id.roomtype);
		nbeds=(TextView)findViewById(R.id.nbeds);
		price=(TextView)findViewById(R.id.price);
		avail=(TextView)findViewById(R.id.avail);
		idprf=(TextView)findViewById(R.id.idprf);
		status=(TextView)findViewById(R.id.status);
		//description=(EditText)findViewById(R.id.description);
//		accept=(Button)findViewById(R.id.accept);
//		reject=(Button)findViewById(R.id.reject);
		
		Bundle b = getIntent().getExtras();
		bid = b.getString("bid");
		try{
			ServerConnection conn = new ServerConnection();
			String path = "hosteladmin/viewBooking.jsp";
			String [][]param = {
					{"bid",bid}
			};
			String dt = conn.doPost(path, param);
			String []datas = dt.split("~");
			bookingid.setText("Booking Id:  "+datas[0]);
			fdate.setText("From Date:   " + datas[1]);
			tdate.setText("To Date:         " +datas[2]);
			nme.setText("Name:            " +datas[4]);
			hidd.setText("HostelId:       " +datas[10]);
			roomid.setText("RoomId:        " +datas[3]);
			roomtype.setText("Room Type: " +datas[11]);
			nbeds.setText("No of Beds:  " +datas[16]);
			price.setText("Prize:              " +datas[12]);
			avail.setText("Availability: " +datas[13]);
			idprf.setText("Id Proof:        " +datas[6]);
			status.setText("Status:           " +datas[7]);
//			description.setText(datas[17]);
			
		}catch(Exception exc){
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.booking_details, menu);
		return true;
	}
	
	public void accept(View v){
		try{
			ServerConnection conn = new ServerConnection();
			String path = "hosteladmin/bookingStatus.jsp";
			//String des = description.getText().toString();
			String [][]param = {
					{"bid",bid},
					{"status","1"},
					//{"desc",des}
			};
			String dt = conn.doPost(path, param);
			Toast.makeText(this, dt, Toast.LENGTH_LONG).show();
		}catch(Exception exc){
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
		}
	}
	
	public void reject(View v){
		try{
			ServerConnection conn = new ServerConnection();
			String path = "hosteladmin/bookingStatus.jsp";
		//	String des = description.getText().toString();
			String [][]param = {
					{"bid",bid},
					{"status","2"},
					//{"desc",des}
			};
			String dt = conn.doPost(path, param);
			Toast.makeText(this, dt, Toast.LENGTH_LONG).show();
		}catch(Exception exc){
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
		}
	}
}
