package mod.ckenja.terrafirmaboiler;

import net.minecraftforge.common.ForgeConfigSpec;

public class AllConfig {
    public static final ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec.DoubleValue activeBoilerHeaterLevelConfigEntry;
    public static ForgeConfigSpec.DoubleValue charcoalForgeHeaterLevelScaleConfigEntry;
    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        activeBoilerHeaterLevelConfigEntry = configBuilder.defineInRange("active_boiler_heater_level", 1.0, -1.0, Double.MAX_VALUE);
        charcoalForgeHeaterLevelScaleConfigEntry = configBuilder.defineInRange("charcoal_forge_heater_level_scale", 2.0, -1.0, Double.MAX_VALUE);
        SERVER_CONFIG = configBuilder.build();
    }
}
