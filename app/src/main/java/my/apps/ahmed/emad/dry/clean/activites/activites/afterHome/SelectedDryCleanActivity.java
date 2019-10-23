package my.apps.ahmed.emad.dry.clean.activites.activites.afterHome;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NavUtils;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import my.apps.ahmed.emad.dry.clean.R;
import my.apps.ahmed.emad.dry.clean.activites.adapters.slider.HomeSliderAdapter;
import my.apps.ahmed.emad.dry.clean.activites.utilites.CairoBoldButton;
import my.apps.ahmed.emad.dry.clean.activites.utilites.ViewPagerCustomDuration;

public class SelectedDryCleanActivity extends AppCompatActivity {

    private ViewPagerCustomDuration viewPager;
    private TabLayout indicator;
    private HomeSliderAdapter sliderAdapter;
    private List<Drawable> imageViewPagerList;

    private AppCompatImageView arrowBackPageTwo;
    private CairoBoldButton mBtnOrder;


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        NavUtils.navigateUpFromSameTask(this);
        Animatoo.animateSlideRight(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected);

        initVeiws();
        initSlider();

    }

    private void initVeiws() {

        mBtnOrder = findViewById(R.id.btn_order);
        mBtnOrder.setOnClickListener(v -> {
            Intent opedOrder = new Intent(SelectedDryCleanActivity.this, FormActivity.class);
            startActivity(opedOrder);
            Animatoo.animateSlideUp(this);
        });

        arrowBackPageTwo = findViewById(R.id.arrow_back_page_two);
        arrowBackPageTwo.setOnClickListener(v -> {
            onBackPressed();
        });
    }

    private void initSlider() {


        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);
        viewPager.setScrollDurationFactor(1.5);

        loadSliderData();

        sliderAdapter = new HomeSliderAdapter(this, imageViewPagerList);
        indicator.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(sliderAdapter);

    }

    private void loadSliderData() {
        imageViewPagerList = new ArrayList<>();
        imageViewPagerList.add(getResources().getDrawable(R.drawable.img_test_two));
        imageViewPagerList.add(getResources().getDrawable(R.drawable.img_test_two));
        imageViewPagerList.add(getResources().getDrawable(R.drawable.img_test_two));

    }

}
