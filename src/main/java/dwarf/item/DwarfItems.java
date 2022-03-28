package dwarf.item;

import dwarf.DwarfMain;
import dwarf.item.base.BasedItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class DwarfItems {
    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item RADIY = add("radiy", new BasedItem(settings()));
    public static final Item CLEAN_RADIY = add("clean_radiy", new BasedItem(settings()));
    public static final Item LIMURIUM = add("limurium", new BasedItem(settings()));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(DwarfMain.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(DwarfMain.ITEM_GROUP_ITEMS);
    }

    public static void register() {
        ITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, ITEMS.get(id)));
    }
}
