package com.cosmo.LecturaXML.repository;

import com.cosmo.LecturaXML.helper.ServicesFactory;
import com.cosmo.LecturaXML.helper.TypeDecryption;
import com.cosmo.LecturaXML.model.BreakFastMenu;
import com.cosmo.LecturaXML.services.IServices;

/**
 * Created by Superadmin1 on 08/11/2017.
 */

public class SimpleRepository implements ISimpleRepository {

    private IServices services;

    public SimpleRepository() {
        ServicesFactory servicesFactory = new ServicesFactory(TypeDecryption.XML);
        services = (IServices) servicesFactory.getInstance(IServices.class);
    }

    @Override
    public BreakFastMenu getBreakFastMenu() {
        BreakFastMenu breakFastMenu = services.getBreakFastMenu();
        return breakFastMenu;
    }
}
