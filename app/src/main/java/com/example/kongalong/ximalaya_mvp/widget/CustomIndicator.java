package com.example.kongalong.ximalaya_mvp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kongalong on 2016/10/31.
 */

public class CustomIndicator extends View {

    //几个圆圈
    private int count;
    //圆圈半径
    private float radius;


    private int width;
    private int height;

    //圆圈间隔
    private float gap;


    private Paint paint;
    private Paint movePaint;

    //会动的圆圈的x坐标
    private float moveX;


    public CustomIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);


        init();


    }

    private void init() {
        count = 8;
        radius = 10;
        gap = radius*3;
        moveX = radius;


        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#FFD1CCCC"));
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);



        movePaint = new Paint();
        movePaint.setAntiAlias(true);
        movePaint.setColor(Color.parseColor("#f98f3e"));
        movePaint.setStrokeWidth(2);
        movePaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = (int)radius*count*3;
        height = (int)radius*2;

        setMeasuredDimension(width,height);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //不会动的圆
        for (int i = 0; i < count; i++) {
            canvas.drawCircle(radius+gap*i,height/2,radius,paint);
        }
        //会动的圆
        canvas.drawCircle(moveX,height/2,radius,movePaint);

    }


    //move
    public void setMoveX(int position,float positionOffset){
        this.moveX = (position+positionOffset)*gap+radius;
       // Log.d("flag", "setMoveX: " +position);
        invalidate();
    }


    public void setCount(int count){
        this.count = count;
        invalidate();
    }
}
