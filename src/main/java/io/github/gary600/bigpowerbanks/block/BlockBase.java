package io.github.gary600.bigpowerbanks.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public abstract class BlockBase extends Block {
    public BlockBase(String unlocalizedName, Material material, float hardness, float resistance, CreativeTabs creativeTab) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(creativeTab);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }
}
