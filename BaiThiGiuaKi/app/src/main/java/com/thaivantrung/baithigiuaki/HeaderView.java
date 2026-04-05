package com.thaivantrung.baithigiuaki;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class HeaderView extends View {
    private Paint paint;
    private Path path;

    public HeaderView(Context context) {
        super(context);
        init();
    }

    public HeaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.parseColor("#49769F"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int cut = height / 3;

        path.reset();

        path.moveTo(0, height / 2f);
        path.lineTo(cut, 0);
        path.lineTo(width - cut, 0);
        path.lineTo(width, height / 2f);
        path.lineTo(width - cut, height);
        path.lineTo(cut, height);
        path.close();

        canvas.drawPath(path, paint);
    }
}
