package com.blackwabi.barcodelist.ui.createarticle;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.blackwabi.barcodelist.R;
import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.mvp.fragment.BaseFragment;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


/**
 * Created by martinbegleiter on 04/12/16.
 */

public class CreateArticleFragment extends BaseFragment<CreateArticlePresenter> {

    private TextView mArticleName;
    private ZXingScannerView mScannerView;
    private FrameLayout mScannerLayout;
    private TextView mArticleCode;
    private ImageView mScannerIcon;
    private ImageView mAddPhoto;
    private ImageView mArticleImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_article, container, false);
        mArticleName = (TextView) view.findViewById(R.id.articleName);

        mArticleCode = (TextView) view.findViewById(R.id.articleCode);

        mScannerIcon = (ImageView) view.findViewById(R.id.scannerIcon);
        mScannerIcon.setOnClickListener(view1 -> mPresenter.onScannerClicked());

        mAddPhoto = (ImageView) view.findViewById(R.id.addPhoto);
        mAddPhoto.setOnClickListener(view1 -> mPresenter.onAddPhoto());

        mArticleImage = (ImageView) view.findViewById(R.id.articleImage);

        mScannerLayout = (FrameLayout) view.findViewById(R.id.scannerContainer);

        Button saveButton = (Button) view.findViewById(R.id.save);
        saveButton.setOnClickListener(view1 -> mPresenter.onSaveClicked(mArticleName.getText()
                .toString()));
        return view;
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        mPresenter.setFragment(this);
        setTitle(R.string.create_article);
    }

    @Override
    public void onPause() {
        if (mScannerView != null) {
            mScannerView.stopCamera();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mScannerView != null) {
            mScannerView.startCamera();
        }
    }

    public void showScanner(boolean show) {
        if (show) {
            mScannerView = new ZXingScannerView(mActivity);
            mScannerView.setResultHandler(mPresenter);
            mScannerLayout.addView(mScannerView);
            mScannerIcon.setVisibility(View.GONE);
            mAddPhoto.setVisibility(View.GONE);
            mArticleImage.setVisibility(View.GONE);
            mScannerLayout.setVisibility(View.VISIBLE);
            mScannerView.startCamera();
        } else {
            mScannerIcon.setVisibility(View.VISIBLE);
            mAddPhoto.setVisibility(View.VISIBLE);
            mArticleImage.setVisibility(View.VISIBLE);
            mScannerLayout.setVisibility(View.GONE);
            mScannerLayout.removeAllViews();
            mScannerView.stopCamera();
            mScannerView = null;
        }
    }

    public void setScannedCode(String scannedCode) {
        mArticleCode.setText(scannedCode);
    }

    public void setArticleImage(@Nullable Uri photoUri) {
        mArticleImage.setImageURI(photoUri);
    }
}
