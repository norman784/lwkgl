package org.lwkgl.glew

import cglew.*
import kotlinx.cinterop.narrow

class GLEW {
    companion object {
        fun init() {
            glewExperimental = GL_TRUE.narrow()
            if (glewInit() != GLEW_OK) {
                throw Error("Failed to initialize GLEW")
            }
        }
    }
}