package exnihilofabrico.compatibility.rei.barrel

import exnihilofabrico.compatibility.rei.GlyphWidget
import exnihilofabrico.compatibility.rei.PluginEntry
import exnihilofabrico.id
import exnihilofabrico.util.getExNihiloItemStack
import me.shedaniel.math.api.Rectangle
import me.shedaniel.rei.api.RecipeCategory
import me.shedaniel.rei.api.Renderer
import me.shedaniel.rei.gui.renderers.ItemStackRenderer
import me.shedaniel.rei.gui.widget.RecipeBaseWidget
import me.shedaniel.rei.gui.widget.SlotWidget
import me.shedaniel.rei.gui.widget.Widget
import java.util.function.Supplier

class FluidOnTopCategory: RecipeCategory<FluidOnTopDisplay> {

    override fun getIdentifier() = PluginEntry.ON_TOP
    override fun getIcon(): ItemStackRenderer = Renderer.fromItemStack(getExNihiloItemStack("oak_barrel"))
    override fun getCategoryName() = "Fluid Above"


    override fun getDisplayHeight() = HEIGHT
    override fun getDisplayWidth(display: FluidOnTopDisplay) =
        WIDTH

    override fun setupDisplay(displaySupplier: Supplier<FluidOnTopDisplay>, bounds: Rectangle): MutableList<Widget> {
        val display = displaySupplier.get()
        val widgets = mutableListOf<Widget>(RecipeBaseWidget(bounds))

        val arrow1 = GlyphWidget(bounds, bounds.minX + ARROW1_X, bounds.minY + ARROW1_Y, ARROW_WIDTH, ARROW_HEIGHT, ARROW, ARROW_U, ARROW_V)
        val arrow2 = GlyphWidget(bounds, bounds.minX + ARROW2_X, bounds.minY + ARROW2_Y, ARROW_WIDTH, ARROW_HEIGHT, ARROW, ARROW_U, ARROW_V)
        widgets.add(arrow1)
        widgets.add(arrow2)

        val inBarrel = display.input[0]
        val onTop = display.input[1]
        val barrels = display.input[2]
        val outputs = display.output

        widgets.add(SlotWidget(bounds.minX + INPUT_X, bounds.minY + INPUT_Y, Renderer.fromItemStacks(inBarrel), true, true, true))
        widgets.add(SlotWidget(bounds.minX + ABOVE_X, bounds.minY + ABOVE_Y, Renderer.fromItemStacks(onTop), false, true, true))
        widgets.add(SlotWidget(bounds.minX + BARRELS_X, bounds.minY + BARRELS_Y, Renderer.fromItemStacks(barrels), false, false, true))
        widgets.add(SlotWidget(bounds.minX + OUTPUT_X, bounds.minY + OUTPUT_Y, Renderer.fromItemStacks(outputs), true, true, true))

        return widgets
    }

    companion object {
        val ARROW = id("textures/gui/rei/glyphs.png")

        val MARGIN = 6

        val WIDTH = 8*18 + MARGIN*2
        val HEIGHT = 2*18 + MARGIN*2

        val ABOVE_X = WIDTH/2 - 9
        val ABOVE_Y = MARGIN

        val BARRELS_X = ABOVE_X
        val BARRELS_Y = ABOVE_Y + 18

        val ARROW1_X = BARRELS_X -18
        val ARROW1_Y = BARRELS_Y
        val ARROW2_X = BARRELS_X + 18
        val ARROW2_Y = BARRELS_Y

        val INPUT_X = BARRELS_X - 2*18
        val INPUT_Y = BARRELS_Y

        val OUTPUT_X = BARRELS_X + 2*18
        val OUTPUT_Y = BARRELS_Y

        val ARROW_WIDTH = 16
        val ARROW_HEIGHT= 16
        val ARROW_U = 0
        val ARROW_V= 0
    }

}