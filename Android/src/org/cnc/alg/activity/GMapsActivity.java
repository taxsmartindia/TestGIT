package org.cnc.alg.activity;

import java.util.List;

import org.cnc.alg.R;
import org.cnc.alg.util.Constant;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.google.android.maps.*;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GMapsActivity extends MapActivity {
	private boolean contactMap;
	private MapView mapView = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		boolean customTitle = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.map);
		
		if (customTitle) {
			getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
					R.layout.customtitle);
			((TextView) findViewById(R.id.txtTitle)).setText(Constant.MAP);
			Button btnBack = (Button) findViewById(R.id.btnBack);
			btnBack.setOnClickListener(backOnClickListener);
			Button btnHome = (Button) findViewById(R.id.btnHome);
			btnHome.setVisibility(View.INVISIBLE);
		}
		
		contactMap = getIntent().getExtras().getBoolean("contact");
		
		mapView = (MapView) findViewById(R.id.mapview);
		
		Button btn_normal = (Button) findViewById(R.id.btn_normalMap);
		Button btn_satellite = (Button) findViewById(R.id.btn_satelliteMap);
		Button btn_hybrid = (Button) findViewById(R.id.btn_hybridMap);
		
		btn_normal.setOnClickListener(onButtonListener);
		btn_satellite.setOnClickListener(onButtonListener);
		btn_hybrid.setOnClickListener(onButtonListener);
		
//		mapView.setSatellite(true);
		mapView.setBuiltInZoomControls(true);
		
		MapController mc = mapView.getController();
		
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.marker);
		MarkItemizedOverlay itemizedoverlay = new MarkItemizedOverlay(drawable, this);
		GeoPoint point = null;
		OverlayItem overlayitem = null;
		if (contactMap) {
			point = new GeoPoint((int) (53.347413 * 1e6), (int) (-6.237938 * 1e6));
			overlayitem = new OverlayItem(point, "A&L Goodbody", "IFSC, North Wall Quay \nDublin 1 \nwww.algoodbody.com \n+353 1 649 2000");
		} else {
			point = new GeoPoint((int) (54.597873 * 1e6), (int) (-5.931784 * 1e6));
			overlayitem = new OverlayItem(point, "A&L Goodbody Belfast", "6th Floor, 42/46 Fountain Street, Belfast BT1 5EF\nwww.algoodbody.com \n+44 (0) 28 90 31 4466");
		}
		
		mc.animateTo(point);
		mc.setCenter(point);
		mc.setZoom(17);
		
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
	}
	
	private OnClickListener backOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = null;
			if (contactMap) {
				intent = new Intent(GMapsActivity.this,
						ContactUsActivity.class);
			} else {
				intent = new Intent(GMapsActivity.this,
						BelfastActivity.class);
			}
			finish();
			startActivity(intent);
		}
	};
	
	private OnClickListener onButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_normalMap:
				mapView.setStreetView(true);
				mapView.setSatellite(false);
				break;
			case R.id.btn_satelliteMap:
				mapView.setStreetView(false);
				mapView.setSatellite(true);
				break;
			case R.id.btn_hybridMap:
				mapView.setStreetView(true);
				mapView.setSatellite(true);
				break;
			default:
				break;
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
