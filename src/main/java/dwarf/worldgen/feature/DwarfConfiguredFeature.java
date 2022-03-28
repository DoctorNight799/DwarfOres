package dwarf.worldgen.feature;

import dwarf.block.DwarfBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import static dwarf.DwarfMain.MODID;

public class DwarfConfiguredFeature {
    private static final ConfiguredFeature<?, ?> RADIUSK_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig
            (OreConfiguredFeatures.STONE_ORE_REPLACEABLES, DwarfBlocks.RADIUSK.getDefaultState(), 4));

    private static final PlacedFeature RADIUSK_OVERWORLD_PLACED_FEATURE = RADIUSK_OVERWORLD.withPlacement(CountPlacementModifier.of(30), //number of veins per chunk
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(30)));

    private static final ConfiguredFeature<?, ?> LIMURIUN_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig
            (OreConfiguredFeatures.STONE_ORE_REPLACEABLES, DwarfBlocks.LIMURIUN.getDefaultState(), 1));

    private static final PlacedFeature LIMURIUN_OVERWORLD_PLACED_FEATURE = LIMURIUN_OVERWORLD.withPlacement(CountPlacementModifier.of(1), //number of veins per chunk
            SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(10)));

    static public void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "radiusk_overworld"), RADIUSK_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MODID, "radiusk_overworld"), RADIUSK_OVERWORLD_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MODID, "radiusk_overworld")));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "limuriun_overworld"), LIMURIUN_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MODID, "limuriun_overworld"), LIMURIUN_OVERWORLD_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MODID, "limuriun_overworld")));
    }
}