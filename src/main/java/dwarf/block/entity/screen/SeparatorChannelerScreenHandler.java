package dwarf.block.entity.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;

public class SeparatorChannelerScreenHandler extends ScreenHandler{
    private final Inventory inventory;
    private final World world;

    public SeparatorChannelerScreenHandler(int syncId,PlayerInventory playerInventory) {
        this(syncId,playerInventory,new SimpleInventory(3));
    }
    public SeparatorChannelerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(DwarfScreenHandlers.SEPARATOR_SCREEN_HANDLER, syncId);
        checkSize(inventory,3);
        this.inventory = inventory;
        this.world = playerInventory.player.world;
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory,0,80,31));
        this.addSlot(new Slot(inventory,1,80,53));
        this.addSlot(new Slot(inventory,2,123,42));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public ItemStack transferSlot(PlayerEntity player, int invSlot){
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()){
            ItemStack orginalStack = slot.getStack();
            newStack = orginalStack.copy();
            if(invSlot < this.inventory.size()){
                if(!this.insertItem(orginalStack, this.inventory.size(), this.slots.size(), false)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(orginalStack, 0 , this.inventory.size(), false)){
                return ItemStack.EMPTY;
            }

            if (orginalStack.isEmpty()){
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
    private void addPlayerInventory(PlayerInventory playerInventory){
        for (int i = 0; i< 3; ++i){
            for(int l = 0; l <9; ++l){
                this.addSlot(new Slot(playerInventory, l +i *9 + 9, 8+l *18, 86 + i *18));
            }
        }
    }
    private  void addPlayerHotbar(PlayerInventory playerInventory){
        for (int i =0; i < 9; ++i){
            this.addSlot(new Slot(playerInventory, i, 8+i *18, 144));
        }
    }
}
