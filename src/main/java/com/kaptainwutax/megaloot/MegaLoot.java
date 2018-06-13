package com.kaptainwutax.megaloot;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.kaptainwutax.megaloot.handler.HandlerRegistry;
import com.kaptainwutax.megaloot.proxy.CommonProxy;
import com.kaptainwutax.megaloot.utility.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class MegaLoot {

	@Mod.Instance
	public static MegaLoot instance;
	
	@SidedProxy(clientSide = Reference.PROXY_CLIENT, serverSide = Reference.PROXY_COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {HandlerRegistry.preInitRegistries(event);}
	@EventHandler
	public static void init(FMLInitializationEvent event) {HandlerRegistry.initRegistries(event);}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {HandlerRegistry.postInitRegistries(event);}
	
}
