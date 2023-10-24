import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8889/mod4_database";
        String user = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String selectUserQuery = "SELECT id FROM users WHERE login = ?";
            PreparedStatement userStatement = connection.prepareStatement(selectUserQuery);
            userStatement.setString(1, "john");
            ResultSet userResultSet = userStatement.executeQuery();
            int userId = -1;
            if (userResultSet.next()) {
                userId = userResultSet.getInt("id");
            }

            String selectItemsQuery = "SELECT id FROM items WHERE category = ?";
            PreparedStatement itemsStatement = connection.prepareStatement(selectItemsQuery);
            itemsStatement.setString(1, "hats");
            ResultSet itemsResultSet = itemsStatement.executeQuery();

            List<Integer> itemIds = new ArrayList<>();
            while (itemsResultSet.next()) {
                itemIds.add(itemsResultSet.getInt("id"));
            }

            String insertOrderQuery = "INSERT INTO orders (user_id, item_id) VALUES (?, ?)";
            PreparedStatement orderStatement = connection.prepareStatement(insertOrderQuery);

            for (int itemId : itemIds) {
                orderStatement.setInt(1, userId);
                orderStatement.setInt(2, itemId);
                orderStatement.executeUpdate();
            }

            String selectOrdersQuery = "SELECT * FROM orders";
            ResultSet ordersResultSet = connection.createStatement().executeQuery(selectOrdersQuery);
            while (ordersResultSet.next()) {
                int orderId = ordersResultSet.getInt("id");
                int orderItemId = ordersResultSet.getInt("item_id");
                int orderUserId = ordersResultSet.getInt("user_id");
                System.out.println("Order ID: " + orderId + ", User ID: " + orderUserId + ", Item ID: " + orderItemId);
            }

            userStatement.close();
            itemsStatement.close();
            orderStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}