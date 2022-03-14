package dwarf;

import dwarf.block.DwarfBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DwarfMain implements ModInitializer {
    public static final String MODID = ("dwarf");

    public static final ItemGroup ITEM_GROUP_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier(MODID, "blocks"),
            () -> new ItemStack(DwarfBlocks.RADIUSK));
    @Override
    public void onInitialize() {
        DwarfBlocks.register();

        }
        public static Identifier newId(String path){
        return new Identifier(MODID, path);
    }
}
