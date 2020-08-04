package my.apps.nada.project.dry.clean.activites.activites.beforeHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.activites.afterHome.HomeActivity;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldButton;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldEditText;

public class VerficationActivity extends AppCompatActivity {

    private NestedScrollView nested;
    private CairoBoldEditText txtOne;
    private CairoBoldEditText txtTwo;
    private CairoBoldEditText txtThree;
    private CairoBoldEditText txtFour;
    private CairoBoldButton btnContinue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verfication);


        initViews();
    }

    private void initViews() {
        nested = findViewById(R.id.nested);
        txtOne = findViewById(R.id.txt_one);
        txtTwo = findViewById(R.id.txt_two);
        txtThree = findViewById(R.id.txt_three);
        txtFour = findViewById(R.id.txt_four);
        btnContinue = findViewById(R.id.btn_continue);

        btnContinue.setOnClickListener(v -> {
            startActivity(new Intent(VerficationActivity.this, HomeActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            Animatoo.animateSplit(this);
        });
    }
}
