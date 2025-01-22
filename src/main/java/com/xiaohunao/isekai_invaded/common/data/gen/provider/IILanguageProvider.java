package com.xiaohunao.isekai_invaded.common.data.gen.provider;

import com.xiaohunao.heaven_destiny_moment.common.data.gen.provider.MomentLanguageProvider;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.init.IIMoments;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

public class IILanguageProvider extends MomentLanguageProvider {

    public IILanguageProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String locale) {
        super(output, lookupProvider, IsekaiInvaded.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        addMomentDefaultBarName(IIMoments.PIGLIN_LEGION, "Piglin Legion", "猪灵军团");
    }
}