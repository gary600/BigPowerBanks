package io.github.gary600.bigpowerbanks.tile;

import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class TileBasicPowerBank extends TileBase {
    @CapabilityInject(ITeslaHolder.class)
    public static final Capability<ITeslaHolder> TESLA_HOLDER_CAPABILITY = null;
    @CapabilityInject(ITeslaConsumer.class)
    public static final Capability<ITeslaConsumer> TESLA_CONSUMER_CAPABILITY = null;
    @CapabilityInject(ITeslaProducer.class)
    public static final Capability<ITeslaProducer> TESLA_PRODUCER_CAPABILITY = null;

    private ITeslaHolder teslaHolderInstance = TESLA_HOLDER_CAPABILITY.getDefaultInstance();
    private ITeslaConsumer teslaConsumerInstance = TESLA_CONSUMER_CAPABILITY.getDefaultInstance();
    private ITeslaProducer teslaProducerInstance = TESLA_PRODUCER_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return TESLA_HOLDER_CAPABILITY == capability;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == TESLA_HOLDER_CAPABILITY) return TESLA_HOLDER_CAPABILITY.<T> cast(teslaHolderInstance);
        else if (capability == TESLA_CONSUMER_CAPABILITY) return TESLA_CONSUMER_CAPABILITY.<T> cast(teslaConsumerInstance);
        else if (capability == TESLA_PRODUCER_CAPABILITY) return TESLA_PRODUCER_CAPABILITY.<T> cast(teslaProducerInstance);
        else return null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("teslaHolder", TESLA_HOLDER_CAPABILITY.getStorage().writeNBT(TESLA_HOLDER_CAPABILITY, teslaHolderInstance, null));
        nbt.setTag("teslaConsumer", TESLA_CONSUMER_CAPABILITY.getStorage().writeNBT(TESLA_CONSUMER_CAPABILITY, teslaConsumerInstance, null));
        nbt.setTag("teslaProducer", TESLA_PRODUCER_CAPABILITY.getStorage().writeNBT(TESLA_PRODUCER_CAPABILITY, teslaProducerInstance, null));
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        TESLA_HOLDER_CAPABILITY.getStorage().readNBT(TESLA_HOLDER_CAPABILITY, teslaHolderInstance, null, nbt.getTag("teslaHolder"));
        TESLA_CONSUMER_CAPABILITY.getStorage().readNBT(TESLA_CONSUMER_CAPABILITY, teslaConsumerInstance, null, nbt.getTag("teslaConsumer"));
        TESLA_PRODUCER_CAPABILITY.getStorage().readNBT(TESLA_PRODUCER_CAPABILITY, teslaProducerInstance, null, nbt.getTag("teslaProducer"));
    }
}
