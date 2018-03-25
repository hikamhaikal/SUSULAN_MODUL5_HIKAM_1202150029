package id.simplify.hikam_1202150029_modul5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

/**
 * Created by simplify on 23/03/18.
 */

public class SwipeToDelete extends ItemTouchHelper.SimpleCallback {

    private SwipetoDismissCallBack swipetoDismissCallBack;

    private Context context;
    private Paint paintLeft = new Paint();
    private Paint paintRight = new Paint();
    private Paint paintNoAction = new Paint();
    private final float THRESHOLD = 0.3f;

    private final int SWIPE_LEFT = 8;

    public SwipeToDelete(Context context, int swipeDirs) {
        super(0, swipeDirs);
        this.context = context;
        paintLeft.setColor(Color.BLUE);
        paintRight.setColor(Color.CYAN);
        paintNoAction.setColor(Color.GRAY);

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (swipetoDismissCallBack != null) {
            if (direction == SWIPE_LEFT) {
                swipetoDismissCallBack.onSwipedLeft(viewHolder);
            } else {
                swipetoDismissCallBack.onSwipedRight(viewHolder);
            }
        }
    }

    public void setSwipetoDismissCallBack(SwipetoDismissCallBack swipetoDismissCallBack) {
        this.swipetoDismissCallBack = swipetoDismissCallBack;
    }


    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return THRESHOLD;
    }

    public interface SwipetoDismissCallBack {
        void onSwipedLeft(RecyclerView.ViewHolder viewHolder);
        void onSwipedRight(RecyclerView.ViewHolder viewHolder);
    }
}
