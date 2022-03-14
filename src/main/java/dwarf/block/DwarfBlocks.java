package dwarf.block;

import dwarf.DwarfMain;
import dwarf.block.base.BasedBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class DwarfBlocks {
    public static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    public static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block RADIUSK =add("radiusk",new BasedBlock(3.0f,3.0f,2));

    private static <B extends Block> B add(String name, B block) {
        Item.Settings settings = new Item.Settings();
        settings.group(DwarfMain.ITEM_GROUP_BLOCKS);
        return addBlockItem(name, block, new BlockItem(block, settings));
    }

    private static <B extends Block> B addBlockItem(String name, B block, BlockItem item) {
        addBlock(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(new Identifier(DwarfMain.MODID, name), item);
        }
        return block;
    }

    private static <B extends Block> B addBlock(String name, B block) {
        BLOCKS.put(new Identifier(DwarfMain.MODID, name), block);
        return block;
    }

    public static void register() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, ITEMS.get(id)));
        BLOCKS.forEach((id, block) -> Registry.register(Registry.BLOCK, id, BLOCKS.get(id)));
    }

    public static Map<Identifier, Block> getBlocks() {
        return BLOCKS;
    }
}
