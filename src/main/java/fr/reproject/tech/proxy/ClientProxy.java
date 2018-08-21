package fr.reproject.tech.proxy;

import fr.reproject.tech.init.REItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void render() {
        REItems.registerRenders();
    }
}
