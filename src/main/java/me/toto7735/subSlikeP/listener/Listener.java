package me.toto7735.subSlikeP.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;

public class Listener implements org.bukkit.event.Listener {

    @EventHandler
    public void onInteractAtEntity(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand() == null || !player.getInventory().getItemInMainHand().hasItemMeta()
                || player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() == null ||
                !player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§c[YOUTUBE] §fVideo With Sincerity")) return;
        if (event.getRightClicked().getType().equals(EntityType.SHEEP)) {
            event.getRightClicked().setCustomName("§c[YOUTUBE] §fSubscribe Sheep");
            for (int i = 0; i < 5; ++i) player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, event.getRightClicked().getLocation().add(new Random().nextInt(1 + 1) - 1, new Random().nextInt(1 + 1) - 1, new Random().nextInt(1 + 1) - 1), 1);
            player.playSound(player.getLocation(), Sound.ENTITY_SHEEP_AMBIENT, 1, 2);
            player.sendMessage("§c[YOUTUBE] §fSubscribe Sheep: Meh!");
            ItemStack subscribe = new ItemStack(Material.DIAMOND);
            ItemMeta itemMeta = subscribe.getItemMeta();
            itemMeta.setDisplayName("§c§kLL §c[YOUTUBE] §fSubScribe §c§kLL");
            itemMeta.setLore(Arrays.asList("§7It's someone's precious subscription", "§eRight-Click to eat!"));
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            subscribe.setItemMeta(itemMeta);
            player.getWorld().dropItem(event.getRightClicked().getLocation(), subscribe);
        } else if (event.getRightClicked().getType().equals(EntityType.PIG)) {
            event.getRightClicked().setCustomName("§c[YOUTUBE] §fSubscribe Pig");
            for (int i = 0; i < 5; ++i) player.getWorld().spawnParticle(Particle.CRIT, event.getRightClicked().getLocation().add(new Random().nextInt(1 + 1) - 1, new Random().nextInt(1 + 1) - 1, new Random().nextInt(1 + 1) - 1), 1);
            player.playSound(player.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1, 2);
            player.sendMessage("§c[YOUTUBE] §fLike Pig: Oink Oink!");
            ItemStack like = new ItemStack(Material.EMERALD);
            ItemMeta itemMeta = like.getItemMeta();
            itemMeta.setDisplayName("§c§kLL §c[YOUTUBE] §fLike §c§kLL");
            itemMeta.setLore(Arrays.asList("§7It's someone's precious like", "§eRight-Click to eat!"));
            itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            like.setItemMeta(itemMeta);
            player.getWorld().dropItem(event.getRightClicked().getLocation(), like);
        } else return;
        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getInventory().getItemInMainHand() == null || !player.getInventory().getItemInMainHand().hasItemMeta()
                || player.getInventory().getItemInMainHand().getItemMeta().getDisplayName() == null) return;
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§c§kLL §c[YOUTUBE] §fSubScribe §c§kLL")) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 2);
            player.sendTitle("§6Yummy!", "§7Subscribe is awesome!", 5, 30, 10);
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        } else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§c§kLL §c[YOUTUBE] §fLike §c§kLL")) {
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 0.5F);
            player.sendTitle("§aAewsome!", "§7Like is awesome!", 5, 30, 10);
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        }
    }
}
