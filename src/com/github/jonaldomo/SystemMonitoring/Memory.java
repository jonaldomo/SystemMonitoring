package com.github.jonaldomo.SystemMonitoring;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Memory extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView lv = (ListView) findViewById(R.id.list);

		String[] menuItems = getResources().getStringArray(
				R.array.memory_items);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				MemoryInfo mi = new MemoryInfo();
				ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
				activityManager.getMemoryInfo(mi);
				long availableMegs = mi.availMem / 1048576L;

				switch ((int) id) {
				case 0:
					Toast.makeText(getApplicationContext(),
							Integer.toString((int)availableMegs) + "MB", Toast.LENGTH_SHORT)
							.show();
					break;
				}

			}
		});
	}
}