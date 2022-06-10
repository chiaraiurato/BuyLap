package com.example.buylap;
import static org.junit.Assert.assertTrue;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.RegistrationController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.EmailVerifyException;

import org.junit.Test;



public class SignUpTest {
    //Test registration account
    @Test
    public void testSignUp() {
        boolean checkRegistration;
        boolean checkEmail= true;
        BeanUser beanUser = new BeanUser();
        try {
            beanUser.setUsername("test");
        } catch (BeanException e) {
            e.printStackTrace();
        }
        try {
            beanUser.setEmail("test@gmail.com");
        } catch (EmailVerifyException e) {
            checkEmail = false;
        }
        assertTrue(checkEmail);
        try {
            beanUser.setPassword("test");
        } catch (BeanException e) {
            e.printStackTrace();
        }
        RegistrationController registrationController = new RegistrationController();

        try {
            checkRegistration = registrationController.createUser(beanUser);
        } catch (DAOException e) {
            checkRegistration= false;
        }
        assertTrue("SignUp error", checkRegistration );

    }

}
