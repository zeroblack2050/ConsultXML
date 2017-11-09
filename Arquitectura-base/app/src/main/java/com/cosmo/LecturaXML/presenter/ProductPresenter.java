package com.cosmo.LecturaXML.presenter;

import android.util.Log;

import com.cosmo.LecturaXML.R;
import com.cosmo.LecturaXML.model.BreakFastMenu;
import com.cosmo.LecturaXML.model.Food;
import com.cosmo.LecturaXML.model.Note;
import com.cosmo.LecturaXML.model.Product;
import com.cosmo.LecturaXML.repository.MapperError;
import com.cosmo.LecturaXML.repository.NoteRepository;
import com.cosmo.LecturaXML.repository.ProductRepository;
import com.cosmo.LecturaXML.repository.RepositoryError;
import com.cosmo.LecturaXML.repository.SimpleRepository;
import com.cosmo.LecturaXML.views.activities.IProductView;

import java.util.ArrayList;

import retrofit.RetrofitError;

/**
 * Created by leidyzulu on 16/09/17.
 */

public class ProductPresenter extends BasePresenter<IProductView> {

    private ProductRepository productRepository;
    private NoteRepository noteRepository;
    private SimpleRepository simpleRepository;

    public ProductPresenter() {
        productRepository = new ProductRepository();
        noteRepository = new NoteRepository();
        simpleRepository = new SimpleRepository();
    }

    public void getListProduct() {
        if (getValidateInternet().isConnected()) {
            createThreadProduct();
        } else {
            getView().showAlertDialogInternet(R.string.error, R.string.validate_internet);
        }
    }

    private void createThreadProduct() {
        // getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getProductList();
            }
        });
        thread.start();
    }



    private void getProductList() {

        //consultNoteXML();
        consultSimpleXML();
        try {
            ArrayList<Product> productArrayList = productRepository.getProductList();
            getView().showProductList(productArrayList);

        } catch (RetrofitError retrofitError) {

            RepositoryError repositoryError = MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
            getView().showAlertError(R.string.error, repositoryError.getMessage());

        }/*finally {
            getView().hideProgress();
        }*/
    }

    public void consultNoteXML(){

        Note note = noteRepository.getNote();
        Log.e("Note",note.getTo().toString()+"\n"
                +note.getFrom().toString()+"\n"
                +note.getHeading().toString()+"\n"
                +note.getBody().toString()+"\n");


    }

    public void consultSimpleXML(){
        BreakFastMenu breakFastMenu = simpleRepository.getBreakFastMenu();
        Food food = breakFastMenu.getFoodArrayList().get(0);

        Log.e(
                "BreakFastMenu","\n"+
                food.getName()+"\n"+
                food.getPrice()+"\n"+
                food.getDescription()+"\n"+
                food.getCalories()+"\n"
        );
    }

}
