package com.xiaohunao.isekai_invaded.common.data.gen.provider;

import com.google.gson.JsonObject;
import com.xiaohunao.heaven_destiny_moment.common.context.TipSettings;
import com.xiaohunao.heaven_destiny_moment.common.data.gen.provider.MomentLanguageProvider;
import com.xiaohunao.heaven_destiny_moment.common.moment.Moment;
import com.xiaohunao.heaven_destiny_moment.common.moment.MomentState;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.init.IIMoments;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class IILanguageProvider extends MomentLanguageProvider {

    public IILanguageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String locale) {
        super(output, lookupProvider, IsekaiInvaded.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        addMomentDefaultBarName(IIMoments.PIGLIN_LEGION, "Piglin Legion", "猪灵军团");
    }
}