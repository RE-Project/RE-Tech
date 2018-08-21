package fr.reproject.tech.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RETabs {

    public static class TechTab extends CreativeTabs {

        public TechTab() {
            super("tabTech");
        }

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.COMMAND_BLOCK_MINECART);
        }
    }
}
