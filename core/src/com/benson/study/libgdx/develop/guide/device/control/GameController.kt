package com.benson.study.libgdx.develop.guide.device.control

import java.util.concurrent.CopyOnWriteArrayList

/**
 * 手动控制器
 */
open class GameController : IGameController {

    enum class GameEvent(val value: Int) {
        PAUSE(PAUSE_VALUE),
        RESUME(RESUME_VALUE),
        EXIT(EXIT_VALUE),
        RESET(RESUME_VALUE)
    }

    private companion object {
        const val PAUSE_VALUE = 0
        const val RESUME_VALUE = 1
        const val EXIT_VALUE = 2
        const val RESET_VALUE = 3
    }

    private val listeners: MutableList<IGameControlListener> = CopyOnWriteArrayList()

    fun registerListener(listener: IGameControlListener) {
        listeners.add(listener)
    }

    fun unreigsterListener(listener: IGameControlListener) {
        listeners.remove(listener)
    }

    fun dispatchEvent(event: GameEvent) {
        listeners.forEach {
            when (event) {
                GameEvent.PAUSE -> it.onPause()
                GameEvent.RESUME -> it.onResume()
                GameEvent.EXIT -> it.onExit()
                GameEvent.RESET -> it.onReset()
            }
        }
    }

    override fun pause() {
        dispatchEvent(GameEvent.PAUSE)
    }

    override fun resume() {
        dispatchEvent(GameEvent.RESUME)
    }

    override fun exit() {
        dispatchEvent(GameEvent.EXIT)
    }

    override fun reset() {
        dispatchEvent(GameEvent.RESET)
    }

}