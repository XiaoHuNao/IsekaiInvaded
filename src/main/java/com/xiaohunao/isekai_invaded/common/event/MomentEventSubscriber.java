package com.xiaohunao.isekai_invaded.common.event;

import com.xiaohunao.heaven_destiny_moment.common.moment.MomentInstance;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.instance.RaidInstance;
import com.xiaohunao.isekai_invaded.common.init.IIMoments;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber
public class MomentEventSubscriber {
//    @SubscribeEvent
//    public static void onBlock(BlockEvent.PortalSpawnEvent event) {
//        LevelAccessor level = event.getLevel();
//        if (level instanceof ServerLevel serverLevel) {
//            MomentInstance.create(IIMoments.PIGLIN_LEGION,serverLevel,event.getPos(),null);
//        }
//        event.setCanceled(true);
//    }

    @SubscribeEvent
    public static void onPlayerInteractRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        InteractionHand hand = event.getHand();
        Player player = event.getEntity();
        if (level.isClientSide() || hand != InteractionHand.MAIN_HAND) {
            return;
        }

        if (level instanceof ServerLevel serverLevel) {
            MomentInstance.create(IIMoments.PIGLIN_LEGION,serverLevel,event.getPos(),null,momentInstance -> {
                if (momentInstance instanceof RaidInstance raidInstance){
                    raidInstance.setOriginalPos(Vec3.atLowerCornerOf(event.getPos()));
                }
            });
        }
    }
}