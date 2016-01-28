package max.hubbard.bettershops.Versions.v1_7_R4.Entities;

import net.minecraft.server.v1_7_R4.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftHorse;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftLivingEntity;
import org.bukkit.entity.Horse;
import org.bukkit.event.entity.CreatureSpawnEvent;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class HorseNPC extends EntityHorse{
    public HorseNPC(World world) {
        super(world);
    }


    @Override
    public void move(double d0, double d1, double d2) {
        return;
    }
         @Override
     public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override
    public void g(double x, double y, double z) {
            }


    public static Horse spawn(Location location) {

        MinecraftServer server = MinecraftServer.getServer();
        WorldServer world = server.getWorldServer(0);
        for (WorldServer ws : server.worlds){
            if (ws.getWorld().getName().equals(location.getWorld().getName())){
                world = ws;
                break;
            }
        }
        World mcWorld = (World) ((CraftWorld) location.getWorld()).getHandle();
        final HorseNPC customEntity = new HorseNPC(
                world);
        customEntity.setLocation(location.getX(), location.getY(),
                location.getZ(), location.getYaw(), location.getPitch());
        ((CraftLivingEntity) customEntity.getBukkitEntity())
                .setRemoveWhenFarAway(false);
        mcWorld.addEntity(customEntity, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (CraftHorse) customEntity.getBukkitEntity();
    }
}
