package com.braydenoneal.itemsfallstraight.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at = @At("TAIL"))
    private void init(EntityType<? extends ItemEntity> entityType, World world, CallbackInfo info) {
        ItemEntity itemEntity = (ItemEntity) (Object) this;
        itemEntity.setYaw(0.0F);
    }

    @Inject(method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;DDD)V", at = @At("TAIL"))
    private void init(World world, double x, double y, double z, ItemStack stack, double velocityX, double velocityY, double velocityZ, CallbackInfo info) {
        ItemEntity itemEntity = (ItemEntity) (Object) this;
        itemEntity.setVelocity(0.0F, 10.25F, 0.0F);
    }
}
