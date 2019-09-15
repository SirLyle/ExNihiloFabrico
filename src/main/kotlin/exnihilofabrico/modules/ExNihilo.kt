package exnihilofabrico.modules

import exnihilofabrico.api.crafting.Lootable
import exnihilofabrico.api.registry.*
import exnihilofabrico.common.ModItems
import exnihilofabrico.common.ore.EnumChunkMaterial
import exnihilofabrico.common.ore.EnumChunkShape
import exnihilofabrico.common.ore.EnumPieceShape
import exnihilofabrico.common.sieves.MeshItem
import exnihilofabrico.common.sieves.MeshProperties
import exnihilofabrico.id
import exnihilofabrico.util.*
import net.minecraft.block.Blocks
import net.minecraft.fluid.Fluids
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.tag.BlockTags
import net.minecraft.util.registry.Registry

object ExNihilo: ICompatModule {

    override fun registerBarrelAlchemy(registry: IBarrelAlchemyRegistry) {

    }

    override fun registerBarrelMilking(registry: IBarrelMilkingRegistry) {

    }

    override fun registerCrucibleHeat(registry: ICrucibleHeatRegistry) {
        registry.register(Blocks.TORCH, 1)
    }

    override fun registerCrucibleStone(registry: ICrucibleRegistry) {

    }

    override fun registerCrucibleWood(registry: ICrucibleRegistry) {

    }

    override fun registerOres(registry: IOreRegistry) {
        // TODO("Implement tag checking to prevent creation of unnecessary ores")
        // Vanilla Metals
        registry.register("iron", MetalColors.IRON, EnumPieceShape.NORMAL, EnumChunkShape.CHUNK, EnumChunkMaterial.GRANITE)
        registry.register("gold", MetalColors.GOLD, EnumPieceShape.FINE, EnumChunkShape.CHUNK, EnumChunkMaterial.STONE)

        // Modded Metals
        registry.register("aluminum",  MetalColors.ALUMINUM,  EnumPieceShape.FINE,   EnumChunkShape.CHUNK, EnumChunkMaterial.SAND)
        registry.register("ardite",    MetalColors.ARDITE,    EnumPieceShape.COARSE, EnumChunkShape.CHUNK, EnumChunkMaterial.NETHERRACK)
        registry.register("beryllium", MetalColors.BERYLLIUM, EnumPieceShape.NORMAL, EnumChunkShape.FLINT, EnumChunkMaterial.STONE)
        registry.register("boron",     MetalColors.BORON,     EnumPieceShape.COARSE, EnumChunkShape.CHUNK, EnumChunkMaterial.SAND)
        registry.register("cobalt",    MetalColors.COBALT,    EnumPieceShape.COARSE, EnumChunkShape.LUMP, EnumChunkMaterial.NETHERRACK)
        registry.register("copper",    MetalColors.COPPER,    EnumPieceShape.NORMAL, EnumChunkShape.CHUNK, EnumChunkMaterial.STONE)
        registry.register("lead",      MetalColors.LEAD,      EnumPieceShape.COARSE, EnumChunkShape.LUMP, EnumChunkMaterial.STONE)
        registry.register("lithium",   MetalColors.LITHIUM,   EnumPieceShape.FINE,   EnumChunkShape.FLINT, EnumChunkMaterial.SAND)
        registry.register("magnesium", MetalColors.MAGNESIUM, EnumPieceShape.COARSE, EnumChunkShape.LUMP, EnumChunkMaterial.STONE)
        registry.register("nickel",    MetalColors.NICKEL,    EnumPieceShape.COARSE, EnumChunkShape.LUMP, EnumChunkMaterial.STONE)
        registry.register("silver",    MetalColors.SILVER,    EnumPieceShape.NORMAL, EnumChunkShape.CHUNK, EnumChunkMaterial.STONE)
        registry.register("tin",       MetalColors.TIN,       EnumPieceShape.NORMAL, EnumChunkShape.LUMP, EnumChunkMaterial.DIORITE)
        registry.register("titanium",  MetalColors.TITANIUM,  EnumPieceShape.COARSE, EnumChunkShape.CHUNK, EnumChunkMaterial.STONE)
        registry.register("thorium",   MetalColors.THORIUM,   EnumPieceShape.COARSE, EnumChunkShape.LUMP, EnumChunkMaterial.STONE)
        registry.register("tungsten",  MetalColors.TUNGSTEN,  EnumPieceShape.COARSE, EnumChunkShape.CHUNK, EnumChunkMaterial.NETHERRACK)
        registry.register("uranium",   MetalColors.URANIUM,   EnumPieceShape.COARSE, EnumChunkShape.LUMP, EnumChunkMaterial.STONE)
        registry.register("zinc",      MetalColors.ZINC,      EnumPieceShape.FINE,   EnumChunkShape.FLINT, EnumChunkMaterial.ANDESITE)
        registry.register("zirconium", MetalColors.ZIRCONIUM, EnumPieceShape.NORMAL, EnumChunkShape.FLINT, EnumChunkMaterial.ANDESITE)
    }

