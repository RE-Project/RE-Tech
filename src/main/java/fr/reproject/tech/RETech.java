package fr.reproject.tech;

import fr.reproject.core.REModList;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = RETech.MODID, name = RETech.NAME, version = RETech.VERSION, dependencies = "required-after:recore@[1.0.3,);")
public class RETech {

    public static final String MODID = "retech";
    public static final String NAME = "RE: Tech";
    public static final String VERSION = "1.0.0";
    public static int id;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        id = REModList.loadMod(MODID, NAME);
        REModList.initLoadMod(id);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
