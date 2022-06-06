package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOseller;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RegistrationController {


    public Boolean createUser(BeanUser beanUser) throws DAOException {

            try {
                DAOuser.insertUser(beanUser);
                return true;

            } catch (SQLException e) {
                throw new DAOException("error on signup for user");
            }

    }
    public Boolean createSeller(BeanSeller beanSeller) throws DAOException {

        try {
            DAOseller.insertSeller(beanSeller);
            return true;

        } catch (SQLException | FileNotFoundException e) {
            throw new DAOException("error on signup for seller");
        }

    }


}
