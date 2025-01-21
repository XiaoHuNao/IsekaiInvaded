package com.xiaohunao.isekai_invaded.common.mixin;


import com.xiaohunao.heaven_destiny_moment.common.moment.MomentInstance;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.instance.RaidInstance;
import com.xiaohunao.isekai_invaded.common.init.IIMoments;
import com.xiaohunao.isekai_invaded.common.init.IIStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;


@Mixin(NetherPortalBlock.class)
public class NetherPortalBlockMixin {

    @Inject(method = "randomTick",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/EntityType;spawn(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/MobSpawnType;)Lnet/minecraft/world/entity/Entity;"), cancellable = true)
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo ci){
        MomentInstance.create(IIMoments.PIGLIN_LEGION,level,pos,null, momentInstance -> {
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
        ci.cancel();
    }
}
