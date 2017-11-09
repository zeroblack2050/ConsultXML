package com.cosmo.LecturaXML;

import com.cosmo.LecturaXML.helper.IValidateInternet;
import com.cosmo.LecturaXML.model.Product;
import com.cosmo.LecturaXML.presenter.CreateProductPresenter;
import com.cosmo.LecturaXML.repository.IProductRepository;
import com.cosmo.LecturaXML.views.activities.ICreateProductView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by leidyzulu on 29/09/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CreateProductPresenterTest {

    @Mock
    IValidateInternet validateInternet;

    @Mock
    IProductRepository productRepository;

    @Mock
    ICreateProductView createProductView;

    CreateProductPresenter createProductPresenter;

    @InjectMocks
    Product product;


    @Before
    public void setUp() throws Exception{
        createProductPresenter = Mockito.spy(new CreateProductPresenter(productRepository));
        createProductPresenter.inject(createProductView, validateInternet);
    }

    @Test
    public void methodValidateInternetShouldCallMethodCreatThread(){
        product.setName("empanda");
        product.setDescription("empanda");
        product.setQuantity("empanda");
        product.setPrice("empanda");
        when(validateInternet.isConnected()).thenReturn(true);
        createProductPresenter.createNewProduct("empanda", "empanda", "empanda", "empanda");
        verify(createProductPresenter).createThreadCreateProduct(refEq(product));
    }



}
