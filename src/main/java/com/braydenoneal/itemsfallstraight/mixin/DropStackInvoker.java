package com.braydenoneal.itemsfallstraight.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.function.Supplier;

@Mixin(Block.class)
public interface DropStackInvoker {
    @Invoker("dropStack")
    static void dropStack(World world, Supplier<ItemEntity> itemEntitySupplier, ItemStack stack) {
        throw new AssertionError();
    }
}
