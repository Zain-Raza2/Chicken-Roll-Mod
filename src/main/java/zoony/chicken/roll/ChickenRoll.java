package zoony.chicken.roll;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
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
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChickenRoll implements ModInitializer {

	static int a = 0;
	static int b = 0;
	static int c = 200;
	public static final Logger LOGGER = LogManager.getLogger("chickenroll");
	public static final Item CHICKEN_ROLL = new Item(new Item.Settings().group(ItemGroup.FOOD));
	public static final Item COOKED_CHICKEN_ROLL = new Item(new Item.Settings().group(ItemGroup.FOOD).food(ChickenRollFoodComponents.COOKED_CHICKEN_ROLL));
	public static final Block CHICKEN_ROLL_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F, 5.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES));
	public static final Block CHICKEN_ROLL_ORE = new ChickenRollOreBlock(FabricBlockSettings.copy(Blocks.STONE));
	private static ConfiguredFeature<?,?> CHICKEN_ROLL_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, CHICKEN_ROLL_ORE.getDefaultState(), 25)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 240))).spreadHorizontally().repeat(10);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.ITEM, new Identifier("chickenroll", "chicken_roll"), CHICKEN_ROLL);
		Registry.register(Registry.ITEM, new Identifier("chickenroll", "cooked_chicken_roll"), COOKED_CHICKEN_ROLL);
		Registry.register(Registry.BLOCK, new Identifier("chickenroll", "chicken_roll_block"), CHICKEN_ROLL_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("chickenroll", "chicken_roll_block"), new BlockItem(CHICKEN_ROLL_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("chickenroll", "chicken_roll_ore"), CHICKEN_ROLL_ORE);
		Registry.register(Registry.ITEM , new Identifier("chickenroll", "chicken_roll_ore"), new BlockItem(CHICKEN_ROLL_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		RegistryKey<ConfiguredFeature<?,?>> chickenrollOreOverWorld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("chickenroll", "chicken_roll_ore"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, chickenrollOreOverWorld.getValue(), CHICKEN_ROLL_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, chickenrollOreOverWorld);
	}
}
