package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.benson.study.libgdx.develop.guide.main.Updatable
import kotlin.math.max
import kotlin.math.min

class CameraHelper: Updatable {

    companion object {
        private const val MIN_ZOOM_IN = 0.25F // 缩小的最小比例
        private const val MAX_ZOOM_OUT = 10F // 放大的最大比例
    }

    var position: Vector2 = Vector2()

    var zoom: Float = 1F
    var target: Sprite? = null

    fun setPosition(x: Float, y: Float) {
        position.x = x
        position.y = y
    }

    override fun update(delta: Float) {
        target?.let {
            position.x = it.x + it.originX
            position.y = it.y + it.originY
        }
    }

    fun addZoom(add: Float) {
        zoom += add
        zoom = max(zoom, MIN_ZOOM_IN)
        zoom = min(zoom, MAX_ZOOM_OUT)
    }

    fun applyTo(camera: OrthographicCamera) {
        camera.position.x = position.x
        camera.position.y = position.y
        camera.zoom = zoom
        camera.update()
    }

}