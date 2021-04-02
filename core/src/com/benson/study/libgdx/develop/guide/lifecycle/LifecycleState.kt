package com.benson.study.libgdx.develop.guide.lifecycle

object LifecycleStateValue {
    const val INITIALIZED = 0 // 未初始化
    const val CREATED = 1 // 创建完成
    const val RESIZED = 2 // 重置大小
    const val PAUSE = 3
    const val RESUME = 4
    const val BEFORE_RENDER = 5 // 渲染前
    const val AFTER_RENDER = 6 // 沉浸后
    const val DISPOSED = 7 // 结束
}

enum class LifecycleState(val value: Int) {

    INITIALIZED(LifecycleStateValue.INITIALIZED),
    CREATED(LifecycleStateValue.CREATED),
    RESIZED(LifecycleStateValue.RESIZED),
    PAUSE(LifecycleStateValue.PAUSE),
    RESUME(LifecycleStateValue.RESUME),
    BEFORE_RENDER(LifecycleStateValue.BEFORE_RENDER),
    AFTER_RENDER(LifecycleStateValue.AFTER_RENDER),
    DISPOSED(LifecycleStateValue.DISPOSED)

}