package com.example.buylap.controller.applicative;

import android.content.Context;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.boundary.BoundaryPayment;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.database.dao.DAOpoints;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.exceptions.NoCardInsertedException;
import com.example.buylap.model.ModelCashback;
import com.example.buylap.model.ModelCreditCard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class GetCashbackController {

    public Boolean createCard(BeanCard beanCard, BeanSession beanSession) throws DAOException, LengthBeanCardException {
        ModelCreditCard modelCreditCard = new ModelCreditCard(beanCard.getCardHolderName(), beanCard.getCardNumber(),
                beanCard.getData());
        String username = beanSession.getUsername();
        try {
            DAOcard.insertCard(modelCreditCard, username);
            return true;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new DAOException("error saving credit card");
        } catch (LengthBeanCardException e) {
            throw new LengthBeanCardException("Number card is too long");
        }
    }

    public BeanCard uploadCreditCard(BeanSession beanSession) throws DAOException, ExpiredDateCardException, ParseException {
        ModelCreditCard modelCreditCard;
        BeanCard beanCard = new BeanCard();
        String username = beanSession.getUsername();
        try {
            modelCreditCard = DAOcard.searchCard(username);
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
        String username = beanSession.getUsername();
        try {
            DAOcard.deleteCreditCard(username);
        }catch(SQLException | FileNotFoundException e){
            throw new DAOException("error delete credit card");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BeanCashback uploadPoints(BeanSession beanSession) throws SQLException{
        BeanCashback beanCashback = new BeanCashback();
        String username = beanSession.getUsername();
        ModelCashback modelCashback = new ModelCashback();
        modelCashback = DAOpoints.uploadPoints(modelCashback, username);
        beanCashback.setPoints(modelCashback.getPoints());
        return beanCashback;
    }
    public BeanCashback updatePoints(BeanCashback beanCashback, BeanSession beanSession) throws SQLException {

        String username = beanSession.getUsername();
        ModelCashback modelCashback = new ModelCashback(beanCashback.getPoints());
        if( DAOpoints.updatePoints(modelCashback, username))
        {

            beanCashback.setPoints(modelCashback.getPoints());
        }else {
            beanCashback.setPoints(0);
        }
        return beanCashback;

    }
    public void sendMoneyToCreditCard(BeanCard beanCard, Context context) throws NoCardInsertedException {
        BoundaryPayment boundaryPayment = new BoundaryPayment();
        boundaryPayment.pay(beanCard,context );
    }
    public void sendMoneyToCreditCardCLI(BeanCard beanCard) throws NoCardInsertedException {
        BoundaryPayment boundaryPayment = new BoundaryPayment();
        boundaryPayment.payCLI(beanCard);
    }
}
