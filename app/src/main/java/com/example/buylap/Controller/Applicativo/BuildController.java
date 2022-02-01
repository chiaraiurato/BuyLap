package com.example.buylap.Controller.Applicativo;

import com.example.buylap.Bean.BeanCpu;
import com.example.buylap.Bean.BeanMotherboard;
import com.example.buylap.Bean.BeanPower;
import com.example.buylap.Bean.BeanRam;
import com.example.buylap.Bean.BeanSsd;
import com.example.buylap.Bean.BeanVideoCard;
import com.example.buylap.Database.DAO.DAOcpu;
import com.example.buylap.Database.DAO.DAOmotherboard;
import com.example.buylap.Database.DAO.DAOpower;
import com.example.buylap.Database.DAO.DAOram;
import com.example.buylap.Database.DAO.DAOssd;
import com.example.buylap.Database.DAO.DAOvideo;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.ModelCpu;
import com.example.buylap.Model.ModelMotherBoard;
import com.example.buylap.Model.ModelPower;
import com.example.buylap.Model.ModelRam;
import com.example.buylap.Model.ModelSsd;
import com.example.buylap.Model.ModelVideoCard;

import java.sql.SQLException;

public class BuildController {
    //risolvere con le BEAN
    public BeanCpu createBuildCpu( String keyword) throws DAOException {
        BeanCpu beanCpu = new BeanCpu();
        ModelCpu modelCpu;
        try {
            modelCpu = DAOcpu.selectCpu("cpu", keyword);
            beanCpu.setName(modelCpu.getName());
            beanCpu.setSubtitles(modelCpu.getSubtitles());
            beanCpu.setUrl(modelCpu.getUrl());
        } catch (SQLException e) {
            throw new DAOException("error with select cpu from controller with keyword" + keyword);
        }
        return beanCpu;
    }
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

}
