package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.benson.study.libgdx.develop.guide.main.WorldController
import com.benson.study.libgdx.develop.guide.util.Platform

/**
 * 键盘控制精灵
 */
class KeyboardController(private val wordController: WorldController, private val speed: Float) : InputAdapter() {

    override fun keyDown(keycode: Int): Boolean {
        return when (keycode) {
            Input.Keys.SPACE -> {
                pauseByKeyPress() || resumeByKeyPress()
            }
            Input.Keys.ESCAPE -> exitByKeyPress()
            Input.Keys.R -> resetByKeyPress()
            Input.Keys.N -> {
                wordController.nextSprite()
                true
            }
            else -> super.keyDown(keycode)
        }
    }

    fun updateByKeyPress(delta: Float): Sprite.() -> Unit {
        return if (Platform.isDesktop()) { // 电脑桌面平台
            {
                val moveSpeed = speed * delta
                val moves = Vector2(0F, 0F)
                when {
                    Gdx.input.isKeyPressed(Input.Keys.A) -> { // left
                        moves.x = -moveSpeed
                    }
                    Gdx.input.isKeyPressed(Input.Keys.W) -> { // top
                        moves.y = +moveSpeed
                    }
                    Gdx.input.isKeyPressed(Input.Keys.D) -> { // right
                        moves.x = +moveSpeed
                    }
                    Gdx.input.isKeyPressed(Input.Keys.S) -> { // bottom
                        moves.y = -moveSpeed
                    }
                }
                translate(moves.x, moves.y)
            }
        } else {
            {}
        }
    }

    private var paused = false

    private fun pauseOrResume() {
        if (paused) {
            wordController.gameController.pause()
        } else {
            wordController.gameController.resume()
        }
    }

    private fun pauseByKeyPress(): Boolean {
        return if (!paused) {
            paused = true
            pauseOrResume()
            true
        } else {
            false
        }
    }

    private fun resumeByKeyPress(): Boolean {
        return if (paused) {
            paused = false
            pauseOrResume()
            true
        } else {
            false
        }
    }

    private fun exitByKeyPress(): Boolean {
        wordController.gameController.exit()
        return true
//        val stage = UIGlobal.currentStage
//        return if (stage != null) {
//            var dialog: Dialog? = null
//            dialog = Dialog(GameConfigConstant.GAME_NAME, Window.WindowStyle(GdxFont.REGULAR_26, Color.BLACK, null))
//                    .button(TextButton("确定", TextButton.TextButtonStyle(null, null, null, GdxFont.REGULAR_26)).apply {
//                        addListener {
//                            Gdx.app.exit()
//                            true
//                        }
//                    })
//                    .button(TextButton("取消", TextButton.TextButtonStyle(null, null, null, GdxFont.REGULAR_26)).apply {
//                        addListener {
//                            dialog?.hide()
//                            true
//                        }
//                    }).show(stage)
//            true
//        } else {
//            false
//        }
    }

    private fun resetByKeyPress(): Boolean {
        wordController.gameController.reset()
        return true
    }

}