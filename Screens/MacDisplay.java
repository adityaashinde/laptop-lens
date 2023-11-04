import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;

public class MacDisplay extends Application {
    Stage pg;

    @Override
    public void start(Stage primaryStage) {
        this.pg = primaryStage;
        // Folder containing the images
        // File folder = new File("C:\\Users\\Aditya Shinde\\Desktop\\JAVA
        // FX\\Mac_Images");

        File folder = new File(
                "Screens\\Mac_Images");
        File[] imageFiles = folder.listFiles((dir, name) -> name.endsWith(".jpg")); // Filter only JPG files

        // Create a GridPane to display the images and their details in rows with
        // spacing
        GridPane gridPane = new GridPane();
        gridPane.setHgap(50); // Set horizontal gap (spacing) between columns
        gridPane.setVgap(50);
        gridPane.setAlignment(Pos.CENTER); // Center the GridPane

        int row = 0;
        int column = 0;

        for (File imageFile : imageFiles) {
            Image image = new Image(imageFile.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300); // Set the width of each image
            imageView.setFitHeight(250); // Set the height of each image

            // Create a VBox to hold the image, description, and additional details
            VBox imageBox = new VBox();

            Text details;
            String description = null;
            Text descriptionText;

            if ((row * 3 + column + 1) == 1) {
                description = "MacBook Pro Apple M1 Max Chip";
            } else if ((row * 3 + column + 1) == 2) {
                description = "Apple MacBook Air M1";
            } else {
                description = "MacBook Pro Apple M1 Pro Chip";
            }

            descriptionText = new Text(description);
            descriptionText.setFont(Font.font("poppins", FontWeight.BOLD, 25));

            if ((row * 3 + column + 1) == 1) {
                details = new Text(
                        "Apple 2021 MacBook Pro (16-inch/41.05 cm, M1 Max chip with 10‑core CPU and 32‑core GPU, 32GB RAM, 1TB SSD) - Silver");
            } else if ((row * 3 + column + 1) == 2) {
                details = new Text(
                        "Apple MacBook Air Laptop M1 chip, 13.3-inch/33.74 cm Retina Display, 8GB RAM, 256GB SSD Storage, Backlit Keyboard, FaceTime HD Camera, Touch ID. Works with iPhone/iPad");
            } else {
                details = new Text(
                        "Apple 2021 MacBook Pro (16-inch/41.05 cm, M1 Pro chip with 10‑core CPU and 16‑core GPU, 16GB RAM, 1TB SSD) - Silver");
            }

            details.setWrappingWidth(250);
            details.setFont(Font.font("poppins", 16));

            imageBox.getChildren().addAll(imageView, descriptionText, details);
            imageBox.setAlignment(Pos.CENTER);

            // Create a border around the VBox for a nice background color
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(imageBox);
            borderPane.setStyle(
                    "-fx-background-color: #F0F0F0; -fx-padding: 10; -fx-border-color: #DDDDDD; -fx-border-width: 1px;");

            // Add the VBox to the grid pane
            gridPane.add(borderPane, column, row);

            // Adjust the column and row for the next image
            column++;
            if (column == 3) {
                column = 0;
                row++;
            }
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            Page2 obj = new Page2(pg);
            obj.openInfoPage(); // Close the application when the back button is clicked
        });

        // Create a VBox to hold the grid pane and the back button and center the button
        VBox root = new VBox(gridPane, backButton);
        root.setAlignment(Pos.CENTER); // Center the content both horizontally and vertically

        Scene scene = new Scene(root);

        primaryStage.setTitle("Images in Rows with Details");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
