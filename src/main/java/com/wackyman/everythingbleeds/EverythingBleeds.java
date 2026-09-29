package com.wackyman.everythingbleeds;

import absolutelyaya.goop.api.DamageGoopEmitter;
import absolutelyaya.goop.api.GoopEmitterRegistry;
import absolutelyaya.goop.api.GoopInitializer;
import absolutelyaya.goop.api.WaterHandling;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.MathHelper;
import org.joml.Vector4f;

/**
 * Goop 1.20.x-0.3 addon equivalent of the old Everything Bleeds emitter.
 */
public final class EverythingBleeds implements GoopInitializer {

    @Override
    public void registerGoopEmitters() {

        DamageGoopEmitter<LivingEntity> emitter = new DamageGoopEmitter<>(
                (entity, data) -> 0xb11208,

                (entity, data) -> new Vector4f(
                        0f,
                        0f,
                        0f,
                        Math.min(data.amount() / 5f, 0.8f)
                ),

                (entity, data) -> MathHelper.clamp(
                        Math.round(data.amount() / 2f),
                        1,
                        32
                ),

                (entity, data) -> Math.min(
                        0.75f
                                + data.amount() / 4f
                                + entity.getRandom().nextFloat() * 0.3f,
                        2f
                )
        );

        emitter.setWaterHandling(WaterHandling.REPLACE_WITH_CLOUD_PARTICLE);

        for (EntityType<?> type : Registries.ENTITY_TYPE) {

            if (!LivingEntity.class.isAssignableFrom(type.getBaseClass())) {
                continue;
            }

            @SuppressWarnings("unchecked")
            EntityType<? extends LivingEntity> livingType =
                    (EntityType<? extends LivingEntity>) type;

            GoopEmitterRegistry.registerEmitter(livingType, emitter);
        }
    }
}
