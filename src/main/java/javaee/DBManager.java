package javaee;


import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/students",
                    "postgres", "biba0218");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> selectAll() {
        ArrayList<Student> students = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM students order by id")){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("middle_name"),
                        resultSet.getDate("birthdate").toLocalDate(),
                        resultSet.getString("iin"),
                        resultSet.getBoolean("is_grant"),
                        resultSet.getString("specialty")));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }



    public static ArrayList<Student> findAllStudentsFilteredPaged(String name, String surname, String iin,
                                                                  boolean isGrant, int fromIndex, int size) {
        ArrayList<Student> students = new ArrayList<>(size);

        String query = "SELECT * FROM students WHERE "
                + ("".equals(name) ? "" : "name = '" + name + "' and ")
                + ("".equals(surname) ? "" : "surname = '" + surname + "' and ")
                + ("".equals(iin) ? "" : "iin = '" + iin + "' and ")
                + "is_grant = '" + isGrant + "' OFFSET " + fromIndex;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("middle_name"),
                        resultSet.getDate("birthdate").toLocalDate(),
                        resultSet.getString("iin"),
                        resultSet.getBoolean("is_grant"),
                        resultSet.getString("specialty")));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return students;
    }

    public static int countStudentsFiltered(String name, String surname, String iin,
                                            boolean isGrant, int fromIndex) {
        String query = "SELECT COUNT(*) as count FROM students where name = " + name + " or surname = " + surname +
                " or iin = " + iin + " or is_grant = " + isGrant + " OFFSET " + fromIndex;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            return statement.executeQuery().getInt("count");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public static Student getStudent(int id) {
        Student student = new Student();
        String query = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return new Student(
                    id,
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("middle_name"),
                    resultSet.getDate("birthdate").toLocalDate(),
                    resultSet.getString("iin"),
                    resultSet.getBoolean("is_grant"),
                    resultSet.getString("specialty"));

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student;
    }

    public static boolean addStudent(Student student) {
        int row = 0;
        String sql = "insert into students " +
                "(name, surname, middle_name, birthdate, iin, is_grant, specialty)" +
                " values (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getMiddleName());
            statement.setDate(4, Date.valueOf(student.getBirthdate()));
            statement.setString(5, student.getIin());
            statement.setBoolean(6, student.isGrant());
            statement.setString(7, student.getSpeciality());

            row = statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row > 0;
    }

    public static boolean saveStudent(Student student) {
        int row = 0;
        String sql = "UPDATE students set name = ?, surname = ?, middle_name = ?, birthdate = ?," +
                "iin = ?, is_grant = ?, specialty = ? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setString(3, student.getMiddleName());
            statement.setDate(4, Date.valueOf(student.getBirthdate()));
            statement.setString(5, student.getIin());
            statement.setBoolean(6, student.isGrant());
            statement.setString(7, student.getSpeciality());

            statement.setInt(8, (int) student.getId());

            row = statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row > 0;
    }

    public static boolean deleteStudent(int id) {
        int row = 0;
        String sql = "DELETE FROM students where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            row = statement.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return row > 0;
    }
}
