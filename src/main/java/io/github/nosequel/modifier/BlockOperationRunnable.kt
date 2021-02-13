package io.github.nosequel.modifier

import org.bukkit.scheduler.BukkitRunnable

class BlockOperationRunnable(plugin: BlockOperationModifierPlugin) : BukkitRunnable() {

    private val handler = plugin.handler;
    private val duration = plugin.config.getInt("modifier_speed")

    override fun run() {
        handler.stream().forEach { modifier: BlockOperationModifier -> modifier.operation?.editTimeCasted(modifier.blockState, duration) }
    }
}