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
import android.widget.RadioButton;
import android.widget.Toast;

public class RegistrationActivity extends Activity {
	EditText mail, pwd, confpwd, name, address, desri, contact;
	RadioButton rdhstl, rdcust;
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		mail = (EditText) findViewById(R.id.mail);
		pwd = (EditText) findViewById(R.id.pwd);
		confpwd = (EditText) findViewById(R.id.confpwd);
		name = (EditText) findViewById(R.id.name);
		address = (EditText) findViewById(R.id.address);
		desri = (EditText) findViewById(R.id.desri);
		contact = (EditText) findViewById(R.id.contact);
		rdhstl = (RadioButton) findViewById(R.id.rdhstl);
		rdcust = (RadioButton) findViewById(R.id.rdcust);
		b1 = (Button) findViewById(R.id.b2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		String tit = item.getTitle().toString();
		if (tit.equals("SIGNIN")) {
			Intent in = new Intent(this, LoginActivity.class);
			startActivity(in);
		}
		return super.onMenuItemSelected(featureId, item);
	}

	public void register(View v) {
		String ma = mail.getText().toString().trim();
		String pass = pwd.getText().toString().trim();
		String conf = confpwd.getText().toString().trim();
		String na = name.getText().toString().trim();
		String add = address.getText().toString().trim();
		String des = desri.getText().toString().trim();
		String con = contact.getText().toString().trim();

		if (ma.length() == 0) {
			Toast.makeText(this, "Mail Id can't be blank !!", Toast.LENGTH_SHORT).show();
			return;
		}
		if (pass.length() == 0) {
			Toast.makeText(this, "Password can't be blank !!", Toast.LENGTH_SHORT).show();
			return;
		}
		if (!pass.equals(conf)) {
			Toast.makeText(this, "Password not matching !!", Toast.LENGTH_SHORT).show();
			return;
		}

		if (na.length() == 0) {
			Toast.makeText(this, "Name can't be blank !!", Toast.LENGTH_SHORT).show();
			return;
		}
		if (add.length() == 0) {
			Toast.makeText(this, "Address can't be blank !!", Toast.LENGTH_SHORT).show();
			return;
		}
		if (des.length() == 0) {
			Toast.makeText(this, "Description can't be blank !!", Toast.LENGTH_SHORT).show();
			return;
		}
		if (con.length() == 0) {
			Toast.makeText(this, "Contact can't be blank !!", Toast.LENGTH_SHORT).show();
			return;
		}

		
		boolean isMail = true;
		if (ma.indexOf(".") == -1)
			isMail = false;
		if (ma.indexOf("@") == -1)
			isMail = false;
		if (ma.lastIndexOf(".") - ma.lastIndexOf("@") < 2)
			isMail = false;
		if (!isMail) {
			Toast.makeText(this, "Invalid Mail", Toast.LENGTH_SHORT).show();
			return;
		}
		String cat = "4";
		if (rdcust.isChecked()) {
			cat = "2";
		}
		String path = "guest/register.jsp";
		String[][] datas = { { "mail", ma }, { "pwd", pass }, { "cat", cat },
				{ "name", na }, { "address", add }, { "desri", des },
				{ "contact", con }, };
		try {
			ServerConnection conn = new ServerConnection();
			String msg = conn.doPost(path, datas);
			if (msg.equals("Message: Saved")) {
				Intent in = new Intent(this, ViewHostelsActivity.class);
				startActivity(in);
			}
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

		} catch (Exception exc) {
			Toast.makeText(this, exc.toString(), Toast.LENGTH_LONG).show();
		}
	}
}
