package com.benson.study.libgdx.develop.guide.main

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

open class WordGame : ApplicationAdapter() {

    private lateinit var controller: WorldController
    private lateinit var render: WorldRender

    private var running = true

    override fun create() {
        super.create()
        Gdx.app.logLevel = Application.LOG_DEBUG // 日志级别控制在debug
        controller = WorldController()
        render = WorldRender(controller)
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        render.resize(width, height)
    }

    override fun pause() {
        super.pause()
        running = false
    }

    override fun resume() {
        super.resume()
        running = true
    }

    override fun render() {
        super.render()
        if (running) {
            controller.update(Gdx.graphics.deltaTime)
        }

        Gdx.gl.glClearColor(0x64 / 255F, 0x95 / 255F, 0xED / 255F, 0xFF / 255F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        render.render()
    }

    override fun dispose() {
        super.dispose()
        render.dispose()
    }
}