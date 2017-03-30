package io.github.gary600.bigpowerbanks.tile;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTiles {
    public static void registerTiles() {
        GameRegistry.registerTileEntity(TileBasicPowerBank.class, "tileBasicPowerBank");
    }
}
