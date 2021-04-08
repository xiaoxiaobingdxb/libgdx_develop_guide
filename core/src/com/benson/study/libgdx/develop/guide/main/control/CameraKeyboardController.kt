package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.benson.study.libgdx.develop.guide.main.Updatable
import com.benson.study.libgdx.develop.guide.main.WorldController
import com.benson.study.libgdx.develop.guide.util.TAG

class CameraKeyboardController(
        private val worldController: WorldController,
        private val speed: Float = 5F,
        private val accelerateSpeed: Float = 5F,
        private val zoomSpeed: Float = 1F,
        private val zoomAccelerateSpeed: Float = 5F
) : InputAdapter(), Updatable {

    val cameraHelper by lazy {
        CameraHelper()
    }

    override fun update(delta: Float) {
        super.update(delta)
        cameraHelper.update(delta)
    }

    private fun computeSpeed(): Float {
        var moveSpeed = speed * Gdx.graphics.deltaTime
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            moveSpeed *= accelerateSpeed
        }
        return moveSpeed
    }

    private fun computeZoomSpeed(): Float {
        var zoomSpeed = this.zoomSpeed * Gdx.graphics.deltaTime
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            zoomSpeed *= zoomAccelerateSpeed
        }
        return zoomSpeed
    }

    override fun keyDown(keycode: Int): Boolean {
        when (keycode) {
            Input.Keys.ENTER -> cameraHelper.target = worldController.testSprites[worldController.selectedSprite]
            Input.Keys.A, Input.Keys.W, Input.Keys.D, Input.Keys.S -> {
                if (!worldController.isRunning()) { // 暂停时由AWDS控制camera
                    val moveSpeed = computeSpeed()
                    moveCamera(
                            when (keycode) {
                                Input.Keys.A -> -moveSpeed
                                Input.Keys.D -> moveSpeed
                                else -> 0F
                            },
                            when (keycode) {
                                Input.Keys.W -> moveSpeed
                                Input.Keys.S -> -moveSpeed
                                else -> 0F
                            }
                    )
                }
            }
            Input.Keys.LEFT, Input.Keys.UP, Input.Keys.RIGHT, Input.Keys.DOWN -> { // 上下左右直接控制camera
                val moveSpeed = computeSpeed()
                moveCamera(
                        when (keycode) {
                            Input.Keys.LEFT -> -moveSpeed
                            Input.Keys.RIGHT -> moveSpeed
                            else -> 0F
                        },
                        when (keycode) {
                            Input.Keys.UP -> moveSpeed
                            Input.Keys.DOWN -> -moveSpeed
                            else -> 0F
                        }
                )
            }
            Input.Keys.COMMA, Input.Keys.PERIOD, Input.Keys.SLASH -> {
                val zoomSpeed = computeZoomSpeed()
                // ,./控制camera缩放
                cameraHelper.addZoom(
                        if (keycode == Input.Keys.COMMA) {
                            1F
                        } else if (keycode == Input.Keys.PERIOD) {
                            -1F
                        } else {
                            1F / zoomSpeed
                        } * zoomSpeed)
                if (keycode == Input.Keys.SLASH) {
                    cameraHelper.zoom = 1F
                }
            }
        }
        return super.keyDown(keycode)
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        Gdx.app.debug(TAG, "mouse scrolled (${amountX}, ${amountY})")
        val zoomSpeed = computeZoomSpeed()
        // 鼠标滚轮控制camera缩放
        cameraHelper.addZoom(
                if (amountY > 0) {
                    1F
                } else if (amountY < 0) {
                    -1F
                } else {
                    0F
                } * zoomSpeed)
        return super.scrolled(amountX, amountY)
    }

    private fun moveCamera(dx: Float, dy: Float) {
        cameraHelper.setPosition(cameraHelper.position.x + dx, cameraHelper.position.y + dy)
    }


}