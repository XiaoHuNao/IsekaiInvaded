package com.xiaohunao.isekai_invaded.common.data.gen;

import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.data.gen.provider.IILanguageProvider;
import com.xiaohunao.isekai_invaded.common.data.gen.provider.IIRegistryProvider;
import com.xiaohunao.isekai_invaded.common.data.gen.provider.IITagProviders;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = IsekaiInvaded.MODID, bus = EventBusSubscriber.Bus.MOD)
public class IIDataGenerator {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        boolean server = event.includeServer();
        boolean client = event.includeClient();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        CompletableFuture<HolderLookup.Provider> registryProvider = generator.addProvider(server, new IIRegistryProvider(output, lookupProvider)).getRegistryProvider();
        generator.addProvider(server, new IITagProviders.Bimes(output,registryProvider,existingFileHelper));
        generator.addProvider(server, new IILanguageProvider(output, registryProvider,"en_us"));
        generator.addProvider(server, new IILanguageProvider(output, registryProvider,"zh_cn"));

    }

}