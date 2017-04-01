package io.github.gary600.bigpowerbanks.tesla;

import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.ITeslaProducer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;


public class TeslaContainer implements ITeslaConsumer, ITeslaProducer, ITeslaHolder, INBTSerializable<NBTTagCompound> {
    private long stored, capacity, inputRate, outputRate;
    public TeslaContainer(long stored, long capacity, long input, long output) {
        this.stored = stored;
        this.capacity = capacity;
        this.inputRate = input;
        this.outputRate = output;
    }

    @Override
    public long getStoredPower() {
        return stored;
    }

    @Override
    public long getCapacity() {
        return capacity;
    }

    public long getInputRate() {
        return inputRate;
    }

    public long getOutputRate() {
        return outputRate;
    }

    @Override
    public long givePower(long tesla, boolean simulated) {
        final long acceptedTesla = Math.min(this.getCapacity() - this.stored, Math.min(this.getInputRate(), tesla));
        if (!simulated) this.stored += acceptedTesla;
        return acceptedTesla;
    }

    @Override
    public long takePower(long tesla, boolean simulated) {
        final long removedTesla = Math.min(this.stored, Math.min(this.getOutputRate(), tesla));
        if (!simulated) this.stored -= removedTesla;
        return removedTesla;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound dataTag = new NBTTagCompound();
        dataTag.setLong("TeslaPower", this.stored);
        dataTag.setLong("TeslaCapacity", this.capacity);
        dataTag.setLong("TeslaInput", this.inputRate);
        dataTag.setLong("TeslaOutput", this.outputRate);
        return dataTag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.stored = nbt.getLong("TeslaPower");
        if (nbt.hasKey("TeslaCapacity"))
            this.capacity = nbt.getLong("TeslaCapacity");
        if (nbt.hasKey("TeslaInput"))
            this.inputRate = nbt.getLong("TeslaInput");
        if (nbt.hasKey("TeslaOutput"))
            this.outputRate = nbt.getLong("TeslaOutput");
        if (this.stored > this.getCapacity())
            this.stored = this.getCapacity();
    }
}
