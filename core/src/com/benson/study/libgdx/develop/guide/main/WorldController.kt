package com.benson.study.libgdx.develop.guide.main

import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.math.MathUtils
import com.benson.study.libgdx.develop.guide.main.control.KeyboardController

class WorldController {

    companion object {
        private const val SPRITE_COUNT = 5 // 精灵个数
        private const val SPRITE_SIZE = 32 // 精灵大小
    }

    lateinit var testSprites: Array<Sprite>
    private var selectedSprite = 0
    private val keyboardController by lazy {
        KeyboardController(5F)
    }

    init {
        initSprites()
    }

    fun update(delta: Float) {
        updateSelectedSprite(delta)
    }

    private fun initSprites() {
        testSprites = Array(SPRITE_COUNT) { index ->
            Sprite(Texture(Pixmap(SPRITE_SIZE, SPRITE_SIZE, Pixmap.Format.RGB888).apply {
                setColor(1F, 0F, 0F, 0.5F)
                fill()

                setColor(1F, 1F, 0F, 1F)
                drawLine(0, 0, width, height)
                drawLine(width, 0, 0, height)

                setColor(0F, 1F, 1F, 1F)
                drawRectangle(0, 0, width, height)
            })).apply {
                setSize(1.0F, 1.0F)
                setOrigin(width / 2, height / 2)
                setPosition(MathUtils.random(-2.0F, 2.0F), MathUtils.random(-2.0F, 2.0F))
            }
        }
    }

    private fun updateSelectedSprite(delta: Float) {
        testSprites[selectedSprite].apply {
            var newRotation = rotation
            newRotation += 90 * delta
            newRotation %= 360
            rotation = newRotation
            keyboardController.updateByKeyPress(delta).invoke(this)
        }
    }
}