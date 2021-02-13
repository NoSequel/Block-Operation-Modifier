package io.github.nosequel.modifier.operations

import io.github.nosequel.modifier.BlockOperation
import org.bukkit.block.BlockState
import org.bukkit.block.Furnace

class FurnaceBlockOperation : BlockOperation<Furnace> {
    override fun editTimeCasted(state: BlockState?, duration: Int): Boolean {
        return editTime(cast(state), duration)
    }

    override fun editTime(block: Furnace, duration: Int): Boolean {
        val time = if (block.inventory.getItem(0) != null && (block.cookTime > 0 || block.burnTime > 0)) block.cookTime + duration else 0
        if (block.inventory.viewers.isEmpty()) {
            return true
        }
        block.cookTime = time.toShort()
        block.burnTime = time.toShort()
        return false
    }

    override fun cast(state: BlockState?): Furnace {
        return type.cast(state)
    }

    override val type: Class<Furnace>
        get() = Furnace::class.java
}