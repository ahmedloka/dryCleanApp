package my.apps.nada.project.dry.clean.activites.activites.afterHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.activites.relatedToSettings.SettingsActivity;
import my.apps.nada.project.dry.clean.activites.fragments.FragmentHome;
import my.apps.nada.project.dry.clean.activites.fragments.FragmentMyOrders;
import my.apps.nada.project.dry.clean.activites.fragments.FragmentProfile;

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


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentHome(), null).commit();

    }

}
