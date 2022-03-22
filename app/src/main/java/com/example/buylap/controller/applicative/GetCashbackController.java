package com.example.buylap.controller.applicative;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class GetCashbackController {

    public Boolean createCard(BeanCard beanCard) throws DAOException {

        try {
            DAOcard.insertCard(beanCard);
            return true;

        } catch (SQLException e) {
            throw new DAOException("error saving credit card");
        }

    }
}
