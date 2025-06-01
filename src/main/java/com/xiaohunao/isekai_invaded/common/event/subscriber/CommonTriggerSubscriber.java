package com.xiaohunao.isekai_invaded.common.event.subscriber;


import com.xiaohunao.heaven_destiny_moment.common.moment.MomentInstanceManager;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.instance.RaidInstance;
import com.xiaohunao.isekai_invaded.common.event.NetherPortalSpawnPigLinEvent;
import com.xiaohunao.isekai_invaded.common.init.IIMoments;
import com.xiaohunao.isekai_invaded.common.init.IIStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.List;

@EventBusSubscriber
public class CommonTriggerSubscriber {
    @SubscribeEvent
    public static void onNetherPortalSpawnPigLin(NetherPortalSpawnPigLinEvent event) {
        event.setCanceled(true);
        ServerLevel level = event.getLevel();
        BlockPos pos = event.getPos();
        MomentInstanceManager momentInstanceManager = MomentInstanceManager.of(level);
        momentInstanceManager.createMomentInstance(IIMoments.PIGLIN_LEGION.get(),pos,null, momentInstance -> {
            if (momentInstance instanceof RaidInstance raidInstance){
                raidInstance.setOriginalPos(Vec3.atLowerCornerOf(pos));
                Structure structure = level.registryAccess().registryOrThrow(Registries.STRUCTURE).get(IIStructures.PIGLIN_LEGION);
                if (structure != null){
                    StructureStart structureStart = level.structureManager().getStructureWithPieceAt(pos, structure);
                    List<StructurePiece> pieces = structureStart.getPieces();
                    if (!pieces.isEmpty()) {
                        Direction direction = pieces.getFirst().getOrientation();
                        momentInstance.getPersistentData().put("dir", Direction.CODEC.encodeStart(NbtOps.INSTANCE, direction).getOrThrow());
                    }
                }
            }
        });
    }

}
