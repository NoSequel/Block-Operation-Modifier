package io.github.nosequel.modifier

import org.bukkit.block.BlockState

interface BlockOperation<T> {
    /**
     * Edit the time of a block
     *
     * @param state    the block
     * @param duration the duration
     * @return whether it should remove it from the list of operations
     */
    fun editTimeCasted(state: BlockState?, duration: Int): Boolean

    /**
     * Edit the time of the block
     *
     * @param block    the block
     * @param duration the duration
     */
    fun editTime(block: T, duration: Int): Boolean

    /**
     * Cast a [BlockState] to [T]
     *
     * @param state the state
     * @return the casted block state
     */
    fun cast(state: BlockState?): T

    /**
     * Get the type of the [BlockOperation] object
     *
     * @return the type
     */
    val type: Class<T>
}