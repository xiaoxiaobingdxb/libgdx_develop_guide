package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.Action
import com.badlogic.gdx.scenes.scene2d.ui.Dialog
import com.badlogic.gdx.scenes.scene2d.ui.Window
import com.benson.study.libgdx.develop.guide.device.control.IGameControlListener
import com.benson.study.libgdx.develop.guide.font.GdxFont

class WordGameControlListener : IGameControlListener, ApplicationListener {

    var isRunning = true

    override fun onPause() {
        super.onPause()
        isRunning = false
    }

    override fun onResume() {
        super.onResume()
        isRunning = true
    }

    override fun onExit() {
        super.onExit()
        Gdx.app.exit()
    }

    override fun create() {

    }

    override fun resize(width: Int, height: Int) {
    }

    override fun render() {
    }

    override fun pause() {
        isRunning = false
    }

    override fun resume() {
        isRunning = true
    }

    override fun dispose() {
    }

}