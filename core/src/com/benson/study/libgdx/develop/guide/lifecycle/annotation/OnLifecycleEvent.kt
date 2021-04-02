package com.benson.study.libgdx.develop.guide.lifecycle.annotation

import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleEvent

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class OnLifecycleEvent(val event: LifecycleEvent)
