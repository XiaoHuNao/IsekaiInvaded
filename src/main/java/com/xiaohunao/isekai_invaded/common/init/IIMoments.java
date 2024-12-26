package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.heaven_destiny_moment.HeavenDestinyMoment;
import com.xiaohunao.heaven_destiny_moment.common.context.condition.WorldUniqueMomentCondition;
import com.xiaohunao.heaven_destiny_moment.common.init.HDMBarRenderTypes;
import com.xiaohunao.heaven_destiny_moment.common.init.HDMRegistries;
import com.xiaohunao.heaven_destiny_moment.common.moment.Moment;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.DefaultMoment;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;

public class IIMoments {
    public static final ResourceKey<Moment> PIGLIN_LEGION = IsekaiInvaded.asResourceKey(HDMRegistries.Keys.MOMENT, "piglin_legion");

    public static void bootstrap(BootstrapContext<Moment> context) {
        context.register(PIGLIN_LEGION, new DefaultMoment()
                        .setBarRenderType(HDMBarRenderTypes.DEFAULT.get()).setMomentData(momentData -> momentData
                                        .conditionGroup(group -> group
                                                        .create(false, WorldUniqueMomentCondition.DEFAULT)
                                        )
                        )
        );
    }
}
