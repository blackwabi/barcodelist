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
    private Uri mPhotoUri;

    @Inject
    BarcodeActivity mActivity;

    @Inject
    public CreateArticlePresenter(Navigator navigator, DataManager dataManager) {
        mNavigator = navigator;
        mDataManager = dataManager;
    }

    public void onSaveClicked(String articleName) {
        if (validArticle(articleName, mScannedCode, mPhotoUri)) {
            mDataManager.addArticle(articleName, mScannedCode, mPhotoUri.toString());
            mNavigator.goToArticles();
        } else {
            mFragment.error("You need to specify name, a scanned code and add a picture");
        }
    }

    private boolean validArticle(String articleName, String scannedCode, Uri photoUri) {
        return articleName != null && scannedCode != null && photoUri != null;
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
            mPhotoUri = generateUri();
            mActivity.takePicture(new BarcodeActivity.PictureListener() {
                @Override
                public void onPictureTaken() {
                    mFragment.setArticleImage(mPhotoUri);
                    mFragment.info("Added image");
                }

                @Override
                public void onError() {
                    mFragment.setArticleImage(null);
                    mFragment.error("Error when trying to add image");
                }
            }, mPhotoUri);
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
