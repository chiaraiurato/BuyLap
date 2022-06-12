package com.example.buylap.cli.graphic_controller;

import com.example.buylap.bean.BeanSeller;
import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.InsertComponentController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;


public class AddComponentGraphicController {
    private InsertComponentController insertComponentController;
    private BeanBuild beanBuild;
    private BeanSession beanSession;

    public AddComponentGraphicController() throws BeanException {
        this.beanSession = SessionManagerCLI.getUserDetails();
        this.insertComponentController = new InsertComponentController();
        this.beanBuild = new BeanBuild();
    }
    public void saveComponent(String input){

        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-c|\\-t|\\-s|\\-p|\\-l");
        beanBuild.setType(token[1]);
        beanBuild.setTitle(token[2].replace("_", " "));
        beanBuild.setSubtitles(token[3].replace("_", ""));
        beanBuild.setPrice(Float.valueOf(token[4]));
        beanBuild.setUrlEbay(token[5]);
        BeanSeller beanSeller = new BeanSeller();
        beanSeller.setUsername(beanSession.getUsername());
        Boolean result= null;
        try {
            result = insertComponentController.saveComponent(beanBuild, beanSeller);
        } catch (DAOException e) {
            System.out.println("Component not saved!");
        }
        if (Boolean.TRUE.equals(result)) {
            System.out.println("Component saved!");
        }


    }
}
