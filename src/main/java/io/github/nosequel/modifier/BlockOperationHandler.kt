package io.github.nosequel.modifier

import io.github.nosequel.modifier.operations.BrewingStandBlockOperation
import io.github.nosequel.modifier.operations.FurnaceBlockOperation
import org.bukkit.block.BlockState
import java.util.*
import java.util.stream.Stream

class BlockOperationHandler {

    private val modifiers: MutableSet<BlockOperationModifier> = HashSet()
    private val operations: Set<BlockOperation<*>> = HashSet<BlockOperation<*>>(Arrays.asList(
            BrewingStandBlockOperation(),
            FurnaceBlockOperation()
    ))

    /**
     * Open a new [Stream] for the list of modifiers
     *
     * @return the stream
     */
    fun stream(): Stream<BlockOperationModifier> {
        return modifiers.stream()
    }

    /**
     * Find a [BlockOperation] by a [BlockState]
     *
     * @param state the state
     * @return the optional of the block operation
     */
    fun findOperation(state: BlockState?): Optional<BlockOperation<*>> {
        return operations.stream()
                .filter { type: BlockOperation<*> -> type.type.isInstance(state) }
                .findFirst()
    }

    /**
     * Register a new [BlockOperationModifier] to the list of modifiers
     * Constructs a new [BlockOperationModifier] object
     *
     * @param state     the block
     * @param operation the operation to run
     */
    fun register(state: BlockState?, operation: BlockOperation<*>?) {
        state?.let { BlockOperationModifier(it, operation) }?.let { this.register(it) }
    }

    /**
     * Register a new [BlockOperationModifier] to the list of modifiers
     *
     * @param modifier the modifier to register
     */
    fun register(modifier: BlockOperationModifier) {
        modifiers.add(modifier)
    }
}