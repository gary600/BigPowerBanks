package io.github.gary600.bigpowerbanks.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static Block blockTest;

    public static void createBlocks() {
        blockTest = new BlockBasicPowerBank("blockBasicPowerBank");
    }

    public static void registerBlocks() {
        GameRegistry.registerBlock(blockTest, "blockBasicPowerBank");
    }

    public static void registerBlockRenders() {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(Item.getItemFromBlock(blockTest), 0, new ModelResourceLocation("bigpowerbanks:blockBasicPowerBank", "inventory"));
    }
}
