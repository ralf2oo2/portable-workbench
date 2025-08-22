package ralf2oo2.portableworkbench.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import ralf2oo2.portableworkbench.PortableWorkbench;
import ralf2oo2.portableworkbench.item.PortableWorkbenchItem;

public class ItemListener {

    public static Item portableWorkbench;
    @EventListener
    public void registerItems(ItemRegistryEvent event){
        portableWorkbench = new PortableWorkbenchItem(Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench"), 20).setTranslationKey(Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench").toString());
    }
}
