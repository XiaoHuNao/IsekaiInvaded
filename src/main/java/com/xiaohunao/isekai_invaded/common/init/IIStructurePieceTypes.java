package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.structure.PiglinLegionStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Locale;

public class IIStructurePieceTypes {
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE = DeferredRegister.create(Registries.STRUCTURE_PIECE, IsekaiInvaded.MODID);

    public static final DeferredHolder<StructurePieceType, StructurePieceType> PIGLIN_LEGION  = registerPieceType("piglin_legion", PiglinLegionStructure.Piece::new);


    private static DeferredHolder<StructurePieceType, StructurePieceType> registerPieceType(String name, StructurePieceType.StructureTemplateType structurePieceType) {
        return STRUCTURE_PIECE.register(name.toLowerCase(Locale.ROOT), () -> structurePieceType);
    }
}
