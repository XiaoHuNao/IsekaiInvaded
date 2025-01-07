package com.xiaohunao.isekai_invaded.common.structure;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
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
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.*;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class PiglinLegionStructure extends Structure {
    public static final MapCodec<PiglinLegionStructure> CODEC = simpleCodec(PiglinLegionStructure::new);

    public PiglinLegionStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    protected Optional<GenerationStub> findGenerationPoint(GenerationContext generationContext) {
        return onTopOfChunkCenter(generationContext, Heightmap.Types.WORLD_SURFACE_WG, structurePiecesBuilder -> this.generatePieces(structurePiecesBuilder, generationContext));
    }

    private void generatePieces(StructurePiecesBuilder pBuilder, Structure.GenerationContext pContext) {
        ChunkPos chunkpos = pContext.chunkPos();
        WorldgenRandom worldgenrandom = pContext.random();
        BlockPos blockpos = new BlockPos(chunkpos.getMinBlockX(), 64, chunkpos.getMinBlockZ());
        Rotation rotation = Rotation.getRandom(worldgenrandom);
        Piece.addPieces(pContext.structureTemplateManager(), blockpos, rotation, pBuilder, worldgenrandom);
    }

    @Override
    public StructureType<?> type() {
        return IIStructureTypes.PIGLIN_LEGION.get();
    }

    public static class Piece extends TemplateStructurePiece {
        static final ResourceLocation STRUCTURE_LOCATION_MY_STRUCTURE = IsekaiInvaded.asResource("piglin_legion_portal");
        static final Map<ResourceLocation, BlockPos> PIVOTS = ImmutableMap.of(
                STRUCTURE_LOCATION_MY_STRUCTURE, new BlockPos(4, 0, 4)
        );
        static final Map<ResourceLocation, BlockPos> OFFSETS = ImmutableMap.of(
                STRUCTURE_LOCATION_MY_STRUCTURE, BlockPos.ZERO
        );

        public static void addPieces(
                StructureTemplateManager pStructureTemplateManager, BlockPos pStartPos, Rotation pRotation, StructurePieceAccessor pPieces, RandomSource pRandom
        ) {
            pPieces.addPiece(new Piece(pStructureTemplateManager, STRUCTURE_LOCATION_MY_STRUCTURE, pStartPos, pRotation, 0));
        }


        public Piece(StructureTemplateManager pStructureTemplateManager, ResourceLocation pLocation, BlockPos pStartPos, Rotation pRotation, int pDown) {
            super(IIStructurePieceTypes.PIGLIN_LEGION.get(), 0, pStructureTemplateManager, pLocation, pLocation.toString(),
                    makeSettings(pRotation, pLocation),
                    makePosition(pLocation, pStartPos, pDown)
            );
        }


        public Piece(StructureTemplateManager pStructureTemplateManager, CompoundTag pTag) {
            super(IIStructurePieceTypes.PIGLIN_LEGION.get(), pTag, pStructureTemplateManager,   resourceLocation -> makeSettings(Rotation.valueOf(pTag.getString("Rot")), resourceLocation));
        }

        private static StructurePlaceSettings makeSettings(Rotation pRotation, ResourceLocation pLocation) {
            return new StructurePlaceSettings()
                    .setRotation(pRotation)
                    .setMirror(Mirror.NONE)
                    .setRotationPivot(PIVOTS.get(pLocation))
                    .addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        }

        private static BlockPos makePosition(ResourceLocation pLocation, BlockPos pPos, int pDown) {
            return pPos.offset(OFFSETS.get(pLocation)).below(pDown);
        }
        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext pContext, CompoundTag pTag) {
            super.addAdditionalSaveData(pContext, pTag);
            pTag.putString("Rot", this.placeSettings.getRotation().name());
        }

        @Override
        protected void handleDataMarker(String pName, BlockPos pPos, ServerLevelAccessor pLevel, RandomSource pRandom, BoundingBox pBox) {
            if ("chest".equals(pName)) {
                pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
                BlockEntity blockentity = pLevel.getBlockEntity(pPos.below());
                if (blockentity instanceof ChestBlockEntity) {
                    ((ChestBlockEntity)blockentity).setLootTable(BuiltInLootTables.IGLOO_CHEST, pRandom.nextLong());
                }
            }
        }

        @Override
        public void postProcess(
                WorldGenLevel pLevel,
                StructureManager pStructureManager,
                ChunkGenerator pGenerator,
                RandomSource pRandom,
                BoundingBox pBox,
                ChunkPos pChunkPos,
                BlockPos pPos
        ) {
            super.postProcess(pLevel, pStructureManager, pGenerator, pRandom, pBox, pChunkPos, pPos);
        }
    }
}
