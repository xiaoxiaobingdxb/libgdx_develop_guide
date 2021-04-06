package com.benson.study.libgdx.develop.guide.main

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.benson.study.libgdx.develop.guide.lifecycle.ApplicationDispatcher
import com.benson.study.libgdx.develop.guide.main.control.WordGameControlListener
import com.benson.study.libgdx.develop.guide.main.global.UIGlobal

open class WordGame : ApplicationDispatcher() {

    private val controller by lazy {
        WorldController()
    }
    private lateinit var render: WorldRender
    private val gameControlListener: WordGameControlListener = WordGameControlListener()

    fun init() {
        lifecycle().addObserver(TestLifecycleObserver())
        register(gameControlListener)
        controller.gameController.registerListener(gameControlListener)
        lifecycle().addObserver(UIGlobal)
    }

    override fun create() {
        super.create()
        init()
        Gdx.app.logLevel = Application.LOG_DEBUG // 日志级别控制在debug
        render = WorldRender(controller)
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        render.resize(width, height)
    }

    override fun render() {
        super.render()
        if (gameControlListener.isRunning) {
            controller.update(Gdx.graphics.deltaTime)
        }

        Gdx.gl.glClearColor(0x64 / 255F, 0x95 / 255F, 0xED / 255F, 0xFF / 255F)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        render.render()
    }

    override fun dispose() {
        super.dispose()
        render.dispose()
        controller.gameController.unreigsterListener(gameControlListener)
    }
}