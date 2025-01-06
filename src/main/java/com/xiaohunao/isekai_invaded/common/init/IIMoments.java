package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.heaven_destiny_moment.client.gui.bar.render.DefaultBarRenderType;
import com.xiaohunao.heaven_destiny_moment.common.context.attachable.CommonAttachable;
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
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Items;

public class IIMoments {
    public static final ResourceKey<Moment<?>> PIGLIN_LEGION = IsekaiInvaded.asResourceKey(HDMRegistries.Keys.MOMENT, "piglin_legion");

    public static void bootstrap(BootstrapContext<Moment<?>> context) {
        context.register(PIGLIN_LEGION, new RaidMoment()
                .setBarRenderType(new DefaultBarRenderType())
                .setMomentData(momentData -> momentData
                        .entitySpawnSettings(entitySpawnSettings -> entitySpawnSettings
                                .spawnAlgorithm(new OpenAreaSpawnAlgorithm(10, 16))
                                .entitySpawnList(
                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                .immuneZombification(true)
                                                .amount(2)
                                                .build()
                                )
                                .entitySpawnList(
                                        new EntityInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                .amount(2, 4)
                                                .attachable(
                                                        new CommonAttachable.Builder()
                                                                .addEffect(MobEffects.REGENERATION, 100, 0)

                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE)

                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET.getDefaultInstance())
                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE.getDefaultInstance())
                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS.getDefaultInstance())
                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS.getDefaultInstance())
                                                                .build()
                                                )
                                                .build(),
                                        new EntityInfo.Builder(EntityType.PIGLIN_BRUTE)
                                                .amount(2, 4)
                                                .attachable(
                                                        new CommonAttachable.Builder()
                                                                .addEffect(MobEffects.REGENERATION, 100, 0, 10)
                                                                .addEffect(MobEffects.MOVEMENT_SPEED, 100, 0, 10)
                                                                .addEffect(MobEffects.DAMAGE_RESISTANCE, 100, 0, 10)

                                                                .addAttribute(Attributes.MAX_HEALTH, IsekaiInvaded.asResource("piglin_legion"), 5, AttributeModifier.Operation.ADD_VALUE, 10)
                                                                .addAttribute(Attributes.ARMOR, IsekaiInvaded.asResource("piglin_legion"), 0.5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, 10)
                                                                .addAttribute(Attributes.JUMP_STRENGTH, IsekaiInvaded.asResource("piglin_legion"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, 10)

                                                                .addEquipment(VanillaEquippableSlot.HEAD, Items.DIAMOND_HELMET.getDefaultInstance(), 10)
                                                                .addEquipment(VanillaEquippableSlot.CHEST, Items.DIAMOND_CHESTPLATE.getDefaultInstance(), 10)
                                                                .addEquipment(VanillaEquippableSlot.LEGS, Items.DIAMOND_LEGGINGS.getDefaultInstance(), 10)
                                                                .addEquipment(VanillaEquippableSlot.FEET, Items.DIAMOND_BOOTS.getDefaultInstance(), 10)
                                                                .build()
                                                )
                                                .build()
                                )
                                .entitySpawnList(
                                        new PiglinInfo.Builder(EntityType.PIGLIN)
                                                .immuneZombification(true)
                                                .amount(2)
                                                .weight(10)
                                                .build(),
                                        new HoglinInfo.Builder(EntityType.HOGLIN)
                                                .immuneZombification(true)
                                                .amount(2)
                                                .weight(10)
                                                .build(),
                                        new EntityInfo.Builder(EntityType.WITHER_SKELETON)
                                                .amount(2)
                                                .weight(10)
                                                .build()
                                )
                        )
                        .conditionGroup(group -> group
                                .create(false, WorldUniqueMomentCondition.DEFAULT)
                        )
                )
        );
    }
}
