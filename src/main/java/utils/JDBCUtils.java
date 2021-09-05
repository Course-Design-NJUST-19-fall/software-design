package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtils {
    private static DataSource dts;
    private static Context ctx;
    static{
        try{
            String jndi = "java:comp/env/jdbc/lib";
            ctx = (Context) new InitialContext();
            dts = (DataSource) ctx.lookup(jndi);
            //System.out.println(jndi);
            //System.out.println(dts);
            Connection con = dts.getConnection();
            con.close();
        }catch(SQLException e){
            System.err.println("SQLException:"+e.getMessage());
        }catch(NamingException e){
            System.err.println("ClassNotFoundException:"+e.getMessage());
        }
    }
    public static Connection getConnection() throws SQLException {
        return dts.getConnection();
    }
    //替换sql中的占位符
    private static String getExecSQL(String sql, Object[] bindArgs) {
        StringBuilder sb = new StringBuilder(sql);
        if (bindArgs != null && bindArgs.length > 0) {
            int index = 0;
            for (int i = 0; i < bindArgs.length; i++) {
                index = sb.indexOf("?", index);
                sb.replace(index, index + 1, String.valueOf(bindArgs[i]));
            }
        }
        return sb.toString();
    }
    //增加、删除、修改
    public static int executeUpdate(String sql, Object[] bindArgs) throws Exception {
        /**影响的行数**/
        int affectRowCount = -1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            /**从数据库连接池中获取数据库连接**/
            connection = dts.getConnection();
            /**执行SQL预编译**/
            preparedStatement = connection.prepareStatement(sql.toString());
            /**设置不自动提交，以便于在出现异常的时候数据库回滚**/
            connection.setAutoCommit(false);
            //System.out.println(getExecSQL(sql, bindArgs));
            if (bindArgs != null) {
                /**绑定参数设置sql占位符中的值**/
                for (int i = 0; i < bindArgs.length; i++) {
                    preparedStatement.setObject(i + 1, bindArgs[i]);
                }
            }
            /**执行sql**/
            affectRowCount = preparedStatement.executeUpdate();
            connection.commit();
            String operate;
            if (sql.toUpperCase().indexOf("DELETE FROM") != -1) {
                operate = "删除";
            } else if (sql.toUpperCase().indexOf("INSERT INTO") != -1) {
                operate = "新增";
            } else {
                operate = "修改";
            }
            //System.out.println("成功" + operate + "了" + affectRowCount + "行");
            //System.out.println();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return affectRowCount;
    }
    public static void releases(Connection connection,
                                Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public JDBCUtils() {
        // TODO Auto-generated constructor stub

    }


}
