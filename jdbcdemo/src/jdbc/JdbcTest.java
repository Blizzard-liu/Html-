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
                /**
                 * 事务的特性:ACID
                 * 原子性:事务中包含的逻辑 不可分割
                 * 一致性:事务执行前后,数据完整
                 * 隔离性:事务执行期间不应该受其他事务的影响
                 * 持久性:事务执行成功,数据应该持久保存在磁盘上
                 */
                //关闭自动提交 ,事务默认自动提交
                connection.setAutoCommit(false);
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
                //提交事务
                connection.commit();
            }


        } catch (Exception e) {
            //回滚事务
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();

            }
            e.printStackTrace();
        }finally {

            JDBCUtil.release(connection,statement,resultSet);
        }
    }

}
