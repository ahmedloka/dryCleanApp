package my.apps.nada.project.dry.clean.activites.activites.beforeHome;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Objects;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.utilites.Constant;
import my.apps.nada.project.dry.clean.activites.utilites.NetworkChangeReceiver;

public class SplashActivity extends AppCompatActivity {

    public static final String TAG = "SPLASH";
    public static ImageView gifImageView;
    // private static ImageView splashBG;
    private BroadcastReceiver mNetworkReceiver;

    public static void showLoader(boolean value) {

        if (value) {

            Handler handler = new Handler();
            Runnable delayRunnable = () -> gifImageView.setVisibility(View.VISIBLE);
            handler.postDelayed(delayRunnable, 3000);

        } else {
            gifImageView.setVisibility(View.VISIBLE);

            //gifImageView.setImageResource(R.drawable.loadder_giff);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Constant.hideStatusBar(this);

        SharedPreferences mSharedPreferences = getSharedPreferences(Constant.SHARED_PREFERENCE, MODE_PRIVATE);

        Log.d(TAG, "onCreate: " + Objects.requireNonNull(mSharedPreferences.getString(Constant.LANGUAGE, Locale.getDefault().getDisplayLanguage())));
        Constant.changeLang(this, Objects.requireNonNull(mSharedPreferences.getString(Constant.LANGUAGE, Locale.getDefault().getDisplayLanguage())));


        mNetworkReceiver = new NetworkChangeReceiver();
        registerNetworkBroadcast();

        gifImageView = findViewById(R.id.gif_loader);
        //splashBG = findViewById(R.id.spalsh_bg);


        //setGifImages();

    }

//    private void setGifImages() {
//        Glide.with(this).asGif()
//                .apply(new RequestOptions()
//                        .override(200, 600))
//                .listener(new RequestListener<GifDrawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
//
//                        if (resource instanceof GifDrawable) {
//                            resource.setLoopCount(Animation.INFINITE);
//                        }
//                        return false;
//                    }
//                }).load(R.drawable.splash_gif).into(gifImageView);
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterNetworkChanges();

    }

    private void registerNetworkBroadcast() {
        registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }

    private void unregisterNetworkChanges() {
        try {
            unregisterReceiver(mNetworkReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
