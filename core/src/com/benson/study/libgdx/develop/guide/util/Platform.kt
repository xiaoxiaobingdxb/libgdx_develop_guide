package com.benson.study.libgdx.develop.guide.util

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx

object Platform {

    fun isDesktop() = Gdx.app.type == Application.ApplicationType.Desktop

    fun isAndroid() = Gdx.app.type == Application.ApplicationType.Android

}