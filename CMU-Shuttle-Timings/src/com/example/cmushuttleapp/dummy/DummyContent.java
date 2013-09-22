package com.example.cmushuttleapp.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.AsyncTask;
import android.util.Log;
import com.example.pattern.*;
/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
	private static int index=0;
	private static String[] routes = {"Route A","Route B","Route AB"}; 
	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();
	
	static {
		new ParseHTMLTask().execute(new String[] { "http://www.cmu.edu/police/shuttleandescort/a-route-departure-times.html"});
		new ParseHTMLTask().execute(new String[] { "http://www.cmu.edu/police/shuttleandescort/b-route-departure-times.html"}); 
		new ParseHTMLTask().execute(new String[] { "http://www.cmu.edu/police/shuttleandescort/ab-departure-times.html"});
	}

	private static void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.routeName, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String routeName;
		public ArrayList<String> routeDetails;

		public DummyItem(String id, ArrayList<String> content) {
			this.routeName = id;
			this.routeDetails = content;
		}

		@Override
		public String toString() {
			return routeName;
		}
	}
	private static class ParseHTMLTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
          String response = "";
          for (String url : urls) {
            try {
            	addItem(new DummyItem(routes[index++],HTMLParser.parse(url)));
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
          return response;
        }
        @Override
        protected void onPostExecute(String result) {
          Log.d("Shuttle", result);
        }
  }   
}
