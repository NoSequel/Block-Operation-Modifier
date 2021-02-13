package io.github.nosequel.modifier.operations

import io.github.nosequel.modifier.BlockOperation
import org.bukkit.block.BlockState
import org.bukkit.block.BrewingStand

class BrewingStandBlockOperation : BlockOperation<BrewingStand> {

    override fun editTimeCasted(state: BlockState?, duration: Int): Boolean {
        return editTime(cast(state), duration)
    }

    override fun editTime(block: BrewingStand, duration: Int): Boolean {
        if (block.inventory.viewers.isEmpty() && block.inventory.getItem(3) == null) {
            return true
        }

        if (block.brewingTime > 1) {
            block.brewingTime = 1.coerceAtLeast(block.brewingTime - duration)
        }
        return false
    }

    override fun cast(state: BlockState?): BrewingStand {
        return type.cast(state)
    }

    override val type: Class<BrewingStand>
        get() = BrewingStand::class.java
}