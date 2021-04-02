package com.benson.study.libgdx.develop.guide.lifecycle


object LifecycleEventValue {
    const val ON_CREATE_VALUE = 0
    const val ON_RESEIZE_VALUE = 1
    const val ON_PAUSE_VALUE = 2
    const val ON_RESUME_VALUE = 3
    const val ON_RENDER_VALUE = 4
    const val ON_RENDERED_VALUE = 5
    const val ON_DISPOSE_VALUE = 6
}

enum class LifecycleEvent(val value: Int) {

    ON_CREATE(LifecycleEventValue.ON_CREATE_VALUE),
    ON_RESEIZE(LifecycleEventValue.ON_RESEIZE_VALUE),
    ON_PAUSE(LifecycleEventValue.ON_PAUSE_VALUE),
    ON_RESUME(LifecycleEventValue.ON_RESUME_VALUE),
    ON_RENDER(LifecycleEventValue.ON_RENDER_VALUE),
    ON_RENDERED(LifecycleEventValue.ON_RENDERED_VALUE),
    ON_DISPOSE(LifecycleEventValue.ON_DISPOSE_VALUE),

}