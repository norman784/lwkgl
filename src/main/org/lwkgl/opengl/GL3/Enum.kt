package org.lwkgl.opengl.GL3

import platform.OpenGL.GL_ACCUM_BUFFER_BIT
import platform.OpenGL3.*

class ClearBitMask(val value: Int)

interface Flags {
    val value: Int
}

infix fun <T: Flags> Flags.or(other: T): ClearBitMask = ClearBitMask(value or other.value)
infix fun ClearBitMask.or(other: Flags): ClearBitMask = ClearBitMask(value or other.value)

// TODO: get the correct stride for each type
enum class AttributeType constructor(val value: Int, val stride: Int) {
    Byte(GL_BYTE, 4),
    UnsignedByte(GL_UNSIGNED_BYTE, 4),
    Short(GL_SHORT, 4),
    UnsignedShort(GL_UNSIGNED_SHORT, 4),
    Integer(GL_INT, 4),
    UnsignedInteger(GL_UNSIGNED_INT, 4),
    HalfFloat(GL_HALF_FLOAT, 4),
    Float(GL_FLOAT, 4),
    Double(GL_DOUBLE, 4),
    Fixed(GL_FIXED, 4),
    Integer_2_10_10_10_Rev(GL_INT_2_10_10_10_REV, 4),
    UnsignedInteger_2_10_10_10_Rev(GL_UNSIGNED_INT_2_10_10_10_REV, 4),
    UnsignedInteger_10F_11F_11F_Rev(GL_UNSIGNED_INT_10F_11F_11F_REV, 4)
}

enum class BufferBindingTarget constructor(val value: Int) {
    Array(GL_ARRAY_BUFFER),
    CopyRead(GL_COPY_READ_BUFFER),
    CopyWrite(GL_COPY_WRITE_BUFFER),
    DrawIndirect(GL_DRAW_INDIRECT_BUFFER),
    ElementArray(GL_ELEMENT_ARRAY_BUFFER),
    PixelPack(GL_PIXEL_PACK_BUFFER),
    PixelUnpack(GL_PIXEL_UNPACK_BUFFER),
    Texture(GL_TEXTURE),
    TransformFeedbackm(GL_TRANSFORM_FEEDBACK),
    Uniform(GL_UNIFORM_BUFFER)
}

enum class Capability constructor(val value: Int) {
    Blend(GL_BLEND),
    ColorLogicOP(GL_COLOR_LOGIC_OP),
    CullFace(GL_CULL_FACE),
    DepthClamp(GL_DEPTH_CLAMP),
    DepthTest(GL_DEPTH_TEST),
    Dither(GL_DITHER),
    FramebufferSRGB(GL_FRAMEBUFFER_SRGB),
    LineSmooth(GL_LINE_SMOOTH),
    MultiSample(GL_MULTISAMPLE),
    PolygonOffsetFill(GL_POLYGON_OFFSET_FILL),
    PolygonOffsetLine(GL_POLYGON_OFFSET_LINE),
    PolygonOffsetPoint(GL_POLYGON_OFFSET_POINT),
    PolygonSmooth(GL_POLYGON_SMOOTH),
    PrimitiveRestart(GL_PRIMITIVE_RESTART),
    RasterizerDiscard(GL_RASTERIZER_DISCARD),
    SampleAlphaToCoverage(GL_SAMPLE_ALPHA_TO_COVERAGE),
    SampleAlphaToOne(GL_SAMPLE_ALPHA_TO_ONE),
    SampleCoverage(GL_SAMPLE_COVERAGE),
    SampleShading(GL_SAMPLE_SHADING),
    SampleMask(GL_SAMPLE_MASK),
    ScissorTest(GL_SCISSOR_TEST),
    StencilTest(GL_STENCIL_TEST),
    TextureCubeMapSeamless(GL_TEXTURE_CUBE_MAP_SEAMLESS),
    ProgramPointSize(GL_PROGRAM_POINT_SIZE)
}

enum class ClearBit constructor(override val value: Int): Flags {
    ColorBuffer(GL_COLOR_BUFFER_BIT),
    DepthBuffer(GL_DEPTH_BUFFER_BIT),
    AccumulationBuffer(GL_ACCUM_BUFFER_BIT),
    StencilBuffer(GL_STENCIL_BUFFER_BIT)
}

