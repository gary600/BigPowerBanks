package io.github.gary600.bigpowerbanks.tile;

import io.github.gary600.bigpowerbanks.tesla.TeslaContainer;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class TileBasicPowerBank extends TileBase implements ITickable{

    private BaseTeslaContainer container = new BaseTeslaContainer(0, 1000000, 1000, 1000);

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return TeslaCapabilities.CAPABILITY_HOLDER == capability
                || TeslaCapabilities.CAPABILITY_CONSUMER == capability
                || TeslaCapabilities.CAPABILITY_PRODUCER == capability;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == TeslaCapabilities.CAPABILITY_CONSUMER
                || capability == TeslaCapabilities.CAPABILITY_PRODUCER
                || capability == TeslaCapabilities.CAPABILITY_HOLDER)
            return (T) this.container;

        return null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        return container.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        container.deserializeNBT(nbt);
    }

    @Override
    public void update() {
        System.out.println(container.getStoredPower());
    }
}
