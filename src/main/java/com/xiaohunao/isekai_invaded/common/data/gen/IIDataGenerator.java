package com.xiaohunao.isekai_invaded.common.data.gen;

import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.isekai_invaded.common.data.gen.provider.IIRegistryProvider;
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

        generator.addProvider(server, new IIRegistryProvider(output, lookupProvider));
    }

}