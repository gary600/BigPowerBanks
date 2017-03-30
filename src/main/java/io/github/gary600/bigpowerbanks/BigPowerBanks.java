package io.github.gary600.bigpowerbanks;

import io.github.gary600.bigpowerbanks.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BigPowerBanks.MODID, version = BigPowerBanks.VERSION)
public class BigPowerBanks {
    public static final String MODID = "bigpowerbanks";
    public static final String VERSION = "0.1";

    @SidedProxy(
            clientSide="io.github.gary600.bigpowerbanks.proxy.ClientProxy",
            serverSide="io.github.gary600.bigpowerbanks.proxy.ServerProxy"
    )
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
