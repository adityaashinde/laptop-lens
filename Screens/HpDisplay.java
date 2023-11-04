
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;

public class HpDisplay extends Application {
    Stage pg;

    @Override
    public void start(Stage primaryStage) {
        this.pg = primaryStage;
        // Folder containing the images
        File folder = new File("Screens\\Hp_Images");
        File[] imageFiles = folder.listFiles((dir, name) -> name.endsWith(".jpeg")); // Filter only PNG files

        // Create a GridPane to display the images and their details in rows with
        // spacing
        GridPane gridPane = new GridPane();
        gridPane.setHgap(30); // Set horizontal gap (spacing) between columns
        gridPane.setVgap(30);
        gridPane.setAlignment(Pos.CENTER);

        int row = 0;
        int column = 0;
        for (File imageFile : imageFiles) {
            Image image = new Image(imageFile.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300); // Set the width of each image
            imageView.setFitHeight(250); // Set the height of each image

            // Create a VBox to hold the image, description, and additional details
            VBox imageBox = new VBox();

            // // Create a label for the description
            // String description = "Description for Image " + (row * 3 + column + 1);
            // Text descriptionText = new Text(description);
            // descriptionText.setFont(Font.font("Arial", FontWeight.BOLD, 14));

            // // Create additional details (you can customize these as needed)
            // Text details = new Text("Additional details for the image.");
            // details.setFont(Font.font("Arial", 12));

            Text details;
            String description = null;
            Text descriptionText;
            if ((row * 3 + column + 1) == 1) {
                description = "HP 14s laptop  " + (row * 3 + column + 1);
                descriptionText = new Text(description);
                descriptionText.setFont(Font.font("poppins", FontWeight.BOLD, 25));
                // Add the image and description to the grid pane
                gridPane.add(imageView, column, row);
                gridPane.add(descriptionText, column, row + 1);

                details = new Text(
                        " Ryzen 5-5500U 16GB RAM/512GB SSD 14-inches (35.6 cm) FHD, IPS, Micro-Edge Display/AMD Radeon Graphics/Alexa/Win 11/Backlit KB/Dual Speakers/MSO 2021/1.46 Kg, 14s- fy1003AU, Windows 11");
                details.setX(100);
                details.setWrappingWidth(250);

                details.setFont(Font.font("poppins", 16));

                imageBox.getChildren().addAll(imageView, descriptionText, details);
                imageBox.setAlignment(Pos.CENTER);

                BorderPane borderPane = new BorderPane();
                borderPane.setCenter(imageBox);
                borderPane.setStyle(
                        "-fx-background-color: #F0F0F0; -fx-padding: 10; -fx-border-color: #DDDDDD; -fx-border-width: 1px;");

                // Add the VBox to the grid pane
                gridPane.add(borderPane, column, row);
            } else if ((row * 3 + column + 1) == 2) {
                description = "HP Victus Gaming Laptop " + (row * 3 + column + 1);
                descriptionText = new Text(description);
                descriptionText.setFont(Font.font("poppins", FontWeight.BOLD, 25));
                // Add the image and description to the grid pane
                gridPane.add(imageView, column, row);
                gridPane.add(descriptionText, column, row + 1);
                details = new Text(
                        "12th Gen Intel Core i7-12650H, NVIDIA RTX 3050 GPU, 15.6-inch (39.6 cm), 75W TGP , FHD, IPS, 144Hz, 9 ms Response time, 16GB DDR4, 512GB SSD (MSO, Blue, 2.29 kg), fa0188TX");
                details.setWrappingWidth(250);
                details.setFont(Font.font("poppins", 16));

                imageBox.getChildren().addAll(imageView, descriptionText, details);
                imageBox.setAlignment(Pos.CENTER);

                BorderPane borderPane = new BorderPane();
                borderPane.setCenter(imageBox);
                borderPane.setStyle(
                        "-fx-background-color: #F0F0F0; -fx-padding: 10; -fx-border-color: #DDDDDD; -fx-border-width: 1px;");

                // Add the VBox to the grid pane
                gridPane.add(borderPane, column, row);
            } else {
                description = "HP 247 G8 Laptop " + (row * 3 + column + 1);
                descriptionText = new Text(description);
                descriptionText.setFont(Font.font("poppins", FontWeight.BOLD, 25));
                // Add the image and description to the grid pane
                gridPane.add(imageView, column, row);
                gridPane.add(descriptionText, column, row + 1);

                details = new Text(
                        "(AMD Athlon P-3045B HD/ 14 inches(35.5cm) HD /8GB RAM DDR4 /1TB HDD/Windows 11 Home/ W11 SL) One Year Warranty, Black, 67U77PA");
                details.setWrappingWidth(250);
                details.setFont(Font.font("poppins", 16));
                imageBox.getChildren().addAll(imageView, descriptionText, details);
                imageBox.setAlignment(Pos.CENTER);

                BorderPane borderPane = new BorderPane();
                borderPane.setCenter(imageBox);
                borderPane.setStyle(
                        "-fx-background-color: #F0F0F0; -fx-padding: 10; -fx-border-color: #DDDDDD; -fx-border-width: 1px;");

                // Add the VBox to the grid pane
                gridPane.add(borderPane, column, row);
            }
            // Add the image, description, and details to the VBox
            // imageBox.getChildren().addAll(imageView, descriptionText, details);

            // // Add the VBox to the grid pane
            // gridPane.add(imageBox, column, row);

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

        // Scene scene = new Scene(gridPane);
        primaryStage.setTitle("Images in Rows with Details");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
