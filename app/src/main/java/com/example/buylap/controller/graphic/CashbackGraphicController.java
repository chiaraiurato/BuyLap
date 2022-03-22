package com.example.buylap.controller.graphic;

import android.util.Log;

import com.example.buylap.bean.BeanCard;
import com.example.buylap.controller.applicative.GetCashbackController;
import com.example.buylap.exceptions.DAOException;
import com.example.buylap.view.AddCardActivity;
import com.example.buylap.view.CashbackFragment;

public class CashbackGraphicController {
    AddCardActivity addCardActivity;
    GetCashbackController getCashbackController;

    public CashbackGraphicController(AddCardActivity addCardActivity) {
        this.addCardActivity = addCardActivity;
        this.getCashbackController = new GetCashbackController();
    }

    public void saveCreditCard() throws DAOException {
        BeanCard beanCard = new BeanCard();
        beanCard.setCardHolderName(addCardActivity.sendName());
        beanCard.setCardNumber(addCardActivity.sendNumber());
        beanCard.setData(addCardActivity.sendDate());
        beanCard.setCvv(addCardActivity.sendCvv());
        Boolean result = getCashbackController.createCard(beanCard);
        if (Boolean.TRUE.equals(result)) {
            Log.d("DATABASE", "Credit card saved");
        }
    }
}
