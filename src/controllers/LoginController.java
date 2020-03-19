package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public Button btnButton;
    @FXML
    public TextField txtLogin;
    @FXML
    public TextField txtParol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    String admin_login = "admin";
    String admin_parol = "admin";
    public void Kirish(MouseEvent mouseEvent) throws IOException {
        String login = txtLogin.getText();
        System.out.println("login :" + login);
        String parol = txtParol.getText();
        System.out.println("parol :"+parol);


        // if (login.equals(admin_login) && parol.equals(admin_parol))
        // {
        System.out.println("Yes");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        Scene homeScene = new Scene(root);
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setTitle("Home");
        window.setScene(homeScene);
        window.show();
        //  }


    }
}