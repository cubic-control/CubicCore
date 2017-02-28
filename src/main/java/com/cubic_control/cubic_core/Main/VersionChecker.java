package com.cubic_control.cubic_core.Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.cubic_control.cubic_core.Bases.VersionCheckerBase;

public class VersionChecker extends VersionCheckerBase{
    
    public VersionChecker(String version, String string, String modname){
    	super(version, string, modname);
    }
}