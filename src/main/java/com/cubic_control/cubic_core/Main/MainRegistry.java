package com.cubic_control.cubic_core.Main;

import com.cubic_control.cubic_core.Commands.MCommandManager;
import com.cubic_control.cubic_core.Events.MEventHandler;
import com.cubic_control.cubic_core.Items.ModItemsManager;
import com.cubic_control.cubic_core.Lib.RefStrings;
import com.cubic_control.cubic_core.Utils.CubicUtils;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION)
public class MainRegistry {
	@SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)
	public static ServerProxy proxy;
	
	@Mod.Instance(RefStrings.MODID)
	public static MainRegistry instance;
	
	// Version checking instance
	public static VersionChecker versionChecker;
	public static boolean haveWarnedVersionOutOfDate = false;
	
	@EventHandler
	public static void preload(FMLPreInitializationEvent PreEvent){
		CubicUtils utils = new CubicUtils();
		ModItemsManager.initializeItems();
		proxy.registerRenderInfo();
	}
	@EventHandler
	public static void load(FMLInitializationEvent event){
		FMLCommonHandler.instance().bus().register(instance);
		MEventHandler.registerEvents();
	}
	@EventHandler
	public static void postload(FMLPostInitializationEvent PostEvent){
		MainRegistry.versionChecker = new VersionChecker();
		Thread versionCheckThread = new Thread(MainRegistry.versionChecker, "Version Check");
		versionCheckThread.start();
	}
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		MCommandManager.loadCommands(event);
	}
}
