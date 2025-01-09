package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class IIModTags {
    public static class Biomes {
        public static final TagKey<Biome> HAS_PIGLIN_LEGION = IsekaiInvaded.asTagKey(Registries.BIOME, "piglin_legion");
    }
}
