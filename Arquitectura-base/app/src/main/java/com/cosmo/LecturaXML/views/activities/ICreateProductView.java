package com.cosmo.LecturaXML.views.activities;

import com.cosmo.LecturaXML.views.IBaseView;

/**
 * Created by jersonsuaza on 9/19/17.
 */

public interface ICreateProductView extends IBaseView {

    void showResultCreateNewProduct(boolean isCreated);

    void showAlertInternet(int title, int message);
}
