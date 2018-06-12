package org.lwkgl.opengl.GL3

class ArrayBuffer(val n: Int, val data: FloatArray, usagePattern: UsagePattern) {
    val id: Int = glGenBuffers(n)

    init {
        glBindBuffer(BufferBindingTarget.Array, id)
        glBufferData(BufferBindingTarget.Array, data, usagePattern)
        glBindBuffer(BufferBindingTarget.Array, 0)
    }

    fun clean() {
        glDeleteBuffers(n, id)
    }
}