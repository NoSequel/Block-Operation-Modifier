package io.github.nosequel.modifier

import io.github.nosequel.modifier.listener.BlockOperationListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class BlockOperationModifierPlugin : JavaPlugin() {

    val handler = BlockOperationHandler()

    override fun onEnable() {
        this.saveDefaultConfig()

        Bukkit.getPluginManager().registerEvents(BlockOperationListener(this.handler), this)
        BlockOperationRunnable(this).runTaskTimer(this, 0L, 4L)
    }
}