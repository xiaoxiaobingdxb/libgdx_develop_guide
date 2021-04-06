package com.benson.study.libgdx.develop.guide.device.control

import com.badlogic.gdx.graphics.g2d.Sprite

/**
 * @author dengxiaobing
 * @date 2021/3/31 9:28 上午
 * @description 精灵的键盘控制器
 */
interface IKeyboardController {

    fun updateByKeyPress(delta: Float): Sprite.() -> Unit

    fun pauseByKeyPress(): Boolean

    fun resumeByKeyPress(): Boolean

    fun exitByKeyPress(): Boolean

}