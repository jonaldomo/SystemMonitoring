package com.github.jonaldomo.SystemMonitoring;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.telephony.ServiceState;

public class Telephony extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView lv = (ListView) findViewById(R.id.list);

		String[] menuItems = getResources().getStringArray(
				R.array.telephony_items);
		lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item,
				menuItems));

		lv.setTextFilterEnabled(true);

		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				ServiceState state = new ServiceState();

				switch ((int) id) {
				case 0:
					Toast.makeText(getApplicationContext(),
							state.getOperatorAlphaShort(), Toast.LENGTH_SHORT)
							.show();
					break;
				case 1:
					Toast.makeText(getApplicationContext(),
							state.getOperatorNumeric(), Toast.LENGTH_SHORT)
							.show();
					break;
				case 2:
					Toast.makeText(getApplicationContext(),
							translateState(state.getState()),
							Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Intent i = new Intent(view.getContext(),
							TelephonyCdma.class);
					startActivity(i);
					break;
				case 4:
					Intent i2 = new Intent(view.getContext(), TelephonyGsm.class);
					startActivity(i2);
					break;
//				case 5:
//					Intent i3 = new Intent(view.getContext(), TelephonySignalStrength.class);
//					startActivity(i3);
//					break;
				}

			}
		});
	}

	public String translateState(int stateId) {
		switch (stateId) {
		case 0:
			return "Emergency Only";
		case 1:
			return "In Service";
		case 2:
			return "Out of Service";
		case 3:
			return "Power Off";
		default:
			return "Unknown";
		}
	}
}