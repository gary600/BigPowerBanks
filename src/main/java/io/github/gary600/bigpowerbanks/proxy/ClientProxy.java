package io.github.gary600.bigpowerbanks.proxy;

import io.github.gary600.bigpowerbanks.block.ModBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ModBlocks.registerBlockRenders();
    }
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
