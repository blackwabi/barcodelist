package com.blackwabi.barcodelist.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.blackwabi.barcodelist.di.FragmentComponent;
import com.blackwabi.barcodelist.presenters.NewListNamePresenter;

/**
 * Created by martinbegleiter on 28/12/16.
 */

public class NewListNameFragment extends BaseDialogFragment<NewListNamePresenter> {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        EditText editText = new EditText(getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        editText.setLayoutParams(lp);
        editText.setGravity(Gravity.CENTER);
        editText.setHint("List name");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Create new article list")
                .setView(editText)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mPresenter.onSaveListNameClick(editText.getText().toString());
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mPresenter.onCancelClick();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    protected void injectIntoComponentAndPresenter(FragmentComponent component) {
        component.inject(this);
        mPresenter.setFragment(this);
    }
}
