package mod.ckenja.terrafirmaboiler;

import com.mojang.logging.LogUtils;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.fml.common.Mod;
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
    }
    private void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerHeater(TFCBlocks.FIREPIT.get(), (level, pos, state) -> {
                boolean value = state.getValue(BlockStateProperties.LIT);
                LOGGER.info(String.valueOf(value));
                if (value == false) {
                    return 2;
                }
                return -1;
            });
            registerHeaterProvider((level, pos, state) -> {
                if (PassiveBoilerLevel1HeaterBlockTag.matches(state)) {
                    return (level1, pos1, state1) -> 0;
                }
                return null;
            });
        });
    }
}
