package com.padc.healthcaredirectory.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.healthcaredirectory.R;
import com.padc.healthcaredirectory.adapters.ArticleAdapter;
import com.padc.healthcaredirectory.data.models.ArticleModel;
import com.padc.healthcaredirectory.data.vos.ArticleVO;
import com.padc.healthcaredirectory.views.holders.ArticleViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleListFragment extends BaseFragment {

    @BindView(R.id.rv_articles)
    RecyclerView rvArticles;

    private ArticleAdapter mArticleAdapter;
    private ArticleViewHolder.ControllerArticleItem mControllerArticleItem;

    public static ArticleListFragment newInstance(){
        ArticleListFragment fragment = new ArticleListFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ArticleViewHolder.ControllerArticleItem){
            mControllerArticleItem = (ArticleViewHolder.ControllerArticleItem) context;
        } else {
            throw new RuntimeException("Unsupported Type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_article_list, container, false);
        ButterKnife.bind(this, rootView);

        List<ArticleVO> articleList = ArticleModel.getInstance().getArticleList();
        //List<HealthCareVO> healthCareList = super.setTempData(R.string.health_care_hospital, HealthCareDirectoryConstants.FRAGMENT_HOSPITAL);

        mArticleAdapter = new ArticleAdapter(articleList, mControllerArticleItem);
        rvArticles.setAdapter(mArticleAdapter);

        rvArticles.setLayoutManager(new GridLayoutManager(getContext(), super.gridColumnSpanCount));

        return rootView; }

}
