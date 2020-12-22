package com.astrojardin.ruby;

import com.astrojardin.ruby.registry.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RubyMain implements ModInitializer {
    public static final String MOD_ID = "ruby";

    @Override
    public void onInitialize() {
        RegisterItems.register();
    }
}
