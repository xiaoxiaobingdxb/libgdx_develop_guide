package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.ui.Dialog
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.Window
import com.benson.study.libgdx.develop.guide.config.GameConfigConstant
import com.benson.study.libgdx.develop.guide.device.control.IGameController
import com.benson.study.libgdx.develop.guide.device.control.IKeyboardController
import com.benson.study.libgdx.develop.guide.font.GdxFont
import com.benson.study.libgdx.develop.guide.main.global.UIGlobal
import com.benson.study.libgdx.develop.guide.util.Platform

/**
 * 键盘控制精灵
 */
class KeyboardController(private val gameController: IGameController, private val speed: Float) : InputAdapter(), IKeyboardController {

    override fun keyDown(keycode: Int): Boolean {
        return listenSystemPress()
    }

    override fun updateByKeyPress(delta: Float): Sprite.() -> Unit {
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
            gameController.pause()
        } else {
            gameController.resume()
        }
    }

    override fun pauseByKeyPress(): Boolean {
        return if (Platform.isDesktop()) { // 电脑桌面平台
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !paused) {
                paused = true
                pauseOrResume()
                true
            } else {
                false
            }
        } else {
            false
        }
    }

    override fun resumeByKeyPress(): Boolean {
        return if (Platform.isDesktop()) { // 电脑桌面平台
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && paused) {
                paused = false
                pauseOrResume()
                true
            } else {
                false
            }
        } else {
            false
        }
    }

    override fun exitByKeyPress(): Boolean {
        return if (Platform.isDesktop()) {
            val stage = UIGlobal.currentStage
            if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) && stage != null) {
                var dialog: Dialog? = null
                dialog = Dialog(GameConfigConstant.GAME_NAME, Window.WindowStyle(GdxFont.REGULAR_26, Color.BLACK, null))
                        .button(TextButton("确定", TextButton.TextButtonStyle(null, null, null, GdxFont.REGULAR_26)).apply {
                            addListener {
                                Gdx.app.exit()
                                true
                            }
                        })
                        .button(TextButton("取消", TextButton.TextButtonStyle(null, null, null, GdxFont.REGULAR_26)).apply {
                            addListener {
                                dialog?.hide()
                                true
                            }
                        }).show(stage)
                true
            } else {
                false
            }
        } else {
            false
        }
    }

    fun listenSystemPress(): Boolean {
        return pauseByKeyPress() || resumeByKeyPress() || exitByKeyPress()
    }

}