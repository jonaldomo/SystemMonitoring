package com.github.jonaldomo.SystemMonitoring;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.telephony.SignalStrength;

public class TelephonySignalStrength extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String[] menuItems = getResources().getStringArray(R.array.signal_strength_items);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		ListView lv = getListView();
		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				SignalStrength signal = null;

				switch ((int) id) {
				case 0:
					Toast.makeText(getApplicationContext(),
							Integer.toString(signal.getCdmaDbm()),
							Toast.LENGTH_SHORT).show();
					break;
				case 1:
					Toast.makeText(getApplicationContext(),
							Integer.toString(signal.getCdmaEcio()),
							Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(getApplicationContext(),
							Integer.toString(signal.getEvdoDbm()),
							Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(getApplicationContext(),
							Integer.toString(signal.getEvdoEcio()),
							Toast.LENGTH_SHORT).show();
					break;
				case 4:
					Toast.makeText(getApplicationContext(),
							Integer.toString(signal.getEvdoSnr()),
							Toast.LENGTH_SHORT).show();
					break;
				case 5:
					Toast.makeText(getApplicationContext(),
							Integer.toString(signal.getGsmBitErrorRate()),
							Toast.LENGTH_SHORT).show();
					break;
				case 6:
					Toast.makeText(getApplicationContext(),
							Integer.toString(signal.getGsmSignalStrength()),
							Toast.LENGTH_SHORT).show();
					break;
				}

			}
		});
	}
}
