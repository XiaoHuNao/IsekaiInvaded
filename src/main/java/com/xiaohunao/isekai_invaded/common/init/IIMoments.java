package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.heaven_destiny_moment.api.MomentManager;
import com.xiaohunao.heaven_destiny_moment.common.init.HDMRegistries;
import com.xiaohunao.heaven_destiny_moment.common.moment.Moment;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.xhn_lib.api.register.FlexibleHolder;
import com.xiaohunao.xhn_lib.api.register.FlexibleRegister;

public class IIMoments {
    public static final FlexibleRegister<Moment> MOMENT = FlexibleRegister.create(HDMRegistries.MOMENT,IsekaiInvaded.MODID, MomentManager.getInstance());

    public static final FlexibleHolder<Moment,?> PIGLIN_LEGION = MOMENT.registerDynamic("piglin_legion");

}
