package ua.antibyte.designviewpagertransitions.transofrmation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class CubeTransformation implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        float deltaY = 0.5f;
        float pivotX = position < 0f ? page.getWidth() : 0f;
        float pivotY = page.getHeight() * deltaY;
        float rotationY = 45f * position;

        page.setPivotX(pivotX);
        page.setPivotY(pivotY);
        page.setRotationY(rotationY);
    }
}
