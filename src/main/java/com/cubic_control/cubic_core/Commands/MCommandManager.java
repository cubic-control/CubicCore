package com.cubic_control.cubic_core.Commands;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class MCommandManager {
	public static void loadCommands(FMLServerStartingEvent event){
		event.registerServerCommand(new MCommandModInfo());
	}
}
