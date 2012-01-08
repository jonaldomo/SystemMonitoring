package com.github.jonaldomo.SystemMonitoring;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

public class SystemMonitoring extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView lv = (ListView) findViewById(R.id.list);
		
		String[] menuItems = getResources().getStringArray(R.array.menu_items);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch ((int) id) {
				case 0:
					Intent i = new Intent(view.getContext(), Telephony.class);
					startActivity(i);
					break;
				case 1:
					Intent i1 = new Intent(view.getContext(), Memory.class);
					startActivity(i1);
					break;
				case 2:
					Intent i2 = new Intent(view.getContext(), Storage.class);
					startActivity(i2);
					break;
				case 3:
					Intent i3 = new Intent(view.getContext(), Network.class);
					startActivity(i3);
					break;
				case 4:
					Intent i4 = new Intent(view.getContext(), Display.class);
					startActivity(i4);
					break;
				case 5:
					Intent i5 = new Intent(view.getContext(),
							OperatingSystem.class);
					startActivity(i5);
					break;
				}
			}
		});
	}
}