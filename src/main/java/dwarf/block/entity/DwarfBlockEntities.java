package dwarf.block.entity;

import dwarf.DwarfMain;
import dwarf.block.DwarfBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DwarfBlockEntities {
    public static BlockEntityType<SeparatorEntity> SEPARATOR_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DwarfMain.MODID, "separator"),
                    FabricBlockEntityTypeBuilder.create(SeparatorEntity::new,
                            DwarfBlocks.SEPARATOR).build(null));

    protected void readNbt(NbtCompound nbt) {
    }
}
