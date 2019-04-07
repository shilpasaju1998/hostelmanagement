package sh.bsc.hostelmanagement;

import java.util.List;

import stech.server.ServerConnection;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateHostelActivity extends Activity implements LocationListener{
	EditText hname,lat,longi,add,place,desc;
	Button findl,save;
	
	//find location
	LocationManager locationMngr;
	Geocoder geo;
	float latitude=0,longitude=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_hostel);
		hname=(EditText)findViewById(R.id.hname);
		lat=(EditText)findViewById(R.id.lat);
		longi=(EditText)findViewById(R.id.longi);
		add=(EditText)findViewById(R.id.add);
		place=(EditText)findViewById(R.id.place);
		desc=(EditText)findViewById(R.id.desc);
		findl=(Button)findViewById(R.id.findl);
		save=(Button)findViewById(R.id.save);
		
		geo = new Geocoder(this);

		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_hostel, menu);
		return true;
	}
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		String tit=item.getTitle().toString();
		if(tit.equals("Create Hostel")){
			Intent in = new Intent(this,CreateHostelActivity.class);
			startActivity(in);
		}
		return super.onMenuItemSelected(featureId, item);
	}
	public void register(View v)
	{
		String hn=hname.getText().toString();
		String la=lat.getText().toString();
		String lo=longi.getText().toString();
		String adr=add.getText().toString();
		String pl=place.getText().toString();
		String des=desc.getText().toString();
		String path="hosteladmin/register.jsp";
		String[][]datas={
				{"hname",hn},
				{"lat",la},
				{"longi",lo},
				{"add",adr},
				{"place",pl},
				{"desc",des},
				
		};
		try{
			ServerConnection conn = new ServerConnection();
			String msg = conn.doPost(path, datas);
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
			
			
		}catch(Exception exc){
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
		}
	}

	public void findLocation(View v){
		getLocation();
		lat.setText(latitude+"");
		longi.setText(longitude+"");
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Updating Location"
				 , Toast.LENGTH_SHORT).show();
		 latitude = (float)location.getLatitude();
		 longitude = (float)location.getLongitude();
		add.setText("Changing Current Location: " +  latitude
				+ ", " + longitude + ", " + locationName(latitude, longitude));

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	void getLocation() {
        try {
        	locationMngr = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        	
        	// Trying GPS Location
        	if(locationMngr.isProviderEnabled(LocationManager.GPS_PROVIDER)){
        		 locationMngr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
        		 Location location =locationMngr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        		 if(location!=null){
        			 latitude = (float)location.getLatitude();
        			 longitude = (float)location.getLongitude();
        			 add.setText("Current Location(GPS): " +  latitude
        						+ ", " + longitude + ", " + locationName(latitude, longitude));
        			 
        		 }else{
//        			 loc_1.setText("GPS Location Not Available ...");
        		 }
        	}else{
//        		 loc_1.setText( "GPS Provider Not Enabled ...");
        	}
        	
        	
        	// Trying Network Location
        	if(locationMngr.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
        		 locationMngr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        		 Location location =locationMngr.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        		 if(location!=null){
        			 latitude = (float)location.getLatitude();
        			 longitude = (float)location.getLongitude();
        			 add.setText("Current Location(N/W): " + +  latitude
     						+ ", " + longitude + ", " + locationName(latitude, longitude));
        		 }else{
        			 add.setText("N/W Location Not Available ...");
        		 }
        	}else{
        		add.setText("N/W Provider Not Enabled ...");
        	}
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

	private String locationName(float latitude, float longitude) {
		String loc = "";
    	try{
    		List<Address> lst = geo.getFromLocation(latitude, longitude, 1);
    		if(lst!=null && lst.size()>0){
    			Address add = lst.get(0);
    			loc = add.getAddressLine(0);
//    					+", " + add.getPremises()
//    					+", " + add.getSubLocality() 
//    					+ "," +  add.getLocality()
//    					+ "," +  add.getCountryName();
    		}
    	}catch(Exception exc){
    		loc = exc.toString();
    	}
    	return loc;

	}

}
