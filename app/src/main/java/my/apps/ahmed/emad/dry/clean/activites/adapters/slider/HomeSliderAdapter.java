package my.apps.ahmed.emad.dry.clean.activites.adapters.slider;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import my.apps.ahmed.emad.dry.clean.R;
import my.apps.ahmed.emad.dry.clean.activites.utilites.CairoBoldTextView;

public class HomeSliderAdapter  extends PagerAdapter {

    private List<Drawable> imageList;
    private Context context;
    private SharedPreferences sharedPreferences;
    private AppCompatImageView img;
    private CairoBoldTextView textTitle;
    private CairoBoldTextView txtDesc;

    public HomeSliderAdapter(Context context, List<Drawable> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider_home, null);

        initViews(view);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        Glide.with(context)
                .load(imageList.get(position))
                .apply(requestOptions)
                .into(img);


        container.addView(view, 0);

        return view;
    }

    private void initViews(View view) {
        img = view.findViewById(R.id.img);

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}


