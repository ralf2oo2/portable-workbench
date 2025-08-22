package ralf2oo2.portableworkbench.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipeManager;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.world.World;
import ralf2oo2.portableworkbench.item.PortableWorkbenchItem;
import ralf2oo2.portableworkbench.screen.slot.PortableCraftingResultSlot;

public class PortableWorkbenchScreenHandler extends ScreenHandler {
    public CraftingInventory input = new CraftingInventory(this, 3, 3);
    public Inventory result = new CraftingResultInventory();
    public World world;

    public PortableWorkbenchScreenHandler(PlayerInventory playerInventory, World world){
        this.world = world;


        this.addSlot(new PortableCraftingResultSlot(playerInventory.player, this.input, this.result, 0, 124, 35));

        for(int var6 = 0; var6 < 3; ++var6) {
            for(int var7 = 0; var7 < 3; ++var7) {
                this.addSlot(new Slot(this.input, var7 + var6 * 3, 30 + var7 * 18, 17 + var6 * 18));
            }
        }

        for(int var8 = 0; var8 < 3; ++var8) {
            for(int var10 = 0; var10 < 9; ++var10) {
                this.addSlot(new Slot(playerInventory, var10 + var8 * 9 + 9, 8 + var10 * 18, 84 + var8 * 18));
            }
        }

        for(int var9 = 0; var9 < 9; ++var9) {
            this.addSlot(new Slot(playerInventory, var9, 8 + var9 * 18, 142));
        }

        this.onSlotUpdate(this.input);
    }

    @Override
    public void onSlotUpdate(Inventory inventory) {
        this.result.setStack(0, CraftingRecipeManager.getInstance().craft(this.input));
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        if (!this.world.isRemote) {
            for(int var2 = 0; var2 < 9; ++var2) {
                ItemStack var3 = this.input.getStack(var2);
                if (var3 != null) {
                    player.dropItem(var3);
                }
            }

        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        if(player.getHand() != null && player.getHand().getItem() instanceof PortableWorkbenchItem){
            return true;
        }
        return false;
    }

    @Override
    public ItemStack quickMove(int slot) {
        ItemStack var2 = null;
        Slot var3 = (Slot)this.slots.get(slot);
        if (var3 != null && var3.hasStack()) {
            ItemStack var4 = var3.getStack();
            var2 = var4.copy();
            if (slot == 0) {
                this.insertItem(var4, 10, 46, true);
            } else if (slot >= 10 && slot < 37) {
                this.insertItem(var4, 37, 46, false);
            } else if (slot >= 37 && slot < 46) {
                this.insertItem(var4, 10, 37, false);
            } else {
                this.insertItem(var4, 10, 46, false);
            }

            if (var4.count == 0) {
                var3.setStack((ItemStack)null);
            } else {
                var3.markDirty();
            }

            if (var4.count == var2.count) {
                return null;
            }

            var3.onTakeItem(var4);
        }

        return var2;
    }
}
