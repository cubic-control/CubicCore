package com.cubic_control.cubic_core.Bases;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class VersionCheckerBase implements Runnable{
    private static boolean isLatestVersion = false;
    private static String latestVersion = "";
    private static String currentVersion = "";
    private static String url = "";
    private static String name = "";
    
    public VersionCheckerBase(String version, String address, String modname){
    	this.currentVersion = version;
    	this.url = address;
    	this.name = modname;
    }
    
    @Override
    public void run() {
        InputStream in = null;
        try {
            in = new URL(url).openStream();
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        try {
            latestVersion = IOUtils.readLines(in).get(0);
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        finally {
            IOUtils.closeQuietly(in);
        }
        System.out.println("["+name+"]: Latest mod version = "+latestVersion);
        System.out.println("["+name+"]: Current mod version = "+currentVersion);
        isLatestVersion = currentVersion.equals(latestVersion);
        System.out.println("["+name+"]: Are you running latest version = "+isLatestVersion);
    }
    
    public boolean isLatestVersion() {
     return isLatestVersion;
    }
    
    public String getLatestVersion() {
     return latestVersion;
    }
}