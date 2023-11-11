import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

public class FormController {
    public JFXTextField phoneField;
    public JFXTextField addressField;
    public JFXTextField ageField;
    public JFXTextField emailField;
    public JFXButton submitButton;
    public JFXTextField fullNameField;
    public JFXButton clearButton;
    public JFXTextField courseField;

    private boolean containsDigits(String fullName){
        for (int i=0; i<fullName.length(); i++){
            try {
                Integer.parseInt(fullName.charAt(i)+"");
                return true;
            }catch (Exception ignored){

            }
        }
        return false;
    }

    private boolean containsAt(String email){
        for (int i=0; i<email.length(); i++){
            boolean result= email.charAt(i) == '@';
            if (result){
                return true;
            }
        }
        return false;
    }

    private boolean validated(){
        boolean validated=true;
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String message="";
        if (ageField.getText().isEmpty()||Integer.parseInt(ageField.getText())<=0 ||Integer.parseInt(ageField.getText())>200) {
            message+="Invalid Age!!\n";
            validated=false;
        }
        if (fullNameField.getText().isEmpty()||containsDigits(fullNameField.getText())){
            message+="Invalid name!!\n";
            validated=false;
        }
        if (phoneField.getText().isEmpty()||phoneField.getText().length()!=10){
            message+="Invalid phone number!!\n";
            validated=false;
        }
        if (emailField.getText().isEmpty()||!containsAt(emailField.getText())){
            message+="Invalid email address!!\n";
            validated=false;
        }
        if (addressField.getText().isEmpty()){
            message+="Invalid Address!!\n";
            validated=false;
        }
        if (courseField.getText().isEmpty()){
            message+="Invalid Course Name!!\n";
            validated=false;
        }
        if (!validated){
            alert.setHeaderText(message);
            alert.showAndWait();
        }
        return validated;
    }
    public void submitButtonAction(ActionEvent actionEvent) {
        if (validated()){
            System.out.println(fullNameField.getText()+", "+ageField.getText()+", "+phoneField.getText()+", "+addressField.getText()+", "+emailField.getText()+", "+courseField.getText());
        }
    }


    public void clearButtonAction(ActionEvent actionEvent) {
        ageField.clear();
        phoneField.clear();
        fullNameField.clear();
        addressField.clear();
        emailField.clear();
        courseField.clear();
    }
}
