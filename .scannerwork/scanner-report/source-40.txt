package com.example.buylap.database.dao;

public class DAOssd {
    /*
    public static ModelSsd selectSsd(String name, String keyword) throws SQLException, DAOException {
        ModelSsd modelSsd;
        Connection connection = null;
        Statement statement = null;

        try {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            connection = JdbcConnection.getInstance().getConnection();

            statement = connection.createStatement();
            ResultSet rs = QueryCpu.retrieveCpu(statement, name, keyword);
            if (!rs.first()) {
                throw new DAOException("Table not found with keyword " + keyword);
            }
            String recordName = rs.getString(2);
            String recordSubtitles = rs.getString(3);
            String recordUrl = rs.getString(4);
            modelSsd = new ModelSsd(recordName, recordSubtitles, recordUrl );
            rs.close();


        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return modelSsd;
    }

     */
}
