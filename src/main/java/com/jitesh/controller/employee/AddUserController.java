package com.jitesh.controller.employee;

import com.jitesh.bean.User;
import com.jitesh.config.StageManager;
import com.jitesh.service.UserService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
@ComponentScan
public class AddUserController implements Initializable {
@Autowired
private UserService userservice;
    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private TextField firstField, lastField, usernameField, phoneField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextArea addressArea;
    @FXML
    private Button saveButton;
    /*private EmployeeModel employeeModel;*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*employeeModel = new EmployeeModel();*/
    }

    @FXML
    public void handleCancel(ActionEvent event) {
        firstField.setText("");
        lastField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        phoneField.setText("");
        addressArea.setText("");
    }

    /*@FXML
    public void handleSave(ActionEvent event) {

        if (validateInput()) {

            User user = new User();
                    user.setFirstName(firstField.getText());
            user.setLastName(lastField.getText());
                    user.setUserName(usernameField.getText());
            user.setPassword(DigestUtils.sha1Hex(passwordField.getText()));
                    user.setPhone(phoneField.getText());
                    user.setAddress(addressArea.getText());


            userservice.save(user);
            userservice.EMPLOYEELIST.clear();
            userservice.EMPLOYEELIST.addAll(userservice.getemployees());

            ((Stage) saveButton.getScene().getWindow()).close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful");
            alert.setHeaderText("Employe Created!");
            alert.setContentText("Employee is created successfully");
            alert.showAndWait();
        }
    }*/

    @FXML
    private void handleSave(ActionEvent event){





                    User user = new User();
            user.setFirstName(firstField.getText());
            user.setLastName(lastField.getText());
            user.setUserName(usernameField.getText());
            user.setPassword(DigestUtils.sha1Hex(passwordField.getText()));
            user.setPhone(phoneField.getText());
            user.setAddress(addressArea.getText());

                    User newUser = userservice.addUser(user);

                    saveAlert(newUser);
                }




    private void saveAlert(User user){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User saved successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The user "+user.getFirstName()+" "+user.getLastName() +" has been created ");
        alert.showAndWait();
    }


    private boolean validateInput() {

        String errorMessage = "";

        if (firstField.getText() == null || firstField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }

        if (lastField.getText() == null || lastField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }

        if (usernameField.getText() == null || usernameField.getText().length() == 0) {
            errorMessage += "No valid username!\n";
        }

        if (passwordField.getText() == null || passwordField.getText().length() == 0) {
            errorMessage += "No valid password!\n";
        }

        if (phoneField.getText() == null || phoneField.getText().length() == 0) {
            errorMessage += "No valid phone number!\n";
        }

        if (addressArea.getText() == null || addressArea.getText().length() == 0) {
            errorMessage += "No email address!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }

    @FXML
    public void closeAction(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
}
