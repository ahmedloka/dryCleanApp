package my.apps.nada.project.dry.clean.activites.activites.afterHome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.adapters.rv.NotificationsAdapter;
import my.apps.nada.project.dry.clean.activites.utilites.Constant;

public class NotificationsActivity extends AppCompatActivity implements NotificationsAdapter.OnClickHandler {

    private RecyclerView mRV;
    private List<String> imgUrls;
    private List<String> descList;
    private NotificationsAdapter notificationsAdapter;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        NavUtils.navigateUpFromSameTask(this);
        Animatoo.animateSwipeRight(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        initViews();
    }

    private void initViews() {
        mRV = findViewById(R.id.rv);
        mRV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        loadRecyclerData();
        notificationsAdapter = new NotificationsAdapter(this, imgUrls, descList, this);
        mRV.setAdapter(notificationsAdapter);
        Constant.runLayoutAnimation(mRV);

    }

    private void loadRecyclerData() {
        descList = new ArrayList<>();
        imgUrls = new ArrayList<>();

        descList.add("hello world ! hello world !hello world !hello world !hello world !");
        descList.add("hello world ! hello world !hello world !hello world !hello world !");
        descList.add("hello world ! hello world !hello world !hello world !hello world !");


    }

    @Override
    public void onClick(int position) {

    }
}
