package com.xiaohunao.isekai_invaded.common.data.gen.provider;


import com.xiaohunao.heaven_destiny_moment.common.init.HDMRegistries;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.init.IIMoments;
import com.xiaohunao.isekai_invaded.common.init.IIStructureSets;
import com.xiaohunao.isekai_invaded.common.init.IIStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class IIRegistryProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder()
            .add(HDMRegistries.Keys.MOMENT, IIMoments::bootstrap)
            .add(Registries.STRUCTURE, IIStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, IIStructureSets::bootstrap);

    public IIRegistryProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, REGISTRY_SET_BUILDER, Set.of(IsekaiInvaded.MODID, "minecraft"));
    }
}
