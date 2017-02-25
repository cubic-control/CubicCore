package com.cubic_control.cubic_core.Events;

import cpw.mods.fml.common.FMLCommonHandler;

public class MEventHandler {
	public static void registerEvents(){
		FMLCommonHandler.instance().bus().register(new MEventUpdateChecker());
	}

}
