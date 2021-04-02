package com.benson.study.libgdx.develop.guide.lifecycle

interface Lifecycle {

    var currentState: LifecycleState

    fun addObserver(observer: LifecycleObserver)

    fun removeObserver(observer: LifecycleObserver)

}