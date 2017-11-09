package com.cosmo.LecturaXML.presenter;

import com.cosmo.LecturaXML.R;
import com.cosmo.LecturaXML.model.User;
import com.cosmo.LecturaXML.repository.INoteRepository;
import com.cosmo.LecturaXML.repository.IProductRepository;
import com.cosmo.LecturaXML.repository.RepositoryError;
import com.cosmo.LecturaXML.views.activities.ILoginView;

/**
 * Created by leidyzulu on 13/10/17.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    private IProductRepository iProductRepository;
    private INoteRepository iNoteRepository;


    public LoginPresenter(IProductRepository productRepository) {
     this.iProductRepository = productRepository;
    }

    public void login(String user, String password) {
        if(getValidateInternet().isConnected()){
            createThreadLogin(user, password);

        }else{
            //TODO

        }
    }



    private void createThreadLogin(final String user, final String password) {
        getView().showProgress(R.string.loading_message);
        Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                loginInRepository(user, password);
            }
        });
        thread.start();
    }

    private void loginInRepository(String user, String password) {

        try {
            User userLogin = iProductRepository.login(user, password);
            getView().showDashBoard(userLogin);


        }catch (RepositoryError repositoryError){
            //TODO
        }finally {
            getView().hideProgress();
        }



    }

    public void autoLogin(String token) {
        if(getValidateInternet().isConnected()){
            createThreadautoLogin(token);
        }else{
            //TODO
        }

    }

    private void createThreadautoLogin(final String token) {
        getView().showProgress(R.string.loading_message);
        Thread thread =  new Thread(new Runnable() {
            @Override
            public void run() {
                autoLoginInRepository(token);
            }
        });
        thread.start();
    }

    private void autoLoginInRepository(String token) {

        try {
            iProductRepository.autologin(token);
            getView().showDashBoard();

        }catch (RepositoryError repositoryError){
            //TODO
        }finally {
            getView().hideProgress();
        }

    }
}
