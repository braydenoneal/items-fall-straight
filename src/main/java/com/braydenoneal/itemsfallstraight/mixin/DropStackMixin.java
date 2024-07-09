package com.braydenoneal.itemsfallstraight.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Block.class)
public class DropStackMixin {
    /**
     * @author Brayden O'Neal
     * @reason Remove random item starting position.
     */
    @Overwrite
    public static void dropStack(World world, BlockPos pos, ItemStack stack) {
        float f = EntityType.ITEM.getHeight() / 2.0F;
        double d = (float)pos.getX() + 0.5F;
        double e = (float)pos.getY() + 0.55F - (double) f;
        double g = (float)pos.getZ() + 0.5F;

        DropStackInvoker.dropStack(world, () -> new ItemEntity(world, d, e, g, stack), stack);
    }

    /**
     * @author Brayden O'Neal
     * @reason Remove random item starting position.
     */
    @Overwrite
    public static void dropStack(World world, BlockPos pos, Direction direction, ItemStack stack) {
        int i = direction.getOffsetX();
        int j = direction.getOffsetY();
        int k = direction.getOffsetZ();

        float f = EntityType.ITEM.getWidth() / 2.0F;
        float g = EntityType.ITEM.getHeight() / 2.0F;

        double d = (double)((float)pos.getX() + 0.5F) + (i == 0 ? 0 : (double)((float)i * (0.5F + f)));
        double e = (double)((float)pos.getY() + 0.5F) + (j == 0 ? 0 : (double)((float)j * (0.5F + g))) - (double)g;
        double h = (double)((float)pos.getZ() + 0.5F) + (k == 0 ? 0 : (double)((float)k * (0.5F + f)));

        double l = i == 0 ? MathHelper.nextDouble(world.random, -0.1, 0.1) : (double)i * 0.1;
        double m = j == 0 ? MathHelper.nextDouble(world.random, 0.0, 0.1) : (double)j * 0.1 + 0.1;
        double n = k == 0 ? MathHelper.nextDouble(world.random, -0.1, 0.1) : (double)k * 0.1;

        DropStackInvoker.dropStack(world, () -> new ItemEntity(world, d, e, h, stack, l, m, n), stack);
    }
}
