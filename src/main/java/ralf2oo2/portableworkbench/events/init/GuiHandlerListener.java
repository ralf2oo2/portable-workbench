package ralf2oo2.portableworkbench.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.modificationstation.stationapi.api.client.gui.screen.GuiHandler;
import net.modificationstation.stationapi.api.client.registry.GuiHandlerRegistry;
import net.modificationstation.stationapi.api.event.registry.GuiHandlerRegistryEvent;
import net.modificationstation.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.api.util.Identifier;
import ralf2oo2.portableworkbench.PortableWorkbench;
import ralf2oo2.portableworkbench.client.gui.screen.PortableWorkbenchScreen;

public class GuiHandlerListener {
    @EventListener
    public void registerGuiHandlers(GuiHandlerRegistryEvent event){
        GuiHandlerRegistry registry = event.registry;
        Registry.register(registry, Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench_screen"), new GuiHandler((GuiHandler.ScreenFactoryNoMessage)this::openPortableWorkbenchScreen, () -> null));
    }

    public Screen openPortableWorkbenchScreen(PlayerEntity player, Inventory inventory){
        return new PortableWorkbenchScreen(player.inventory, player.world);
    }
}
