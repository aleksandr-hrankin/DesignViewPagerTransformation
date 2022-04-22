package ua.antibyte.designviewpagertransitions.transofrmation;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

public class FlipHorizontalPageTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(View page, float pos) {
        final float rotation = 180f * pos;

        page.setAlpha(rotation > 90f || rotation < -90f ? 0 : 1);
        page.setPivotX(page.getWidth() * 0.5f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setRotationY(rotation);
    }
}
