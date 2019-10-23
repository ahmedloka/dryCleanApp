package my.apps.ahmed.emad.dry.clean.activites.activites.afterHome;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import my.apps.ahmed.emad.dry.clean.R;
import my.apps.ahmed.emad.dry.clean.activites.activites.relatedToSettings.SettingsActivity;
import my.apps.ahmed.emad.dry.clean.activites.adapters.rv.HomeAdapter;
import my.apps.ahmed.emad.dry.clean.activites.adapters.slider.HomeSliderAdapter;
import my.apps.ahmed.emad.dry.clean.activites.fragments.FragmentHome;
import my.apps.ahmed.emad.dry.clean.activites.fragments.FragmentMyOrders;
import my.apps.ahmed.emad.dry.clean.activites.fragments.FragmentProfile;
import my.apps.ahmed.emad.dry.clean.activites.utilites.Constant;
import my.apps.ahmed.emad.dry.clean.activites.utilites.ViewPagerCustomDuration;

public class HomeActivity extends AppCompatActivity  {


    private AppCompatImageView notifications;
    private AppCompatImageView settings;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new FragmentHome();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, null).commit();
                return true;
            case R.id.navigation_my_orders:
                fragment = new FragmentMyOrders();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, null).commit();
                return true;
            case R.id.navigation_profile:
                fragment = new FragmentProfile();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, null).commit();
                return true;

        }

        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();



    }

    private void initViews() {
        notifications = findViewById(R.id.notifications);
        settings = findViewById(R.id.settings);

        notifications.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, NotificationsActivity.class));
            Animatoo.animateSlideLeft(this);
        });

        settings.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
            Animatoo.animateSlideLeft(this);
        });


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentHome(), null).commit();

    }

}
