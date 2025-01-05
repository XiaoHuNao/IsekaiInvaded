package com.xiaohunao.isekai_invaded.common.init;

import com.mojang.serialization.MapCodec;
import com.xiaohunao.heaven_destiny_moment.client.gui.bar.render.DefaultBarRenderType;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.common.WorldUniqueMomentCondition;
import com.xiaohunao.heaven_destiny_moment.common.context.entity_info.EntityInfo;
import com.xiaohunao.heaven_destiny_moment.common.init.HDMRegistries;
import com.xiaohunao.heaven_destiny_moment.common.moment.Moment;
import com.xiaohunao.heaven_destiny_moment.common.moment.MomentInstance;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.RaidMoment;
import com.xiaohunao.heaven_destiny_moment.common.spawn_algorithm.ISpawnAlgorithm;
import com.xiaohunao.heaven_destiny_moment.common.spawn_algorithm.OpenAreaSpawnAlgorithm;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;

public class IIMoments {
    public static final ResourceKey<Moment<?>> PIGLIN_LEGION = IsekaiInvaded.asResourceKey(HDMRegistries.Keys.MOMENT, "piglin_legion");

    public static void bootstrap(BootstrapContext<Moment<?>> context) {
        context.register(PIGLIN_LEGION, new RaidMoment()
                        .setBarRenderType(new DefaultBarRenderType())
                        .setMomentData(momentData -> momentData
                                .entitySpawnSettings(entitySpawnSettings -> entitySpawnSettings
                                        .spawnAlgorithm(new OpenAreaSpawnAlgorithm(10,16))
                                        .entitySpawnList(
                                                new EntityInfo.Builder(EntityType.PIGLIN)
                                                    .amount(2)
                                                    .build()
                                        )
                                        .entitySpawnList(
                                                new EntityInfo.Builder(EntityType.PIGLIN)
                                                        .amount(2)
                                                        .weight(10)
                                                        .build(),
                                                new EntityInfo.Builder(EntityType.HOGLIN)
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
