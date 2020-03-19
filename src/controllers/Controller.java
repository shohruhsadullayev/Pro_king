package controllers;


import dao.StudentDao;
import entity.StudentEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Model;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button btnList;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSetting;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnConvert;

    @FXML
    private Pane pnlStatus;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblStatusMini;

    @FXML
    private TableView<StudentEntity> tableview;

    @FXML
    private Pane pnAll;

    @FXML
    private Pane pnSetting;

    @FXML
    private Pane pnHelp;

    @FXML
    private TextField txtFirstNameStudent;

    @FXML
    private TextField txtLastNameStudent;

    @FXML
    private TextField txtMobilPhoneStudent;

    @FXML
    private TextField txtHomePhoneStudent;

    @FXML
    private DatePicker txtDateOfBirthStudent;

    @FXML
    private TextArea txtAddressStudent;

    @FXML
    private RadioButton rdbMale;

    @FXML
    private RadioButton rdbFamale;

    @FXML
    private Button btnDelete;

    @FXML
    private AnchorPane pnlList;


    @FXML
    private Button btnAddStudent;
    private StudentDao studentDao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model model = new Model();
        studentDao = new StudentDao();

        printData();
        loadData();


    }

    private void printData() {
        btnAddStudent.setOnAction(e->{
            if(!txtAddressStudent.getText().equals("") && !txtFirstNameStudent.getText().equals("") && !txtLastNameStudent.getText().equals("") &&
                    !txtHomePhoneStudent.getText().equals("") && !txtMobilPhoneStudent.getText().equals("") && !txtDateOfBirthStudent.getValue().toString().equals("")){
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setFirstname(txtFirstNameStudent.getText());
                studentEntity.setLastname(txtLastNameStudent.getText());
                studentEntity.setMobilphone(txtMobilPhoneStudent.getText());
                studentEntity.setHomephone(txtHomePhoneStudent.getText());
                studentEntity.setDate(txtDateOfBirthStudent.getValue().toString());
                studentEntity.setAddress(txtAddressStudent.getText());
                studentDao.saveProduct(studentEntity);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Ma'lumotlar muvaffaqiyatli kritildi!");
                alert.showAndWait();

            }else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Ma'lumotlar to'liq kiritilmagan!");
                alert.showAndWait();
            }

        });
    }

    private void loadData()
    {
        List<StudentEntity> list = studentDao.listStudents();
        ObservableList<StudentEntity> observableList = FXCollections.observableList(list);

        TableColumn id = new TableColumn("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn lastName = new TableColumn("Last Name");
        lastName.setMinWidth(100);
        lastName.setCellValueFactory(
                new PropertyValueFactory<>("lastname"));

        TableColumn firstName = new TableColumn("First name");
        firstName.setMinWidth(200);
        firstName.setCellValueFactory(
                new PropertyValueFactory<>("firstname"));

        TableColumn address = new TableColumn("Address");
        address.setMinWidth(200);
        address.setCellValueFactory(
                new PropertyValueFactory<>("address"));

        TableColumn mobilphone = new TableColumn("Mobil Phone");
        mobilphone.setMinWidth(200);
        mobilphone.setCellValueFactory(
                new PropertyValueFactory<>("mobilphone"));

        TableColumn homephone = new TableColumn("Home Phone");
        homephone.setMinWidth(200);
        homephone.setCellValueFactory(
                new PropertyValueFactory<>("homephone"));

        TableColumn date = new TableColumn("Date of Birth");
        date.setMinWidth(200);
        date.setCellValueFactory(
                new PropertyValueFactory<>("date"));


        tableview.getColumns().clear();
        tableview.getColumns().addAll(id, lastName, firstName, address, mobilphone, homephone, date);

        tableview.setItems(observableList);


    }


    @FXML
    public void press(javafx.event.ActionEvent event) {
        if(event.getSource() ==btnList){
            lblStatus.setText("List");
            lblStatusMini.setText("/home/List");
            pnlList.toFront();
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(113,86,221), CornerRadii.EMPTY, Insets.EMPTY)));
        }else
        if(event.getSource() ==btnAdd){
            lblStatus.setText("Add");
            lblStatusMini.setText("/home/Add");
            pnAll.toFront();
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43,63,99), CornerRadii.EMPTY, Insets.EMPTY)));
        }else
        if(event.getSource() ==btnSetting){
            lblStatus.setText("Setting");
            lblStatusMini.setText("/home/Setting");
            pnSetting.toFront();
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(43,99,63), CornerRadii.EMPTY, Insets.EMPTY)));
        }else
        if(event.getSource() ==btnHelp){
            lblStatus.setText("Help");
            lblStatusMini.setText("/home/Help");
            pnHelp.toFront();
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(99,43,63), CornerRadii.EMPTY, Insets.EMPTY)));
        }else
        if(event.getSource() ==btnConvert){
            lblStatus.setText("Convert");
            lblStatusMini.setText("/home/Convert");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(42,28,66), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    public void refresh(MouseEvent mouseEvent) {
        loadData();
    }


    public void handleRefresh(ActionEvent event) {
    }

    public void handleEdit(ActionEvent event) {
    }

    public void handleDelete() {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + " ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            StudentEntity entity = tableview.getSelectionModel().getSelectedItem();
            studentDao.deleteProduct(entity);
            loadData();
        }


    }


    public void btnDel() {
        handleDelete();
    }
}


