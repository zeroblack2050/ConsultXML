package com.cosmo.LecturaXML.repository;

import com.cosmo.LecturaXML.helper.ServicesFactory;
import com.cosmo.LecturaXML.helper.TypeDecryption;
import com.cosmo.LecturaXML.model.Note;
import com.cosmo.LecturaXML.services.IServices;

/**
 * Created by Superadmin1 on 07/11/2017.
 */

public class NoteRepository implements INoteRepository {

    private IServices services;

    public NoteRepository() {
        ServicesFactory servicesFactory = new ServicesFactory(TypeDecryption.XML);
        services = (IServices) servicesFactory.getInstance(IServices.class);
    }

    @Override
    public Note getNote() {
        Note note = services.getNote();
        return note;
    }
}
