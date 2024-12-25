package com.xiaohunao.isekai_invaded.common.init;


import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.worldgen.structure.PiglinLegionPortalStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IIStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPE = DeferredRegister.create(Registries.STRUCTURE_TYPE, IsekaiInvaded.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<PiglinLegionPortalStructure>> PIGLIN_LEGION_PORTAL = STRUCTURE_TYPE.register("piglin_legion_portal", () -> () -> PiglinLegionPortalStructure.CODEC);
}
