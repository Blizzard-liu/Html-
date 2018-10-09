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
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            if (connection != null) {
                //mysql查询语句
                String sql = "SELECT * FROM test1 where name = ?";
//                statement = connection.createStatement();
//                resultSet = statement.executeQuery(sql);

                //预先校验sql语句 ? 对应的内容,不管后面传递什么进来,都把它看成字符串 or select
                statement = connection.prepareStatement(sql);
                //?对应的索引从1开始
                statement.setString(1,"11");
                resultSet = statement.executeQuery();
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
