package fr.reproject.tech;

import fr.reproject.core.REModList;
import fr.reproject.tech.init.RETabs;
import fr.reproject.tech.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = RETech.MODID, name = RETech.NAME, version = RETech.VERSION, dependencies = "required-after:recore@[1.0.3,);")
public class RETech {

    public static final String MODID = "retech";
    public static final String NAME = "RE: Tech";
    public static final String VERSION = "1.0.0";
    public static final String CLIENT_PROXY_CLASSE = "fr.reproject.tech.proxy.ClientProxy";
    public static int id;

    public static final CreativeTabs RE_TECH = new RETabs.TechTab();

    @SidedProxy(clientSide = RETech.CLIENT_PROXY_CLASSE)
    public static CommonProxy proxy;


    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        id = REModList.loadMod(MODID, NAME) - 1;
        REModList.initLoadMod(id);
        logger = event.getModLog();
        logger.info("[RE: Tech] i get " + id + " for id in RE: Core");
        proxy.preInit();
        proxy.render();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
