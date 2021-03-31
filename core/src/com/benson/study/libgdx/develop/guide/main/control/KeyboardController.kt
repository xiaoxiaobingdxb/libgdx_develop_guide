package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.Vector2
import com.benson.study.libgdx.develop.guide.device.control.IKeyboardController

/**
 * 键盘控制精灵
 */
class KeyboardController(private val speed: Float) : IKeyboardController {

    override fun updateByKeyPress(delta: Float): Sprite.() -> Unit {
        return if (Gdx.app.type == Application.ApplicationType.Desktop) { // 电脑桌面平台
            {
                val moveSpeed = speed * delta
                val moves = Vector2(0F, 0F)
                if (Gdx.input.isKeyPressed(Input.Keys.A)) { // left
                    moves.x = -moveSpeed
                } else if (Gdx.input.isKeyPressed(Input.Keys.W)) { // top
                    moves.y = +moveSpeed
                } else if (Gdx.input.isKeyPressed(Input.Keys.D)) { // right
                    moves.x = +moveSpeed
                } else if (Gdx.input.isKeyPressed(Input.Keys.S)) { // bottom
                    moves.y = -moveSpeed
                }
                translate(moves.x, moves.y)
            }
        } else {
            {}
        }
    }

}