package com.benson.study.libgdx.develop.guide.lifecycle

import com.benson.study.libgdx.develop.guide.lifecycle.reflect.ReflectiveGenericLifecycleObserver

object Lifeycling {

    fun lifecycleEventObserver(observer: LifecycleObserver): LifecycleEventObserver {
        return ReflectiveGenericLifecycleObserver(observer)
    }

}