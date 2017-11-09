package com.cosmo.LecturaXML.views;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cosmo.LecturaXML.helper.IValidateInternet;
import com.cosmo.LecturaXML.helper.ShowAlertDialog;
import com.cosmo.LecturaXML.helper.ValidateInternet;
import com.cosmo.LecturaXML.presenter.BasePresenter;

/**
 * Created by leidyzulu on 16/09/17.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseView {


    private IValidateInternet validateInternet;
    private ProgressDialog progressDialog;
    private T presenter;
    private ShowAlertDialog showAlertDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validateInternet = new ValidateInternet(BaseActivity.this);
        this.showAlertDialog = new ShowAlertDialog(this);

    }

    public ShowAlertDialog getShowAlertDialog() {
        return showAlertDialog;
    }

    @Override
    public void showProgress(int message) {
        progressDialog.setMessage(getResources().getString(message));
        progressDialog.show();
    }

    public void createProgressDialog(){
        this.progressDialog = new ProgressDialog(this);
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }


    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

}
