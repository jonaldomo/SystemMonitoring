package com.github.jonaldomo.SystemMonitoring;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class OperatingSystem extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView lv = (ListView) findViewById(R.id.list);

		String[] menuItems = getResources().getStringArray(R.array.os_items);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				switch ((int) id) {
				case 0:
					Toast.makeText(getApplicationContext(), Build.BOARD,
							Toast.LENGTH_SHORT).show();
					break;
				case 1:
					Toast.makeText(getApplicationContext(), Build.BOOTLOADER,
							Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(getApplicationContext(), Build.BRAND,
							Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(getApplicationContext(), Build.DEVICE,
							Toast.LENGTH_SHORT).show();
					break;
				case 4:
					Toast.makeText(getApplicationContext(), Build.DISPLAY,
							Toast.LENGTH_SHORT).show();
					break;
				case 5:
					Toast.makeText(getApplicationContext(), Build.FINGERPRINT,
							Toast.LENGTH_SHORT).show();
					break;
				case 6:
					Toast.makeText(getApplicationContext(), Build.HARDWARE,
							Toast.LENGTH_SHORT).show();
					break;
				case 7:
					Toast.makeText(getApplicationContext(), Build.MANUFACTURER,
							Toast.LENGTH_SHORT).show();
					break;
				case 8:
					Toast.makeText(getApplicationContext(), Build.MODEL,
							Toast.LENGTH_SHORT).show();
					break;
				case 9:
					Toast.makeText(getApplicationContext(), Build.PRODUCT,
							Toast.LENGTH_SHORT).show();
					break;
				}

			}
		});
	}
}