    override fun registerMesh(registry: IMeshRegistry) {
        registry.register(id("mesh_string"), "item.minecraft.string", Color.WHITE, Ingredient.ofItems(Items.STRING))
        registry.register(id("mesh_flint"), "item.minecraft.flint", Color.DARK_GRAY, Ingredient.ofItems(Items.FLINT))
        registry.register(id("mesh_iron"), "Iron", Color("777777"), Ingredient.ofItems(Items.IRON_INGOT))
        registry.register(id("mesh_gold"), "Gold", Color.GOLD, Ingredient.ofItems(Items.GOLD_INGOT))
        registry.register(id("mesh_diamond"), "item.minecraft.diamond", Color.DARK_AQUA, Ingredient.ofItems(Items.DIAMOND))
    }

    override fun registerSieve(registry: ISieveRegistry) {
        val MESH_STRING = Registry.ITEM[id("mesh_string")]
        val MESH_FLINT = Registry.ITEM[id("mesh_flint")]
        val MESH_IRON = Registry.ITEM[id("mesh_iron")]
        val MESH_GOLD = Registry.ITEM[id("mesh_gold")]
        val MESH_DIAMOND = Registry.ITEM[id("mesh_diamond")]

        registry.register(MESH_STRING, Blocks.GRAVEL, Lootable(Items.FLINT, .5))
        registry.register(MESH_FLINT, Blocks.GRAVEL, Lootable(Items.FLINT, .3))

        registry.register(MESH_STRING, Fluids.WATER, Blocks.SAND, Lootable(id("seed_sugarcane"), listOf(.5)))
        registry.register(MESH_STRING, Fluids.WATER, Blocks.SAND, Lootable(id("seed_kelp"), listOf(.3, .2)))
        registry.register(MESH_STRING, Fluids.WATER, Blocks.DIRT, Lootable(Items.TROPICAL_FISH, listOf(.1, .2, .3)))
        registry.register(MESH_STRING, Fluids.WATER, Blocks.MYCELIUM, Lootable(Items.PUFFERFISH, listOf(.1, .2, .3)))

        registry.register(MESH_FLINT, Fluids.WATER, Blocks.SAND, Lootable(id("seed_sugarcane"), listOf(.3)))
        registry.register(MESH_FLINT, Fluids.WATER, Blocks.SAND, Lootable(id("seed_kelp"), listOf(.5, .5)))
        registry.register(MESH_FLINT, Fluids.WATER, Blocks.SAND, Lootable(id("seed_sea_pickle"), listOf(.1)))
        registry.register(MESH_FLINT, Fluids.WATER, Blocks.DIRT, Lootable(Items.TROPICAL_FISH, listOf(.4)))
        registry.register(MESH_FLINT, Fluids.WATER, Blocks.MYCELIUM, Lootable(Items.PUFFERFISH, listOf(.5)))

        registry.register(MESH_IRON, Blocks.GRAVEL, Lootable(Items.DIAMOND, .01))
        registry.register(MESH_GOLD, Blocks.GRAVEL, Lootable(Items.DIAMOND, .02))
        registry.register(MESH_DIAMOND, Blocks.GRAVEL, Lootable(Items.DIAMOND, .03))
    }

