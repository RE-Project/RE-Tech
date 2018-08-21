package fr.reproject.tech.proxy;


import fr.reproject.tech.init.REItems;

public class CommonProxy {

    public void preInit() {
        REItems.init();
        REItems.registerItems();
    }

    public void render() {

    }
}
