package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.heaven_destiny_moment.client.gui.bar.render.DefaultBarRenderType;
import com.xiaohunao.heaven_destiny_moment.common.context.attachable.CommonAttachable;
import com.xiaohunao.heaven_destiny_moment.common.context.attachable.EquipmentAttachable;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.LocationCondition;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.PlayerCondition;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.common.WorldUniqueMomentCondition;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.EntityInfo;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.HoglinInfo;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.PiglinInfo;
import com.xiaohunao.heaven_destiny_moment.common.context.equippable_slot.VanillaEquippableSlot;
import com.xiaohunao.heaven_destiny_moment.common.init.HDMRegistries;
import com.xiaohunao.heaven_destiny_moment.common.moment.Moment;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.RaidMoment;
import com.xiaohunao.heaven_destiny_moment.common.spawn_algorithm.OpenAreaSpawnAlgorithm;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Items;

import java.util.List;

public class IIMoments {
    public static final ResourceKey<Moment<?>> PIGLIN_LEGION = IsekaiInvaded.asResourceKey(HDMRegistries.Keys.MOMENT, "piglin_legion");

    public static void bootstrap(BootstrapContext<Moment<?>> context) {
        context.register(PIGLIN_LEGION, new RaidMoment()
                .setBarRenderType(new DefaultBarRenderType())
                .setMomentData(momentData -> momentData
                        .entitySpawnSettings(entitySpawnSettings -> entitySpawnSettings
                                .spawnAlgorithm(new OpenAreaSpawnAlgorithm.Builder().direction(Direction.WEST).build())
                                // 1
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(3, 4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.GOLDEN_SWORD)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(2, 3)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
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
                                                                .immuneZombification(true)
                                                                .amount(2)
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 2
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(7, 9)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.GOLDEN_SWORD)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(4, 6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(7, 9)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.GOLDEN_SWORD)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(2, 3)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                .immuneZombification(true)
                                                                .amount(3, 4)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(6, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.STONE_SWORD)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 3
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(7, 9)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_SWORD)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(4, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(4, 6)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.GHAST)
                                                                .amount(2, 4)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(3, 5)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.STONE_SWORD)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(3, 5)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 4
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(6, 8)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                .immuneZombification(true)
                                                                .amount(2, 5)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("hoglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(5, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()

                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(3)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(2)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(3)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_AXE)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_brute_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.MAGMA_CUBE)
                                                                .amount(3, 5)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.GHAST)
                                                                .amount(2, 4)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("ghast_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 5
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(12, 15)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.GOLDEN_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .vehicle(
                                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                                .immuneZombification(true)
                                                                                .amount(1)
                                                                                .build()
                                                                )
                                                                .amount(4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW)  // todo 缓慢箭
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(6, 8)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(5, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .vehicle(new EntityInfo.Builder(EntityType.GHAST)
                                                                        .attachable(
                                                                                new CommonAttachable.Builder()
                                                                                        .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("ghast_legion"), 10, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                        .build()
                                                                        )
                                                                        .amount(1)
                                                                        .build())
                                                                .amount(5)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.SLOW_FALLING, 24000, 0, 10)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 6
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(10)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.FIREWORK_ROCKET)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)

                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(12)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("wither_skeleton_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .amount(18)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()

                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                .amount(6)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 1, 10)
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("hoglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 7
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(4, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.FIREWORK_ROCKET)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(4, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) // todo 反胃效果箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(4, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) // todo 黑暗效果箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(4, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) // todo 凋零效果箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build()

                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(18, 20)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("hoglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build(),

                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.STONE_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.LEATHER_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.LEATHER_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.LEATHER_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.LEATHER_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build()

                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(3)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.GHAST)
                                                                .amount(8)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("ghast_legion"), 20, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 8
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .vehicle(
                                                                        new EntityInfo.Builder(EntityType.MAGMA_CUBE)
                                                                                .amount(1)
                                                                                .attachable(
                                                                                        new CommonAttachable.Builder()
                                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 0, 10)
                                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("magma_cube_legion"), 20, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .amount(6, 8)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 0, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 20, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build(),
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .vehicle(
                                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                                .amount(1)
                                                                                .attachable(
                                                                                        new CommonAttachable.Builder()
                                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 1, 10)
                                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("hoglin_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .amount(5, 6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.IRON_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.IRON_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.IRON_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .vehicle(new EntityInfo.Builder(EntityType.GHAST)
                                                                        .attachable(
                                                                                new CommonAttachable.Builder()
                                                                                        .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("ghast_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                        .build()
                                                                        )
                                                                        .amount(1)
                                                                        .build())
                                                                .amount(4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.SLOW_FALLING, 24000, 0, 10)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .vehicle(
                                                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                                .amount(1)
                                                                                .attachable(
                                                                                        new CommonAttachable.Builder()
                                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("hoglin_legion"), 60, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                                .build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .amount(6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) //todo 凋零箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 9
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 0, 10)
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 0, 10)
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_brute_legion"), 40, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(8)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 1, 10)
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("wither_skeleton_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.GHAST)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 3, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("ghast_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .amount(1)
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 10
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(5, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 3, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_brute_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.MAGMA_CUBE)
                                                                .amount(7, 9)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 3, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_brute_legion"), 10, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build()

                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new EntityInfo.Builder(EntityType.GHAST)
                                                                .attachable(
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 6, 10)
                                                                                .build()
                                                                )
                                                                .amount(7, 9)
                                                                .build()
                                                ), 1
                                        )
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(10, 12)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.DIAMOND_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 3, 10)
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("wither_skeleton_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(6, 8)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.IRON_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.IRON_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 3, 10)
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("wither_skeleton_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build()
                                                ), 1
                                        )
                                )
                                // 11
                                .entitySpawnList(weightedEntityInfo -> weightedEntityInfo
                                        .add(
                                                List.of(
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(3, 4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) // todo 迟缓效果箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 2, 10)
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 40, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(3, 4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) // todo 反胃效果箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 2, 10)
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 40, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .amount(3, 4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.CROSSBOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) // todo 毒箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 2, 10)
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 40, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                                .amount(6, 7)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.BOW)
                                                                                .addEquipment(VanillaEquippableSlot.OFFHAND, Items.SPECTRAL_ARROW) // todo 凋零效果箭
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("wither_skeleton_legion"), 50, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                                .immuneZombification(true)
                                                                .amount(3, 4)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.NETHERITE_AXE)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.NETHERITE_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.NETHERITE_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.NETHERITE_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.NETHERITE_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 4, 10)
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 1, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_brute_legion"), 10, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .vehicle(new EntityInfo.Builder(EntityType.GHAST)
                                                                        .attachable(
                                                                                new CommonAttachable.Builder()
                                                                                        .addEffect(MobEffects.REGENERATION, 24000, 3, 10)
                                                                                        .addEffect(MobEffects.DAMAGE_BOOST, 24000, 1, 10)
                                                                                        .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("ghast_legion"), 60, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                        .build()
                                                                        )
                                                                        .amount(1)
                                                                        .build())
                                                                .amount(5, 6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.NETHERITE_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.NETHERITE_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.NETHERITE_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.NETHERITE_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.NETHERITE_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 2, 10)
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 1, 10)
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 1, 10)
                                                                                .addEffect(MobEffects.SLOW_FALLING, 24000, 0, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
                                                                                .build()
                                                                )
                                                                .build(),
                                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                                .immuneZombification(true)
                                                                .vehicle(new HoglinInfo.Builder(EntityType.HOGLIN)
                                                                        .amount(1)
                                                                        .attachable(
                                                                                new CommonAttachable.Builder()
                                                                                        .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 2, 10)
                                                                                        .addEffect(MobEffects.REGENERATION, 24000, 2, 10)
                                                                                        .addEffect(MobEffects.DAMAGE_BOOST, 24000, 2, 10)
                                                                                        .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("hoglin_legion"), 60, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                                        .build()
                                                                        )
                                                                        .build())
                                                                .amount(5, 6)
                                                                .attachable(
                                                                        new EquipmentAttachable.Builder()
                                                                                .addEquipment(VanillaEquippableSlot.MAINHAND, Items.NETHERITE_SWORD)
                                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.NETHERITE_HELMET, 1)
                                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.NETHERITE_CHESTPLATE, 1)
                                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.NETHERITE_LEGGINGS, 1)
                                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.NETHERITE_BOOTS, 1)
                                                                                .build(),
                                                                        new CommonAttachable.Builder()
                                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 24000, 2, 10)
                                                                                .addEffect(MobEffects.REGENERATION, 24000, 1, 10)
                                                                                .addEffect(MobEffects.DAMAGE_BOOST, 24000, 1, 10)
                                                                                .addEffect(MobEffects.SLOW_FALLING, 24000, 0, 10)
                                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 30, AttributeModifier.Operation.ADD_VALUE, 20)
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
