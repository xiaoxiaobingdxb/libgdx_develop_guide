package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.benson.study.libgdx.develop.guide.device.control.IGameControlListener

class WordGameControlListener: IGameControlListener, ApplicationListener {

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
    }

    override fun resume() {
    }

    override fun dispose() {
    }

}