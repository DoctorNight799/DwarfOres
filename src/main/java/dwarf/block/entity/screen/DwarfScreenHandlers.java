package dwarf.block.entity.screen;

import dwarf.DwarfMain;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class DwarfScreenHandlers {
    public static ScreenHandlerType<SeparatorChannelerScreenHandler> SEPARATOR_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(DwarfMain.MODID, "separator"),
                    SeparatorChannelerScreenHandler::new);
}