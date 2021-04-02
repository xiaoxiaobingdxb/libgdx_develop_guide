package com.benson.study.libgdx.develop.guide.lifecycle

abstract class LifecycleEventObserver(internal val observer: LifecycleObserver): LifecycleObserver {

    abstract fun onStateChanged(owner: LifecycleOwner, event: LifecycleEvent, vararg args: Any)

}