package sflin.open.customview01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by a9951 on 2016/6/22.
 */

public class ZombieView extends View {

    private static final int ANIM_NULL = 0;         //动画状态-没有
    private static final int ANIM_CHECK = 1;        //动画状态-开启
    private static final int ANIM_UNCHECK = 2;      //动画状态-结束

    private int mWidth,mHeight;              //宽高
    private Handler mHandler;

    private Bitmap zombie;

    private int index = 0;                 //计算图片位置的下标
    private int animCurrentPage = 0;       // 当前页码
    private int animMaxPage = 22;           // 总页数
    private int animDuration = 5000;         // 动画时长
    private int animState = ANIM_NULL;      // 动画状态

    private boolean isStart = false;        // 是否开始状态

    public ZombieView(Context context) {
        super(context);
    }

    public ZombieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        zombie = BitmapFactory.decodeResource(context.getResources(),R.mipmap.zombie);

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (animCurrentPage < animMaxPage && animCurrentPage >= 0) {
                    invalidate();
                    if (animState == ANIM_NULL)
                        return;
                    if (animState == ANIM_CHECK) {
                        animCurrentPage++;
                    } else if (animState == ANIM_UNCHECK) {
                        animCurrentPage--;
                    }
                    Log.e("AAA", "Count=" + animCurrentPage);
                    Log.e("AAA", "index=" + index);
                    this.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
                } else {
                    animState = ANIM_NULL;
                }
            }
        };
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 移动坐标系到画布中央
        canvas.translate(mWidth / 2, mHeight / 2);

        // 得出图像宽高
        int sideWidth = zombie.getWidth()/11;
        int sideHeight = zombie.getHeight()/2;

        // 得到图像选区
        Rect src = null;
        if (animCurrentPage%2==0 && animCurrentPage<animMaxPage){
            index = animCurrentPage;
            if(animCurrentPage>11){
                index = animCurrentPage/2;
            }
            src = new Rect(sideWidth*index,0,sideWidth*(index+1),sideHeight);
        }else {
            src = new Rect(sideWidth*index,sideHeight,sideWidth*(index+1),sideHeight*2);
        }
        //实际绘制位置
        Rect dst = new Rect(-66, -84, 66, 84);
        canvas.drawBitmap(zombie,src,dst,null);
    }

    /**
     * 开始
     */
    public void start() {
        if (animState != ANIM_NULL || isStart) return;
        animState = ANIM_CHECK;
        animCurrentPage = 0;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isStart = true;
    }

    /**
     * 回退
     */
    public void sendBack() {
        if (animState != ANIM_NULL || (!isStart)) {
            return;
        }
        animState = ANIM_UNCHECK;
        animCurrentPage = animMaxPage - 1;
        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage);
        isStart = false;
    }

    /**
     * 设置动画时长
     * @param animDuration
     */
    public void setAnimDuration(int animDuration) {
        if (animDuration <= 0)
            return;
        this.animDuration = animDuration;
    }
}
