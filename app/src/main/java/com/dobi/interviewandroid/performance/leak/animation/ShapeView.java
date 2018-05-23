package com.dobi.interviewandroid.performance.leak.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.dobi.interviewandroid.R;

/**
 * Created by Administrator on 2018/4/23.
 */

public class ShapeView extends View {

    /*
    private Shape mCurrentShape = Shape.Circle;
    Paint mPaint;
    private Path mPath;

    public ShapeView(Context context) {
        this(context,null);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //保证正方形
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        ////同时取最小值
        setMeasuredDimension(Math.min(width,height),Math.min(width,height));

    }

    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        switch (mCurrentShape){
            case Circle:
                //画圆形
                int center = getWidth()/2;
              //  mPaint.setColor(Color.parseColor(R.color.circle));
                mPaint.setColor(ContextCompat.getColor(getContext(),R.color.circle));
                canvas.drawCircle(center,center,center,mPaint);
                break;
            case Shape:
                //画正方形
                mPaint.setColor(Color.BLUE);
                canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
                break;
            case Triangle:
                //画三角形 Path 画路径
                mPaint.setColor(Color.RED);
                if (mPath == null) {
                    // 画路径,等边三角形
                    mPath = new Path();
                    mPath.moveTo(getWidth() / 2, 0);
                    mPath.lineTo(0, (float) ((getWidth()/2)*Math.sqrt(3)));
                    mPath.lineTo(getWidth(), (float) ((getWidth()/2)*Math.sqrt(3)));
                    // path.lineTo(getWidth()/2,0);
                    mPath.close();// 把路径闭合
                }
                canvas.drawPath(mPath, mPaint);
                break;

        }
    }

    public  void exchange(){
        switch (mCurrentShape){
            case Circle:
                mCurrentShape= Shape.Shape;
                break;
            case Shape:
                mCurrentShape = Shape.Triangle;
                break;
            case Triangle:
                mCurrentShape = Shape.Circle;
                break;
        }
        //不断调用onDraw重新绘制
        invalidate();
    }

    public  enum Shape{
        Circle,Shape,Triangle
    }

    public Shape getCurrentShape(){
        return mCurrentShape;
    }
    */

    private Shape mCurrentShape = Shape.Circle;
    Paint mPaint;
    private Path mPath;

    public ShapeView(Context context) {
        this(context, null);
    }

    public ShapeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 只保证是正方形
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(Math.min(width, height), Math.min(width, height));
    }

    @Override
    protected void onDraw(Canvas canvas) {

        switch (mCurrentShape) {
            case Circle:
                // 画圆形
                int center = getWidth() / 2;
                mPaint.setColor(ContextCompat.getColor(getContext(), R.color.circle));
                canvas.drawCircle(center, center, center, mPaint);
                break;
            case Square:
                // 画正方形
                mPaint.setColor(ContextCompat.getColor(getContext(), R.color.rect));
                canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
                break;
            case Triangle:
                // 画三角  Path 画路线
                mPaint.setColor(ContextCompat.getColor(getContext(), R.color.triangle));
                if (mPath == null) {
                    // 画路径
                    mPath = new Path();
                    mPath.moveTo(getWidth() / 2, 0);
                    mPath.lineTo(0, (float) ((getWidth()/2)* Math.sqrt(3)));
                    mPath.lineTo(getWidth(), (float) ((getWidth()/2)* Math.sqrt(3)));
                    // path.lineTo(getWidth()/2,0);
                    mPath.close();// 把路径闭合
                }
                canvas.drawPath(mPath, mPaint);
                break;
        }
    }

    /**
     * 改变形状
     */
    public void exchange() {
        switch (mCurrentShape) {
            case Circle:
                mCurrentShape = Shape.Square;
                break;
            case Square:
                mCurrentShape = Shape.Triangle;
                break;
            case Triangle:
                // 画三角  Path 画路线
                mCurrentShape = Shape.Circle;
                break;
        }
        // 不断重新绘制形状
        invalidate();
    }

    public enum Shape {
        Circle, Square, Triangle
    }

    public Shape getCurrentShape() {
        return mCurrentShape;
    }
}
