package mod.ckenja.terrafirmaboiler;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PassiveBoilerLevel1HeaterBlockTag {
    public static final TagKey<Block> blockTagKey = BlockTags.create(new ResourceLocation(BuildConfig.MODID,"passive_boiler_level1_heater"));
    public static boolean matches(BlockState blockState){
        return blockState.is(blockTagKey);
    }
}