enum class DestinationFactor constructor(val value: Int) {
    Zero(GL_ZERO),
    One(GL_ONE),
    SourceColor(GL_SRC_COLOR),
    OneMinusSourceColor(GL_ONE_MINUS_SRC_COLOR),
    DestinationColor(GL_DST_COLOR),
    OneMinusDestinationColor(GL_ONE_MINUS_DST_COLOR),
    SourceAlpha(GL_SRC_ALPHA),
    OneMinusSourceAlpha(GL_ONE_MINUS_SRC_ALPHA),
    DestinationAlpha(GL_DST_ALPHA),
    OneMinusDestinationAlpha(GL_ONE_MINUS_DST_ALPHA),
    ConstantColor(GL_CONSTANT_COLOR),
    OneMinusConstantColor(GL_ONE_MINUS_CONSTANT_COLOR),
    ConstantAlpha(GL_CONSTANT_ALPHA),
    OneMinusConstantAlpha(GL_ONE_MINUS_CONSTANT_ALPHA),
    SourceAlphaSaturate(GL_SRC_ALPHA_SATURATE),
    Source1Color(GL_SRC1_COLOR),
    OneMinusSource1Color(GL_ONE_MINUS_SRC1_COLOR),
    Source1Alpha(GL_SRC1_ALPHA),
    OneMinusSource1Alpha(GL_ONE_MINUS_SRC1_ALPHA)
}

enum class DrawMode constructor(val value: Int) {
    Points(GL_POINTS),
    LineStrip(GL_LINE_STRIP),
    LineLoop(GL_LINE_LOOP),
    Lines(GL_LINES),
    LineStripAdjacency(GL_LINE_STRIP_ADJACENCY),
    LinesAdjacency(GL_LINES_ADJACENCY),
    TriangleStrip(GL_TRIANGLE_STRIP),
    TriangleFan(GL_TRIANGLE_FAN),
    Triangles(GL_TRIANGLES),
    TrianglesStripAdjacency(GL_TRIANGLE_STRIP_ADJACENCY),
    TrianglesAdjacency(GL_TRIANGLES_ADJACENCY),
    Patches(GL_PATCHES)
}

enum class ElementType constructor(val value: Int) {
    UnsignedByte(GL_UNSIGNED_BYTE),
    UnsignedShort(GL_UNSIGNED_SHORT),
    UnsignedInt(GL_UNSIGNED_INT)
}

