package com.example.buylap.Controller;

import com.example.buylap.Bean.BEANcpu;
import com.example.buylap.Database.DAO.DAOcpu;
import com.example.buylap.Exceptions.DAOException;

import java.sql.SQLException;

public class BuildController {

    public boolean createBuild() throws DAOException {

        try {
            DAOcpu.selectCpu("gaming");
            return true;
        } catch (SQLException e) {
            throw new DAOException("error with select cpu from controller");
        }

    }
}
