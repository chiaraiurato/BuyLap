package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Bean.BeanUser;
import com.example.buylap.Database.DAO.DAObuild;
import com.example.buylap.Database.DAO.DAOuser;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelBuild;
import com.example.buylap.Model.Users.ModelUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    public Boolean createUser(BeanUser beanUser) throws DAOException {

            try {
                DAOuser.insertUser(beanUser);
                return true;

            } catch (SQLException e) {
                throw new DAOException("error on signup");
            }

    }

}
