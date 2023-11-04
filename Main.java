
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private Stage primaryStage;
    private Scene loginScene;
    private Scene signupScene;
    private Button signup;
    StackPane layout;
    Pane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // Create the login page
        StackPane loginLayout = createLoginPage();

        // Create the signup page
        StackPane signupLayout = createSignupPage();

        loginScene = new Scene(loginLayout, 1440, 810);
        signupScene = new Scene(signupLayout, 1440, 810);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login page");
        primaryStage.show();

    }

    private StackPane createSignupPage() {
        StackPane layout = new StackPane();

        layout.setStyle("-fx-background-image: url('xyz.jpeg'); -fx-background-size: cover;");

        VBox vbox = new VBox(40);
        vbox.setAlignment(Pos.CENTER);
        Label l1 = new Label("Laptop Lens !!");

        l1.setStyle(
                "-fx-font-style: italic; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 100"
        // "-fx-background-color:transparent;"// Set font color to a custom color (in
        // this case, a shade of red)
        );
        vbox.getChildren().add(l1);
        vbox.setAlignment(Pos.CENTER);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), l1);
        translateTransition.setToX(150); // Move the label 200 pixels to the right
        // translateTransition.setToY(150);

        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Repeats indefinitely

        translateTransition.play();

        // Label for Login account
        Label l2 = new Label("Create Account");

        l2.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 50"

        );

        l2.setLayoutX(520);
        l2.setLayoutY(206);
        vbox.getChildren().add(l2);

        // textfiled of Email
        TextField textField1 = new TextField();
        textField1.setPromptText("Email");
        textField1.setPrefHeight(50);
        textField1.setMaxWidth(300);
        vbox.getChildren().add(textField1);

        // textfiled of username
        TextField textField2 = new TextField();
        textField2.setPromptText("Username");
        textField2.setPrefHeight(50);
        textField2.setMaxWidth(300);
        vbox.getChildren().add(textField2);

        // password field of password
        PasswordField passField = new PasswordField();
        passField.setMinSize(300, 50);
        passField.setPromptText("Password");

        passField.setPrefHeight(50);
        passField.setMaxWidth(100);
        vbox.getChildren().add(passField);

        Button signup = new Button("Sign UP");
        signup.setMinSize(300, 50);
        signup.setFont(new Font(22));
        vbox.getChildren().add(signup);
        signup.setStyle("-fx-background-radius: 10;-fx-opacity: 0.7;-fx-background-color:white;-fx-font-weight: bold;");
        signup.setLayoutX(560);
        signup.setLayoutY(506);
        // database call
        signup.setOnAction(e -> {
            // Add data to the database for sign-up
            addToDatabase(textField1.getText(), textField2.getText(), passField.getText());
            textField1.clear();
            textField2.clear();
            passField.clear();

            // Open a new file (you can specify the file path here)
            // openNewFile();
        });

        // Label for SignUp account
        Label l3 = new Label("Login to Account");

        l3.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 50"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        l3.setLayoutX(520);
        l3.setLayoutY(606);
        vbox.getChildren().add(l3);

        // login button
        Button login = new Button("Login");
        login.setMinSize(300, 50);
        login.setFont(new Font(22));
        vbox.getChildren().add(login);
        login.setStyle("-fx-background-radius: 10;-fx-opacity: 0.7;-fx-background-color:white;-fx-font-weight: bold;");
        login.setLayoutX(560);
        login.setLayoutY(706);

        login.setOnAction(e -> {
            // Switch back to the login scene when the "Back to Login" button is clicked
            primaryStage.setScene(loginScene);
        });

        layout.getChildren().add(vbox);

        return layout;
    }

    private StackPane createLoginPage() {

        layout = new StackPane();

        layout.setStyle("-fx-background-image: url('xyz.jpeg'); -fx-background-size: cover;");

        VBox vbox = new VBox(50);
        vbox.setAlignment(Pos.CENTER);
        Label l1 = new Label("Laptop Lens !!");

        l1.setStyle(
                "-fx-font-style: italic; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 100"
        // "-fx-background-color:transparent;"// Set font color to a custom color (in
        // this case, a shade of red)
        );
        vbox.getChildren().add(l1);
        vbox.setAlignment(Pos.CENTER);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), l1);
        translateTransition.setToX(150); // Move the label 200 pixels to the right
        // translateTransition.setToY(150);

        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Repeats indefinitely

        translateTransition.play();

        // Label for Login account
        Label l2 = new Label("Login to Account");

        l2.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 50"

        );

        l2.setLayoutX(520);
        l2.setLayoutY(206);
        vbox.getChildren().add(l2);

        // textfiled of username
        TextField textField1 = new TextField();
        textField1.setPromptText("Username");
        textField1.setPrefHeight(50);
        textField1.setMaxWidth(300);
        vbox.getChildren().add(textField1);

        // password field of password
        PasswordField passField = new PasswordField();
        passField.setMinSize(300, 50);
        passField.setPromptText("Password");

        passField.setPrefHeight(50);
        passField.setMaxWidth(100);
        vbox.getChildren().add(passField);

        // login button
        Button login = new Button("Login");
        login.setMinSize(300, 50);
        login.setFont(new Font(22));
        vbox.getChildren().add(login);
        login.setStyle("-fx-background-radius: 10;-fx-opacity: 0.7;-fx-background-color:white;-fx-font-weight: bold;");
        login.setLayoutX(560);
        login.setLayoutY(506);
        login.setOnAction(e -> {
            String enteredUsername = textField1.getText();
            String enteredPassword = passField.getText();

            // Check if the username and password are valid
            if (isUserValid(enteredUsername, enteredPassword)) {
                // Display a success message
                displaySuccessMessage("Successfully Logged In");

                // Clear the fields
                textField1.clear();
                passField.clear();

                file2();
            } else {
                // Display an error message if the login is not valid
                displayErrorMessage("Invalid credentials. Please try again.");
            }

        });

        // Label for SignUp account
        Label l3 = new Label("SignUp to Account");

        l3.setStyle(
                "-fx-font-style: bold; " + // Set font style to italic
                        "-fx-font-family: 'poppins'; " + // Set font family to Arial
                        "-fx-text-fill: black ;" +
                        "-fx-font-size : 50"
        // "-fx-background-color:white;"// Set font color to a custom color (in this
        // case, a shade of red)
        );

        l3.setLayoutX(520);
        l3.setLayoutY(606);
        vbox.getChildren().add(l3);

        // login button
        Button signup = new Button("SignUp");
        signup.setMinSize(300, 50);
        signup.setFont(new Font(22));
        vbox.getChildren().add(signup);
        signup.setStyle("-fx-background-radius: 10;-fx-opacity: 0.7;-fx-background-color:white;-fx-font-weight: bold;");
        signup.setLayoutX(560);
        signup.setLayoutY(700);
        signup.setOnAction(e -> {
            // Switch to the signup page when the login button is clicked
            primaryStage.setScene(signupScene);

        });
        layout.getChildren().add(vbox);

        return layout;
    }/*
      * private void openApp() throws Exception {
      * 
      * App obj = new App();
      * 
      * }
      */

    /*
     * private void openPage2() {
     * 
     * App obj = new App();
     * layout.getChildren().setAll(obj.getContent());
     * }
     */

    private void file2() {

        Page2 obj = new Page2(primaryStage);
        // root.getChildren().setAll(obj.quickTips());

    }

    private void displayErrorMessage(String message) {

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void displaySuccessMessage(String message) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void addToDatabase(String email, String username, String password) {
        // Perform database operations here (e.g., insert data into a table)
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccount", "root", "password");
            String sql = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isUserValid(String username, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccount", "root", "password");
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            // If there is at least one row in the result set, the username and password are
            // valid
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
