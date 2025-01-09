package com.xiaohunao.isekai_invaded.common.structure;

import com.mojang.serialization.MapCodec;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.init.IIStructurePieceTypes;
import com.xiaohunao.isekai_invaded.common.init.IIStructureTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Optional;

public class PiglinLegionStructure extends Structure {
    public static final MapCodec<PiglinLegionStructure> CODEC = simpleCodec(PiglinLegionStructure::new);

    public PiglinLegionStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
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
            pieces.addPiece(new PiglinLegionStructure.Piece(context.structureTemplateManager(), IsekaiInvaded.asResource("piglin_legion_portal"), pos, rotation));
        });
    }


    @Override
    public StructureType<?> type() {
        return IIStructureTypes.PIGLIN_LEGION.get();
    }

    public static class Piece extends TemplateStructurePiece {
        public Piece( StructureTemplateManager structureTemplateManager, ResourceLocation location, BlockPos templatePosition, Rotation rotation) {
            super(IIStructurePieceTypes.PIGLIN_LEGION.get(), 0, structureTemplateManager, location, location.toString(), makeSettings(rotation), templatePosition);
        }

        public Piece(StructureTemplateManager structureManager, CompoundTag tag) {
            super(IIStructurePieceTypes.PIGLIN_LEGION.get(), tag, structureManager, (location) -> makeSettings(Rotation.valueOf(tag.getString("rot"))));
        }

        public Piece(StructurePieceSerializationContext context, CompoundTag tag) {
            this(context.structureTemplateManager(), tag);
        }

        @Override
        protected void handleDataMarker(String name, BlockPos pos, ServerLevelAccessor level, RandomSource random, BoundingBox box) {}

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag tag) {
            super.addAdditionalSaveData(context, tag);
            tag.putString("rot", this.placeSettings.getRotation().name());
        }

        private static StructurePlaceSettings makeSettings(Rotation rotation) {
            return new StructurePlaceSettings().setRotation(rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreProcessor.STRUCTURE_AND_AIR);
        }
    }
}
