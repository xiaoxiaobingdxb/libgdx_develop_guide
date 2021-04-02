package com.benson.study.libgdx.develop.guide.lifecycle.reflect

import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleEvent
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleEventObserver
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleObserver
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleOwner

class ReflectiveGenericLifecycleObserver(observer: LifecycleObserver) : LifecycleEventObserver(observer) {

    private val callInfo: CallInfo? = ClassInfoCache.getInfo(observer)
    override fun onStateChanged(owner: LifecycleOwner, event: LifecycleEvent, vararg args: Any) {
        callInfo?.call(owner, event, observer, *args)
    }
}