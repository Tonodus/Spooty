package io.github.tonodus.spooty.api.gameidentifier;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.entity.living.meta.DyeColor;
import org.spongepowered.api.text.format.TextColor;

public class ColorImpl implements Color {
    private final TextColor tcolor;
    private final DyeColor dcolor;

    public ColorImpl(TextColor tcolor, DyeColor dcolor) {
        this.tcolor = tcolor;
        this.dcolor = dcolor;
    }

    @Override
    public TextColor toTextColor() {
        return tcolor;
    }

    @Override
    public DyeColor toDyeColor() {
        return dcolor;
    }

    @Override
    public BlockState apply(BlockState block) {
        //TODO
        return block;
    }
}
