package mod.ckenja.terrafirmaboiler;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ActiveBoilerHeaterBlockTag {
    public static final TagKey<Block> blockTagKey = BlockTags.create(new ResourceLocation(BuildConfig.MODID,"active_boiler_heaters"));
    public static boolean matches(BlockState blockState){
        return blockState.is(blockTagKey);
    }
}
