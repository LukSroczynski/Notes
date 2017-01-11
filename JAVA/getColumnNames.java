public List<String> getColumnsNames() {
        List<String> content = new ArrayList<String>();

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT *\n"
                    + "FROM email_mod.\"Mail_Events\"\n"
                    + "WHERE id_queue = (SELECT min(id_queue) FROM email_mod.\"Mail_Events\" );");
            
            ColumnsNames.clear();
            ColumnsNames = getColumnsNames(rs);
            
            for(String x : ColumnsNames) {
                content.add(x);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            setLogger_insertTo_MailEventLog("DBConnector SQLException", ex.toString());
        } finally {
            endConnection();
        }
        return content;
    }
