package exnihilofabrico.compatibility.rei.barrel

import exnihilofabrico.api.recipes.barrel.FluidOnTopRecipe
import exnihilofabrico.compatibility.rei.PluginEntry
import exnihilofabrico.modules.ModBlocks
import exnihilofabrico.modules.barrels.modes.FluidMode
import exnihilofabrico.modules.barrels.modes.ItemMode
import exnihilofabrico.util.asStack
import me.shedaniel.rei.api.RecipeDisplay
import net.minecraft.item.ItemStack

class FluidOnTopDisplay(val recipe: FluidOnTopRecipe): RecipeDisplay {
    override fun getRecipeCategory() = PluginEntry.ON_TOP

    override fun getOutput() = listOf(
        when(recipe.result) {
            is ItemMode -> recipe.result.stack
            is FluidMode -> recipe.result.fluid.rawFluid?.bucketItem?.asStack() ?: ItemStack.EMPTY
            else -> ItemStack.EMPTY
        }
    )
    override fun getInput() =
        listOf(recipe.inBarrel.flattenListOfBuckets(), recipe.onTop.flattenListOfBuckets(), ModBlocks.BARRELS.values.map { it.asStack() })

}