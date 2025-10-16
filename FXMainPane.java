package DataManager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
* This panel is the basic panel, inside which other panels are placed.
* Before beginning to implement, design the structure of your GUI in order to
* understand what panels go inside which ones, and what buttons or other components
* go in which panels.
* @author
ralexander
*
*/
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
//student Task #2:
// declare five buttons, a label, and a textfield
	private Button helloButton, howdyButton, chineseButton, clearButton, exitButton;
	private Label feedbackLabel;
	private TextField feedbackField;
	
// declare two HBoxes
	private HBox hBoxButtons, hBoxFeedback;
    
//student Task #4:
// declare an instance of DataManager
	private DataManager dataManager;
/**
* The MainPanel constructor sets up the entire GUI in this approach. Remember to
* wait to add a component to its containing component until the container has
* been created. This is the only constraint on the order in which the following
* statements appear.
*/
FXMainPane() {
//student Task #2:
// instantiate the buttons, label, and textfield
	helloButton = new Button("Hello");
    howdyButton = new Button("Howdy");
    chineseButton = new Button("Chinese");
    clearButton = new Button("Clear");
    exitButton = new Button("Exit");
    feedbackLabel = new Label("Feedback:");
    feedbackField = new TextField();
// instantiate the HBoxes
	hBoxButtons = new HBox();
    hBoxFeedback = new HBox();
//student Task #4:
// instantiate the DataManager instance
    dataManager = new DataManager();
// set margins and set alignment of the components
    hBoxButtons.setAlignment(Pos.CENTER);
    hBoxFeedback.setAlignment(Pos.CENTER);
    VBox.setMargin(hBoxButtons, new Insets(10));
    VBox.setMargin(hBoxFeedback, new Insets(10));
//student Task #3:
// add the label and textfield to one of the HBoxes
	hBoxFeedback.getChildren().addAll(feedbackLabel, feedbackField);
// add the buttons to the other HBox
	  hBoxButtons.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
// add the HBoxes to this FXMainPanel (a VBox)
	  this.getChildren().addAll(hBoxFeedback, hBoxButtons);

//Task #4:
// create a private inner class to handle the button clicks
helloButton.setOnAction(new ButtonHandler());
howdyButton.setOnAction(new ButtonHandler());
chineseButton.setOnAction(new ButtonHandler());
clearButton.setOnAction(new ButtonHandler());
exitButton.setOnAction(new ButtonHandler());
}
//Task #4:
//create a private inner class to handle the button clicks
private class ButtonHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Object source = event.getSource();

        if (source == helloButton) {
            feedbackField.setText(dataManager.getHello());
        } else if (source == howdyButton) {
           feedbackField.setText(dataManager.getHowdy());
        } else if (source == chineseButton) {
            feedbackField.setText(dataManager.getChinese());
        } else if (source == clearButton) {
            feedbackField.setText("");
        } else if (source == exitButton) {
            Platform.exit();
            System.exit(0);
        }
    }
}
}
