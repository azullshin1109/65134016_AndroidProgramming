package com.thaivantrung.listview_dsvatlieu;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class WavyHeaderView extends View {
    private Paint paint;
    private Path path;

    // Các hàm khởi tạo bắt buộc phải có cho Custom View
    public WavyHeaderView(Context context) {
        super(context);
        init();
    }

    public WavyHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#FFFFFF"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        path.reset();

        path.moveTo(0, 0);
        path.lineTo(width, 0);
        path.lineTo(width, height - 40);


        path.quadTo(3f * width / 4f, height + 15, width / 2f, height - 40);
        //
        path.quadTo(width / 4f, height - 100, 0, height - 40);


        path.lineTo(0, 0);
        path.close();

        canvas.drawPath(path, paint);
    }
}