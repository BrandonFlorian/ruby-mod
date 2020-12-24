package com.astrojardin.ruby.utility;

import com.mojang.authlib.GameProfile;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.block.Block;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BedItem;
import net.minecraft.item.CompassItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.EventObject;
import java.util.Optional;

public class RubySlippers extends Item {

    public RubySlippers(Settings settings) {
        super(settings);
    }

    //Attempts to find the players spawn position and teleports them to it.
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        try {
            MinecraftServer server = world.getServer();
            String playerName = playerEntity.getName().asString();
            PlayerManager playerManager = server.getPlayerManager();
            ServerPlayerEntity serverPlayer = playerManager.getPlayer(playerName);
            BlockPos pos = serverPlayer.getSpawnPointPosition();
            playerEntity.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            if(pos != null){
                double x = pos.getX();
                double y = pos.getY();
                double z = pos.getZ();
                serverPlayer.teleport(x, y, z);
                //playerEntity.teleport(x, y, z);
            }

            return TypedActionResult.success(playerEntity.getStackInHand(hand));
        }
        catch(Exception e){
            System.out.println("Error message: " + e.getMessage() + e.toString());
            return TypedActionResult.fail(playerEntity.getStackInHand(hand));
        }

        //return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    //not used at the moment
    public BlockPos getBedLocation(World world, PlayerEntity playerEntity){
        try{
            MinecraftServer server = world.getServer();
            String playerName = playerEntity.getName().asString();
            PlayerManager playerManager = server.getPlayerManager();
            ServerPlayerEntity serverPlayer = playerManager.getPlayer(playerName);
            BlockPos pos = serverPlayer.getSpawnPointPosition();
            return pos;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
