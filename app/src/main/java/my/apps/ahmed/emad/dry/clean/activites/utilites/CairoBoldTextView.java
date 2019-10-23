package my.apps.ahmed.emad.dry.clean.activites.utilites;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public final class CairoBoldTextView extends AppCompatTextView {


    public CairoBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public CairoBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CairoBoldTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Cairo-Bold.ttf");
        setTypeface(tf);

    }

}
