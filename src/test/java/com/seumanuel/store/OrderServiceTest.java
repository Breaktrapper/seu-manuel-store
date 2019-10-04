package com.seumanuel.store;


import com.seumanuel.store.model.Order;
import com.seumanuel.store.repository.OrderRepository;
import com.seumanuel.store.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository repository;

    private OrderService service;

    @Rule
    public ExpectedException exceptionExpect = ExpectedException.none();

    @Before
    public void setUp() {

        this.service = new OrderService(repository);
    }

    @Test
    public void testNewProduct(){
        //setup

        //exec

        //assert
    }

    @Test
    public void testComputerDeleteSuccess() {
        //setup
        willDoNothing().given(repository).deleteById("1");

        //exec
        service.deleteOrder("1");

        //assert
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);

        verify(repository, times(1)).deleteById(argument.capture());
        Assert.assertEquals("1", argument.getValue());
    }
}
