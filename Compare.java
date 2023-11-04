
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.beans.binding.When;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Compare {

    TextField t1;
    TextField t2;
    TextField t3;
    TextField t4;
    TextField t5;
    TextField t6;
    TextField t7;
    TextField t8;
    ComboBox<String> leftComboBox1;
    Stage pg = new Stage();

    Compare(Stage pg) {
        this.pg = pg;
        comparison();

    }

    public void comparison() {

        // Stage pg = new Stage();
        pg.setTitle("SplitPane Example");

        HBox hBox = new HBox();

        Pane leftPane = new Pane();

        Image image = new Image("abc.jpeg");
        ImageView imageView = new ImageView(image);

        // Add the ImageView to the Pane
        leftPane.getChildren().add(imageView);// leftPane.setStyle("-fx-background-image: url('WhatsApp Image 2023-10-26
                                              // at 3.55.18 PM.jpeg'); -fx-background-size: cover;");
        leftPane.setPrefWidth(600);
        Line verticalLine = new Line();
        verticalLine.setStartX(600); // X-coordinate of the starting point
        verticalLine.setStartY(0); // Y-coordinate of the starting point
        verticalLine.setEndX(600); // X-coordinate of the ending point
        verticalLine.setEndY(1200); // Y-coordinate of the ending point*/
        verticalLine.setStyle("-fx-stroke: black;"); // Set the line color

        // Add the Line to the Pane
        leftPane.getChildren().add(verticalLine);

        // Create two ComboBoxes for the left and right panes
        ComboBox<String> leftComboBox = new ComboBox<>();
        leftComboBox.setMinSize(300, 50);
        leftComboBox.setPromptText("SELECT BRAND");
        leftComboBox.setLayoutX(150);
        leftComboBox.setLayoutY(50);
        leftComboBox.getItems().addAll("HP", "ACER", "DELL", "MAC");

        leftComboBox1 = new ComboBox<>();
        leftComboBox1.setMinSize(300, 50);
        leftComboBox1.setPromptText("SELECT LAPTOP");
        leftComboBox1.setLayoutX(150);
        leftComboBox1.setLayoutY(150);
        leftComboBox1.getItems().addAll("HP Victus Gaming Laptop", "HP Laptop Office Work", "HP Pavilion 14",
                "Dell Laptop 15, 13th Gen Intel", "Dell Inspiron 5430 Laptop", "Dell Latitude 7390 Notebook-cr",
                "Aspire 5 Gaming", "Acer One 14 Z2-493", "Aspire Lite", "MacBook Air", "MacBook Pro", "MacBook Pro");

        Label l1 = new Label("RAM");
        l1.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        l1.setLayoutX(150);
        l1.setLayoutY(250);

        t1 = new TextField();

        t1.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent;");
        t1.setPrefHeight(30);
        t1.setMaxWidth(300);
        t1.setLayoutX(150);
        t1.setLayoutY(290);

        Label l2 = new Label("PROCESSOR");
        l2.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        l2.setLayoutX(150);
        l2.setLayoutY(360);

        t3 = new TextField();
        t3.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent");
        t3.setPrefHeight(30);
        t3.setMaxWidth(300);
        t3.setLayoutX(150);
        t3.setLayoutY(390);

        Label l3 = new Label("PRICE");
        l3.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        l3.setLayoutX(150);
        l3.setLayoutY(460);

        t5 = new TextField();
        t5.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent");
        t5.setPrefHeight(30);
        t5.setMaxWidth(300);
        t5.setLayoutX(150);
        t5.setLayoutY(490);

        Label l4 = new Label("STORAGE TYPE");
        l4.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        l4.setLayoutX(150);
        l4.setLayoutY(560);

        t7 = new TextField();
        t7.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent");
        t7.setPrefHeight(30);
        t7.setMaxWidth(300);
        t7.setLayoutX(150);
        t7.setLayoutY(590);

        leftComboBox1.setOnAction(event -> {

            String selectedItem = leftComboBox1.getValue();
            if (selectedItem != null) {
                fetchDataFromDatabase(selectedItem, t1, t3, t5, t7);

            }
        });

        // Add the ComboBoxes to the left and right panes
        leftPane.getChildren().addAll(leftComboBox, leftComboBox1, l1, t1, l2, t3, l3, t5, l4, t7);
        // root.getChildren().addAll(leftComboBox,rightComboBox);

        Pane rightPane = new Pane();
        rightPane.setPrefWidth(600);
        // Create two ComboBoxes for the left and right panes
        ComboBox<String> rightComboBox = new ComboBox<>();
        rightComboBox.setMinSize(300, 50);
        rightComboBox.setPromptText("SELECT BRAND");
        rightComboBox.setLayoutX(150);
        rightComboBox.setLayoutY(50);
        rightComboBox.getItems().addAll("HP", "ACER", "DELL", "MAC");

        // Set the initial divider position to divide the pane into equal halves
        ComboBox<String> rightComboBox1 = new ComboBox<>();
        rightComboBox1.setMinSize(300, 50);
        rightComboBox1.setPromptText("SELECT LAPTOPS");
        rightComboBox1.setLayoutX(150);
        rightComboBox1.setLayoutY(150);
        rightComboBox1.getItems().addAll("HP Victus Gaming Laptop", "HP Laptop Office Work", "HP Pavilion 14",
                "Dell Laptop 15, 13th Gen Intel", "Dell Inspiron 5430 Laptop", "Dell Latitude 7390 Notebook-cr",
                "Aspire 5 Gaming", "Acer One 14 Z2-493", "Aspire Lite", "MacBook Air", "MacBook Pro", "MacBook Pro");

        Label r1 = new Label("RAM");
        r1.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        r1.setLayoutX(150);
        r1.setLayoutY(250);

        TextField t2 = new TextField();
        t2.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent");
        t2.setPrefHeight(30);
        t2.setMaxWidth(300);
        t2.setLayoutX(150);
        t2.setLayoutY(290);
        // Add the ComboBoxes to the left and right panes
        Label r2 = new Label("PROCESSOR");
        r2.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        r2.setLayoutX(150);
        r2.setLayoutY(360);

        TextField t4 = new TextField();
        t4.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent");
        t4.setPrefHeight(30);
        t4.setMaxWidth(300);
        t4.setLayoutX(150);
        t4.setLayoutY(390);

        Label r3 = new Label("PRICE");
        r3.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        r3.setLayoutX(150);
        r3.setLayoutY(460);

        TextField t6 = new TextField();
        t6.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent");
        t6.setPrefHeight(30);
        t6.setMaxWidth(300);
        t6.setLayoutX(150);
        t6.setLayoutY(490);

        Label r4 = new Label("STORAGE TYPE");
        r4.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 30"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        r4.setLayoutX(150);
        r4.setLayoutY(560);

        TextField t8 = new TextField();
        t8.setStyle("-fx-font-size : 30;-fx-font-style: bold;-fx-background-color:transparent");
        t8.setPrefHeight(30);
        t8.setMaxWidth(300);
        t8.setLayoutX(150);
        t8.setLayoutY(590);

        rightComboBox1.setOnAction(event -> {
            String selectedItem = rightComboBox1.getValue();
            if (selectedItem != null) {
                fetchRightDataFromDatabase(selectedItem, t2, t4, t6, t8);

            }
        });

        Button back = new Button("Back");
        back.setLayoutX(500);
        back.setLayoutY(680);
        back.setStyle(
                "fx-font-size: 25;-fx-background-radius: 10;-fx-opacity: 0.7;-fx-background-color:white;-fx-font-weight: bold;");
        back.setOnAction(event -> {
            Page2 obj = new Page2(pg);
        });

        rightPane.getChildren().addAll(rightComboBox, rightComboBox1, r1, t2, r2, t4, r3, t6, r4, t8, back);

        // rightPane.setStyle("-fx-background-image: url('abc.jpeg');
        // -fx-background-size: cover;");
        hBox.getChildren().addAll(leftPane, rightPane);

        leftPane.setStyle(
                "-fx-background-image: url('WhatsApp Image 2023-10-26 at 3.55.18 PM.jpeg'); -fx-background-size: cover;");
        Scene scene = new Scene(hBox, 1200, 750); // Set an initial width and height

        // Set the Scene to the Stage
        pg.setScene(scene);

        // Maximize the Stage to make it full-screen
        pg.setMaximized(false);

        pg.show();
    }

    private void fetchRightDataFromDatabase(String selectedItem, TextField t2, TextField t4, TextField t6,
            TextField t8) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccount", "root",
                "password")) {
            String query = "SELECT ram, processor, price, storagetype FROM laptops WHERE information = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, selectedItem);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        t2.setText(String.valueOf(resultSet.getInt("ram")));
                        t4.setText(resultSet.getString("processor"));
                        t6.setText(String.valueOf(resultSet.getDouble("price")));
                        t8.setText(resultSet.getString("storagetype"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void fetchDataFromDatabase(String selectedItem, TextField t1, TextField t3, TextField t5, TextField t7) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccount", "root",
                "password")) {
            String query = "SELECT ram, processor, price, storagetype FROM laptops WHERE information = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, selectedItem);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        t1.setText(String.valueOf(resultSet.getInt("ram")));
                        t3.setText(resultSet.getString("processor"));
                        t5.setText(String.valueOf(resultSet.getDouble("price")));
                        t7.setText(resultSet.getString("storagetype"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
