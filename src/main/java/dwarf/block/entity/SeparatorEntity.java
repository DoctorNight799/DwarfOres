package dwarf.block.entity;

import dwarf.block.entity.screen.SeparatorChannelerScreenHandler;
import dwarf.item.DwarfItems;
import dwarf.item.inventory.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SeparatorEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3,ItemStack.EMPTY);

    public  SeparatorEntity(BlockPos pos, BlockState state){
        super(DwarfBlockEntities.SEPARATOR_ENTITY, pos,state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public ItemStack getInvStack(int i) {
        return null;
    }

    @Override
    public int getInvSize() {
        return 0;
    }

    @Override
    public int getInvMaxStackAmount() {
        return 0;
    }

    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inventory);
    }

    public void writeNbt(NbtCompound nbt){
        Inventories.writeNbt(nbt, inventory);
        /*Где? return*/ super.writeNbt(nbt);
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Separator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new SeparatorChannelerScreenHandler(syncId,inv,this);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SeparatorEntity entity){
        if(hasRecipe(entity) && hasNotReacheadStackLimit(entity)){
            craftItem(entity);

            if(!world.isClient()){
                EntityType.LIGHTNING_BOLT.spawn((ServerWorld) world, null, null, null, pos,
                        SpawnReason.TRIGGERED, true, true);
            }
        }
    }

    private static void craftItem(SeparatorEntity entity) {
        entity.removeStack(0,1);
        entity.removeStack(1,1);

        entity.setStack(2,new ItemStack(DwarfItems.CLEAN_RADIY, entity.getStack(2).getCount() + 1));
    }

    private static boolean hasRecipe(SeparatorEntity entity){
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == DwarfItems.RADIY;
        boolean hasItemInSecondSlot = entity.getStack(0).getItem() == DwarfItems.LIMURIUM;

        return  hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static boolean hasNotReacheadStackLimit(SeparatorEntity entity){
        return entity.getStack(2).getCount() < entity.getStack(2).getMaxCount();
    }
}
