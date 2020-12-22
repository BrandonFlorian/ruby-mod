package com.astrojardin.ruby.registry;

import com.astrojardin.ruby.RubyItem;
import com.astrojardin.ruby.armor.BaseArmor;
import com.astrojardin.ruby.armor.RubyArmorMaterial;
import com.astrojardin.ruby.block.RubyBlock;
import com.astrojardin.ruby.tools.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

public class RegisterItems {

    public static final String MODID = "ruby";
    public static final Item RUBY_ITEM = new RubyItem(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Block RUBY_BLOCK = new RubyBlock();

    public static final ArmorMaterial RUBY_ARMOR = new RubyArmorMaterial();

    public static void register() {
    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_item"), RUBY_ITEM);
    Registry.register(Registry.BLOCK, new Identifier(MODID, "ruby_block"), RUBY_BLOCK);
    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings().group(ItemGroup.MATERIALS)));

    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_pickaxe"), new PickaxeBase(new ToolMaterialRuby()));
    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_axe"), new AxeBase(new ToolMaterialRuby()));
    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_shovel"), new ShovelBase(new ToolMaterialRuby()));
    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_hoe"), new HoeBase(new ToolMaterialRuby()));




//    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_helmet"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.HEAD));
//    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_chestplate"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.CHEST));
//    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_leggings"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.LEGS));
//    Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_boots"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.FEET));
    }
}
