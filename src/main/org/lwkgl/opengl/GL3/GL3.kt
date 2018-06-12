package org.lwkgl.opengl.GL3

import kotlinx.cinterop.*
import platform.OpenGL3.*

typealias Shader = Int
typealias ShaderProgram = Int

// TODO: implement it
fun glActiveTexture(){ TODO() }

fun glAttachShader(program: ShaderProgram, shader: Shader) = platform.OpenGL3.glAttachShader(program, shader)

fun glBindBuffer(target: BufferBindingTarget, buffer: Int) = platform.OpenGL3.glBindBuffer(target.value, buffer)

fun glBindTexture(target: TextureType, texture: Int) = platform.OpenGL3.glBindTexture(target.value, texture)

fun glBindVertexArray(array: Int) = platform.OpenGL3.glBindVertexArray(array)

fun glBlendFunc(sourceFactor: SourceFactor, destinationFactor: DestinationFactor) = platform.OpenGL3.glBlendFunc(sourceFactor.value, destinationFactor.value)

fun glBufferData(target: BufferBindingTarget, data: FloatArray, usage: UsagePattern) {
    platform.OpenGL3.glBufferData(target.value, (data.size * AttributeType.Float.stride).signExtend(), data.refTo(0), usage.value)
}

fun glBufferData(target: BufferBindingTarget, data: IntArray, usage: UsagePattern) {
    platform.OpenGL3.glBufferData(target.value, (data.size * AttributeType.Integer.stride).signExtend(), data.refTo(0), usage.value)
}

fun glClear(mask: ClearBit) = platform.OpenGL3.glClear(mask.value)

fun glClear(mask: ClearBitMask) = platform.OpenGL3.glClear(mask.value)

fun glClearColor(red: Float, green: Float, blue: Float, alpha: Float) = platform.OpenGL3.glClearColor(red, green, blue, alpha)

fun glCompileShader(shader: Shader) = platform.OpenGL3.glCompileShader(shader)

fun glCreateProgram(): ShaderProgram = platform.OpenGL3.glCreateProgram()

fun glCreateShader(type: ShaderType): Shader = platform.OpenGL3.glCreateShader(type.value)

fun glDrawArrays(mode: DrawMode, first: Int, count: Int) = platform.OpenGL3.glDrawArrays(mode.value, first, count)

fun glDrawElements(mode: DrawMode, count: Int, type: ElementType, indices: Byte) = platform.OpenGL3.glDrawElements(mode.value, count, type.value, byteArrayOf(indices).refTo(0))

fun glDeleteBuffers(n: Int, buffers: Int) = memScoped {
    val result: IntVarOf<Int> = alloc()
    result.value = buffers
    platform.OpenGL3.glDeleteBuffers(n, result.ptr)
}

fun glDeleteShader(shader: Shader) = platform.OpenGL3.glDeleteShader(shader)

fun glDeleteTextures(n: Int, textures: Int) = memScoped {
    val result: IntVarOf<Int> = alloc()
    result.value = textures
    platform.OpenGL3.glDeleteTextures(n, result.ptr)
}

fun glDeleteVertexArrays(n: Int, arrays: Int) = memScoped {
    val result: IntVarOf<Int> = alloc()
    result.value = arrays
    platform.OpenGL3.glDeleteVertexArrays(n, result.ptr)
}

fun glDisable(capability: Capability) = platform.OpenGL3.glDisable(capability.value)

fun glEnable(capability: Capability) = platform.OpenGL3.glEnable(capability.value)

fun glEnableVertexAttribArray(index: Int) = platform.OpenGL3.glEnableVertexAttribArray(index)

fun glGenBuffers(n: Int): Int = memScoped {
    val result: IntVarOf<Int> = alloc()
    platform.OpenGL3.glGenBuffers(n, result.ptr)
    result.value
}

fun glGenerateMipmap(target: MipmapTarget) = platform.OpenGL3.glGenerateMipmap(target.value)

//fun glGenerateTextureMipmap(texture: GLGenRef) = platform.OpenGL3.glGenerateTextureMipmap(texture.id)

fun glGenTextures(n: Int): Int = memScoped {
    val result: IntVarOf<Int> = alloc()
    platform.OpenGL3.glGenTextures(n, result.ptr)
    result.value
}

fun glGenVertexArrays(n: Int): Int = memScoped {
    val result: IntVarOf<Int> = alloc()
    glGenVertexArrays(n, result.ptr)
    result.value
}

fun glGetError() = platform.OpenGL3.glGetError()

fun glGetProgramInfoLog(shader: Shader): String = memScoped {
    val log = allocArray<ByteVar>(512)
    glGetProgramInfoLog(shader, 512, null, log)

    with(true) {

    }

    return log.toKString()
}

fun glGetProgramiv(program: ShaderProgram, option: Programiv): Int = memScoped {
    val status = alloc<IntVar>()
    glGetProgramiv(program, option.value, status.ptr)
    return status.value
}

fun glGetShaderInfoLog(shader: Shader): String = memScoped {
    val log = allocArray<ByteVar>(512)
    glGetShaderInfoLog(shader, 512, null, log)
    return log.toKString()
}

fun glGetShaderiv(shader: Shader, option: Shaderiv): Int = memScoped {
    val status = alloc<IntVar>()
    glGetShaderiv(shader, option.value, status.ptr)
    return status.value
}

fun glPixelStorei(pname: PixelParam, param: Int) = platform.OpenGL3.glPixelStorei(pname.value, param)

fun glShaderSource(shader: Shader, count: Int, source: String) = memScoped {
    platform.OpenGL3.glShaderSource(shader, count, cValuesOf(source.cstr.getPointer(memScope)), null)
}

fun glTexImage2D(target: TextureParameterTarget, level: Int, internalFormat: InternalFormat, width: Int, height: Int, border: Int, format: TextureFormat, data: ByteArray) = memScoped {
    data.usePinned {
        val rawPointer = interpretCPointer<ByteVar>(it.addressOf(0).rawValue) as CArrayPointer<ByteVar>
        platform.OpenGL3.glTexImage2D(target.value, level, internalFormat.value, width, height, border, format.value, TextureDataType.UNSIGNED_BYTE.value, rawPointer)
    }

}

fun glTexParameterf(target: TextureParameterTarget, pname: TextureParameterName, param: Float) {
    platform.OpenGL3.glTexParameterf(target.value, pname.value, param)
}

fun glTexParameteri(target: TextureParameterTarget, pname: TextureParameterName, param: Int) {
    platform.OpenGL3.glTexParameteri(target.value, pname.value, param)
}

fun glLinkProgram(program: ShaderProgram) = platform.OpenGL3.glLinkProgram(program)

fun glUseProgram(program: ShaderProgram) = platform.OpenGL3.glUseProgram(program)

// TODO: find if pointer parameter if really needed and how to implement it
fun glVertexAttribPointer(index: Int, size: Int, type: AttributeType, normalized: Boolean) {
    val _normalized = if (normalized) GL_TRUE else GL_FALSE
    platform.OpenGL3.glVertexAttribPointer(index, size, type.value, _normalized.narrow(), 0, null)
}

// TODO: implement all other methods