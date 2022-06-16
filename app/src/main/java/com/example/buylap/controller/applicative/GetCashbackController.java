package com.example.buylap.controller.applicative;

import android.content.Context;
import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanCashback;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.boundary.BoundaryEbay;
import com.example.buylap.boundary.BoundaryPayment;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.database.dao.DAOpoints;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.exceptions.NoCardInsertedException;
import com.example.buylap.model.ModelCashback;
import com.example.buylap.model.ModelCreditCard;
import com.example.buylap.model.users.ModelUser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class GetCashbackController {
    private ModelUser modelUser;

    public GetCashbackController(BeanUser beanUser) throws DAOException {
         this.modelUser = new LoginController().searchUser(beanUser);

    }

    public Boolean createCard(BeanCard beanCard, BeanUser beanUser) throws DAOException, LengthBeanCardException {
        ModelCreditCard modelCreditCard = new ModelCreditCard(beanCard.getCardHolderName(), beanCard.getCardNumber(),
                beanCard.getData());
        ModelUser modelUser = new LoginController().searchUser(beanUser);
        modelUser.setCreditCard(modelCreditCard);

        String username = beanUser.getUsername();
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

    public BeanCard uploadCreditCard(BeanUser beanUser) throws DAOException, ExpiredDateCardException, ParseException {
        ModelCreditCard modelCreditCard;
        BeanCard beanCard = new BeanCard();
        ModelUser modelUser = new LoginController().searchUser(beanUser);
        String username = beanUser.getUsername();
        try {
            modelCreditCard = DAOcard.searchCard(username);

            if(modelCreditCard == null){
                return null;
            }else {


                beanCard.setCardHolderName(modelCreditCard.getName());
                beanCard.setCardNumber(modelCreditCard.getNumber());
                beanCard.setData(modelCreditCard.getData().substring(0, Math.min(modelCreditCard.getData().length(), 7)));
                if (modelUser != null) {
                    modelUser.setCreditCard(modelCreditCard);
                }

                return beanCard;
            }

        }catch (SQLException e){
            throw new DAOException("error upload credit card");
        }

    }

    public void deleteCreditCard(BeanUser beanUser) throws DAOException {
        String username = beanUser.getUsername();

        try {
            DAOcard.deleteCreditCard(username);
        }catch(SQLException | FileNotFoundException e){
            throw new DAOException("error delete credit card");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BeanCashback uploadPoints(BeanUser beanUser) throws SQLException{
        BeanCashback beanCashback = new BeanCashback();
        String username = beanUser.getUsername();
        ModelCashback modelCashback = new ModelCashback();
        modelCashback = DAOpoints.uploadPoints(modelCashback, username);
        if(modelUser != null){
            modelUser.setModelCashback(modelCashback);
        }

        beanCashback.setPoints(modelCashback.getPoints());
        return beanCashback;
    }
    public BeanCashback updatePoints(BeanCashback beanCashback, BeanUser beanUser) throws SQLException {

        String username = beanUser.getUsername();
        ModelCashback modelCashback = new ModelCashback(beanCashback.getPoints());
        if( DAOpoints.updatePoints(modelCashback, username) && modelUser != null)
        {
            modelUser.setModelCashback(modelCashback);
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
    public void purchasedFromEbay(BeanCashback beanCashback, BeanUser beanUser) throws SQLException {
        BoundaryEbay boundaryEbay = new BoundaryEbay();
        String username = beanUser.getUsername();
        BeanCashback beanPoints= boundaryEbay.madePurchase(beanCashback);

        ModelCashback modelCashbackNew = new ModelCashback(beanPoints.getPoints());
        ModelCashback modelCashbackOld = new ModelCashback();

        modelCashbackOld = DAOpoints.uploadPoints(modelCashbackOld, username);

        if( modelCashbackOld.getPoints() != 0) {
            modelCashbackNew.setPoints(modelCashbackNew.getPoints()+ modelCashbackOld.getPoints());

            DAOpoints.updatePoints(modelCashbackNew, username);
        }else{
            try {
                DAOpoints.addPoints(modelCashbackNew, username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(modelUser != null)
            modelUser.setModelCashback(modelCashbackNew);


    }
}
