package ui;

import java.io.IOException;

import exceptions.EmptyFieldException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.CircleManager;
import model.ProgressManager;
import model.TimeKeeperManager;
import thread.ControllerThread;

public class AlgorithmsRaceGUI {

    @FXML
    private TextField txtN;

    @FXML
    private ToggleGroup algorithm;

    @FXML
    private ToggleGroup mode;

    @FXML
    private Label timekeeper;

    @FXML
    private Circle circleBig;

    @FXML
    private Circle circleSmall;

    @FXML
    private Label timeArrayList;

    @FXML
    private Label timeABB;

    @FXML
    private Label timeLinkedList;

    @FXML
    private ProgressIndicator progressIndiAL;

    @FXML
    private ProgressIndicator progressIndiLE;

    @FXML
    private ProgressIndicator progressIndiABB;

    @FXML
    private ProgressBar progressBarAL;

    @FXML
    private ProgressBar progressBarABB;

    @FXML
    private ProgressBar progressBarLE;

    @FXML
    private Button runButton;

    @FXML
    private Label operationsAL;

    @FXML
    private Label operationsLE;

    @FXML
    private Label operationsABB;

    @FXML
    private Button resetButtom;

    ////////////////////////////
    private ProgressManager progressBarArrayList;
    private ProgressManager progressBarLinkedList;
    private ProgressManager progressBarAbb;
    
    private ProgressManager progressIndiArrayList;
    private ProgressManager progressIndiLinkedList;
    private ProgressManager progressIndiAbb;
    
    private CircleManager c1;
	private CircleManager c2;
	
	private Stage waitStage;
	
	private TimeKeeperManager timeKeeperManager;
    
    public void initialize() {
    	progressBarArrayList = new ProgressManager();
    	progressBarLinkedList = new ProgressManager();
    	progressBarAbb = new ProgressManager();
    	
    	progressIndiArrayList = new ProgressManager();
        progressIndiLinkedList = new ProgressManager();
        progressIndiAbb = new ProgressManager();
        
        c1 = new CircleManager(circleBig.getRadius());
    	c2 = new CircleManager(circleSmall.getRadius());
    	timeKeeperManager = new TimeKeeperManager();
    	
    	waitStage = new Stage();
    }
    
    public void openWaitStage() throws IOException {
    	Parent root= FXMLLoader.load(getClass().getResource("WaitStage.fxml"));
    	Scene scene = new Scene(root);
    	scene.setFill(Color.TRANSPARENT);
    	
    	waitStage.initStyle(StageStyle.TRANSPARENT);
    	waitStage.setScene(scene);
    	waitStage.setResizable(false);
    	waitStage.getIcons().add(new Image("images/iconito.png"));
    	waitStage.setTitle("Wait Stage");
    	waitStage.show();
    }
    
    public void closeWaitStage() {
    	waitStage.close();
    }
    
    public void updateProgressBar() {
    	progressBarABB.setProgress(progressBarAbb.getProgress());
    	progressBarAL.setProgress(progressBarArrayList.getProgress());
    	progressBarLE.setProgress(progressBarLinkedList.getProgress());
    }

    public void updateProgressIndi() {
    	progressIndiABB.setProgress(progressIndiAbb.getProgress());
    	progressIndiAL.setProgress(progressIndiArrayList.getProgress());
    	progressIndiLE.setProgress(progressIndiLinkedList.getProgress());
    }
    
    public void updateOperationsLabelArrayList(String operations) {
    	operationsAL.setText(operations);
    }
    
    public void updateOperationsLabelLinkedList(String operations) {
    	operationsLE.setText(operations);
    }
    
    public void updateOperationsLabelAbb(String operations) {
    	operationsABB.setText(operations);
    }
    
    public void updateCircles() {
    	circleBig.setRadius(c1.getRadius());
    	circleSmall.setRadius(c2.getRadius());
    }
    
    public void updateTimeKeeper() {
    	timekeeper.setText(timeKeeperManager.getTime());
    }
    
    public void updateTimeArrayListLabel() {
    	timeArrayList.setText(timeKeeperManager.getTime());
    }
    
    public void updateTimeLinkedListLabel() {
    	timeLinkedList.setText(timeKeeperManager.getTime());
    }

    public void updateTimeABBLabel() {
    	timeABB.setText(timeKeeperManager.getTime());
    }
    
    @FXML
    void reset(ActionEvent event) {
    	timeArrayList.setText("00:00:000");
    	timeLinkedList.setText("00:00:000");
    	timeABB.setText("00:00:000");
    	
    	operationsAL.setText("");
    	operationsABB.setText("");
    	operationsLE.setText("");
    	
    	timeKeeperManager.reset();
    	updateTimeKeeper();
    	
    	progressBarAbb.reset();
    	progressBarArrayList.reset();
    	progressBarLinkedList.reset();
    	updateProgressBar();
    	
    	progressIndiAbb.reset();
    	progressIndiArrayList.reset();
    	progressIndiLinkedList.reset();
    	updateProgressIndi();
    	
    	waitStage = new Stage();
    	
    	resetButtom.setDisable(true);
    	runButton.setDisable(false);
    }

    @FXML
    void run(ActionEvent event) {
    	
    	String method;
    	if(((RadioButton)algorithm.getSelectedToggle()).getText().equals("Add"))
    		method = ControllerThread.METHOD_ADD;
    	else if(((RadioButton)algorithm.getSelectedToggle()).getText().equals("Search"))
    		method = ControllerThread.METHOD_SEARCH;
    	else
    		method = ControllerThread.METHOD_DELETE;
    	
    	boolean iterative;
    	if(((RadioButton)mode.getSelectedToggle()).getText().equals("Iterative"))
    		iterative = true;
    	else
    		iterative = false;
    	
    	long n;
    	try {
    		if(txtN.getText().equals("")) {
        		throw new EmptyFieldException("N");
        	}else {
        		n = Long.parseLong(txtN.getText());
        		runButton.setDisable(true);
        		ControllerThread ct = new ControllerThread(this, progressBarArrayList, progressBarLinkedList, progressBarAbb, progressIndiArrayList, progressIndiLinkedList, progressIndiAbb, c1, c2, timeKeeperManager, method, iterative, n);
            	ct.start();
            	resetButtom.setDisable(false);
        	}
    	}catch(EmptyFieldException e) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setHeaderText(e.getMessage());
    		alert.setTitle("EMPTY FIELD");
    		alert.show();
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Enter a valid number");
    		alert.setHeaderText(e.getMessage());
    		alert.setTitle("ERROR");
    		alert.show();
    	}
    }
}
