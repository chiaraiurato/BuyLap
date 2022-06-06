package com.example.buylap.controller.applicative;
import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.model.ModelCreditCard;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


public class GetCashbackController {

    public Boolean createCard(BeanCard beanCard, BeanSession beanSession) throws DAOException {

        try {
            DAOcard.insertCard(beanCard, beanSession);
            return true;

        } catch(SQLException | IOException e){
            e.printStackTrace();
            throw new DAOException("error saving credit card");
        }
    }

    public BeanCard uploadCreditCard(BeanSession beanSession) throws DAOException {
        ModelCreditCard modelCreditCard;
        BeanCard beanCard = new BeanCard();
        try {
            modelCreditCard = DAOcard.searchCard(beanSession);
            if(modelCreditCard == null){
                return null;
            }else{
                beanCard.setCardHolderName(modelCreditCard.getName());
                beanCard.setCardNumber(modelCreditCard.getNumber());
                beanCard.setData(modelCreditCard.getData().substring(0, Math.min(modelCreditCard.getData().length(), 7)));

                return beanCard;
            }

        }catch (SQLException e){
            throw new DAOException("error upload credit card");
        }

    }

    public void deleteCreditCard(BeanSession beanSession) throws DAOException {
        try {
            DAOcard.deleteCreditCard(beanSession);
        }catch(SQLException | FileNotFoundException e){
            throw new DAOException("error delete credit card");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int uploadPoints(BeanSession beanSession) throws SQLException, IOException {

        return DAOuser.uploadPoints(beanSession);
    }

    public void deletePoints(BeanSession beanSession) throws SQLException, IOException {
        DAOuser.deletePoints(beanSession);
    }
}
