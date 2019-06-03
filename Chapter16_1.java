/********************************************************************************************************************
 ********************************************************************************************************************
 *****                                         Chapter 16: Problem 1                                            *****
 *****__________________________________________________________________________________________________________*****
 *****              1. Create a GUI which consists of 4 Labels and 3 Buttons organized as follows               *****
 *****----------------------------------------------------------------------------------------------------------*****
 *****          Label 1	                             Button 1	                               Label 2          *****
 *****         TextField	                         Button 2	                               Label 3          *****
 *****                                               Button 3                                                   *****
 *****__________________________________________________________________________________________________________*****
 *****        The 3 Buttons should line up evenly with the 2 items on either side of Buttons 1 and 2.           *****
 *****                        The GUI works as follows. A user enters text into TextField,                      *****
 *****                             presses Button1 and that text is copied into Label4.                         *****
 *****                                Button2 clears both the TextField and Label4.                             *****
 *****                                       Button3 quits the program.                                         *****
 *****                           Label1 says "Enter a String" and Label2 says "Output".                         *****
 *****                         The Buttons should be labeled as "Echo", "Clear" and "Quit".                     *****
 *****                                 To do "Quit", simply execute System.exit(0);                             *****
 ********************************************************************************************************************
 ********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Chapter16_1 extends Application {

    // CLASS VARIABLE(s) declaration(s)
    private Label lbl1, lbl2, lbl3;
    private TextField txtFld;
    private Button btn1, btn2, btn3;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage){
        //////////////////////////////////////// INITIALIZE THE LABELS ////////////////////////////////////////
        // Initialize the Label, to go in the upper left corner, to instruct the user to enter a String
        lbl1 = new Label("Enter a String: ");
        // Initialize the Label, to go in the upper right corner, to inform the user that the output will be
            // output directly beneath it
        lbl2 = new Label("Output: ");
        // Initialize the Label, to go in the right column, middle row, directly beneath the "Output: " Label,
            // that displays the output of the user inputted String
        lbl3 = new Label("");

        //////////////////////////////////////// INITIALIZE THE BUTTONS ////////////////////////////////////////
        // Initialize the Button, to go in the top row, center column, to capture the user inputted String
            // from the TextField and Set the Preferred Width
        btn1 = new Button("Echo");
        btn1.setPrefWidth(100);
        // Initialize the Button, to go in the center row, center column, to clear the output in the output Label
            // and Set the Preferred Width
        btn2 = new Button("Clear");
        btn2.setPrefWidth(100);
        // Initialize the Button, to go in the bottom row, center column, to quit the program and
            // Set the Preferred Width
        btn3 = new Button("Quit");
        btn3.setPrefWidth(100);

        // Initialize the TextField for user String input
        txtFld = new TextField("");

        // Create and Initialize the first FlowPane, Set the Orientation to VERTICAL, add lbl1 and txtFld and
            // Set the Vgap
        FlowPane fP1 = new FlowPane();
        fP1.setOrientation(Orientation.VERTICAL);
        fP1.getChildren().add(lbl1);
        fP1.getChildren().add(txtFld);
        fP1.setVgap(15);

        // Create and Initialize the second FlowPane, Set the Orientation to VERTICAL, add btn1, btn2 and btn3 and
            // Set the Vgap
        FlowPane fP2 = new FlowPane();
        fP2.setOrientation(Orientation.VERTICAL);
        fP2.getChildren().add(btn1);
        fP2.getChildren().add(btn2);
        fP2.getChildren().add(btn3);
        fP2.setVgap(15);

        // Create and Initialize the third FlowPane, Set the Orientation to VERTICAL, add lbl2 and lbl3 and
            // Set the Vgap
        FlowPane fP3 = new FlowPane();
        fP3.setOrientation(Orientation.VERTICAL);
        fP3.getChildren().add(lbl2);
        fP3.getChildren().add(lbl3);
        fP3.setVgap(15);

        // Create and Initialize the GridPane, add the FlowPanes to it and Set the Hgap
        GridPane gPane = new GridPane();
        gPane.add(fP1, 0, 0);
        gPane.add(fP2, 1, 0);
        gPane.add(fP3, 2, 0);
        gPane.setHgap(50);

        // Create and Initialize the Scene, Set the Title of the Stage, Set the Scene to the Stage and Show the Stage
        Scene scene = new Scene(gPane, 500, 125);
        primaryStage.setTitle("Chapter 16: Problem 1");
        primaryStage.setScene(scene);
        primaryStage.show();

        // EventHandler for btn1
        btn1.setOnAction(e -> {
            String input = txtFld.getText();
            lbl3.setText(input);
            txtFld.clear();
        });

        // EventHandler for btn2
        btn2.setOnAction(e -> {
            txtFld.clear();
            lbl3.setText("");
        });

        // EventHandler for btn3
        btn3.setOnAction(e -> {
            System.exit(0);
        });
    }
}
