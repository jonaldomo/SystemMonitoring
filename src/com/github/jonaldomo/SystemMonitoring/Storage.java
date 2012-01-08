package com.github.jonaldomo.SystemMonitoring;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Storage extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView lv = (ListView) findViewById(R.id.list);
		
		String[] menuItems = getResources().getStringArray(
				R.array.storage_items);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				File path = Environment.getDataDirectory();
			    StatFs stat = new StatFs(path.getPath());
			    long freeSpace = stat.getAvailableBlocks() * stat.getBlockSize();
			    long totalSpace = stat.getBlockCount() * stat.getBlockSize();

				switch ((int) id) {
				case 0:
					Toast.makeText(getApplicationContext(),
							Long.toString(freeSpace / 131072) + " MB", Toast.LENGTH_SHORT)
							.show();
					break;
				case 1:
					Toast.makeText(getApplicationContext(),
							Long.toString(totalSpace / 131072) + " MB", Toast.LENGTH_SHORT)
							.show();
					break;
				}

			}
		});
	}
}