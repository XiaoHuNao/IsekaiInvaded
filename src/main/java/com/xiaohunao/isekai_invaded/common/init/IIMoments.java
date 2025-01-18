package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.heaven_destiny_moment.client.gui.bar.render.DefaultBarRenderType;
import com.xiaohunao.heaven_destiny_moment.common.context.Weighted;
import com.xiaohunao.heaven_destiny_moment.common.context.attachable.CommonAttachable;
import com.xiaohunao.heaven_destiny_moment.common.context.attachable.EquipmentAttachable;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.LocationCondition;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.PlayerCondition;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.common.WorldUniqueMomentCondition;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.EntityInfo;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.HoglinInfo;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.IEntityInfo;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.PiglinInfo;
import com.xiaohunao.heaven_destiny_moment.common.context.equippable_slot.VanillaEquippableSlot;
import com.xiaohunao.heaven_destiny_moment.common.init.HDMRegistries;
import com.xiaohunao.heaven_destiny_moment.common.moment.Moment;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.RaidMoment;
import com.xiaohunao.heaven_destiny_moment.common.spawn_algorithm.OpenAreaSpawnAlgorithm;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class IIMoments {
    public static final ResourceKey<Moment<?>> PIGLIN_LEGION = IsekaiInvaded.asResourceKey(HDMRegistries.Keys.MOMENT, "piglin_legion");
    public static final ResourceKey<Moment<?>> OLD_ONES_ARMY = IsekaiInvaded.asResourceKey(HDMRegistries.Keys.MOMENT, "old_ones_army");

    public static void bootstrap(BootstrapContext<Moment<?>> context) {
//        Optional<HolderLookup.RegistryLookup<Enchantment>> enchantmentRegistryLookup = context.registryLookup(Registries.ENCHANTMENT);
        HolderGetter<Enchantment> enchantmentHolder = context.lookup(Registries.ENCHANTMENT);

        context.register(PIGLIN_LEGION, new RaidMoment()
                .setBarRenderType(new DefaultBarRenderType())
                .setMomentData(momentData -> momentData
                        .entitySpawnSettings(entitySpawnSettings -> entitySpawnSettings
                                .spawnAlgorithm(new OpenAreaSpawnAlgorithm.Builder().direction(Direction.WEST).build())
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(3, 4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_SWORD)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(2, 3)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW )
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(5, 6)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                .amount(2)
                                                                .build()
                                                ), 1
                                        )
                                )
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(7,9)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.GOLDEN_SWORD )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(4,6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW )
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(7,9)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.GOLDEN_SWORD )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(2,3)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                .amount(3,4)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(6,7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.STONE_SWORD )
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(7,9)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.HEAD,Items.LEATHER_HELMET ,1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST,Items.LEATHER_CHESTPLATE ,1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS,Items.LEATHER_LEGGINGS ,1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET,Items.LEATHER_BOOTS ,1)
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_SWORD )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(4,7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.HEAD,Items.LEATHER_HELMET ,1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST,Items.LEATHER_CHESTPLATE ,1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS,Items.LEATHER_LEGGINGS ,1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET,Items.LEATHER_BOOTS ,1)
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW )
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(4,6)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.GHAST)
                                                                .amount(2,4)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(3,5)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.STONE_SWORD )
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(3,5)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.HEAD,Items.LEATHER_HELMET ,1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST,Items.LEATHER_CHESTPLATE ,1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS,Items.LEATHER_LEGGINGS ,1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET,Items.LEATHER_BOOTS ,1)
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW )
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                        )
                        .conditionGroup(group -> group
                                .create(false,
                                        WorldUniqueMomentCondition.DEFAULT,
                                        new PlayerCondition.Builder(PlayerCondition.Type.ANY)
                                                .checkAdvancementDone(ResourceLocation.withDefaultNamespace("nether/loot_bastion"), true)
                                                .build(),
                                        new LocationCondition.Builder()
                                                .setStructures(IIStructures.PIGLIN_LEGION)
                                                .build()
                                )
                        )
                )
        );
    }
}
