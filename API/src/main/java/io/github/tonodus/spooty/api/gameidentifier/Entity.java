package io.github.tonodus.spooty.api.gameidentifier;

import org.spongepowered.api.entity.EntityType;

public class Entity extends AbstractGameIdentifier {
    private final EntityType type;

    public Entity(EntityType type) {
        this.type = type;
    }

    @Override
    public org.spongepowered.api.entity.Entity apply(org.spongepowered.api.entity.Entity entity) {
        //TODO
        return entity;
    }
}
