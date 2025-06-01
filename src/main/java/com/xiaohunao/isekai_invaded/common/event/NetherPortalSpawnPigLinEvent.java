package com.xiaohunao.isekai_invaded.common.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.ICancellableEvent;

public class NetherPortalSpawnPigLinEvent extends Event implements ICancellableEvent {
    private BlockState state;
    private ServerLevel level;
    private BlockPos pos;

    public NetherPortalSpawnPigLinEvent(BlockState state, ServerLevel level, BlockPos pos) {
        this.state = state;
        this.level = level;
        this.pos = pos;
    }

    public BlockState getState() {
        return state;
    }

    public ServerLevel getLevel() {
        return level;
    }

    public BlockPos getPos() {
        return pos;
    }
}
