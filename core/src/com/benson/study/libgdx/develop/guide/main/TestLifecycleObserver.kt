package com.benson.study.libgdx.develop.guide.main

import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleEvent
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleObserver
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleOwner
import com.benson.study.libgdx.develop.guide.lifecycle.annotation.OnLifecycleEvent

class TestLifecycleObserver : LifecycleObserver {

    @OnLifecycleEvent(LifecycleEvent.ON_CREATE)
    fun onCreate(owner: LifecycleOwner) {
        println("onCreate, owner=${owner}")
    }

    @OnLifecycleEvent(LifecycleEvent.ON_CREATE)
    fun onCreateCopy() {
        println("onCreate copy")
    }

    @OnLifecycleEvent(LifecycleEvent.ON_RESEIZE)
    fun onResize(width: Int, height: Int) {
        println("width=${width}, height=${height}")
    }

    @OnLifecycleEvent(LifecycleEvent.ON_PAUSE)
    fun onPause() {
        println("onPause")
    }

    @OnLifecycleEvent(LifecycleEvent.ON_RESUME)
    fun onResume() {
        println("onResume")
    }

    @OnLifecycleEvent(LifecycleEvent.ON_RENDER)
    fun onBeforeRender() {
        println("onBeforeRender")
    }

    @OnLifecycleEvent(LifecycleEvent.ON_RENDERED)
    fun onAfterRender() {
        println("onAfterRender")
    }

    @OnLifecycleEvent(LifecycleEvent.ON_DISPOSE)
    fun onDispose() {
        print("onDispose")
    }


}