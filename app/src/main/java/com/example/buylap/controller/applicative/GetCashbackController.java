package com.example.buylap.controller.applicative;



import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.exceptions.DAOException;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class GetCashbackController {

    public Boolean createCard(BeanCard beanCard, BeanSession beanSession) throws DAOException {

        try {

                DAOcard.insertCard(beanCard, beanSession);

            return true;

            } catch(SQLException | FileNotFoundException e){
                e.printStackTrace();
                throw new DAOException("error saving credit card");
            }
        }

}
