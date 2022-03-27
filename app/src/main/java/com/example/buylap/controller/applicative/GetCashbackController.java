package com.example.buylap.controller.applicative;



import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.users.ModelUser;
import com.example.buylap.singleton.UserSingleton;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class GetCashbackController {

    public Boolean createCard(BeanCard beanCard, BeanUser beanUser) throws DAOException {

        try {

           //risolvere con bean unica e non diversa -->modificare DB

                DAOcard.insertCard(beanCard, beanUser);

            return true;
                /*

            }else {
                DAOcard.insertCard(beanCard, beanSeller);
            }

            return true;

                 */

            } catch(SQLException | FileNotFoundException e){
                e.printStackTrace();
                throw new DAOException("error saving credit card");
            }
        }
}
