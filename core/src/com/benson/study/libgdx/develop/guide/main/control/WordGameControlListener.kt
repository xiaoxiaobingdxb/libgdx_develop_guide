package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.Gdx

class WordGameControlListener : MultiGameController {

    private var isRunning = true
    override fun isRunning(): Boolean = isRunning

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

    override fun onReset() {
        super.onReset()
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