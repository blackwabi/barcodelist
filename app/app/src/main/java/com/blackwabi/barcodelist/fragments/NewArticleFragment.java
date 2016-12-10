package com.blackwabi.barcodelist.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.NewArticlePresenter;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


/**
 * Created by martinbegleiter on 04/12/16.
 */

public class NewArticleFragment extends BaseFragment<NewArticlePresenter> implements
        ZXingScannerView.ResultHandler {

    private TextView mArticleName;
    private String mScannedCode;
    private ZXingScannerView mScannerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_article, container, false);
        mArticleName = (TextView) view.findViewById(R.id.articleName);

        FrameLayout scannerLayout = (FrameLayout) view.findViewById(R.id.articleCode);
        mScannerView = new ZXingScannerView(mContext);
        mScannerView.setResultHandler(this);
        scannerLayout.addView(mScannerView);

        Button saveButton = (Button) view.findViewById(R.id.save);
        saveButton.setOnClickListener(view1 -> mPresenter.onSaveClicked(mArticleName.getText()
                .toString(), mScannedCode));
        return view;
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        getPresenter().setFragment(this);
    }

    @Override
    public void handleResult(Result result) {
        mScannedCode = result.getText();
    }

    @Override
    public void onPause() {
        mScannerView.stopCamera();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.startCamera();
    }
}
