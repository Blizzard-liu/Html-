package jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.*;

/**
 * @Author: liubo
 * @version: 2018/10/11 17:00
 * @describe:
 */

/**
 * // ResultSetHandler<T>,<T>表示封装结果的类型
 *  //MyHandler 是自定义的ResultSetHandler封装结果集策略对象
 *  public class MyHandler implements ResultSetHandler<List<User>>{
 *
 *     @Override
 *     public List<User> handle(ResultSet rs) throws SQLException {
 *        // 封装数据，数据从 Resultset 中获取
 *        List<User> list = new ArrayList<User>();
 *         while(rs.next()){
 *           User u = new User();
 *           u.setId(rs.getInt( "id"));
 *           u.setName(rs.getString( "name"));
 *           u.setPwd(rs.getString( "pwd"));
 *
 *           list.add(u);
 *        }
 *         return list;
 *     }
 *
 *  }
 *
 */


public class CommonCRUDUtils<T> {


    /**
     * 增删改功能
     * @param sql  insert into test1 values(?,?)
     * @param args
     */
    public void update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            ParameterMetaData parameterMetaData = statement.getParameterMetaData();
            //获取问号(占位符)的个数
            int parameterCount = parameterMetaData.getParameterCount();
            for (int i = 0; i < parameterCount; i++) {
                statement.setObject(i + 1, args[i]);
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            JDBCUtil.release(connection,statement);
        }
    }

    /**
     * 查询数据
     * @param sql
     * @param handler
     * @param args
     * @return
     */
    public T query(String sql, ResultSetHandler<T> handler, Object... args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            ParameterMetaData parameterMetaData = statement.getParameterMetaData();
            //获取问号(占位符)的个数
            int parameterCount = parameterMetaData.getParameterCount();
            for (int i = 0; i < parameterCount; i++) {
                statement.setObject(i + 1, args[i]);
            }
            resultSet = statement.executeQuery();
            return handler.handle(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,statement,resultSet);
        }

        return null;
    }
}
