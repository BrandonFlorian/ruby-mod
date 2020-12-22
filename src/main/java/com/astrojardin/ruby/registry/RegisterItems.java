package com.astrojardin.ruby.registry;

import com.astrojardin.ruby.RubyItem;
import com.astrojardin.ruby.block.RubyBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

public class RegisterItems {

    public static final Item RUBY_ITEM = new RubyItem(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Block RUBY_BLOCK = new RubyBlock();

    public static void register() {
    Registry.register(Registry.ITEM, new Identifier("ruby", "ruby_item"), RUBY_ITEM);
    Registry.register(Registry.BLOCK, new Identifier("ruby", "ruby_block"), RUBY_BLOCK);
    Registry.register(Registry.ITEM, new Identifier("ruby", "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings().group(ItemGroup.MATERIALS)));
    }
}
