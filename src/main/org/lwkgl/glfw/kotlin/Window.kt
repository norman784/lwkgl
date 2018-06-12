package org.lwkgl.glfw

import cglfw.*
import kotlinx.cinterop.*
import platform.OpenGL.*

class Window(var title: String?, var width: Int, var height: Int) {
    private var handle: CPointer<GLFWwindow>? = null

    init {
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2)
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE)
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE)
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE)

        handle = glfwCreateWindow(width, height, title, null, null)
        if (handle == null) {
            throw Exception("Failed to create GLFW window")
            glfwTerminate()
        }

        glfwMakeContextCurrent(handle)
        GLFW.windows.add(this)
    }

    fun shouldClose(): Boolean {
        return glfwWindowShouldClose(handle) == GLFW_TRUE
    }

    fun swapBuffer() {
        glfwSwapBuffers(handle)
    }

    fun close() {
        GLFW.windows.remove(this)
        glfwDestroyWindow(handle)
    }
}