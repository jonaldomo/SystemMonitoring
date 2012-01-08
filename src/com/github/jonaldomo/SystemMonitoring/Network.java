package com.github.jonaldomo.SystemMonitoring;

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Network extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView lv = (ListView) findViewById(R.id.list);

		String[] menuItems = getResources().getStringArray(
				R.array.network_items);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				InetAddress localhost = null;
				try {
					localhost = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				switch ((int) id) {
				case 0:
					Toast.makeText(getApplicationContext(),
							localhost.getHostAddress(), Toast.LENGTH_SHORT)
							.show();
					break;
				case 1:
					Toast.makeText(getApplicationContext(),
							localhost.getHostName(), Toast.LENGTH_SHORT)
							.show();
					break;
				case 2:
					Toast.makeText(getApplicationContext(),
							localhost.getCanonicalHostName(), Toast.LENGTH_SHORT)
							.show();
					break;
				}

			}
		});
	}
}