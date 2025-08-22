package ralf2oo2.portableworkbench;

import net.glasslauncher.mods.gcapi3.api.ConfigEntry;
import net.glasslauncher.mods.gcapi3.api.ConfigRoot;

public class PortableWorkbenchConfig {
    @ConfigRoot(value = "config", visibleName = "Portable Workbench Config")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {
        @ConfigEntry(
                name = "Disable Durability",
                description = "Enabling this will stop the portable crafting tables from losing durability",
                multiplayerSynced = true
        )
        public Boolean disableDurability = false;
    }
}
