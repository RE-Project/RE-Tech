package fr.reproject.tech.proxy;


import fr.reproject.tech.init.REBlocks;
import fr.reproject.tech.init.REItems;

public class CommonProxy {

    public void preInit() {
        REItems.init();
        REItems.registerItems();
        REBlocks.init();
        REBlocks.registerBlocks();
    }

    public void render() {

    }
}
