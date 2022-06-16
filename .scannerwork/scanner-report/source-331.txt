package com.example.buylap;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.exceptions.ExpiredDateCardException;
import com.example.buylap.exceptions.LengthBeanCardException;

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
        } catch (ParseException | ExpiredDateCardException e) {
            checkInfoCard = false;
        }
        beanCard.setCardHolderName("Mr. Test");
        BeanUser beanUser = new BeanUser();
        try {
            beanUser.setUsername("test");
        } catch (BeanException e) {
            e.printStackTrace();
        }

        assertTrue(checkInfoCard);
        GetCashbackController controller = null;
        try {
            controller = new GetCashbackController(beanUser);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        try {
            assert controller != null;
            checkAdditionToDb=controller.createCard(beanCard, beanUser);
        } catch (DAOException | LengthBeanCardException e) {
           checkAdditionToDb = false;
        }
        assertTrue(checkAdditionToDb);
    }
}