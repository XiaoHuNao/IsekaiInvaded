package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.structure.PiglinLegionStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IIStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE = DeferredRegister.create(Registries.STRUCTURE_TYPE, IsekaiInvaded.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<PiglinLegionStructure>> PIGLIN_LEGION = STRUCTURE_TYPE.register("piglin_legion", () -> () -> PiglinLegionStructure.CODEC);
}
