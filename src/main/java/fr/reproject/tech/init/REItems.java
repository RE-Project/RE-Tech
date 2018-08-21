package fr.reproject.tech.init;

import fr.reproject.core.basic.REItem;
import fr.reproject.core.utils.Register;
import fr.reproject.tech.RETech;
import net.minecraft.item.Item;

public class REItems {
    private static int numberOfItem = 1;

    public static Item[] items;

    public static void init() {
        Item testTube = new REItem( "testtube", RETech.MODID); //item 1, 0 for the game



        items = new Item[]{
                testTube
        };
    }

    public static void registerItems() {
        for(int i = 0; i <= numberOfItem - 1; i++) {
            Register.registerItem(items[i], RETech.RE_TECH, RETech.logger);

        }
    }

    public static void registerRenders() {
        for(int i = 0; i <= numberOfItem - 1; i++) {
            //Register.registerRender(items[i], RETech.MODID, RETech.logger);
            Register.registerRender(items[i], RETech.id, RETech.logger);
        }
    }
}
