package com.benson.study.libgdx.develop.guide.main.control

import com.badlogic.gdx.ApplicationListener
import com.benson.study.libgdx.develop.guide.device.control.IGameControlListener
import com.benson.study.libgdx.develop.guide.device.control.Running

interface MultiGameController: IGameControlListener, ApplicationListener, Running {
}