enum class InternalFormat constructor(val value: Int) {
    // Base Internal Format
    DEPTH_COMPONENT(GL_DEPTH_COMPONENT),
    DEPTH_STENCIL(GL_DEPTH_STENCIL),
    RED(GL_RED),
    RG(GL_RG),
    RGB(GL_RGB),
    RGBA(GL_RGBA),
    // Sized Internal Format
    R8(GL_R8),
    R8_SNORM(GL_R8_SNORM),
    R16(GL_R16),
    R16_SNORM(GL_R16_SNORM),
    RG8(GL_RG8),
    RG8_SNORM(GL_RG8_SNORM),
    RG16(GL_RG16),
    RG16_SNORM(GL_RG16_SNORM),
    R3_G3_B2(GL_R3_G3_B2),
    RGB4(GL_RGB4),
    RGB5(GL_RGB5),
    RGB8(GL_RGB8),
    RGB8_SNORM(GL_RGB8_SNORM),
    RGB10(GL_RGB10),
    RGB12(GL_RGB12),
    RGB16_SNORM(GL_RGB16_SNORM),
    RGBA2(GL_RGBA2),
    RGBA4(GL_RGBA4),
    RGB5_A1(GL_RGB5_A1),
    RGBA8(GL_RGBA8),
    RGBA8_SNORM(GL_RGBA8_SNORM),
    RGB10_A2(GL_RGB10_A2),
    RGB10_A2UI(GL_RGB10_A2UI),
    RGBA12(GL_RGBA12),
    RGBA16(GL_RGBA16),
    SRGB8(GL_SRGB8),
    SRGB8_ALPHA8(GL_SRGB8_ALPHA8),
    R16F(GL_R16F),
    RG16F(GL_RG16F),
    RGB16F(GL_RGB16F),
    RGBA16F(GL_RGBA16F),
    R32F(GL_R32F),
    RG32F(GL_RG32F),
    RGB32F(GL_RGB32F),
    RGBA32F(GL_RGBA32F),
    R11F_G11F_B10F(GL_R11F_G11F_B10F),
    RGB9_E5(GL_RGB9_E5),
    R8I(GL_R8I),
    R8UI(GL_R8UI),
    R16I(GL_R16I),
    R16UI(GL_R16UI),
    R32I(GL_R32I),
    R32UI(GL_R32UI),
    RG8I(GL_RG8I),
    RG8UI(GL_RG8UI),
    RG16I(GL_RG16I),
    RG16UI(GL_RG16UI),
    RG32I(GL_RG32I),
    RG32UI(GL_RG32UI),
    RGB8I(GL_RGB8I),
    RGB8UI(GL_RGB8UI),
    RGB16I(GL_RGB16I),
    RGB16UI(GL_RGB16UI),
    RGB32I(GL_RGB32I),
    RGB32UI(GL_RGB32UI),
    RGBA8I(GL_RGBA8I),
    RGBA8UI(GL_RGBA8UI),
    RGBA16I(GL_RGBA16I),
    RGBA16UI(GL_RGBA16UI),
    RGBA32I(GL_RGBA32I),
    RGBA32UI(GL_RGBA32UI),
    // Compressed Internal Format
    COMPRESSED_RED(GL_COMPRESSED_RED),
    COMPRESSED_RG(GL_COMPRESSED_RG),
    COMPRESSED_RGB(GL_COMPRESSED_RGB),
    COMPRESSED_RGBA(GL_COMPRESSED_RGBA),
    COMPRESSED_SRGB(GL_COMPRESSED_SRGB),
    COMPRESSED_SRGB_ALPHA(GL_COMPRESSED_SRGB_ALPHA),
    COMPRESSED_RED_RGTC1(GL_COMPRESSED_RED_RGTC1),
    COMPRESSED_SIGNED_RED_RGTC1(GL_COMPRESSED_SIGNED_RED_RGTC1),
    COMPRESSED_RG_RGTC2(GL_COMPRESSED_RG_RGTC2),
    COMPRESSED_SIGNED_RG_RGTC2(GL_COMPRESSED_SIGNED_RG_RGTC2),
//    COMPRESSED_RGBA_BPTC_UNORM(GL_COMPRESSED_RGBA_BPTC_UNORM),
//    COMPRESSED_SRGB_ALPHA_BPTC_UNORM(GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM),
//    COMPRESSED_RGB_BPTC_SIGNED_FLOAT(GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT),
//    COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT(GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT)
}

enum class MipmapTarget constructor(val value: Int) {
    Texture1D(GL_TEXTURE_1D),
    Texture1DArray(GL_TEXTURE_1D_ARRAY),
    Texture2D(GL_TEXTURE_2D),
    Texture2DArray(GL_TEXTURE_2D_ARRAY),
    Texture3D(GL_TEXTURE_3D),
    CubeMap(GL_TEXTURE_CUBE_MAP),
    CubeMapArray(GL_TEXTURE_CUBE_MAP_ARRAY)
}

enum class PixelParam constructor(val value: Int) {
    PackSwapBytes(GL_PACK_SWAP_BYTES),
    PackLSBFirst(GL_PACK_LSB_FIRST),
    PackRowLength(GL_PACK_ROW_LENGTH),
    PackImageHeight(GL_PACK_IMAGE_HEIGHT),
    PackSkipPixels(GL_PACK_SKIP_PIXELS),
    PackSkipRows(GL_PACK_SKIP_ROWS),
    PackSkipImages(GL_PACK_SKIP_IMAGES),
    PackAligment(GL_PACK_ALIGNMENT),
    UnpackSwapBytes(GL_UNPACK_SWAP_BYTES),
    UnpackLSBFirst(GL_UNPACK_LSB_FIRST),
    UnpackRowLength(GL_UNPACK_ROW_LENGTH),
    UnpackImageHeight(GL_UNPACK_IMAGE_HEIGHT),
    UnpackSkipPixels(GL_UNPACK_SKIP_PIXELS),
    UnpackSkipRows(GL_UNPACK_SKIP_ROWS),
    UnpackSkipImages(GL_UNPACK_SKIP_IMAGES),
    UnpackAligment(GL_UNPACK_ALIGNMENT)
}

