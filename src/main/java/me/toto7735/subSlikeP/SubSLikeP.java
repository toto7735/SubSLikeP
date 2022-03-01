package me.toto7735.subSlikeP;

import me.toto7735.subSlikeP.listener.Listener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class SubSLikeP extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Enabled!");

        ItemStack item = new ItemStack(Material.HONEYCOMB);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c[YOUTUBE] §fVideo With Sincerity");
        meta.setLore(Arrays.asList("§7This is a very carefully crafted video"));
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(this, "video");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("PIP", "III", "PPP");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('P', Material.OAK_PLANKS);
        Bukkit.addRecipe(recipe);

        Bukkit.getPluginManager().registerEvents(new Listener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Disabled!");
    }
}
