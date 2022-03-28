package dwarf;

import dwarf.block.DwarfBlocks;
import dwarf.item.DwarfItems;
import dwarf.item.tool.DwarfTools;
import dwarf.worldgen.feature.DwarfConfiguredFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class DwarfMain implements ModInitializer {

    public static final String MODID = ("dwarf");

    public static final ItemGroup ITEM_GROUP_BLOCKS = FabricItemGroupBuilder.build(
            new Identifier(MODID, "blocks"),
            () -> new ItemStack(DwarfBlocks.RADIUSK));

    public static final ItemGroup ITEM_GROUP_ITEMS = FabricItemGroupBuilder.build(
            new Identifier(MODID, "items"),
            () -> new ItemStack(DwarfItems.RADIY));

    public static final ItemGroup ITEM_GROUP_TOOLS = FabricItemGroupBuilder.build(
            new Identifier(MODID, "tools"),
            () -> new ItemStack(DwarfTools.RADIY_PICKAXE));


    @Override
    public void onInitialize() {
        DwarfBlocks.register();
        DwarfItems.register();
        DwarfConfiguredFeature.register();
        DwarfTools.register();
    }

    public static Identifier newId(String path){
        return new Identifier(MODID, path);
    }
}
