package com.xiaohunao.isekai_invaded.common.init;

import com.xiaohunao.heaven_destiny_moment.api.MomentManager;
import com.xiaohunao.heaven_destiny_moment.common.init.HDMRegistries;
import com.xiaohunao.heaven_destiny_moment.common.moment.IMoment;
import com.xiaohunao.heaven_destiny_moment.common.moment.Moment;
import com.xiaohunao.heaven_destiny_moment.common.moment.moment.RaidMoment;
import com.xiaohunao.isekai_invaded.IsekaiInvaded;
import com.xiaohunao.xhn_lib.api.register.holder.FlexibleHolder;
import com.xiaohunao.xhn_lib.api.register.register.FlexibleRegister;

public class IIMoments {
    public static final FlexibleRegister<IMoment> MOMENT = FlexibleRegister.create(HDMRegistries.MOMENT,IsekaiInvaded.MODID, MomentManager.getInstance());

    public static final FlexibleHolder<IMoment, RaidMoment> PIGLIN_LEGION = MOMENT.registerDynamic("piglin_legion");

}
