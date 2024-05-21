import java.net.URL;

//https://medium.com/@antonio.gabriel/javafx-trabalhando-com-tableview-5cc1065babab

// Java efects
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Alert.AlertType;
// import javafx.stage.Stage;
// import javafx.scene.control.Button;
// import javafx.scene.control.ButtonType;
// import javafx.scene.control.CheckBox;
// import javafx.scene.control.PasswordField;
// import javafx.scene.control.TextField;

public class MainSceneController {
  // Vamos fazer uma função CreateScene que irá
  // criar a cena apartir de um FXMLLoader carregando
  // o .fxml.
  public static Scene CreateScene() throws Exception
  {
    URL sceneUrl = MainSceneController.class.getResource("main-scene.fxml");
    Parent root = FXMLLoader.load(sceneUrl);
    Scene scene = new Scene(root);
    return scene;
  }

}