    override fun registerCrook(registry: IToolRegistry) {
        registry.registerTag(BlockTags.LEAVES, Lootable(Items.APPLE, 0.05))
        registry.registerTag(BlockTags.LEAVES, Lootable(Items.STICK, 0.01))
        registry.registerTag(BlockTags.LEAVES, Lootable(id("silkworm_raw"), listOf(0.1, 0.2, 0.2)))
        for(w in EnumVanillaWoodTypes.values()) {
            registry.registerDrops(w.getLeafBlock(), Lootable(w.getSeedItem(), 0.25))
        }
    }

    override fun registerHammer(registry: IToolRegistry) {
        // Stone
        registry.registerDrops(Blocks.STONE, Lootable(Blocks.COBBLESTONE, 1.0))
        registry.registerDrops(Blocks.COBBLESTONE, Lootable(Blocks.GRAVEL, 1.0))
        registry.registerDrops(Blocks.GRAVEL, Lootable(Blocks.SAND, 1.0))
        registry.registerTag(BlockTags.SAND, Lootable(id("silt"), 1.0))
        registry.registerDrops(id("silt"), Lootable(id("dust"), 1.0))

        // Andesite
        registry.registerDrops(Blocks.ANDESITE, Lootable(id("crushed_andesite"), 1.0))
        registry.registerDrops(id("crushed_andesite"), Lootable(Blocks.LIGHT_GRAY_CONCRETE_POWDER, 1.0))

        // Diorite
        registry.registerDrops(Blocks.DIORITE, Lootable(id("crushed_diorite"), 1.0))
        registry.registerDrops(id("crushed_diorite"), Lootable(Items.WHITE_CONCRETE_POWDER, 1.0))

        // Granite
        registry.registerDrops(Blocks.GRANITE, Lootable(id("crushed_granite"), 1.0))
        registry.registerDrops(id("crushed_granite"), Lootable(Items.RED_SAND, 1.0))

        // Netherrack
        registry.registerDrops(Blocks.NETHERRACK, Lootable(id("crushed_netherrack"), 1.0))
        registry.registerDrops(Blocks.NETHER_BRICKS, Lootable(id("crushed_netherrack"), 1.0))
        registry.registerDrops(id("crushed_netherrack"), Lootable(Blocks.RED_CONCRETE_POWDER, 1.0))

        // End Stone
        registry.registerDrops(Blocks.END_STONE, Lootable(id("crushed_endstone"), 1.0))
        registry.registerDrops(Blocks.END_STONE_BRICKS, Lootable(id("crushed_endstone"), 1.0))
        registry.registerDrops(id("crushed_endstone"), Lootable(Blocks.YELLOW_CONCRETE_POWDER, 1.0))

        // Prismarine
        registry.registerDrops(Blocks.PRISMARINE, Lootable(id("crushed_prismarine"), 1.0))
        registry.registerDrops(id("crushed_prismarine"), Lootable(Blocks.CYAN_CONCRETE_POWDER, 1.0))

        // Misc.
        EnumVanillaColors.values().forEach { c ->
            // Concrete Hammering
            registry.registerDrops(c.getConcrete(), Lootable(c.getConcretePowder(), 1.0))
            registry.registerDrops(c.getConcretePowder(), Lootable(id("silt"), 1.0))
            registry.registerDrops(c.getConcretePowder(), Lootable(c.getDye(), 0.0625))
            // Wool Hammering
            registry.registerDrops(c.getWool(), Lootable(Items.STRING.asStack(4), 1.0))
            registry.registerDrops(c.getWool(), Lootable(c.getDye(), 0.5))
            // Glass Hammering
            registry.registerDrops(c.getGlass(), Lootable(Blocks.SAND, 1.0))
            registry.registerDrops(c.getGlass(), Lootable(c.getDye(), 0.0625))
        }

        //
    }

    override fun registerWitchWaterEntity(registry: IWitchWaterEntityRegistry) {

    }

    override fun registerWitchWaterFluid(registry: IWitchWaterFluidRegistry) {

    }

}