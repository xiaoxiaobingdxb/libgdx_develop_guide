package com.benson.study.libgdx.develop.guide.lifecycle.reflect

import com.badlogic.gdx.Gdx
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleEvent
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleObserver
import com.benson.study.libgdx.develop.guide.lifecycle.LifecycleOwner
import java.lang.reflect.Method

class CallInfo(private val lifecycleMethods: Map<LifecycleEvent, Set<Method>>) {

    companion object {
        private const val TAG = "CallInfo"
    }

    fun call(owner: LifecycleOwner, event: LifecycleEvent, target: LifecycleObserver, vararg args: Any) {
        lifecycleMethods[event]?.forEachIndexed { index, method ->
            var hasOwner = false
            val args = method.parameters.map { p ->
                if (LifecycleOwner::class.java.isAssignableFrom(p.type)) {
                    hasOwner = true
                    owner
                } else {
                    val findIndex = if (hasOwner) index + 1 else index
                    args.takeIf { it.size > findIndex }?.get(findIndex)
                }
            }.toTypedArray()
            try {
                method.invoke(target, *args)
            } catch (t: Throwable) {
                Gdx.app.error(TAG, "method=${method}, target=${target}, args=${args}", t)
            }
        }
    }

}