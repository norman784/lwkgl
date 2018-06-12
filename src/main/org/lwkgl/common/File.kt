package org.lwkgl.common

import platform.posix.*
import kotlinx.cinterop.*

class File {
    companion object {
        fun readByteArray(path: String): ByteArray? = memScoped {
            val info = alloc<stat>()
            if (stat(path, info.ptr) != 0) return null
            val size = info.st_size.toInt()
            val result = ByteArray(size)
            val file = fopen(path, "rb") ?: return null
            var position = 0
            while (position < size) {
                val toRead = minOf(size - position, 4096)
                val read = fread(result.refTo(position), 1, toRead.signExtend(), file).toInt()
                if (read <= 0) break
                position += read
            }
            fclose(file)
            return result
        }

        fun read(path: String): String? {
            val result = readByteArray(path)
            return result?.stringFromUtf8(0, result.size)
        }

        fun write(path: String, data: ByteArray, append: Boolean = false) = memScoped {
            val file = fopen(path, if (append) "ab" else "wb")
            if (file == null) throw Error("Cannot write to $file")
            var position = 0
            while (position < data.size) {
                val toWrite = minOf(data.size - position, 4096)
                val written = fwrite(data.refTo(position), 1, toWrite.signExtend(), file).toInt()
                if (written <= 0) break
                position += written
            }
            fclose(file)
        }

        fun write(path: String, data: String, append: Boolean = false) = write(path, data.toUtf8(), append)
    }
}