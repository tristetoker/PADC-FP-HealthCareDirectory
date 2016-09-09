package com.padc.healthcaredirectory.fragments;

import android.support.v4.app.Fragment;

import com.padc.healthcaredirectory.R;
import com.padc.healthcaredirectory.data.vos.HealthCareVO;
import com.padc.healthcaredirectory.utils.HealthCareDirectoryConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phyoe Khant on 9/9/2016.
 */
public class BaseFragment extends Fragment {

    protected static int gridColumnSpanCount = 1;

    protected List<HealthCareVO> getTempData(int dummy_title, int fragment_id){
        List<HealthCareVO> healthCareList = new ArrayList<>();
        String category = "";
        switch (fragment_id){
            case 1 : category = HealthCareDirectoryConstants.STR_HOSPITAL; break;
            case 2 : category = HealthCareDirectoryConstants.STR_CLINIC; break;
            case 3 : category = HealthCareDirectoryConstants.STR_PHARMACY; break;
        }

        for(int i=0 ; i<10 ; i++){
            HealthCareVO healthcare = new HealthCareVO();
            healthcare.setName(getString(dummy_title) + " " + (i+1));
            healthcare.setTownship(getString(R.string.dummy_township));
            healthcare.setCategory(category);
            healthCareList.add(healthcare);
        }
        return healthCareList;
    }
}
