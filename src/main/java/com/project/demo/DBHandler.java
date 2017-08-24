package com.project.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:tasks.db");
    }

    private static Statement createStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        System.out.println("CREATE TABLE IF NOT EXISTS `tasks` (`id` VARCHAR, `name` VARCHAR, `assignee` VARCHAR, `reporter` VARCHAR)");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `tasks` " +
                "(`id` VARCHAR, `name` VARCHAR, `assignee` VARCHAR, `reporter` VARCHAR, PRIMARY KEY (id))");

        return statement;
    }

    static boolean createTask(TaskObject taskObject){
        Connection connection = null;
        try {
            // create a database connection
            connection = getConnection();
            Statement statement = createStatement(connection);
            System.out.println("INSERT INTO `tasks` VALUES('"+ taskObject.id + "', '" +
                    taskObject.name + "', '" + taskObject.assignee + "', '" + taskObject.reporter + "')");
            statement.executeUpdate("INSERT INTO `tasks` VALUES('"+ taskObject.id + "', '" +
                    taskObject.name + "', '" + taskObject.assignee + "', '" + taskObject.reporter + "')");
        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
            return false;
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return true;
    }

    static boolean updateTask(TaskObject taskObject){
        Connection connection = null;
        try {
            // create a database connection
            connection = getConnection();
            Statement statement = createStatement(connection);
            System.out.println("INSERT INTO `tasks` VALUES('"+ taskObject.id + "', '" +
                    taskObject.name + "', '" + taskObject.assignee + "', '" + taskObject.reporter + "')");
            statement.executeUpdate("UPDATE `tasks` SET (`name`, `assignee`, `reporter`) = ('" +
                    taskObject.name + "', '" + taskObject.assignee + "', '" + taskObject.reporter + "') WHERE `id`='"+ taskObject.id +"'");
        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
            return false;
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return true;
    }

    public static List<TaskObject> getAllTasks(){
        Connection connection = null;
        ArrayList<TaskObject> tasks = new ArrayList<TaskObject>();
        try {
            // create a database connection
            connection = getConnection();
            Statement statement = createStatement(connection);
            System.out.println("select * from tasks");
            ResultSet rs = statement.executeQuery("select * from tasks");
            while(rs.next()) {
                TaskObject taskObject = new TaskObject();
                taskObject.id = rs.getString("id");
                taskObject.name = rs.getString("name");
                taskObject.assignee = rs.getString("assignee");
                taskObject.reporter = rs.getString("reporter");
                tasks.add(taskObject);
            }
        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return tasks;
    }

    public static TaskObject getTask(String taskId){
        Connection connection = null;
        TaskObject taskObject = new TaskObject();
        try {
            // create a database connection
            connection = getConnection();
            Statement statement = createStatement(connection);
            ResultSet rs = statement.executeQuery("select * from `tasks` where `id`='"+taskId+"'");
            if(rs.next()) {
                taskObject.id = rs.getString("id");
                taskObject.name = rs.getString("name");
                taskObject.assignee = rs.getString("assignee");
                taskObject.reporter = rs.getString("reporter");
            } else {
                taskObject = null;
            }
        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return taskObject;
    }

    static boolean deleteTask(String taskId){
        Connection connection = null;
        try {
            // create a database connection
            connection = getConnection();
            Statement statement = createStatement(connection);
            statement.executeUpdate("DELETE FROM `tasks` WHERE `id`='"+taskId+"'");
        } catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
            return false;
        } finally {
            try {
                if(connection != null)
                    connection.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return true;
    }
}
