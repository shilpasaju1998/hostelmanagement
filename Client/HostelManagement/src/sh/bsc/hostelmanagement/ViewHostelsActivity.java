package sh.bsc.hostelmanagement;

import stech.server.ServerConnection;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewHostelsActivity extends Activity {

	WebView hostel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_hostels);
		hostel = (WebView) findViewById(R.id.hostelWebView);
		WebSettings set = hostel.getSettings();
		set.setJavaScriptEnabled(true);
		String path= ServerConnection.sPath +  "/customer/viewHostels.jsp";
		hostel.loadUrl(path);
		hostel.setWebViewClient(new WebViewClient());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_hostels, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		String tit=item.getTitle().toString();
		Intent in=null;
		if(tit.equals("SIGNIN")){
			in=new Intent(this,LoginActivity.class);
			
		}
		else if(tit.equals("SIGNUP")){
			 in=new Intent(this,RegistrationActivity.class);
		
			
		}
		if(in!=null)	startActivity(in);	
		return super.onMenuItemSelected(featureId, item);
	}
}
