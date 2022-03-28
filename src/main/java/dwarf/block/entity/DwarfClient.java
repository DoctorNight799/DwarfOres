package dwarf.block.entity;

import dwarf.block.entity.screen.DwarfScreenHandlers;
import dwarf.block.entity.screen.SeparatorChannelerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class DwarfClient implements ClientModInitializer {
    public void onInitializeClient(){
        ScreenRegistry.register(DwarfScreenHandlers.SEPARATOR_SCREEN_HANDLER, SeparatorChannelerScreen::new);
    }
}
