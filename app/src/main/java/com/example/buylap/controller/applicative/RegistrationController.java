package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOseller;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.users.ModelSeller;
import com.example.buylap.model.users.ModelUser;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RegistrationController {


    public Boolean createUser(BeanUser beanUser) throws DAOException {
        ModelUser modelUser = new ModelUser(beanUser.getUsername(), beanUser.getEmail(), beanUser.getPassword());
            try {
                DAOuser.insertUser(modelUser);
                return true;

            } catch (SQLException e) {
                throw new DAOException("error on signup for user");
            }

    }
    public Boolean createSeller(BeanSeller beanSeller) throws DAOException {

        ModelSeller modelSeller = new ModelSeller(beanSeller.getUsername(), beanSeller.getEmail(), beanSeller.getPassword(),
                beanSeller.getIva());
        try {
            DAOseller.insertSeller(modelSeller);
            return true;

        } catch (SQLException | FileNotFoundException e) {
            throw new DAOException("error on signup for seller");
        }

    }


}
