 // login authorization
    public boolean isLogin(String user, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT username, password FROM public.users WHERE username = ? AND password = ?;\n";
        try {
            preparedStatement = c.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                return true;
            else
                return false;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
