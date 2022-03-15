package dwarf.item.tool;

import dwarf.DwarfMain;
import dwarf.item.tool.radiy.RadiyMaterial;
import dwarf.item.tool.radiy.RadiyPickaxeItem;
import dwarf.item.tool.radiy.RadiySwordItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public class DwarfTools {

    private static final Map<Identifier, Item> TOOLITEMS = new LinkedHashMap<>();

    public static final ToolItem RADIY_SWORD =add("radiy_sword",new RadiySwordItem(RadiyMaterial.RADIY_MATERIAL,0,0f,settings()));
    public static final ToolItem RADIY_PICKAXE =add("radiy_pickaxe",new RadiyPickaxeItem(RadiyMaterial.RADIY_MATERIAL,0,1f,settings()));

    private static <I extends ToolItem> I add(String name, I item) {
        TOOLITEMS.put(new Identifier(DwarfMain.MODID, name), item);
        return item;
    }

    private static FabricItemSettings settings(){
        return new FabricItemSettings().group(DwarfMain.ITEM_GROUP_TOOLS);
    }

    public static void register(){
        TOOLITEMS.forEach((id, item) -> Registry.register(Registry.ITEM, id, TOOLITEMS.get(id)));
    }
}
