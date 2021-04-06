package com.benson.study.libgdx.develop.guide.font
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.BitmapFont

object GdxFont {

    val REGULAR_26 by lazy {
        BitmapFont(Gdx.app.files.internal("font/Amble-Regular-26.fnt"))
    }

}