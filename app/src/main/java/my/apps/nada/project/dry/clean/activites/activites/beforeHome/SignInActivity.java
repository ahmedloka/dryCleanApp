package my.apps.nada.project.dry.clean.activites.activites.beforeHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.activites.afterHome.HomeActivity;
import my.apps.nada.project.dry.clean.activites.activites.relatedToSettings.ForgetPasswordActivity;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldButton;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldEditText;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldTextView;

public class SignInActivity extends AppCompatActivity {

    private CairoBoldEditText userName;
    private CairoBoldEditText txtPassword;
    private CairoBoldButton btnSignIn;
    private CairoBoldTextView txtForgotPassword;
    private CairoBoldTextView txtRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        initViews();
    }

    private void initViews() {
        userName = findViewById(R.id.user_name);
        txtPassword = findViewById(R.id.txt_password);
        btnSignIn = findViewById(R.id.btn_sign_in);
        txtForgotPassword = findViewById(R.id.txt_forgot_password);
        txtRegister = findViewById(R.id.txt_register);

        btnSignIn.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, HomeActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            Animatoo.animateSplit(this);
        });

        txtRegister.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
            Animatoo.animateSwipeLeft(this);
        });

        txtForgotPassword.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, ForgetPasswordActivity.class));
            Animatoo.animateSwipeLeft(this);
        });
    }
}
