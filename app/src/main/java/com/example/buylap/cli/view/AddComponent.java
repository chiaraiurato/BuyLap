package com.example.buylap.cli.view;

import com.example.buylap.cli.graphic_controller.AddComponentGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

public class AddComponent {
    private AddComponent(){
        //View AddComponent
    }
    public static void main(String input) throws DAOException, BeanException {
        AddComponentGraphicController addComponentGraphicController = new AddComponentGraphicController();
        addComponentGraphicController.saveComponent(input);
    }
}
