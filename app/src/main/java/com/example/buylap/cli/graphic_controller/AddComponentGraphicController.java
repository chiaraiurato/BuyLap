package com.example.buylap.cli.graphic_controller;

import com.example.buylap.bean.BeanComponentFromEbay;
import com.example.buylap.bean.BeanSeller;
import com.example.buylap.bean.BeanUser;
import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.controller.applicative.InsertComponentController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;


public class AddComponentGraphicController {
    private InsertComponentController insertComponentController;
    private BeanComponentFromEbay beanComponentFromEbay;
    private BeanUser beanUser;

    public AddComponentGraphicController() throws BeanException {
        this.beanUser = SessionManagerCLI.getUserDetails();
        this.insertComponentController = new InsertComponentController();
        this.beanComponentFromEbay = new BeanComponentFromEbay();
    }
    public void saveComponent(String input) throws BeanException {

        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-c|\\-t|\\-s|\\-p|\\-l");
        beanComponentFromEbay.setType(token[1]);
        beanComponentFromEbay.setTitle(token[2].replace("_", " "));
        beanComponentFromEbay.setSubtitles(token[3].replace("_", ""));
        beanComponentFromEbay.setPrice(Float.valueOf(token[4]));
        beanComponentFromEbay.setUrlEbay(token[5]);
        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(beanUser.getUsername());
        Boolean result= null;
        try {
            result = insertComponentController.saveComponent(beanComponentFromEbay, beanSeller);
        } catch (DAOException e) {
            System.out.println("Component not saved!");
        }
        if (Boolean.TRUE.equals(result)) {
            System.out.println("Component saved!");
        }


    }
}
