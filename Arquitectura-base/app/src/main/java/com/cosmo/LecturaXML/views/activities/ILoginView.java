package com.cosmo.LecturaXML.views.activities;

import com.cosmo.LecturaXML.model.User;
import com.cosmo.LecturaXML.views.IBaseView;

/**
 * Created by leidyzulu on 13/10/17.
 */

public interface ILoginView extends IBaseView {
    void showDashBoard(User userLogin);

    void showDashBoard();
}
