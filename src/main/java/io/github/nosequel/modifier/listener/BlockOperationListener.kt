package io.github.nosequel.modifier.listener

import io.github.nosequel.modifier.BlockOperation
import io.github.nosequel.modifier.BlockOperationHandler
import io.github.nosequel.modifier.BlockOperationModifierPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class BlockOperationListener constructor(plugin: BlockOperationModifierPlugin) : Listener {

    private val handler: BlockOperationHandler = plugin.handler;

    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        val block = event.clickedBlock
        if (block != null && event.action == Action.RIGHT_CLICK_BLOCK) {
            handler.findOperation(block.state)
                    .ifPresent { operation: BlockOperation<*>? -> handler.register(block.state, operation) }
        }
    }
}