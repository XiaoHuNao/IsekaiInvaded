package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class IIStructureSets {
    public static final ResourceKey<StructureSet> PIGLIN_LEGION = IsekaiInvaded.asResourceKey(Registries.STRUCTURE_SET,"piglin_legion");

    public static void bootstrap(BootstrapContext<StructureSet> pContext) {

        HolderGetter<Structure> holdergetter = pContext.lookup(Registries.STRUCTURE);
        pContext.register(
                PIGLIN_LEGION,
                new StructureSet(holdergetter.getOrThrow(IIStructures.PIGLIN_LEGION),
                        new RandomSpreadStructurePlacement(80, 40, RandomSpreadType.LINEAR, 1629143766))
        );
    }
}
