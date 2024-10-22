package com.example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CalculatorController {
    @FXML
    private Button ClearButton;
    @FXML
    private Button DivideButton;
    @FXML
    private Button EightButton;
    @FXML
    private Button EqualsButton;
    @FXML
    private Button FiveButton;
    @FXML
    private Button FourButton;
    @FXML
    private Button MultiplyButton;
    @FXML
    private Button NineButton;
    @FXML
    private Button OneButton;
    @FXML
    private Text OperationLabel;
    @FXML
    private Button PlusButton;
    @FXML
    private Label ResultLabel;
    @FXML
    private Button SevenButton;
    @FXML
    private Button SixButton;
    @FXML
    private Button SubtractButton;
    @FXML
    private Button ThreeButton;
    @FXML
    private Button TwoButton;
    @FXML
    private Button ZeroButton;

    private StringBuilder input = new StringBuilder();
    private double leftOperand = 0, rightOperand = 0;
    private int previousOp = -1;
    private boolean performingOp;

    public CalculatorController(){
        ResultLabel = new Label();
        ResultLabel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        ResultLabel.setTextAlignment(TextAlignment.RIGHT);
    }


    @FXML
    void ZeroButtonPressed(ActionEvent event) {
        addDidget('0');
    }

    @FXML
    void OneButtonPressed(ActionEvent event) {
        addDidget('1');
    }
    
    @FXML
    void TwoButtonPressed(ActionEvent event) {
        addDidget('2');
    }

    @FXML
    void ThreeButtonPressed(ActionEvent event) {
        addDidget('3');
    }
    
    @FXML
    void FourButtonPressed(ActionEvent event) {
        addDidget('4');
    }
    
    @FXML
    void FiveButtonPressed(ActionEvent event) {
        addDidget('5');
    }
    
    @FXML
    void SixButtonPressed(ActionEvent event) {
        addDidget('6');
    }

    @FXML
    void SevenButtonPressed(ActionEvent event) {
        addDidget('7');
    }
    
    @FXML
    void EightButtonPressed(ActionEvent event) {
        addDidget('8');
    }
    
    @FXML
    void NineButtonPressed(ActionEvent event) {
        addDidget('9');
    }
    
    @FXML
    void EuqalsButtonPressed(ActionEvent event) {
        performOperation(4);
    }
     
    @FXML
    void PlusButtonPressed(ActionEvent event) {
        performOperation(0);
    }
    
    @FXML
    void MinusButtonPressed(ActionEvent event) {
        performOperation(1);
    }
    
    @FXML
    void MultiplyButtonPressed(ActionEvent event) {
        performOperation(2);
    }
    
    @FXML
    void DivideButtonPressed(ActionEvent event) {
        performOperation(3);
    }
    @FXML
    void ClearButtonPressed(ActionEvent event){
        clear();
    }
    
    private void addDidget(char didget){
        if (performingOp) {
            ResultLabel.setText("");
            input = new StringBuilder();
            performingOp = false;
        }
        if (input.length() < 10) {
            input.append(didget);
            ResultLabel.setText(input.toString());
        }
    }

    private void performOperation(int mode){
        performingOp = true;
        if (previousOp != -1) {
            if (input.length() > 0 || mode == 4) {
                if (input.length() > 0) {
                    rightOperand = Double.parseDouble(input.toString());
                    input.setLength(0);
                }
                switch (previousOp) {
                    case 0:
                        leftOperand = leftOperand + rightOperand;
                        break;
                    case 1:
                        leftOperand = leftOperand - rightOperand;
                        break;
                    case 2:
                        leftOperand = leftOperand * rightOperand;
                        break;
                    case 3:
                        leftOperand = leftOperand / rightOperand;
                        break;
                    default:
                        break;
                    }
                ResultLabel.setText(String.valueOf(leftOperand));
                
            }
        }
        else{
            if (input.length()>0) {
                leftOperand = Double.parseDouble(input.toString());
                
            }
        }
        if (mode != 4) {
            previousOp = mode;
        }
    }

    private void clear(){
        previousOp = -1;
        leftOperand = 0;
        rightOperand = 0;
        input.setLength(0);
        ResultLabel.setText("0");
    }
}
