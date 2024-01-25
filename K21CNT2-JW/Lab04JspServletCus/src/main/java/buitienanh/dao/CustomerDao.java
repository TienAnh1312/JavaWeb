package buitienanh.dao;

import buitienanh.beans.Customer;
import buitienanh.conn.ConnectionUtils;

public class CustomerDao {
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO CUSTOMER (CusUser, CusPass, CusName, CusPhone, CusAdd, CusEmail, CusFacebook, CusSkyper, CusStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER_SQL = "UPDATE CUSTOMER SET CusUser=?, CusPass=?, CusName=?, CusPhone=?, CusAdd=?, CusEmail=?, CusFacebook=?, CusSkyper=?, CusStatus=? WHERE CusID=?";
    private static final String DELETE_CUSTOMER_SQL = "DELETE FROM CUSTOMER WHERE CusID=?";
    private static final String SELECT_ALL_CUSTOMERS_SQL = "SELECT * FROM CUSTOMER";
    private static final String SELECT_CUSTOMER_BY_ID_SQL = "SELECT * FROM CUSTOMER WHERE CusID=?";
    private static final String SELECT_CUSTOMER_BY_USER_SQL = "SELECT * FROM CUSTOMER WHERE CusUser=?";

    public static void createCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection conn = ConnectionUtils.getMySQLConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getCusUser());
            preparedStatement.setString(2, customer.getCusPass());
            preparedStatement.setString(3, customer.getCusName());
            preparedStatement.setString(4, customer.getCusPhone());
            preparedStatement.setString(5, customer.getCusAdd());
            preparedStatement.setString(6, customer.getCusEmail());
            preparedStatement.setString(7, customer.getCusFacebook());
            preparedStatement.setString(8, customer.getCusSkyper());
            preparedStatement.setInt(9, customer.getCusStatus());

            preparedStatement.executeUpdate();
        }
    }

    public static void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection conn = ConnectionUtils.getMySQLConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getCusUser());
            preparedStatement.setString(2, customer.getCusPass());
            preparedStatement.setString(3, customer.getCusName());
            preparedStatement.setString(4, customer.getCusPhone());
            preparedStatement.setString(5, customer.getCusAdd());
            preparedStatement.setString(6, customer.getCusEmail());
            preparedStatement.setString(7, customer.getCusFacebook());
            preparedStatement.setString(8, customer.getCusSkyper());
            preparedStatement.setInt(9, customer.getCusStatus());
            preparedStatement.setInt(10, customer.getCusID());

            preparedStatement.executeUpdate();
        }
    }

    public static void deleteCustomer(int cusID) throws SQLException, ClassNotFoundException {
        try (Connection conn = ConnectionUtils.getMySQLConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, cusID);

            preparedStatement.executeUpdate();
        }
    }

    public static List<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = ConnectionUtils.getMySQLConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_CUSTOMERS_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = extractCustomerFromResultSet(resultSet);
                customers.add(customer);
            }
        }
        return customers;
    }

    public static Customer getCustomerByID(int cusID) throws SQLException, ClassNotFoundException {
        try (Connection conn = ConnectionUtils.getMySQLConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_CUSTOMER_BY_ID_SQL)) {
            preparedStatement.setInt(1, cusID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractCustomerFromResultSet(resultSet);
            }
            return null;
        }
    }

    public static Customer getCustomerByUser(String cusUser) throws SQLException, ClassNotFoundException {
        try (Connection conn = ConnectionUtils.getMySQLConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_CUSTOMER_BY_USER_SQL)) {
            preparedStatement.setString(1, cusUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractCustomerFromResultSet(resultSet);
            }
            return null;
        }
    }

    private static Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCusID(resultSet.getInt("CusID"));
        customer.setCusUser(resultSet.getString("CusUser"));
        customer.setCusPass(resultSet.getString("CusPass"));
        customer.setCusName(resultSet.getString("CusName"));
        customer.setCusPhone(resultSet.getString("CusPhone"));
        customer.setCusAdd(resultSet.getString("CusAdd"));
        customer.setCusEmail(resultSet.getString("CusEmail"));
        customer.setCusFacebook(resultSet.getString("CusFacebook"));
        customer.setCusSkyper(resultSet.getString("CusSkyper"));
        customer.setCusStatus(resultSet.getInt("CusStatus"));
        return customer;
    }
}