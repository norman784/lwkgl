package org.lwkgl.stb

import kotlinx.cinterop.*
import cstb.*

enum class ImageType constructor(val value: Int) {
    RGB(STBI_rgb),
    RGBA(STBI_rgb_alpha)
}

class Image(val width: Int, val height: Int, val type: ImageType, val data: ByteArray) {
    companion object {
        fun load(file: String): Image? = memScoped {
            val width: IntVar = alloc()
            val height: IntVar = alloc()
            val components: IntVar = alloc()

//            stbi_set_flip_vertically_on_load(1)
            val data = stbi_load(file, width.ptr, height.ptr, components.ptr, 0)

            //public fun stbi_load(filename: kotlin.String?, x: kotlinx.cinterop.CValuesRef<kotlinx.cinterop.IntVar /* = kotlinx.cinterop.IntVarOf<kotlin.Int> */>?, y: kotlinx.cinterop.CValuesRef<kotlinx.cinterop.IntVar /* = kotlinx.cinterop.IntVarOf<kotlin.Int> */>?, channels_in_file: kotlinx.cinterop.CValuesRef<kotlinx.cinterop.IntVar /* = kotlinx.cinterop.IntVarOf<kotlin.Int> */>?, desired_channels: kotlin.Int): kotlinx.cinterop.CPointer<kotlinx.cinterop.ByteVarOf<kotlin.Byte>>? { /* compiled code */ }
//            kotlinx.cinterop.CPointer<kotlinx.cinterop.ByteVarOf<kotlin.Byte>>
            if (data == null) {
                var error = "Error:\n\tdata: null"
                if (width.value == 0) error += "\twidth: 0"
                if (height.value == 0) error += "\theight: 0"
                throw Error(error)
            } else {
                val result: String = data.toKString()
                stbi_image_free(data)
                Image(
                    width.value,
                    height.value,
                    if (components.value == 4) ImageType.RGBA else ImageType.RGB,
                    result.toUtf8(0, result.count())
                )
            }
        }
    }
}