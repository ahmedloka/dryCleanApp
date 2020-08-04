package my.apps.nada.project.dry.clean.activites.fragments;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.activites.afterHome.SelectedDryCleanActivity;
import my.apps.nada.project.dry.clean.activites.adapters.rv.HomeAdapter;
import my.apps.nada.project.dry.clean.activites.adapters.slider.HomeSliderAdapter;
import my.apps.nada.project.dry.clean.activites.utilites.Constant;
import my.apps.nada.project.dry.clean.activites.utilites.ViewPagerCustomDuration;

public class FragmentHome extends Fragment implements HomeAdapter.OnClickHandler {


    private ViewPagerCustomDuration viewPager;
    private TabLayout indicator;
    private HomeSliderAdapter sliderAdapter;
    private List<Drawable> imageViewPagerList;

    //rv
    private HomeAdapter homeAdapter;
    private RecyclerView mRV;
    private List<String> mListImages;
    private List<String> mListLocation;
    private List<String> mListImagesCover;
    private List<String> mListNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_home, container, false);

        initViews(rootView);
        initSlider(rootView);
        initRV(rootView);

        return rootView;
    }

    private void initSlider(View rootView) {


        viewPager = rootView.findViewById(R.id.viewPager);
        indicator = rootView.findViewById(R.id.indicator);
        viewPager.setScrollDurationFactor(1.5);

        loadSliderData();

        sliderAdapter = new HomeSliderAdapter(getContext(), imageViewPagerList);
        indicator.setupWithViewPager(viewPager, true);
        viewPager.setAdapter(sliderAdapter);

    }

    private void loadSliderData() {
        imageViewPagerList = new ArrayList<>();
        imageViewPagerList.add(getResources().getDrawable(R.drawable.test));
        imageViewPagerList.add(getResources().getDrawable(R.drawable.test));
        imageViewPagerList.add(getResources().getDrawable(R.drawable.test));

    }

    private void initRV(View rootView) {
        mRV = rootView.findViewById(R.id.rv);
        mRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        laodRVData();
        homeAdapter = new HomeAdapter(getContext(), mListNames, mListLocation, mListImages, mListImagesCover, this);
        mRV.setAdapter(homeAdapter);
        Constant.runLayoutAnimation(mRV);
    }

    private void laodRVData() {
        mListImagesCover = new ArrayList<>();
        mListImages = new ArrayList<>();
        mListLocation = new ArrayList<>();
        mListNames = new ArrayList<>();

        mListNames.add("Name Here");
        mListNames.add("Name Here");
        mListNames.add("Name Here");
        mListNames.add("Name Here");


        mListLocation.add("Location Here");
        mListLocation.add("Location Here");
        mListLocation.add("Location Here");
        mListLocation.add("Location Here");
    }

    @Override
    public void onClick(int position) {
        Intent openSelectedDryClean = new Intent(getContext(), SelectedDryCleanActivity.class);
        startActivity(openSelectedDryClean);
        Animatoo.animateSlideLeft(getContext());
    }

    private void initViews(View rootView) {

    }

}
