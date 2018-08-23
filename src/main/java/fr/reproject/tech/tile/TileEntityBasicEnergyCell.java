package fr.reproject.tech.tile;

import cjminecraft.core.energy.EnergyUnit;
import cjminecraft.core.energy.EnergyUtils;
import cjminecraft.core.energy.compat.forge.CustomForgeEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityBasicEnergyCell extends TileEntity implements ITickable {

    private ItemStackHandler handler;
    private CustomForgeEnergyStorage storage;

    public TileEntityBasicEnergyCell() {
        this.handler = new ItemStackHandler(2);
        this.storage = new CustomForgeEnergyStorage(2097152, 0);
    }

    @Override
    public void update() {
        if (this.world != null) {
            if (!this.world.isRemote) {
                this.storage.extractEnergyInternal((int)EnergyUtils.giveEnergyAllFaces(this.world, this.pos, 512, EnergyUnit.FORGE_ENERGY, false, true), false);
                this.storage.receiveEnergyInternal((int)EnergyUtils.takeEnergyAllFaces(this.world, this.pos, 512, EnergyUnit.FORGE_ENERGY, false, true), false);
            }
        }
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T) this.handler;
        if(capability == CapabilityEnergy.ENERGY)
            return (T) this.storage;
        return super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return true;
        if(capability == CapabilityEnergy.ENERGY)
            return true;
        return super.hasCapability(capability, facing);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("Inventory", this.handler.serializeNBT());
        this.storage.writeToNBT(compound);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
        this.storage.readFromNBT(compound);
        super.readFromNBT(compound);
    }
}
