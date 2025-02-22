package com.dwhincandi.opsheeps.entity;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;

public class SheepEntityData {
    public static final TrackedData<Boolean> IS_OP_SHEEP = DataTracker.registerData(SheepEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
}
