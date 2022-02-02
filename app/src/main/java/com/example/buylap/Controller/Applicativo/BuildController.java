package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanBuild;
import com.example.buylap.Bean.BeanCpu;
import com.example.buylap.Bean.BeanMotherboard;
import com.example.buylap.Bean.BeanPower;
import com.example.buylap.Bean.BeanRam;
import com.example.buylap.Bean.BeanSsd;
import com.example.buylap.Bean.BeanVideoCard;
import com.example.buylap.Database.DAO.DAObuild;
import com.example.buylap.Database.DAO.DAOcpu;
import com.example.buylap.Database.DAO.DAOmotherboard;
import com.example.buylap.Database.DAO.DAOpower;
import com.example.buylap.Database.DAO.DAOram;
import com.example.buylap.Database.DAO.DAOssd;
import com.example.buylap.Database.DAO.DAOvideo;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelBuild;
import com.example.buylap.Model.ModelCpu;
import com.example.buylap.Model.ModelMotherBoard;
import com.example.buylap.Model.ModelPower;
import com.example.buylap.Model.ModelRam;
import com.example.buylap.Model.ModelSsd;
import com.example.buylap.Model.ModelVideoCard;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildController {
    //risolvere con le BEAN
    public List<BeanBuild> createBuild(String keyword) throws DAOException {
        String[] table = new String[6];
        table[0] = "motherboard";
        table[1] = "ssd";
        table[2] = "cpu";
        table[3] = "ram";
        table[4] = "videocard";
        table[5] = "powersupply";
        int index;
        List<BeanBuild> beanBuild = new ArrayList<>();
        List<ModelBuild> modelBuild = new ArrayList<ModelBuild>();
        for(index = 0; index < 6; index++){

            try {
                modelBuild.add( DAObuild.selectBuild(table[index], keyword));
                BeanBuild beanBuildinstance = new BeanBuild();
                beanBuildinstance.setName(modelBuild.get(index).getName());
                beanBuildinstance.setSubtitles(modelBuild.get(index).getSubtitles());
                beanBuildinstance.setUrl(modelBuild.get(index).getUrl());
                beanBuild.add(beanBuildinstance);
            } catch (SQLException e) {
                throw new DAOException("error with select"+ table+ " from controller with keyword" + keyword);
            }
        }
        return beanBuild;

    }
    /*
    public BeanMotherboard createBuildMotherBoard( String keyword) throws DAOException {
        BeanMotherboard beanMotherboard = new BeanMotherboard();
        ModelMotherBoard modelMotherBoard;
        try {
            modelMotherBoard = DAOmotherboard.selectMotherboard("motherboard", keyword);
            beanMotherboard.setName(modelMotherBoard.getName());
            beanMotherboard.setSubtitles(modelMotherBoard.getSubtitles());
            beanMotherboard.setUrl(modelMotherBoard.getUrl());
        } catch (SQLException e) {
            throw new DAOException("error with select motherboard from controller with keyword" + keyword);
        }
        return beanMotherboard;
    }
    public BeanRam createBuildRam(String keyword) throws DAOException {
        BeanRam beanRam = new BeanRam();
        ModelRam modelRam;
        try {
            modelRam = DAOram.selectRam("ram", keyword);
            beanRam.setName(modelRam.getName());
            beanRam.setSubtitles(modelRam.getSubtitles());
            beanRam.setUrl(modelRam.getUrl());
        } catch (SQLException e) {
            throw new DAOException("error with select ram from controller with keyword" + keyword);
        }
        return beanRam;
    }
    public BeanPower createBuildPower(String keyword) throws DAOException {
        BeanPower beanPower = new BeanPower();
        ModelPower modelPower;
        try {
            modelPower = DAOpower.selectPower("powersupply", keyword);
            beanPower.setName(modelPower.getName());
            beanPower.setSubtitles(modelPower.getSubtitles());
            beanPower.setUrl(modelPower.getUrl());
        } catch (SQLException e) {
            throw new DAOException("error with select power from controller with keyword" + keyword);
        }
        return beanPower;
    }
    public BeanVideoCard createBuildVideo(String keyword) throws DAOException {
        BeanVideoCard beanVideoCard = new BeanVideoCard();
        ModelVideoCard modelVideoCard;
        try {
            modelVideoCard = DAOvideo.selectVideo("videocard", keyword);
            beanVideoCard.setName(modelVideoCard.getName());
            beanVideoCard.setSubtitles(modelVideoCard.getSubtitles());
            beanVideoCard.setUrl(modelVideoCard.getUrl());
        } catch (SQLException e) {
            throw new DAOException("error with select videocard from controller with keyword" + keyword);
        }
        return beanVideoCard;
    }
    public BeanSsd createBuildSsd(String keyword) throws DAOException {
        BeanSsd beanSsd = new BeanSsd();
        ModelSsd modelSsd;
        try {
            modelSsd = DAOssd.selectSsd("ssd", keyword);
            beanSsd.setName(modelSsd.getName());
            beanSsd.setSubtitles(modelSsd.getSubtitles());
            beanSsd.setUrl(modelSsd.getUrl());
        } catch (SQLException e) {
            throw new DAOException("error with select ssd from controller with keyword" + keyword);
        }
        return beanSsd;
    }

     */

}
