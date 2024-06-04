package com.yasminm.scenes;

import com.yasminm.model.TableEstado;
import com.yasminm.util.HibernateUtil;

import java.net.URL;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class CadastroEstadoSceneController {
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = CadastroEstadoSceneController.class.getResource("cadastro-estado-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected Button btCadastrar;

    @FXML
    protected TextField tfEstado;

    @FXML
    protected Button btVoltar;

    public Object cbEstado;

    public void cadastrarEstado(ActionEvent e) {
        String input_estado = getTfEstado();
        
        TableEstado estado = new TableEstado();
        estado.setEstado(input_estado);

        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(estado);
        transaction.commit();

        Alert alert = new Alert(
            AlertType.INFORMATION,
            "Estado adicionado com sucesso!",
            ButtonType.OK);
        alert.showAndWait();

        setTfEstado("");
    }

    public void voltar() {
        try {
            Stage crrStage = (Stage) btVoltar
            .getScene().getWindow();
            crrStage.close();
            
            Stage stage = new Stage();
            Scene scene = MainSceneController.CreateScene();
            stage.setScene(scene);
            stage.show();
        } 
        catch (Exception ex) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Erro ao processar a tela Main. Consulte o apoio de TI",
                    ButtonType.OK);
            alert.showAndWait();
            ex.printStackTrace();
        }
    }


    public Button getBtVoltar() {
        return btVoltar;
    }

    public void setBtVoltar(Button btVoltar) {
        this.btVoltar = btVoltar;
    }

    public Button getBtCadastrar() {
        return btCadastrar;
    }

    public void setBtCadastrar(Button btCadastrar) {
        this.btCadastrar = btCadastrar;
    }

    public String getTfEstado() {
        return tfEstado.getText();
    }

    public void setTfEstado(String string) {
        this.tfEstado.setText(string);
    }

}
