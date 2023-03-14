package mod.ckenja.terrafirmaboiler;

import com.mojang.logging.LogUtils;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.devices.CharcoalForgeBlock;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.simibubi.create.content.contraptions.fluids.tank.BoilerHeaters.registerHeater;
import static com.simibubi.create.content.contraptions.fluids.tank.BoilerHeaters.registerHeaterProvider;

@Mod(BuildConfig.MODID)
public class TerraFirmaBoilerMod {
    public static final Logger LOGGER = LogUtils.getLogger();
    public TerraFirmaBoilerMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, AllConfig.SERVER_CONFIG);
    }
    private void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerHeater(TFCBlocks.CHARCOAL_FORGE.get(), (level, pos, state) -> {
                int heat = state.getValue(CharcoalForgeBlock.HEAT);
                LOGGER.debug("charcoal_forge heater level scale: {}", AllConfig.charcoalForgeHeaterLevelScaleConfigEntry.get().floatValue());
                if (heat < 3) return -1;
                if (heat < 7) return 1 * AllConfig.charcoalForgeHeaterLevelScaleConfigEntry.get().floatValue();
                return 2 * AllConfig.charcoalForgeHeaterLevelScaleConfigEntry.get().floatValue();
            });
            registerHeaterProvider((level, pos, state) -> {
                if (ActiveBoilerHeaterBlockTag.matches(state)) {
                    return (level1, pos1, state1) -> AllConfig.activeBoilerHeaterLevelConfigEntry.get().floatValue();
                }
                return null;
            });
        });
    }

}
