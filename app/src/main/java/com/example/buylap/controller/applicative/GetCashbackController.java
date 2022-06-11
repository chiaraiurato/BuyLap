package com.example.buylap.controller.applicative;
import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanPoints;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.database.dao.DAOcard;
import com.example.buylap.database.dao.DAOpoints;
import com.example.buylap.database.dao.DAOuser;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.model.ModelCreditCard;
import com.example.buylap.model.ModelPoints;
import com.example.buylap.model.users.ModelSeller;
import com.example.buylap.model.users.ModelUser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.zip.DataFormatException;


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

    public BeanPoints uploadPoints(BeanSession beanSession) throws SQLException{
        BeanPoints beanPoints = new BeanPoints();
        String username = beanSession.getUsername();
        ModelPoints modelPoints = new ModelPoints();
        modelPoints = DAOpoints.uploadPoints(modelPoints, username);
        beanPoints.setPoints(modelPoints.getPoints());
        return beanPoints;
    }
    public BeanPoints updatePoints(BeanPoints beanPoints, BeanSession beanSession) throws SQLException {

        String username = beanSession.getUsername();
        ModelPoints modelPoints = new ModelPoints(beanPoints.getPoints());
        if( DAOpoints.updatePoints(modelPoints, username))
        {

            beanPoints.setPoints(modelPoints.getPoints());
        }else {
            beanPoints.setPoints(0);
        }
        return beanPoints;

    }
    public void deletePoints(BeanSession beanSession) throws SQLException {
        String username = beanSession.getUsername();
        DAOpoints.deletePoints(username);
    }
}
