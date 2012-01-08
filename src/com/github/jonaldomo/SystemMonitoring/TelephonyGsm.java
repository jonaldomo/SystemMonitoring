package com.github.jonaldomo.SystemMonitoring;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.telephony.gsm.GsmCellLocation;

public class TelephonyGsm extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView lv = (ListView) findViewById(R.id.list);

		String[] menuItems = getResources().getStringArray(R.array.gsm_items);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				GsmCellLocation gsm = new GsmCellLocation();

				switch ((int) id) {
				case 0:
					Toast.makeText(getApplicationContext(),
							Integer.toString(gsm.getCid()), Toast.LENGTH_SHORT)
							.show();
					break;
				case 1:
					Toast.makeText(getApplicationContext(),
							Integer.toString(gsm.getLac()), Toast.LENGTH_SHORT)
							.show();
					break;
				}

			}
		});
	}
}
