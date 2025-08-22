package ralf2oo2.portableworkbench.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.util.Identifier;
import ralf2oo2.portableworkbench.PortableWorkbench;
import ralf2oo2.portableworkbench.item.PortableWorkbenchItem;

public class ItemListener {

    public static Item portableWorkbenchWood;
    public static Item portableWorkbenchIron;
    public static Item portableWorkbenchGold;
    public static Item portableWorkbenchDiamond;
    @EventListener
    public void registerItems(ItemRegistryEvent event){
        portableWorkbenchWood = new PortableWorkbenchItem(Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench_wood"), 256).setTranslationKey(PortableWorkbench.NAMESPACE, "portable_workbench_wood");
        portableWorkbenchIron = new PortableWorkbenchItem(Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench_iron"), 1024).setTranslationKey(PortableWorkbench.NAMESPACE, "portable_workbench_iron");
        portableWorkbenchGold = new PortableWorkbenchItem(Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench_gold"), 32).setTranslationKey(PortableWorkbench.NAMESPACE, "portable_workbench_gold");
        portableWorkbenchDiamond = new PortableWorkbenchItem(Identifier.of(PortableWorkbench.NAMESPACE, "portable_workbench_diamond"), -1).setTranslationKey(PortableWorkbench.NAMESPACE, "portable_workbench_diamond");
    }
}
