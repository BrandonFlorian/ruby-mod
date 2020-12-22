package com.astrojardin.ruby.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class RubyBlock extends Block {
    public RubyBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                .breakByHand(false)
                .breakByTool(FabricToolTags.PICKAXES)
                .strength(5, 0.6f)
                .sounds(BlockSoundGroup.METAL));
    }
}
