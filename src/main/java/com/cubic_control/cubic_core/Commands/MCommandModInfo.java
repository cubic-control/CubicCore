package com.cubic_control.cubic_core.Commands;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class MCommandModInfo implements ICommand{
	private final List aliases;
	
	public MCommandModInfo(){
		aliases = new ArrayList();
		aliases.add("modinfo");
	}
	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
	@Override
	public String getCommandName() {
		return "mod_info";
	}
	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "mod_info <Text>";
	}
	@Override
	public List getCommandAliases() {
		return this.aliases;
	}
	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		World world = var1.getEntityWorld();
		if(!world.isRemote){
			if(var2.length <= 0){
				var1.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"Usage: /mod_info <Text>"));
			}else{
				if(Loader.isModLoaded(var2[0])){
					var1.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"This command is currently in beta!"));
					var1.addChatMessage(new ChatComponentText("modid:"+var2[0]));
					var1.addChatMessage(new ChatComponentText("name:"));
					var1.addChatMessage(new ChatComponentText("version:"));
				}else{
					var1.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+var2[0]+" is not a valid modid, Please enter a valid modid."));
				}
			}
		}
	}
	@Override
	public boolean canCommandSenderUseCommand(ICommandSender var1) {
		return true;
	}
	@Override
	public List addTabCompletionOptions(ICommandSender var1, String[] var2) {
		return null;
	}
	@Override
	public boolean isUsernameIndex(String[] var1, int var2) {
		return false;
	}
}
