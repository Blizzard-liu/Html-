package jdbc;

import java.sql.*;

/**
 * @Author: liubo
 * @version: 2018/10/9 14:42
 * @describe:
 */
public class JdbcTest {


    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            if (connection != null) {
                //mysql查询语句
                String sql = "SELECT name FROM test1";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
//
                while (resultSet.next()) {
                    System.out.println("用户名:" + resultSet.getString("name"));
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            JDBCUtil.release(connection,statement,resultSet);
        }
    }

}
