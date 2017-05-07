package com.cubic_control.cubic_core.Items;

import net.minecraft.item.Item;

public class ModItemsManager {
	public static Item remover;
	
	public static void initializeItems(){
		remover = new ModItemRemover("remover", 0.5f);
	}

}
