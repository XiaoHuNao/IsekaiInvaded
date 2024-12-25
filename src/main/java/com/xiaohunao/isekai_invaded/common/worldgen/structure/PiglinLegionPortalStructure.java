package com.xiaohunao.isekai_invaded.common.worldgen.structure;

import com.mojang.serialization.MapCodec;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.init.IIStructureTypes;
import com.xiaohunao.isekai_invaded.common.worldgen.structure.piece.PiglinLegionPortalPiece;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class PiglinLegionPortalStructure extends Structure {
    public static final MapCodec<PiglinLegionPortalStructure> CODEC = simpleCodec(PiglinLegionPortalStructure::new);

    public PiglinLegionPortalStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    @NotNull
    protected Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext context) {
        return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, (pieces) -> {
            ChunkPos chunk = context.chunkPos();
            WorldgenRandom rand = context.random();
            int x = chunk.getMinBlockX();
            int z = chunk.getMinBlockZ();
            int y = context.chunkGenerator().getFirstOccupiedHeight(
                    x, z, Heightmap.Types.WORLD_SURFACE_WG,
                    context.heightAccessor(), context.randomState());
            BlockPos pos = new BlockPos(x, y, z);
            Rotation rotation = Rotation.getRandom(rand);
            pieces.addPiece(new PiglinLegionPortalPiece(context.structureTemplateManager(), IsekaiInvaded.asResource("piglin_legion_portal"), rotation, pos));
        });
    }

    @Override
    @NotNull
    public StructureType<?> type() {
        return IIStructureTypes.PIGLIN_LEGION_PORTAL.get();
    }
}
