package com.xiaohunao.isekai_invaded.common.worldgen.structure.piece;

import com.xiaohunao.isekai_invaded.common.init.IIStructurePieceTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

public class PiglinLegionPortalPiece extends TemplateStructurePiece {
    public PiglinLegionPortalPiece(StructureTemplateManager manager, ResourceLocation location, Rotation rotation, BlockPos blockPos) {
        super(IIStructurePieceTypes.PIGLIN_LEGION_PORTAL.get(), 0, manager, location, location.toString(), makeSettings(),blockPos);
    }

    public PiglinLegionPortalPiece(StructureTemplateManager templateManagerIn, CompoundTag tag) {
        super(IIStructurePieceTypes.PIGLIN_LEGION_PORTAL.get(), tag, templateManagerIn, (location) -> makeSettings());
    }

    public PiglinLegionPortalPiece(StructurePieceSerializationContext context, CompoundTag tag) {
        this(context.structureTemplateManager(), tag);
    }


    @Override
    protected void handleDataMarker(String name, BlockPos blockPos, ServerLevelAccessor serverLevelAccessor, RandomSource randomSource, BoundingBox boundingBox) {

    }

    private static StructurePlaceSettings makeSettings() {
        return (new StructurePlaceSettings());
    }

}
