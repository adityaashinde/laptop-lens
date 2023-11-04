import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tips {
    Stage pg;
    Tips(Stage pg){
        this.pg = pg;
        quickTips();
    }
    public void quickTips() {

        //Stage guide = new Stage();

        Pane root = new Pane();

        root.setStyle("-fx-background-image:url('pqr.jpeg');-fx-background-size:cover");

        Text text = new Text();
        text.setWrappingWidth(900);
        text.setText("Quick tips"); // Enable text wrapping
        text.setX(600);
        text.setY(70);
        text.setStyle("-fx-font-size: 50; -fx-fill: Black; -fx-font-weight: bold;");
        root.getChildren().add(text);

        Text text1 = new Text();
        text1.setWrappingWidth(900);
        text1.setText("1. Pick a platform:\n \ta.Windows 11 \n \tb. macOS \n \tc. Chrome OS");
        text1.setStyle("-fx-font-size: 25; -fx-fill: Black; ");
        text1.setX(30);
        text1.setY(100);
        root.getChildren().add(text1);

        Text text2 = new Text();
        text2.setWrappingWidth(900);
        text2.setText("2. Don’t Skip on Battery Life");
        text2.setStyle("-fx-font-size: 25; -fx-fill: Black; ");
        text2.setX(30);
        text2.setY(240);
        root.getChildren().add(text2);

        Text text3 = new Text();
        text3.setWrappingWidth(900);
        text3.setText("3. Plan Based on Your Budget");
        text3.setStyle("-fx-font-size: 25; -fx-fill: Black; ");
        text3.setX(30);
        text3.setY(290);
        root.getChildren().add(text3);

        Text text4 = new Text();
        text4.setWrappingWidth(900);
        text4.setText(
                "4. Pick your specs\n  a. Processor\n\t -Intel 13th Gen CPUs\n\t -Intel 12th Gen CPUs\n\t -AMD Ryzen 7000:\n\t -AMD Ryzen 5000 and 6000\n b. RAM\n\t -At least 8GB\n\t -16GB\n\t -32GB\n\t -64GB & above is for professional power users or high-end gamers. ");
        text4.setStyle("-fx-font-size: 25; -fx-fill: Black; ");
        text4.setX(30);
        text4.setY(340);
        root.getChildren().add(text4);

        Text text5 = new Text();
        text5.setWrappingWidth(900);
        text5.setText(
                "5.Graphics card\n\t -if you play games or use rendering software, you will need a discrete graphics card.");
        text5.setStyle("-fx-font-size: 25; -fx-fill: Black; ");
        text5.setX(30);
        text5.setY(725);
        root.getChildren().add(text5);

        Hyperlink feedbackLink = new Hyperlink("Feedback");
        feedbackLink.setLayoutX(1200);
        feedbackLink.setLayoutY(50);
        feedbackLink.setStyle("-fx-font-size: 25;-fx-font-weight: bold;");
        root.getChildren().add(feedbackLink);
        feedbackLink.setOnAction(event -> {

            // Create a feedback dialog
            Alert feedbackDialog = new Alert(AlertType.NONE);
            feedbackDialog.setTitle("Feedback");
            feedbackDialog.setHeaderText("Provide Your Feedback");
            feedbackDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

            // Create a TextArea for the feedback text
            TextArea feedbackTextArea = new TextArea();
            feedbackTextArea.setWrapText(true);

            VBox content = new VBox();
            content.getChildren().addAll(new Label("Please enter your feedback:"), feedbackTextArea);
            content.setSpacing(10);
            content.setPadding(new Insets(10));

            feedbackDialog.getDialogPane().setContent(content);

            feedbackDialog.showAndWait();
        });
        Button back =new Button("Back");
        back.setLayoutX(1300);
        back.setLayoutY(750);
        back.setStyle("fx-font-size: 25;-fx-background-radius: 10;-fx-opacity: 0.7;-fx-background-color:white;-fx-font-weight: bold;");
        back.setOnAction(event-> {
            Page2 obj = new Page2(pg);
        });

        root.getChildren().add(back);


        Stage stage = new Stage();
        Scene sc = new Scene(root, 1440, 810);
        stage.setScene(sc);
        stage.setResizable(false);
        pg.setScene(sc);
        pg.setTitle("Login");
        pg.show();

    }

}
