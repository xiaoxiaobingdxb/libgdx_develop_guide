package com.benson.study.libgdx.develop.guide.lifecycle

import com.badlogic.gdx.ApplicationListener
import java.util.concurrent.CopyOnWriteArrayList

open class ApplicationDispatcher : ApplicationListener, LifecycleOwner {

    private val listeners: MutableList<ApplicationListener> = CopyOnWriteArrayList()
    private val lifecycle by lazy {
        LifecycleRegistry(this)
    }

    override fun lifecycle(): Lifecycle = lifecycle

    fun register(listener: ApplicationListener) {
        listeners.add(listener)
    }

    fun unregister(listener: ApplicationListener) {
        listeners.add(listener)
    }

    private fun dispatch(event: LifecycleEvent, vararg args: Any) {
        lifecycle.handleLifecycleEvent(event, *args)
    }

    override fun create() {
        listeners.forEach { it.create() }
        dispatch(LifecycleEvent.ON_CREATE)
    }

    override fun resize(width: Int, height: Int) {
        listeners.forEach { it.resize(width, height) }
        dispatch(LifecycleEvent.ON_RESEIZE, width, height)
    }

    override fun render() {
        dispatch(LifecycleEvent.ON_RENDER)
        listeners.forEach { it.render() }
        dispatch(LifecycleEvent.ON_RENDERED)
    }

    override fun pause() {
        listeners.forEach { it.pause() }
        dispatch(LifecycleEvent.ON_PAUSE)
    }

    override fun resume() {
        listeners.forEach { it.resume() }
        dispatch(LifecycleEvent.ON_RESUME)
    }

    override fun dispose() {
        listeners.forEach { it.dispose() }
        dispatch(LifecycleEvent.ON_DISPOSE)
    }
}