package ua.antibyte.designviewpagertransitions

import ua.antibyte.designviewpagertransitions.transofrmation.*

val data = listOf(
    R.drawable.img_1,
    R.drawable.img_2,
    R.drawable.img_3,
    R.drawable.img_4
)

val transformations = listOf(
    AntiClockSpinTransformation(),
    ClockSpinTransformation(),
    CubeInDepthTransformation(),
    CubeInRotationTransformation(),
    CubeInScalingTransformation(),
    CubeOutDepthTransformation(),
    CubeOutRotationTransformation(),
    CubeOutScalingTransformation(),
    CubeInTransformation(),
    CubeTransformation(),
    DepthPageTransformer(),
    DepthTransformation(),
    FadeOutTransformation(),
    FanTransformation(),
    FidgetSpinTransformation(),
    FlipHorizontalPageTransformer(),
    GateTransformation(),
    HorizontalFlipTransformation(),
    PopTransformation(),
    SpinnerTransformation(),
    TossTransformation(),
    VerticalFlipTransformation(),
    VerticalShutTransformation(),
    ZoomInTransformer(),
    ZoomOutPageTransformer()
)