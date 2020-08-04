package my.apps.nada.project.dry.clean.activites.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.adapters.rv.MyOrdersAdapter;
import my.apps.nada.project.dry.clean.activites.utilites.Constant;

public class FragmentMyOrders extends Fragment implements MyOrdersAdapter.OnClickHandler {


    private RecyclerView mRV;
    private List<String> imgUrls;
    private List<String> listNames;
    private List<String> listNums;
    private List<String> listDates;
    private MyOrdersAdapter myOrdersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_my_orders, container, false);

        initViews(rootView);

        return rootView;
    }

    private void initViews(View rootView) {
        mRV = rootView.findViewById(R.id.rv);
        mRV.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        loadRecyclerData();
        myOrdersAdapter = new MyOrdersAdapter(getContext(), imgUrls, listNames, listDates, listNums, this);
        mRV.setAdapter(myOrdersAdapter);
        Constant.runLayoutAnimation(mRV);

    }

    private void loadRecyclerData() {
        listNames = new ArrayList<>();
        listDates = new ArrayList<>();
        listNums = new ArrayList<>();
        imgUrls = new ArrayList<>();

        listNames.add("Dry Clean");
        listNames.add("Dry Clean");
        listNames.add("Dry Clean");

        listNums.add("43343");
        listNums.add("43343");
        listNums.add("43343");

        listDates.add("14/12/1996");
        listDates.add("14/12/1996");
        listDates.add("14/12/1996");
    }

    @Override
    public void onClick(int position) {

    }

}
