package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: liubo
 * @version: 2018/10/9 15:54
 * @describe:
 */
public class JDBCUtil {

//    /**
//     *   mysql驱动包名
//     */
//    private static String DRIVER_NAME = null;
//
//    /**
//     * 数据库连接地址 解决6.0+以上版本 会出现以上错误 时区不同步错误
//     */
//    private static  String URL = null;
//    //用户名
//    private static  String USER_NAME = null;
//    //密码
//    private static  String PASSWORD = null;
//
//    static{
//        //创建属性配置对象
//        Properties properties = new Properties();
//        //使用类加载器读取src底下的资源文件
//        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        try {
//            //导入输入流
//            properties.load(is);
//            //读取属性
//            DRIVER_NAME = properties.getProperty("DRIVER_NAME");
//            URL = properties.getProperty("URL");
//            USER_NAME = properties.getProperty("USER_NAME");
//            PASSWORD = properties.getProperty("PASSWORD");
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//    }

//    public static Connection getConnection() {
//
//        Connection connection = null;
//        try {
//            //加载mysql的驱动类
//            Class.forName(DRIVER_NAME);
//            //获取数据库连接
//            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//        return connection;
//    }


    // 获得c3p0连接池对象
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /**
     * 获得数据库连接对象
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 获得c3p0连接池对象
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }


    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
        }
    }

    private static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement = null;
        }
    }


    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }
}
