package org.lwkgl.opengl.GL3

import kotlinx.cinterop.*
import platform.OpenGL.GL_LINEAR
import platform.OpenGL3.GL_REPEAT

class Texture(val width: Int, val height: Int, data: ByteArray, components: Int) {
    var id: Int = 0
        private set

    init {
        id = glGenTextures(1)
        glBindTexture(TextureType.Texture2D, id)

        val internalFormat: InternalFormat
        val textureFormat: TextureFormat

        when (components) {
            4 -> {
                internalFormat = InternalFormat.RGBA
                textureFormat = TextureFormat.RGBA
            }
            else -> {
                internalFormat = InternalFormat.RGB
                textureFormat = TextureFormat.RGB
            }
        }

        glTexParameteri(TextureParameterTarget.Texture2D, TextureParameterName.WrapS, GL_REPEAT)
        glTexParameteri(TextureParameterTarget.Texture2D, TextureParameterName.WrapT, GL_REPEAT)

        glTexParameteri(TextureParameterTarget.Texture2D, TextureParameterName.MinFilter, GL_LINEAR)
        glTexParameteri(TextureParameterTarget.Texture2D, TextureParameterName.MagFilter, GL_LINEAR)

        glTexImage2D(
            TextureParameterTarget.Texture2D,
            0,
            internalFormat,
            width,
            height,
            0,
            textureFormat,
            data
        )
        glGenerateMipmap(MipmapTarget.Texture2D)

        glBindTexture(TextureType.Texture2D, 0)
    }
}