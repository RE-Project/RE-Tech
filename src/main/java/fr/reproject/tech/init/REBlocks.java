package fr.reproject.tech.init;

import fr.reproject.core.utils.Register;
import fr.reproject.tech.RETech;
import net.minecraft.block.Block;

public class REBlocks {

    private static int numberOfBlock = 0;

    public static Block[] blocks;

    public static void init() {



        blocks = new Block[]{
        };
    }

    public static void registerBlocks() {
        for(int i = 0; i <= numberOfBlock - 1; i++) {
            Register.registerBlock(blocks[i], RETech.RE_TECH, RETech.logger);

        }
    }

    public static void registerRenders() {
        for(int i = 0; i <= numberOfBlock - 1; i++) {
            Register.registerRender(blocks[i], RETech.id, RETech.logger);
        }
    }
}
