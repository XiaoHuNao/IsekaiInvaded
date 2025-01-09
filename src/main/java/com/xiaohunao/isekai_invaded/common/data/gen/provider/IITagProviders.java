package com.xiaohunao.isekai_invaded.common.data.gen.provider;

import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.init.IIModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@ParametersAreNonnullByDefault
public class IITagProviders {
    public static class Bimes extends BiomeTagsProvider {

        public Bimes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                     @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, IsekaiInvaded.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(IIModTags.Biomes.HAS_PIGLIN_LEGION).add(Biomes.PLAINS).add(Biomes.MEADOW);
        }

    }
}