
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

public class DellDisplay extends Application {
    Stage pg;

    @Override
    public void start(Stage primaryStage) {
        this.pg = primaryStage;
        // Folder containing the images
        File folder = new File(
                "Screens\\Dell_Images");
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
                description = "Dell Inspiron 7430 2in1 Laptop" + (row * 3 + column + 1);
                descriptionText = new Text(description);
                descriptionText.setFont(Font.font("poppins", FontWeight.BOLD, 25));
                // Add the image and description to the grid pane
                gridPane.add(imageView, column, row);
                gridPane.add(descriptionText, column, row + 1);

                details = new Text(
                        "Intel Core i3-1315U Processor, 8GB, 256Gb SSD, 14.0\" (35.56cm) FHD+ Touch Display, Active Pen, Win 11 + MSO'21, Backlit KB + FPR, Silver, 1.58kg,");
                details.setX(100);
                details.setWrappingWidth(250);

                details.setFont(Font.font("poppins", 16));

                imageBox.getChildren().addAll(imageView, descriptionText, details);

                // Add the VBox to the grid pane
                gridPane.add(imageBox, column, row);
            } else if ((row * 3 + column + 1) == 2) {
                description = "Dell 15 Laptop " + (row * 3 + column + 1);
                descriptionText = new Text(description);
                descriptionText.setFont(Font.font("poppins", FontWeight.BOLD, 25));
                // Add the image and description to the grid pane
                gridPane.add(imageView, column, row);
                gridPane.add(descriptionText, column, row + 1);
                details = new Text(
                        "Intel Core i3-1115G4 Processor/8GB DDR4/512GB SSD/15.6\" (39.62cm) FHD Anti-Glare 120Hz Refresh Rate 250 nits Narrow Border Display/Win 11+MSO'21/15 Month McAfee/Carbon Black/1.66 kg");
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
                // Add the VBox to the grid pane

            } else {
                description = "Dell Inspiron 5320 Laptop" + (row * 3 + column + 1);
                descriptionText = new Text(description);
                descriptionText.setFont(Font.font("poppins", FontWeight.BOLD, 25));
                // Add the image and description to the grid pane
                gridPane.add(imageView, column, row);
                gridPane.add(descriptionText, column, row + 1);

                details = new Text(
                        "Intel Core i5-1240P Processor, 16GB, 512GB,13.3\" (33.78cm) QHD+,Backlit KB + FPR,Windows 11 + MSO'21, 15 Month McAfee, FHD Camera with Privacy Shutter,Platinum Silver,1.25kg");
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