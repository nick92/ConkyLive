package com.example.conkylive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import android.os.Environment;
import android.os.StatFs;

public class getInfo {
	
	protected String getCPUInfo() {

	    StringBuffer sb = new StringBuffer();
	    String[] toks = {};
	    
	    if (new File("/proc/stat").exists()) {
	        try {

	            BufferedReader br = new BufferedReader(new FileReader(new File("/proc/stat")));
	            String load = br.readLine();
	            br.close();     
	            toks = load.split(" ");
	            
	            if (br != null) {
	                br.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	    }
	    else
	    {
	    	sb.append("900202");
	    }
	    return toks[4];
	}
   
	protected String getMemInfo() {

	    StringBuffer sb = new StringBuffer();
	    ArrayList<String> toks = new ArrayList<String>();
	    String load = null;
	    if (new File("/proc/meminfo").exists()) {
	        try {

	            BufferedReader br = new BufferedReader(new FileReader(new File("/proc/meminfo")));
	            //load = br.readLine();
	            String aLine;
	            
	            while ((aLine = br.readLine()) != null) {
	                aLine = aLine.replace("   ", "");
	            	sb.append(aLine + "\n");
	                toks.add(aLine);
	            }
	            
	            if (br != null) {
	                br.close();
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } 

	    }
	    else
	    {
	    	sb.append("900202");
	    }
	    return toks.get(5).toString();
	}
	
	protected int getSDInfo(){
		
		StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
		double sdAvailSize = (double)stat.getAvailableBlocks() * (double)stat.getBlockSize();
		//One binary gigabyte equals 1,073,741,824 bytes.
		double gigaAvailable = (sdAvailSize / 1073741824) * 1000;
		int num = (int)Math.floor(gigaAvailable);
		
		return num;
	}
}
