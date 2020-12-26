package com.astrojardin.ruby.registry;

import com.astrojardin.ruby.RubyItem;
import com.astrojardin.ruby.RubyMain;
import com.astrojardin.ruby.armor.BaseArmor;
import com.astrojardin.ruby.armor.RubyArmorMaterial;
import com.astrojardin.ruby.block.RubyBlock;
import com.astrojardin.ruby.block.RubyOre;
import com.astrojardin.ruby.tools.*;
import com.astrojardin.ruby.utility.RubySlippers;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class RegisterItems {

    public static final String MODID = RubyMain.MOD_ID;
    public static final Item RUBY_ITEM = new RubyItem(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Block RUBY_BLOCK = new RubyBlock();
    public static final OreBlock RUBY_ORE = new RubyOre();

    public static final ArmorMaterial RUBY_ARMOR = new RubyArmorMaterial();

    public static final RubySlippers RUBY_SLIPPERS = new RubySlippers(new Item.Settings().group(ItemGroup.MISC));


    private static ConfiguredFeature<?, ?> RUBY_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    RUBY_ORE.getDefaultState(),
                    9)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    0, // min y level
                    64))) // max y level
            .spreadHorizontally()
            .repeat(20); // number of veins per chunk

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_item"), RUBY_ITEM);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings().group(ItemGroup.MATERIALS)));

        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_pickaxe"), new PickaxeBase(new ToolMaterialRuby()));
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_axe"), new AxeBase(new ToolMaterialRuby()));
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_shovel"), new ShovelBase(new ToolMaterialRuby()));
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_hoe"), new HoeBase(new ToolMaterialRuby()));

        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_helmet"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_chestplate"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_leggings"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_boots"), new BaseArmor(RUBY_ARMOR, EquipmentSlot.FEET));

        Registry.register(Registry.ITEM, new Identifier(MODID, "ruby_slippers"), RUBY_SLIPPERS);

        RegistryKey<ConfiguredFeature<?, ?>> oreRubyOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier(MODID, "ruby_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreRubyOverworld.getValue(), RUBY_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreRubyOverworld);


//        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
//            if (RUBY_ORE.equals(id)) {
//                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
//                        .rolls(ConstantLootTableRange.create(1))
//                        .withEntry(ItemEntry.builder(RUBY_ORE).build());
//
//                supplier.withPool(poolBuilder.build());
//            }
//        });

    }
}
