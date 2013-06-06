package com.example.justweet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.util.Log;

public class GetTwitterFeed {

	public String getTwitterFeed() {
		
		BufferedReader in = null;
		String str = "";
		
		try {
			HttpClient client = new DefaultHttpClient();			
			//URI website = new URI("https://api.twitter.com/1/users/lookup.json?screen_name=nick_wilkins,twitter&include_entities=true"); 
			String website = "https://api.twitter.com/1/users/lookup.json?screen_name=nick_wilkins,twitter&include_entities=true";
			//HttpGet request = new HttpGet();
			//request.setURI(website);
	        HttpResponse response = client.execute(new HttpGet(website));
	        response.getStatusLine().getStatusCode();
	        
	        //in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	        JSONObject object = (JSONObject) new JSONTokener(response.getEntity().getContent().toString()).nextValue();
	        str = object.getString("name");
	        //JSONArray locations = object.getJSONArray("locations");
		}
		catch(Exception e)
		{
			Log.e("tag", e.toString());
		}
		
		return str;
	}
}
