package com.bookstoreapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class JdbcConnectionUtil {
        private static final String url="jdbc:postgresql://localhost:5432/ust_books_db";
        private static final String username="postgres";
        private static final String password="postgres";
        private static Connection connection=null;
        public  static Connection createConnection(){
            try{
                if(connection!=null){
                    return  connection;
                }
                connection= DriverManager.getConnection(url,username,password);
                return  connection;
            }
            catch (SQLException ex){
                throw  new RuntimeException(ex.getMessage());
            }
        }
    }