enum class Programiv constructor(val value: Int) {
    DeleteStatus(GL_DELETE_STATUS),
    LinkStatus(GL_LINK_STATUS),
    ValidateStatus(GL_VALIDATE_STATUS),
    InfoLogLength(GL_INFO_LOG_LENGTH),
    AttachedShaders(GL_ATTACHED_SHADERS),
    ActiveAttributes(GL_ACTIVE_ATTRIBUTES),
    ActiveAttributeMaxLength(GL_ACTIVE_ATTRIBUTE_MAX_LENGTH),
    ActiveUniforms(GL_ACTIVE_UNIFORMS),
    ActiveUniformsBlocks(GL_ACTIVE_UNIFORM_BLOCKS),
    ActiveUniformBlockMaxNameLength(GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH),
    ActiveUniformMaxLenght(GL_ACTIVE_UNIFORM_MAX_LENGTH),
    ProgramBinaryLength(GL_PROGRAM_BINARY_LENGTH),
    TransformFeedbackBufferMode(GL_TRANSFORM_FEEDBACK_BUFFER_MODE),
    TransformFeedbackVaryings(GL_TRANSFORM_FEEDBACK_VARYINGS),
    TransformFeedbackVaryingMaxLength(GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH),
    GeometryVerticesOut(GL_GEOMETRY_VERTICES_OUT),
    GeometryInoutType(GL_GEOMETRY_INPUT_TYPE),
    GeometryOutputType(GL_GEOMETRY_OUTPUT_TYPE)
}

enum class Shaderiv constructor(val value: Int) {
    ShaderType(GL_COMPILE_STATUS),
    DeleteStatus(GL_DELETE_STATUS),
    CompileStatus(GL_SHADER_TYPE),
    InfoLogLength(GL_INFO_LOG_LENGTH),
    ShaderSourceLength(GL_SHADER_SOURCE_LENGTH)
}

enum class ShaderType constructor(val value: Int) {
    Vertex(GL_VERTEX_SHADER),
    Fragment(GL_FRAGMENT_SHADER)
}

enum class SourceFactor constructor(val value: Int) {
    One(GL_ONE)
}

enum class TextureDataType constructor(val value: Int) {
    UNSIGNED_BYTE(GL_UNSIGNED_BYTE),
    BYTE(GL_BYTE),
    UNSIGNED_SHORT(GL_UNSIGNED_SHORT),
    SHORT(GL_SHORT),
    UNSIGNED_INT(GL_UNSIGNED_INT),
    INT(GL_INT),
    FLOAT(GL_FLOAT),
    UNSIGNED_BYTE_3_3_2(GL_UNSIGNED_BYTE_3_3_2),
    UNSIGNED_BYTE_2_3_3_REV(GL_UNSIGNED_BYTE_2_3_3_REV),
    UNSIGNED_SHORT_5_6_5(GL_UNSIGNED_SHORT_5_6_5),
    UNSIGNED_SHORT_5_6_5_REV(GL_UNSIGNED_SHORT_5_6_5_REV),
    UNSIGNED_SHORT_4_4_4_4(GL_UNSIGNED_SHORT_4_4_4_4),
    UNSIGNED_SHORT_4_4_4_4_REV(GL_UNSIGNED_SHORT_4_4_4_4_REV),
    UNSIGNED_SHORT_5_5_5_1(GL_UNSIGNED_SHORT_5_5_5_1),
    UNSIGNED_SHORT_1_5_5_5_REV(GL_UNSIGNED_SHORT_1_5_5_5_REV),
    UNSIGNED_INT_8_8_8_8(GL_UNSIGNED_INT_8_8_8_8),
    UNSIGNED_INT_8_8_8_8_REV(GL_UNSIGNED_INT_8_8_8_8_REV),
    UNSIGNED_INT_10_10_10_2(GL_UNSIGNED_INT_10_10_10_2),
    UNSIGNED_INT_2_10_10_10_REV(GL_UNSIGNED_INT_2_10_10_10_REV),
}

enum class TextureFormat constructor(val value: Int) {
    RED(GL_RED),
    RG(GL_RG),
    RGB(GL_RGB),
    BGR(GL_BGR),
    RGBA(GL_RGBA),
    BGRA(GL_BGRA),
    RED_INTEGER(GL_RED_INTEGER),
    RG_INTEGER(GL_RG_INTEGER),
    RGB_INTEGER(GL_RGB_INTEGER),
    BGR_INTEGER(GL_BGR_INTEGER),
    RGBA_INTEGER(GL_RGBA_INTEGER),
    BGRA_INTEGER(GL_BGRA_INTEGER),
    STENCIL_INDEX(GL_STENCIL_INDEX),
    DEPTH_COMPONENT(GL_DEPTH_COMPONENT),
    DEPTH_STENCIL(GL_DEPTH_STENCIL)
}

