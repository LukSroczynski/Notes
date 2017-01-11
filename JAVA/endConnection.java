public void endConnection() {
        System.out.println("Database connection closed");
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (c != null && !c.isClosed()) {
                c.close();
            }
        } catch (SQLException ex) {
            setLogger_insertTo_MailEventLog("DBConnector SQLException", ex.toString());
        }
    }
