package com.cubic_control.cubic_core.Main;

import com.cubic_control.cubic_core.Events.MEventHandler;
import com.cubic_control.cubic_core.Lib.RefStrings;
import com.cubic_control.cubic_core.Utils.ModUtils;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)
public class MainRegistry {
	@SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)
	public static ServerProxy proxy;
	
	@Mod.Instance(RefStrings.MODID)
	public static MainRegistry instance;
	
	public static VersionChecker versionChecker;
	public static boolean haveWarnedVersionOutOfDate = false;
	
	@EventHandler
	public static void Preload(FMLPreInitializationEvent PreEvent){
		ModUtils utils = new ModUtils();
		proxy.registerRenderInfo();
	}
	@EventHandler
	public static void load(FMLInitializationEvent event){
		FMLCommonHandler.instance().bus().register(instance);
		MEventHandler.registerEvents();
		
		MainRegistry.versionChecker = new VersionChecker(RefStrings.VERSION,
				"https://raw.githubusercontent.com/cubic-control/CubicCore/master/src/main/resources/version_file.txt",
				RefStrings.NAME);
		Thread versionCheckThread = new Thread(MainRegistry.versionChecker, "Version Check");
		versionCheckThread.start();
	}
	@EventHandler
	public static void Postload(FMLPostInitializationEvent PostEvent){
	}
}
