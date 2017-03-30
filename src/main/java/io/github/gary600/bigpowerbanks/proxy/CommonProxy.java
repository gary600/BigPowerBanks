package io.github.gary600.bigpowerbanks.proxy;

import io.github.gary600.bigpowerbanks.block.ModBlocks;
import io.github.gary600.bigpowerbanks.tile.ModTiles;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.createBlocks();
        ModBlocks.registerBlocks();
        ModTiles.registerTiles();
    }
    public void init(FMLInitializationEvent event) {

    }
    public void postInit(FMLPostInitializationEvent event) {

    }
}
