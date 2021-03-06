package com.iiitb.devopscalc.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {
    @InjectMocks
    CalculatorController underTest;

    @Test
    public void testShowForm() {
        Model model = new ConcurrentModel();
        underTest.showForm(model);
        Assertions.assertNotNull(model.getAttribute("request"));
    }

    @Test
    public void testGetResult_log() {
        Model model = new ConcurrentModel();
        RequestDto request = new RequestDto();
        request.setNumber(8);
        request.setOperation(1);
        underTest.getResult(request, model);

        Assertions.assertNotNull(model.getAttribute("result"));
        Assertions.assertEquals("2.0794415416798357", model.getAttribute("result").toString());
    }

    @Test
    public void testGetResult_sqrt() {
        Model model = new ConcurrentModel();
        RequestDto request = new RequestDto();
        request.setNumber(9);
        request.setOperation(2);
        underTest.getResult(request, model);

        Assertions.assertNotNull(model.getAttribute("result"));
        Assertions.assertEquals("3.0", model.getAttribute("result").toString());
    }

    @Test
    public void testGetResult_factorial() {
        Model model = new ConcurrentModel();
        RequestDto request = new RequestDto();
        request.setNumber(5);
        request.setOperation(3);
        underTest.getResult(request, model);

        Assertions.assertNotNull(model.getAttribute("result"));
        Assertions.assertEquals("120.0", model.getAttribute("result").toString());
    }

    @Test
    public void testGetResult_power() {
        Model model = new ConcurrentModel();
        RequestDto request = new RequestDto();
        request.setNumber(2);
        request.setBase(3);
        request.setOperation(4);
        underTest.getResult(request, model);

        Assertions.assertNotNull(model.getAttribute("result"));
        Assertions.assertEquals("8.0", model.getAttribute("result").toString());
    }

}