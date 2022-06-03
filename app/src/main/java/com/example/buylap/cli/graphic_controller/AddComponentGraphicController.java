package com.example.buylap.cli.graphic_controller;

import com.example.buylap.cli.utils.SessionManagerCLI;
import com.example.buylap.bean.BeanBuild;
import com.example.buylap.bean.BeanSession;
import com.example.buylap.controller.applicative.InsertComponentController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;


import java.util.Map;

public class AddComponentGraphicController {
    private InsertComponentController insertComponentController;
    private BeanBuild beanBuild = new BeanBuild();
    SessionManagerCLI sessionManagerCLI;
    Map<String, String> user;

    public AddComponentGraphicController(){
        this.insertComponentController = new InsertComponentController();
        this.sessionManagerCLI = new SessionManagerCLI();
    }
    public void saveComponent(String input) throws BeanException, DAOException {
        BeanSession beanSession = new BeanSession();
        user = sessionManagerCLI.getUserDetails();
        if(user.get("user") != null) {
            beanSession.setUsername(user.get("user"));
        }
        String replaceSpace = input.replace(" ", "");
        String[] token = replaceSpace.split("-c|\\-t|\\-s|\\-p|\\-l");
        beanBuild.setType(token[1]);
        beanBuild.setTitle(token[2].replaceAll("_", " "));
        beanBuild.setSubtitles(token[3].replaceAll("_", ""));
        beanBuild.setPrice(Float.valueOf(token[4]));
        beanBuild.setUrlEbay(token[5]);
        Boolean result=  insertComponentController.saveComponent(beanBuild, beanSession);
        if (Boolean.TRUE.equals(result)) {
            System.out.println("Component saved!");
        }

    }
}
