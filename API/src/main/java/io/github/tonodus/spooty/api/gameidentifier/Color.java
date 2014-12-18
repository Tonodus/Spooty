package io.github.tonodus.spooty.api.gameidentifier;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.living.Dyeable;
import org.spongepowered.api.entity.living.meta.DyeColor;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.message.Message;

public interface Color extends GameIdentifier {
    @Override
    default public <M> Message<M> apply(Message<M> on) {
        return on.builder().color(toTextColor()).build();
    }

    @Override
    default public Entity apply(Entity entity) {
        if (entity instanceof FallingBlock) {
            FallingBlock b = (FallingBlock) entity;
            b.setBlockState(apply(b.getBlockState()));
        } else if (entity instanceof Dyeable) {
            ((Dyeable) entity).setColor(toDyeColor());
        }

        return entity;
    }

    TextColor toTextColor();

    DyeColor toDyeColor();
}
