package com.example.buylap;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;
import com.example.buylap.model.ModelCreditCard;

import java.text.ParseException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class InsertCreditCardTest {

    //Test the correct functioning of the credit card addition
    @Test
    public void testInsertCreditCard() {
        boolean checkInfoCard= true;
        boolean checkAdditionToDb;
        BeanCard beanCard = new BeanCard();
        beanCard.setCardNumber("1234 1234 1234 1234");
        try {
            beanCard.setData("23-09");
        } catch (ParseException e) {
            checkInfoCard = false;
        } catch (ExpiredDateCardException e) {
            checkInfoCard = false;
        }
        beanCard.setCardHolderName("Mr. Test");
        BeanSession beanSession = new BeanSession();
        try {
            beanSession.setUsername("test");
        } catch (BeanException e) {
            e.printStackTrace();
        }
        beanSession.setType("guest");
        assertTrue(checkInfoCard);
        GetCashbackController controller = new GetCashbackController();
        try {
            checkAdditionToDb=controller.createCard(beanCard, beanSession);
        } catch (DAOException e) {
           checkAdditionToDb = false;
        }catch (LengthBeanCardException e){
            checkAdditionToDb = false;
        }
        assertTrue(checkAdditionToDb);
    }
}