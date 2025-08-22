package ralf2oo2.portableworkbench.screen.slot;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import ralf2oo2.portableworkbench.PortableWorkbenchConfig;

public class PortableCraftingResultSlot extends CraftingResultSlot {
    PlayerEntity playerEntity;
    public PortableCraftingResultSlot(PlayerEntity player, Inventory input, Inventory inventory, int index, int x, int y) {
        super(player, input, inventory, index, x, y);
        this.playerEntity = player;
    }

    @Override
    public void onTakeItem(ItemStack stack) {

        if(!PortableWorkbenchConfig.config.disableDurability && this.playerEntity.getHand().getMaxDamage() > 0){
            this.playerEntity.getHand().damage(1, playerEntity);
            if(this.playerEntity.getHand().getDamage() >= this.playerEntity.getHand().getMaxDamage()){
                this.playerEntity.inventory.main[this.playerEntity.inventory.selectedSlot] = null;
            }
        }
        super.onTakeItem(stack);
    }
}
