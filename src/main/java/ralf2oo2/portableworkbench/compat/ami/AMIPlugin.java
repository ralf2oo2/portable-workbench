package ralf2oo2.portableworkbench.compat.ami;

import net.glasslauncher.mods.alwaysmoreitems.api.*;
import net.minecraft.nbt.NbtCompound;
import net.modificationstation.stationapi.api.util.Identifier;
import ralf2oo2.portableworkbench.PortableWorkbench;
import ralf2oo2.portableworkbench.screen.PortableWorkbenchScreenHandler;

public class AMIPlugin implements ModPluginProvider {
    @Override
    public String getName() {
        return "Portable Workbench";
    }

    @Override
    public Identifier getId() {
        return PortableWorkbench.NAMESPACE.id("portableworkbench");
    }

    @Override
    public void onAMIHelpersAvailable(AMIHelpers amiHelpers) {

    }

    @Override
    public void onItemRegistryAvailable(ItemRegistry itemRegistry) {

    }

    @Override
    public void register(ModRegistry modRegistry) {
        modRegistry.getRecipeTransferRegistry().addRecipeTransferHandler(PortableWorkbenchScreenHandler.class, "minecraft.crafting", 1, 9, 10, 36);
    }

    @Override
    public void onRecipeRegistryAvailable(RecipeRegistry recipeRegistry) {

    }

    @Override
    public SyncableRecipe deserializeRecipe(NbtCompound nbtCompound) {
        return null;
    }

    @Override
    public void updateBlacklist(AMIHelpers amiHelpers) {

    }
}
