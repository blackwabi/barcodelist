package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.NewArticlePresenter;


/**
 * Created by martinbegleiter on 04/12/16.
 */

public class NewArticleFragment extends BaseFragment<NewArticlePresenter>{

    private TextView mArticleName;
    private TextView mArticleCode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_article, container, false);
        mArticleName = (TextView) view.findViewById(R.id.articleName);
        mArticleCode = (TextView) view.findViewById(R.id.articleCode);
        Button saveButton = (Button) view.findViewById(R.id.save);
        saveButton.setOnClickListener(view1 -> mPresenter.onSaveClicked(mArticleName.getText()
                .toString(), mArticleCode.getText().toString()));
        return view;
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        getPresenter().setFragment(this);
    }
}
