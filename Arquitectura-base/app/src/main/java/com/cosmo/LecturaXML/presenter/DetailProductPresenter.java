package com.cosmo.LecturaXML.presenter;

import com.cosmo.LecturaXML.R;
import com.cosmo.LecturaXML.model.DeleteResponse;
import com.cosmo.LecturaXML.repository.IProductRepository;
import com.cosmo.LecturaXML.repository.RepositoryError;
import com.cosmo.LecturaXML.views.activities.IDetailProductView;

/**
 * Created by leidyzulu on 23/09/17.
 */

public class DetailProductPresenter extends BasePresenter<IDetailProductView> {

    private IProductRepository productRepository;

    public DetailProductPresenter(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void deleteProduct(String id) {
        if(getValidateInternet().isConnected()){
            createThreadDeleteProduct(id);
        }else{
            getView().showToast(R.string.validate_internet);
        }
    }

    public void createThreadDeleteProduct(final String id) {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                deleteProductRepository(id);
            }
        });
        thread.start();
    }

    public void deleteProductRepository(String id) {

        try{
            DeleteResponse deleteResponse = productRepository.deleteProduct(id);
            if(deleteResponse.isStatus()){
                getView().showToast(R.string.correct);
            }else{
                getView().showToast(R.string.error_delete_product);
            }

        }catch (RepositoryError repositoryError){
            getView().showToast(repositoryError.getMessage());
        }finally {
            getView().hideProgress();
        }

    }


}
