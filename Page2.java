
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Page2 {

    Button backButton;
    Button back;
    Stage pg = new Stage();

    Page2(Stage pg) {
        this.pg = pg;
        page2();

    }

    public void page2() {

        // Stage pg = new Stage();

        Pane root = new Pane();
        root.setStyle("-fx-background-image:url('Background2.jpg');-fx-background-size:cover");

        Text text = new Text();
        text.setWrappingWidth(500);
        text.setText("Laptop Lens");
        text.setX(280);
        text.setY(100);
        Glow glow = new Glow();
        glow.setLevel(0.9);
        text.setEffect(glow);
        text.setStyle("-fx-font-size: 60; -fx-fill: White; -fx-font-weight: bold;-fx-font-style: italic;");

        Button button1 = new Button("Model Information");
        Button button2 = new Button("   Comparison    ");
        Button button3 = new Button("     Guide     ");
        Button button4 = new Button("About us");

        button1.setLayoutX(100);
        button1.setLayoutY(200);
        button1.setStyle("-fx-font-size: 37; -fx-fill: Black; -fx-font-weight: Lighter;-fx-font-style: italic;");
        button1.setOnAction(event -> openInfoPage());

        button2.setLayoutX(250);
        button2.setLayoutY(320);
        button2.setStyle("-fx-font-size: 37; -fx-fill: Black; -fx-font-weight: Lighter;-fx-font-style: italic;");
        button2.setOnAction(e -> {
            // Switch comparison button2 is clicked
            openComparison();
        });

        button3.setLayoutX(420);
        button3.setLayoutY(440);
        button3.setStyle("-fx-font-size: 37; -fx-fill: Black; -fx-font-weight: Lighter;-fx-font-style: italic;");
        button3.setOnAction(e -> {
            // Switch comparison button2 is clicked
            Tips obj2 = new Tips(pg);

        });

        button4.setLayoutX(780);
        button4.setLayoutY(550);
        button4.setFont(new Font(18));
        button4.setStyle(
                "-fx-font-size: 22;-fx-background-color: dark grey; -fx-text-fill: white;-fx-font-style: italic;");
        button4.setOnAction(event -> openSecondPage());

        backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 15;");
        backButton.setLayoutX(420);
        backButton.setLayoutY(550);
        backButton.setOnAction(event -> {
            Page2 sc = new Page2(pg);
        });

        back = new Button("Back");
        back.setStyle("-fx-font-size: 15;");
        back.setLayoutX(280);
        back.setLayoutY(550);
        back.setOnAction(event -> {
            Page2 sc = new Page2(pg);
        });
        // Add the buttons to the Pane
        root.getChildren().addAll(text, button1, button2, button3, button4);
        Stage stage = new Stage();
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        pg.setScene(scene);
        pg.setTitle("Laptop Lens");
        pg.show();

    }

    private void openComparison() {

        Compare obj2 = new Compare(pg);

    }

    // ********************************************
    public void openInfoPage() {
        // Stage secondStage = new Stage();
        pg.setTitle("Model Information");
        Pane root = new Pane();
        root.setStyle("-fx-background-image:url('imgg.jpg');-fx-background-size:cover");

        Image image1 = new Image("Hp.jpg");
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(300);
        imageView1.setFitHeight(200);

        Button imageButton = new Button(null, imageView1);
        imageButton.setStyle("-fx-background-color: transparent;");
        imageButton.setLayoutX(80);
        imageButton.setLayoutY(40);

        imageButton.setOnAction(event -> {
            // Define what happens when the button is clicked
            HpDisplay obj = new HpDisplay();
            obj.start(pg);
        });

        /*
         * Action event to next brand page write here...
         * imageButton.setOnAction(event -> {
         * // Define what happens when the button is clicked
         * System.out.println("Button clicked!");
         * });
         */

        Image image2 = new Image("Acer.jpg");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(290);
        imageView2.setFitHeight(200);

        Button imageButton2 = new Button(null, imageView2);
        imageButton2.setStyle("-fx-background-color: transparent;");
        imageButton2.setLayoutX(510);
        imageButton2.setLayoutY(40);

        imageButton2.setOnAction(event -> {
            // Define what happens when the button is clicked
            AcerDisplay obj = new AcerDisplay();
            obj.start(pg);
        });

        Image image3 = new Image("dell-icon-1.png");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(300); // Width
        imageView3.setFitHeight(220); // Height

        Button imageButton3 = new Button(null, imageView3);
        imageButton3.setStyle("-fx-background-color: transparent;");
        imageButton3.setLayoutX(80);
        imageButton3.setLayoutY(330);

        imageButton3.setOnAction(event -> {
            // Define what happens when the button is clicked
            DellDisplay obj = new DellDisplay();
            obj.start(pg);
        });
        /*
         * Action event to next brand page write here...
         * imageButton.setOnAction(event -> {
         * // Define what happens when the button is clicked
         * System.out.println("Button clicked!");
         * });
         */

        Image image4 = new Image("mac.jpg");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitWidth(290); // Width
        imageView4.setFitHeight(220); // Height

        Button imageButton4 = new Button(null, imageView4);
        imageButton4.setStyle("-fx-background-color: transparent;");
        imageButton4.setLayoutX(510);
        imageButton4.setLayoutY(330);
        imageButton4.setOnAction(event -> {
            // Define what happens when the button is clicked
            MacDisplay obj = new MacDisplay();
            obj.start(pg);
        });

        /*
         * Action event to next brand page write here...
         * imageButton.setOnAction(event -> {
         * // Define what happens when the button is clicked
         * System.out.println("Button clicked!");
         * });
         */

        Scene scene = new Scene(root, 900, 600);
        

        root.getChildren().addAll(imageView1, imageView2, imageView3, imageView4, imageButton, imageButton2,
                imageButton3, imageButton4, backButton);
        pg.setScene(scene);
        pg.show();

    }

    // ********************************************

    /*
     * private void openMac() {
     * 
     * MacDisplay obj =new MacDisplay();
     * obj.start(pg);
     * }
     * private void openAcer() {
     * 
     * AcerDisplay obj = new AcerDisplay();
     * obj.start(pg);
     * 
     * }
     */
    public void openSecondPage() {
        // Create a new stage for the second page
        // Stage secondStage = new Stage();
        pg.setTitle("About Us");

        HBox hbox = new HBox();
        // Create the left half
        Pane leftHalf = new Pane();

        leftHalf.setStyle("-fx-background-color: lightyellow;");
        leftHalf.setPrefWidth(550);
        // Set the width as needed
        Text text = new Text();
        text.setText("Welcome to Laptop Lens"); // Enable text wrapping
        text.setX(80);
        text.setY(50);
        text.setStyle("-fx-font-size: 35; -fx-fill: Black; -fx-font-weight: bold;-fx-font-style: italic;");

        Text text2 = new Text();
        text2.setWrappingWidth(500);
        text2.setText(
                "Our mission is to provide users with comprehensive information and unbiased comparisons of various laptop models to help you make informed decisions when choosing your next laptop. Whether you're a student, professional, or tech enthusiast, we're here to assist you in finding the perfect laptop that suits your needs."); // Enable
                                                                                                                                                                                                                                                                                                                                                   // text
                                                                                                                                                                                                                                                                                                                                                   // wrapping
        text2.setX(30);
        text2.setY(100);
        text2.setStyle("-fx-font-size: 20; -fx-fill: Black; -fx-font-weight: Lighter;-fx-font-style:italic;");

        Text text4 = new Text();
        text4.setText("Group Members"); // Enable text wrapping
        text4.setX(190);
        text4.setY(430);
        text4.setStyle("-fx-font-size: 27; -fx-fill: Black; -fx-font-weight: bold;-fx-font-style: italic;");

        Text text3 = new Text();
        text3.setText("Super-X Team"); // Enable text wrapping
        text3.setX(190);
        text3.setY(290);
        text3.setStyle("-fx-font-size: 27; -fx-fill: Black; -fx-font-weight: bold;-fx-font-style: italic;");

        Text text5 = new Text();
        text5.setWrappingWidth(450);
        text5.setText(
                "Prachi Dawkhar                Sampada Bhosale    Sahil Gade                        Shivam Chincholkar      Aditya Shinde");
        text5.setX(70);
        text5.setY(465);
        text5.setStyle("-fx-font-size:21; -fx-fill: Black; -fx-font-weight: Lighter;");

        Text text8 = new Text();
        text8.setWrappingWidth(450);
        text8.setText(
                "Govind Dindewad                Shivkumar Tengse     Vishal Lohbande                  Prajwal Kadam     Subodh Yelgandharwar");
        text8.setX(70);
        text8.setY(320);
        text8.setStyle("-fx-font-size:21; -fx-fill: Black; -fx-font-weight: Lighter;");

        leftHalf.getChildren().addAll(text, text2, text4, text5, text3, text8);

        // Create the right half
        Pane rightHalf = new Pane();
        rightHalf.setStyle("-fx-background-color: ;");
        rightHalf.setPrefWidth(350);
        Image image = new Image("file:///C:/Users/Sampada/Desktop/JavaFx project/sirrrr11.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(350);
        imageView.setFitHeight(280);

        // Image image2 = new Image("core2web"); // Replace with your image file path
        // ImageView imageView2 = new ImageView(image2);
        // imageView2.setFitWidth(90);
        // imageView2.setFitHeight(70);
        // imageView2.setLayoutX(20);
        // imageView2.setLayoutY(520);

        Text text6 = new Text();
        text6.setText(" Know the code\r\n" + //
                "                till the core"); // Enable text wrapping
        text6.setX(20);
        text6.setY(310);
        text6.setStyle("-fx-font-size:26; -fx-font-weight: Bold;-fx-font-style: italic;");
        // Create a Glow effect
        Glow glow = new Glow();
        glow.setLevel(0.9);
        text6.setEffect(glow);

        Text text7 = new Text();
        text7.setWrappingWidth(340);
        text7.setText("Thankyou Sir,\r\n" + //
                "We want to express our heartfelt gratitude for your guidance.Your mentorship made a significant difference in the success, and thankful for your commitment to our growth.");
        text7.setX(10);
        text7.setY(380);
        text7.setStyle("-fx-font-size:19; -fx-font-weight: Lighter;-fx-font-style: italic;");

        rightHalf.getChildren().addAll(back, imageView, text6, text7);

        hbox.getChildren().addAll(leftHalf, rightHalf);

        // Create the scene and set it on the stage
        leftHalf.setStyle("-fx-background-image:url('YellowImage.jpg');-fx-background-size:cover");
        Scene scene = new Scene(hbox, 900, 600);

        pg.setScene(scene);

        pg.show();
    }

}
