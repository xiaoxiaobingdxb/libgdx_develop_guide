package com.benson.study.libgdx.develop.guide.main

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.viewport.FillViewport
import com.benson.study.libgdx.develop.guide.config.GameConfigConstant
import com.benson.study.libgdx.develop.guide.main.global.UIGlobal

class WorldRender(private val controller: WorldController) : Disposable {

    private val batch: Batch = SpriteBatch()
    private val camera: Camera = OrthographicCamera(GameConfigConstant.VIEWPORT_WIDTH, GameConfigConstant.VIEWPORT_HEIGHT).apply {
        position.set(Vector3(0F, 0F, 0F))
        update()
    }

    private val mainStage = Stage(FillViewport(GameConfigConstant.VIEWPORT_WIDTH, GameConfigConstant.VIEWPORT_HEIGHT))
    init {
        UIGlobal.currentStage = mainStage
    }

    fun resize(width: Int, height: Int) {
        camera.viewportWidth = GameConfigConstant.VIEWPORT_HEIGHT / height * width
        camera.update()
    }

    fun render() {
        batch.projectionMatrix = camera.combined
        batch.begin()
        renderSprites()
        mainStage.act()
        mainStage.draw()
        batch.end()
    }

    private fun renderSprites() {
        controller.testSprites.forEach {
            it.draw(batch)
        }
    }

    override fun dispose() {
        mainStage.dispose()
        batch.dispose()
    }
}