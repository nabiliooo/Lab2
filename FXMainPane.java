


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
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
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	Button button1, button2, button3, button4, button5;
	Label lbl;
	TextField tf;
	HBox hb1, hb2;
	
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataM = new DataManager();
	Insets inset = new Insets(5);
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		
		lbl = new Label("Feedback: ");
		tf = new TextField();
		hb1 = new HBox();
		hb2 = new HBox();
		
		button1.setOnAction(new handler());
		button2.setOnAction(new handler());
		button3.setOnAction(new handler());
		button4.setOnAction(new handler());
		button5.setOnAction(new handler());
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		hb1.setAlignment(Pos.CENTER);
		hb2.setAlignment(Pos.CENTER);
		hb1.setMargin(tf, inset);
		
		hb2.setMargin(button1, inset);
		hb2.setMargin(button2, inset);
		hb2.setMargin(button3, inset);
		hb2.setMargin(button4, inset);
		hb2.setMargin(button5, inset);
		
		
		
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		hb1.getChildren().addAll(lbl, tf);
		hb2.getChildren().addAll(button1, button2, button3, button4, button5);
		
		this.getChildren().addAll(hb1, hb2);
		
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class handler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			EventTarget targ = event.getTarget();
			
			if(targ == button1) {
				tf.setText(dataM.getHello());
			}else if(targ == button2) {
				tf.setText(dataM.getHowdy());
			}else if(targ == button3) {
				tf.setText(dataM.getChinese());
			}else if(targ == button4) {
				tf.setText("");
			}else if(targ == button5) {
				Platform.exit();
				System.exit(0);
		}
	}
	
}
}
	
