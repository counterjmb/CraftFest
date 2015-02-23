package com.craftfest.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static int MCDATE = 0;
	
	public static void init(File file){
		
		Configuration config = new Configuration(file);
		
		config.load();
		
		//int test = config.getInt(name, category, defaultValue, minValue, maxValue, comment).getInt();
		
		config.save();
		
	}

}
