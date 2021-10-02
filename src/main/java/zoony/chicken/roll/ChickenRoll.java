package zoony.chicken.roll;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;

import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

import net.minecraft.sound.BlockSoundGroup;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChickenRoll implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("chickenroll");
	public static final Item CHICKEN_ROLL = new Item(new Item.Settings().group(ItemGroup.FOOD));
	public static final Item COOKED_CHICKEN_ROLL = new Item(new Item.Settings().group(ItemGroup.FOOD).food(ChickenRollFoodComponents.COOKED_CHICKEN_ROLL));
	public static final Block CHICKEN_ROLL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F, 5.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block CHICKEN_ROLL_ORE = new ChickenRollOreBlock(FabricBlockSettings.copy(Blocks.STONE));

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.ITEM, new Identifier("chickenroll", "chicken_roll"), CHICKEN_ROLL);
		Registry.register(Registry.ITEM, new Identifier("chickenroll", "cooked_chicken_roll"), COOKED_CHICKEN_ROLL);
		Registry.register(Registry.BLOCK, new Identifier("chickenroll", "chicken_roll_block"), CHICKEN_ROLL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("chickenroll", "chicken_roll_block"), new BlockItem(CHICKEN_ROLL_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("chickenroll", "chicken_roll_ore"), CHICKEN_ROLL_ORE);
		Registry.register(Registry.ITEM , new Identifier("chickenroll", "chicken_roll_ore"), new BlockItem(CHICKEN_ROLL_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
