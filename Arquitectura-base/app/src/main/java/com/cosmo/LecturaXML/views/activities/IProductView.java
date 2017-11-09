package com.cosmo.LecturaXML.views.activities;

import com.cosmo.LecturaXML.model.Product;
import com.cosmo.LecturaXML.views.IBaseView;

import java.util.ArrayList;

/**
 * Created by leidyzulu on 16/09/17.
 */

public interface IProductView extends IBaseView {


    void showProductList(ArrayList<Product> productArrayList);

    void showAlertDialogInternet(int title, int message);

    void showAlertError(int title, String message);
}
