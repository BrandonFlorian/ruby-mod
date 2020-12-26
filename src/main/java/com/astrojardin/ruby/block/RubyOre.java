package com.astrojardin.ruby.block;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;

public class RubyOre extends OreBlock {
    public RubyOre() {
        super(FabricBlockSettings.of(Material.METAL)
                .breakByHand(false)
                .breakByTool(FabricToolTags.PICKAXES)
                .strength(3, 0.6f)
                .sounds(BlockSoundGroup.METAL));
    }
}
