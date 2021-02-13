package io.github.nosequel.modifier

import org.bukkit.block.BlockState

class BlockOperationModifier constructor(blockState: BlockState, operation: BlockOperation<*>?) {

    val blockState: BlockState = blockState;
    val operation: BlockOperation<*>? = operation;

}