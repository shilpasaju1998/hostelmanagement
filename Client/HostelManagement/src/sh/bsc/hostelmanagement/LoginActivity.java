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

public class LoginActivity extends Activity {
EditText username,psd;
Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        psd=(EditText)findViewById(R.id.psd);
        b2=(Button)findViewById(R.id.b2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    @Override
    	public boolean onMenuItemSelected(int featureId, MenuItem item) {
    		String tit = item.getTitle().toString();
    		Intent in = null;
    		if(tit.equals("SIGNUP")){
    			in =  new Intent(this,RegistrationActivity.class);
    		}else if(tit.equals("Search Hostel")){
    			in =  new Intent(this,SearchHostelActivity.class);
    		}
    		if(in!=null){
    			startActivity(in);
    		}
    		return super.onMenuItemSelected(featureId, item);
    	}
    public void login(View v)
    {
    	String user=username.getText().toString();
    	String ps=psd.getText().toString();
    	String path="guest/login.jsp";
    	String [][]datas ={
    			{"username",user},
    			{"psd",ps}
    	};
    	try{
    		ServerConnection conn = new ServerConnection();
    		String msg = conn.doPost(path, datas);
    		Intent in = null;
    		if(msg.equals("1")){
    			in = new Intent(this,AdminHomeActivity.class);
    		}else if(msg.equals("3")){
    			Toast.makeText(this, "Inactivated User !!", Toast.LENGTH_LONG).show();
    		}else if(msg.equals("2")){
    			in = new Intent(this,UsersActivity.class);
    		}else if(msg.equals("4")){
    			Toast.makeText(this, "Inactivated User !!", Toast.LENGTH_LONG).show();
    		}else if(msg.equals("5")){
    			in = new Intent(this,HostelHomeActivity.class);
    		}else{
    			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    		}
    		if(in!=null){
    			startActivity(in);
    		}
    	}catch(Exception exc){
    		Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
    	}
     }
    
    
}
