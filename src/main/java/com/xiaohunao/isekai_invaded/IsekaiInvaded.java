package com.xiaohunao.isekai_invaded;


import com.xiaohunao.isekai_invaded.common.init.IIStructurePieceTypes;
import com.xiaohunao.isekai_invaded.common.init.IIStructureTypes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;


@Mod(IsekaiInvaded.MODID)
public class IsekaiInvaded {
    public static final String MODID = "isekai_invaded";

    public IsekaiInvaded(IEventBus modEventBus, ModContainer modContainer) {
//        NeoForge.EVENT_BUS.register(this);
        IIStructureTypes.STRUCTURE_TYPE.register(modEventBus);
        IIStructurePieceTypes.STRUCTURE_PIECE.register(modEventBus);
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static String asDescriptionId(String path) {
        return MODID + "." + path;
    }

    public static <T> ResourceKey<T> asResourceKey(ResourceKey<? extends Registry<T>> registryKey, String path) {
        return ResourceKey.create(registryKey, asResource(path));
    }

    public static <T> ResourceKey<Registry<T>> asResourceKey(String path) {
        return ResourceKey.createRegistryKey(asResource(path));
    }

//    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientModEvents {
//
//    }
}
