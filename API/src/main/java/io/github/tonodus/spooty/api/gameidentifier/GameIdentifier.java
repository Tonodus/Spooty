package io.github.tonodus.spooty.api.gameidentifier;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.text.message.Message;

/**
 * A GameIdentifier that can be used change multiple game element.
 */
public interface GameIdentifier {
    <M> Message<M> apply(Message<M> on);

    BlockState apply(BlockState block);

    org.spongepowered.api.entity.Entity apply(Entity entity);

    static GameIdentifier none() {
        return new AbstractGameIdentifier();
    }

    static GameIdentifier forMultiple(GameIdentifier... contents) {
        return new GameIdentifier() {
            @Override
            public <M> Message<M> apply(Message<M> on) {
                Message<M> c = on;
                for (GameIdentifier i : contents)
                    c = i.apply(c);
                return c;
            }

            @Override
            public BlockState apply(BlockState block) {
                BlockState c = block;
                for (GameIdentifier i : contents)
                    c = i.apply(c);
                return c;
            }

            @Override
            public org.spongepowered.api.entity.Entity apply(Entity entity) {
                org.spongepowered.api.entity.Entity c = entity;
                for (GameIdentifier i : contents)
                    c = i.apply(c);
                return c;
            }
        };
    }
}
