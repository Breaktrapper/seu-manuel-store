package com.seumanuel.store;


import com.seumanuel.store.model.Product;
import com.seumanuel.store.repository.ProductRepository;
import com.seumanuel.store.service.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    private ProductService service;

    @Rule
    public ExpectedException exceptionExpect = ExpectedException.none();

    @Before
    public void setUp() {
        this.service = new ProductService(repository);
    }


    @Test
    public void testProductFindByIdReturningNull() {
        //setup
        given(repository.findById("123")).willReturn(Optional.empty());

        //exec
        Product ret = service.findById("123");

        //assert
        verify(repository, atLeastOnce()).findById("123");
        Assert.assertNull(ret);
    }

    @Test
    public void testProductFindByIdReturningObject() {
        //setup
        given(repository.findById("124")).willReturn(Optional.of(new Product()));

        //exec
        Product ret = service.findById("124");

        //assert
        verify(repository, atLeastOnce()).findById("124");
        Assert.assertNotNull(ret);
    }
    /*
    @Test
    public void testProductSaveSuccess() {
        //setup
        given(repository.save(any(Product.class))).willAnswer(defaultProductAnswer("1234"));
        Computer computerToSave = newComputer("processor1", 1, 2);

        //exec
        Computer ret = service.save(computerToSave);

        //assert
        ArgumentCaptor<Computer> argument = ArgumentCaptor.forClass(Computer.class);

        verify(repository, atLeastOnce()).save(argument.capture());
        Assert.assertEquals("processor1", argument.getValue().getProcessor());

        Assert.assertEquals("1234", ret.getId());
        Assert.assertEquals("processor1", ret.getProcessor());
        Assert.assertEquals(Integer.valueOf(1), ret.getRam());
        Assert.assertEquals(Integer.valueOf(2), ret.getHd());

    }

    */
    @Test
    public void testProductDeleteSuccess() {
        //setup
        willDoNothing().given(repository).deleteById("123");

        //exec
        service.deleteProductById("123");

        //assert
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        verify(repository, times(1)).deleteById(argument.capture());
        Assert.assertEquals("123", argument.getValue());
    }
    /*
    @Test
    public void testProductFindAllSuccess() {
        //setup
        given(repository.findAll()).willReturn(newComputerList(2, 11));

        //exec
        List<Computer> ret = service.findAll();

        //assert
        Assert.assertEquals(11, ret.size());

        int index = 1;
        for (Computer currentComputer : ret) {
            Assert.assertEquals("processor" + index++, currentComputer.getProcessor());
            Assert.assertTrue(currentComputer.getHd() >= 0);
            Assert.assertTrue(currentComputer.getHd() < 100);
            Assert.assertTrue(currentComputer.getRam() >= 0);
            Assert.assertTrue(currentComputer.getRam() < 100);
        }
    }
    */


}

