package org.lwkgl.glfw

import cglfw.*
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString
import platform.OpenGL.GL_TRUE

class GLFW {
    companion object {
        private var shouldClose: Boolean = false
        internal var windows: MutableSet<Window> = mutableSetOf()

        fun init() {
            val version = glfwGetVersionString()
            println("GLFW v${version?.toKString()}")
            glfwSetErrorCallback(staticCFunction(::errorCallback))

            if (glfwInit() == GLFW_FALSE) {
                throw Exception("Unable to initialize window")
            }

            glfwWindowHint(GLFW_SAMPLES, 4)
            glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
            glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2)
            glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE)
            glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
        }

        fun update(callback: () -> Unit) {
            while (!shouldClose) {
                if (windows.count() == 0) {
                    shouldClose = true
                }

                callback()

                windows.forEach {
                    if (it.shouldClose()) {
                        it.close()
                    } else {
                        it.swapBuffer()
                    }
                }

                glfwPollEvents()
            }

            deinit()
        }

        fun deinit() {
            glfwTerminate()
        }
    }
}

private fun errorCallback(code: Int, byte: CPointer<ByteVarOf<Byte>>?) {
    println("$code\t${byte?.toKString()}")
}