enum class TextureParameterName constructor(val value: Int) {
//    DepthStencilTextureMode(GL_DEPTH_STENCIL_TEXTURE_MODE),
    BaseLevel(GL_TEXTURE_BASE_LEVEL),
    CompareFunc(GL_TEXTURE_COMPARE_FUNC),
    CompareMode(GL_TEXTURE_COMPARE_MODE),
    LODBias(GL_TEXTURE_LOD_BIAS),
    MinFilter(GL_TEXTURE_MIN_FILTER),
    MagFilter(GL_TEXTURE_MAG_FILTER),
    MinLOD(GL_TEXTURE_MIN_LOD),
    MaxLOD(GL_TEXTURE_MAX_LOD),
    MaxLevel(GL_TEXTURE_MAX_LEVEL),
    SwizzleR(GL_TEXTURE_SWIZZLE_R),
    SwizzleG(GL_TEXTURE_SWIZZLE_G),
    SwizzleB(GL_TEXTURE_SWIZZLE_B),
    SwizzleA(GL_TEXTURE_SWIZZLE_A),
    WrapS(GL_TEXTURE_WRAP_S),
    WrapT(GL_TEXTURE_WRAP_T),
    WrapR(GL_TEXTURE_WRAP_R),
    BorderColor(GL_TEXTURE_BORDER_COLOR),
    SwizzleRGBA(GL_TEXTURE_SWIZZLE_RGBA)
}

enum class TextureParameterTarget constructor(val value: Int) {
    Texture1D(GL_TEXTURE_1D),
    Texture1DArray(GL_TEXTURE_1D_ARRAY),
    Texture2D(GL_TEXTURE_2D),
    Texture2DArray(GL_TEXTURE_2D_ARRAY),
    Texture2DMultisample(GL_TEXTURE_2D_MULTISAMPLE),
    Texture2DMultisampleArray(GL_TEXTURE_2D_MULTISAMPLE_ARRAY),
    Texture3D(GL_TEXTURE_3D),
    CubeMap(GL_TEXTURE_CUBE_MAP),
    CubeMapArray(GL_TEXTURE_CUBE_MAP_ARRAY),
    Rectangle(GL_TEXTURE_RECTANGLE)
}

enum class TextureType constructor(val value: Int) {
    Texture2D(GL_TEXTURE_2D),
    ProxyTexture2D(GL_PROXY_TEXTURE_2D),
    Texture1DArray(GL_TEXTURE_1D_ARRAY),
    ProxyTexture1DArray(GL_PROXY_TEXTURE_1D_ARRAY),
    Rectangle(GL_TEXTURE_RECTANGLE),
    ProxyRectangle(GL_PROXY_TEXTURE_RECTANGLE),
    CubeMapPositiveX(GL_TEXTURE_CUBE_MAP_POSITIVE_X),
    CubeMapNegativeX(GL_TEXTURE_CUBE_MAP_NEGATIVE_X),
    CubeMapPositiveY(GL_TEXTURE_CUBE_MAP_POSITIVE_Y),
    CubeMapNegativeY(GL_TEXTURE_CUBE_MAP_NEGATIVE_Y),
    CubeMapPositiveZ(GL_TEXTURE_CUBE_MAP_POSITIVE_Z),
    CubeMapNegativeZ(GL_TEXTURE_CUBE_MAP_NEGATIVE_Z),
    ProxyCubeMap(GL_PROXY_TEXTURE_CUBE_MAP)
}

enum class UsagePattern constructor(val value: Int) {
    StreamDraw(GL_STREAM_DRAW),
    StreamRead(GL_STREAM_READ),
    StreamCopy(GL_STREAM_COPY),
    StaticDraw(GL_STATIC_DRAW),
    StaticRead(GL_STATIC_READ),
    StaticCopy(GL_STATIC_COPY),
    DynamicDraw(GL_DYNAMIC_DRAW),
    DynamicRead(GL_DYNAMIC_READ),
    DynamicCopy(GL_DYNAMIC_COPY)
}