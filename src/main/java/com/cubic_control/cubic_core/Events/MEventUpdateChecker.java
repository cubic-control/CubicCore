package com.cubic_control.cubic_core.Events;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import com.cubic_control.cubic_core.Lib.RefStrings;
import com.cubic_control.cubic_core.Main.MainRegistry;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class MEventUpdateChecker {
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onPlayerTickEvent(PlayerTickEvent event) {
		if(!MainRegistry.haveWarnedVersionOutOfDate && event.player.worldObj.isRemote && !MainRegistry.versionChecker.isLatestVersion()) {
			ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "");
	        ChatStyle clickableChatStyle = new ChatStyle().setChatClickEvent(versionCheckChatClickEvent);
	        ChatComponentText versionWarningChatComponent = new ChatComponentText(EnumChatFormatting.WHITE+"["+EnumChatFormatting.BLUE+RefStrings.NAME+EnumChatFormatting.WHITE+"]:"+EnumChatFormatting.RED+" You are running an outdated version of CubicCore! Click here to update.");
	        versionWarningChatComponent.setChatStyle(clickableChatStyle);
	        event.player.addChatMessage(versionWarningChatComponent);
	        MainRegistry.haveWarnedVersionOutOfDate = true;
	    }
	  
	}

}
