package com.example.buylap.cli.view;

import static com.example.buylap.cli.view.HomepageUser.BEAN_EXCEPTION;

import com.example.buylap.cli.graphic_controller.AddComponentGraphicController;
import com.example.buylap.exceptions.BeanException;

public class AddComponent {
    private AddComponent(){
        //View AddComponent
    }
    public static void main(String input){
        AddComponentGraphicController addComponentGraphicController = null;
        try {
            addComponentGraphicController = new AddComponentGraphicController();
        } catch (BeanException e) {
            System.out.println(BEAN_EXCEPTION);
        }
        assert addComponentGraphicController != null;
        try {
            addComponentGraphicController.saveComponent(input);
        } catch (BeanException e) {
            System.out.println(BEAN_EXCEPTION);
        }
    }
}
