package com.blackwabi.barcodelist.ui.createarticle;

import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;

import com.blackwabi.barcodelist.BarcodeActivity;
import com.blackwabi.barcodelist.Navigator;
import com.blackwabi.barcodelist.data.DataManager;
import com.blackwabi.barcodelist.mvp.presenter.BasePresenter;
import com.google.zxing.Result;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by martinbegleiter on 04/12/16.
 */
public class CreateArticlePresenter extends BasePresenter<CreateArticleFragment> implements
        ZXingScannerView.ResultHandler {

    private final Navigator mNavigator;
    private final DataManager mDataManager;
    private String mScannedCode;

    @Inject
    BarcodeActivity mActivity;

    @Inject
    public CreateArticlePresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    public void onSaveClicked(String articleName) {
        mDataManager.addArticle(articleName, mScannedCode);
        mNavigator.goToArticles();
    }

    public void onScannerClicked() {
        mFragment.showScanner(true);
    }

    @Override
    public void handleResult(Result result) {
        mScannedCode = result.getText();
        mFragment.setScannedCode(mScannedCode);
        mFragment.showScanner(false);
    }

    public void onAddPhoto() {
        try {
            final Uri photoUri = generateUri();
            mActivity.takePicture(new BarcodeActivity.PictureListener() {
                @Override
                public void onPictureTaken() {
                    // TODO: Show success toast
                    mFragment.setArticleImage(photoUri);
                }

                @Override
                public void onError() {
                    // TODO: Show error message
                    mFragment.setArticleImage(null);
                }
            }, photoUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Uri generateUri() throws IOException {
        File photoFile = createImageFile();
        if (photoFile == null) throw new IOException("Could not create photo file!");
        return FileProvider.getUriForFile(mActivity,
                "com.blackwabi.barcodelist.fileprovider",
                photoFile);
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = mActivity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        return image;
    }
}
