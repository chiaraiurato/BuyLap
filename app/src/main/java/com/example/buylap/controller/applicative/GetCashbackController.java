package com.example.buylap.controller.applicative;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelCreditCard;
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

    public BeanCard uploadCreditCard( BeanUser beanUser) throws DAOException {
        ModelCreditCard modelCreditCard;
        BeanCard beanCard = new BeanCard();
        try {
            modelCreditCard = DAOcard.searchCard(beanUser);
            beanCard.setCardHolderName(modelCreditCard.getName());
            beanCard.setCardNumber(modelCreditCard.getNumber());
            beanCard.setData(modelCreditCard.getData().substring(0, Math.min(modelCreditCard.getData().length(), 7)));
            beanCard.setCvv(modelCreditCard.getCvv());
            return beanCard;
        }catch (SQLException | FileNotFoundException e){
            throw new DAOException("error upload credit card");
        }

    }

    public void deleteCreditCard(BeanSession beanSession) throws DAOException {
        try {
            DAOcard.deleteCreditCard(beanSession);
        }catch(SQLException | FileNotFoundException e){
            throw new DAOException("error delete credit card");
        }
    }

    public int uploadPoints(BeanUser beanUser) throws DAOException, SQLException, FileNotFoundException {

        return DAOuser.uploadPoints(beanUser);
    }

    public void deletePoints(BeanSession beanSession) throws DAOException, SQLException, FileNotFoundException{
        DAOuser.deletePoints(beanSession);
    }
}
