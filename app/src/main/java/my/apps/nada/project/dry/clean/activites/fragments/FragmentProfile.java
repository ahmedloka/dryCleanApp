package my.apps.nada.project.dry.clean.activites.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.activites.relatedToSettings.EditProfileActivity;
import my.apps.nada.project.dry.clean.activites.utilites.CairoRegularTextView;

public class FragmentProfile extends Fragment {

    private CairoRegularTextView mEditProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_profile, container, false);

        initViews(rootView);
        return rootView;
    }

    private void initViews(View rootView) {
        mEditProfile = rootView.findViewById(R.id.edit_profile);
        mEditProfile.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), EditProfileActivity.class));
            Animatoo.animateSwipeLeft(getContext());
        });
    }

}
