package org.cnc.alg.util;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {
	private ConnectivityManager connectivityManager;
//	private WifiManager wifiManager;

	public NetworkStatus(Context context) {
		connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//		wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	}

	/**
	 * Method use to check network of device is really available
	 * 
	 * @return true if really connect, else return false
	 */
	public boolean isConnection(String urlAddress) {
		boolean isOnline = false;
		try {
			URL url = new URL(urlAddress);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(1000);
			connection.connect();
			isOnline = connection.getResponseCode() == 200;
		} catch (Exception e) {
		}
		return isOnline;
	}

	/**
	 * Method use to check network of device
	 * 
	 * @return true if really connect, else return false
	 */
	public boolean isConnect() {
		return isConnectWifi() || isConnect3G();
	}

	/**
	 * Method used to check connect wifi
	 * 
	 * @return : true if connect, else false
	 */
	public boolean isConnectWifi() {
		NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (wifi != null) {
			return wifi.isConnected();
		}
		return false;
	}

	/**
	 * Method used to check connect 3G
	 * 
	 * @return : true if connect, else false;
	 */
	public boolean isConnect3G() {
		NetworkInfo mobile3G = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (mobile3G != null) {
			return mobile3G.isConnected();
		}
		return false;
	}

	public String getLocalIpAddress() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						return inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (SocketException ex) {
		}
		return null;
	}
}
