package ralf2oo2.portableworkbench.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.gui.screen.container.GuiHelper;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;
import ralf2oo2.portableworkbench.PortableWorkbench;
import ralf2oo2.portableworkbench.screen.PortableWorkbenchScreenHandler;

public class PortableWorkbenchItem extends TemplateItem {
    public PortableWorkbenchItem(Identifier identifier, int maxDamage) {
        super(identifier);
        this.setMaxCount(1);
        if(maxDamage != -1){
            this.setMaxDamage(maxDamage);
        }
    }

    @Override
    public ItemStack use(ItemStack stack, World world, PlayerEntity user) {
        System.out.println(getTranslationKey());
        GuiHelper.openGUI(user, Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench_screen"), user.inventory, new PortableWorkbenchScreenHandler(user.inventory, world));
        return stack;
    }
}
