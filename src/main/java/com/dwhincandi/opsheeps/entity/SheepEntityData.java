package com.dwhincandi.opsheeps.entity;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//! CURRENT ERROR:  java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18

public class SheepEntityData {
    public static final Logger LOGGER = LogManager.getLogger(SheepEntityData.class);

    public static final TrackedData<Boolean> IS_OP_SHEEP = DataTracker.registerData(SheepEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    static {
        try {
            LOGGER.debug("IS_OP_SHEEP DataTracker für SheepEntity registriert.");
        } catch (Exception e) {
            LOGGER.error("Error occurred while registering IS_OP_SHEEP DataTracker", e);
        }
    }
}
