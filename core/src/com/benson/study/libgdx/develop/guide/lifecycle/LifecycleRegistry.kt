package com.benson.study.libgdx.develop.guide.lifecycle

import java.lang.ref.WeakReference
import java.util.concurrent.CopyOnWriteArraySet

class LifecycleRegistry(owner: LifecycleOwner) : Lifecycle {

    private val ownerRef = WeakReference(owner)

    private var observers: MutableSet<LifecycleEventObserver> = CopyOnWriteArraySet()
    private var handleEvent = false

    override var currentState: LifecycleState = LifecycleState.INITIALIZED

    override fun addObserver(observer: LifecycleObserver) {
        if (observers.none { it.observer == observer }) {
            observers.add(Lifeycling.lifecycleEventObserver(observer))
        }
    }

    override fun removeObserver(observer: LifecycleObserver) {
        val get = observers.filter { it.observer == observer }
        observers.removeAll(get)
    }

    private fun getStateAfter(event: LifecycleEvent) =
            when (event) {
                LifecycleEvent.ON_CREATE -> LifecycleState.CREATED
                LifecycleEvent.ON_RESEIZE -> LifecycleState.RESIZED
                LifecycleEvent.ON_PAUSE -> LifecycleState.PAUSE
                LifecycleEvent.ON_RESUME -> LifecycleState.RESUME
                LifecycleEvent.ON_RENDER -> LifecycleState.BEFORE_RENDER
                LifecycleEvent.ON_RENDERED -> LifecycleState.AFTER_RENDER
                LifecycleEvent.ON_DISPOSE -> LifecycleState.DISPOSED
            }

    private fun moveToState(next: LifecycleState, event: LifecycleEvent, vararg args: Any) {
        if (currentState == next || handleEvent) {
            return
        }
        handleEvent = true
        sync(event, *args)
        handleEvent = false
    }

    private fun sync(event: LifecycleEvent, vararg args: Any) {
        ownerRef.get()?.let { owner ->
            observers.forEach { it.onStateChanged(owner, event, *args) }
        }
    }

    fun handleLifecycleEvent(event: LifecycleEvent, vararg args: Any) {
        val nextState = getStateAfter(event)
        moveToState(nextState, event, *args)
    }


}