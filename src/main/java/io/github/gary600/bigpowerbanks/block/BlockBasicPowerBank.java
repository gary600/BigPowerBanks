package io.github.gary600.bigpowerbanks.block;

import io.github.gary600.bigpowerbanks.tile.TileBasicPowerBank;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockBasicPowerBank extends BlockContainer {

    protected BlockBasicPowerBank(String unlocalizedName) {
        super(Material.IRON);
        this.setUnlocalizedName(unlocalizedName);
        this.setHardness(2.0f);
        this.setResistance(6.0f);
        this.setCreativeTab(CreativeTabs.MISC);
        this.setHarvestLevel("pickaxe", 2);
    }


    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileBasicPowerBank();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
