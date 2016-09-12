package com.padc.healthcaredirectory.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.healthcaredirectory.R;
import com.padc.healthcaredirectory.adapters.HealthCareAdapter;
import com.padc.healthcaredirectory.data.models.HealthCareModel;
import com.padc.healthcaredirectory.data.vos.HealthCareVO;
import com.padc.healthcaredirectory.views.holders.HealthCareViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalListFragment extends BaseFragment {

    @BindView(R.id.rv_hospitals)
    RecyclerView rvHospitals;

    private HealthCareAdapter mHealthCareAdapter;
    private HealthCareViewHolder.ControllerHealthCareItem controllerHealthCareItem;

    public static HospitalListFragment newInstance() {
        HospitalListFragment fragment = new HospitalListFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof HealthCareViewHolder.ControllerHealthCareItem){
            controllerHealthCareItem = (HealthCareViewHolder.ControllerHealthCareItem) context;
        } else {
            throw new RuntimeException("Unsupported Type");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //mHealthCareAdapter = new HealthCareAdapter(HealthCareModel.getInstance().getHealthCareList(), controllerHealthCareItem);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_hospital_list, container, false);
        ButterKnife.bind(this, rootView);

        List<HealthCareVO> healthCareList = HealthCareModel.getInstance().getHealthCareList();
        //List<HealthCareVO> healthCareList = super.setTempData(R.string.health_care_hospital, HealthCareDirectoryConstants.FRAGMENT_HOSPITAL);

        mHealthCareAdapter = new HealthCareAdapter(healthCareList, controllerHealthCareItem);
        rvHospitals.setAdapter(mHealthCareAdapter);

        rvHospitals.setLayoutManager(new GridLayoutManager(getContext(), super.gridColumnSpanCount));

        return rootView;
    }
}
