package io.github.tonodus.spooty.api.gameidentifier;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.text.message.Message;

public class AbstractGameIdentifier implements GameIdentifier {
    @Override
    public <M> Message<M> apply(Message<M> on) {
        return on;
    }

    @Override
    public BlockState apply(BlockState block) {
        return block;
    }

    @Override
    public org.spongepowered.api.entity.Entity apply(Entity entity) {
        return entity;
    }
}
