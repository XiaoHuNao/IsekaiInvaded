package com.xiaohunao.isekai_invaded.common.mixin;


import com.xiaohunao.isekai_invaded.common.event.NetherPortalSpawnPigLinEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(NetherPortalBlock.class)
public class NetherPortalBlockMixin {

    @Inject(method = "randomTick",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EntityType;spawn(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;"), cancellable = true)
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci){
        NetherPortalSpawnPigLinEvent netherPortalSpawnPigLinEvent = new NetherPortalSpawnPigLinEvent(state,level, pos);
        NeoForge.EVENT_BUS.post(netherPortalSpawnPigLinEvent);
        if (netherPortalSpawnPigLinEvent.isCanceled()){
            ci.cancel();
        }
    }
}
