package com.example.buylap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.database.dao.DAOseller;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.EmailVerifyException;
import com.example.buylap.model.users.ModelSeller;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public class SignUpTest {
    //Test registration as seller account and search in database its info
@Test
    public void testSignUpSeller(){

    ModelSeller modelSeller = new ModelSeller("test", "test@gmail.com", "test",
            "12345678910");
    try {
        DAOseller.insertSeller(modelSeller);

    } catch (SQLException | FileNotFoundException | DAOException e) {
        e.printStackTrace();
    }
    try {

        modelSeller = DAOseller.searchSeller(modelSeller);
        assertEquals("test", modelSeller.getUsername());
        assertEquals("test@gmail.com", modelSeller.getEmail());
        assertEquals("test", modelSeller.getPassword());
        assertEquals("12345678910", modelSeller.getIva());

    } catch (SQLException | IOException | DAOException e) {
        e.printStackTrace();
    }



}

}
