package dwarf.item.tool.radiy;

import dwarf.item.DwarfItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RadiyMaterial implements ToolMaterial {

    public static final RadiyMaterial RADIY_MATERIAL = new RadiyMaterial();

    @Override
    public int getDurability() {
        return 280;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.5f;
    }

    @Override
    public float getAttackDamage() {
        return 2.5f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(DwarfItems.RADIY);
    }
}
