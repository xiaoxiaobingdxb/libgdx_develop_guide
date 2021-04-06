package com.benson.study.libgdx.develop.guide.main.global

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Disposable
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleEvent
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleObserver
import com.benson.study.libgdx.develop.guide.lifecycle.annotation.OnLifecycleEvent

object UIGlobal : LifecycleObserver, Disposable {

    var currentStage: Stage? = null
    override fun dispose() {
        currentStage = null
    }

    @OnLifecycleEvent(LifecycleEvent.ON_DISPOSE)
    fun onDispose() {
        dispose()
    }

}