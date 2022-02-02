package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Database.DAO.DAObuild;
import com.example.buylap.Database.DAO.DAOuser;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelBuild;
import com.example.buylap.Model.Users.ModelUser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    public List<BeanBuild> createUser(String keyword) throws DAOException {
        List<BeanBuild> beanBuild = new ArrayList<>();
        List<ModelUser> modelUsers = new ArrayList<>();


            try {
                modelUsers.add( DAOuser.insertUser("", keyword));
                BeanBuild beanBuildinstance = new BeanBuild();
                beanBuildinstance.setName(modelUsers.get(index).getName());
                beanBuildinstance.setSubtitles(modelBuild.get(index).getSubtitles());
                beanBuildinstance.setUrl(modelBuild.get(index).getUrl());
                beanBuild.add(beanBuildinstance);
            } catch (SQLException e) {
                throw new DAOException("error with select"+ table+ " from controller with keyword" + keyword);
            }

        return beanBuild;

    }
}
