package kr.co.md00to22.dailys;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ThumbnailImage extends android.support.v7.widget.AppCompatImageView {

    public ThumbnailImage(Context context) {
        super(context);
    }

    public ThumbnailImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThumbnailImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // onDraw는 View의 생성자가 종료된 후 한번만 실행되며, 이 클래스의 화면을 그려낸다. onDraw가 종료되어야 화면에 나타남.
    @Override
    protected void onDraw(Canvas canvas) {
        //파라미터로 전달된 canvas가 그림
    }
}
