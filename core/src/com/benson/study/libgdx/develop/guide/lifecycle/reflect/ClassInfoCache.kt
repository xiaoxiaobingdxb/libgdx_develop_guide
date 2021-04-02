package com.benson.study.libgdx.develop.guide.lifecycle.reflect

import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleObserver
import com.benson.study.libgdx.develop.guide.lifecycle.annotation.OnLifecycleEvent

object ClassInfoCache {

    fun getInfo(observer: LifecycleObserver): CallInfo? {
        val result = observer.javaClass.declaredMethods.mapNotNull { method ->
            val annotations = method.annotations.filterIsInstance<OnLifecycleEvent>()
            if (annotations.isNotEmpty()) {
                Pair(annotations.last().event, method)
            } else {
                null
            }
        }.groupBy { it.first }.mapValues { e -> e.value.map { it.second }.toSet() }
        return CallInfo(result)
    }
}