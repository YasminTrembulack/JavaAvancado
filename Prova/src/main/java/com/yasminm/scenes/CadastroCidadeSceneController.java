package com.yasminm.scenes;

import java.net.URL;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yasminm.model.TableCidade;
import com.yasminm.model.TableEstado;
import com.yasminm.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class CadastroCidadeSceneController {

    public static Scene CreateScene() throws Exception {
        URL sceneUrl = CadastroCidadeSceneController.class.getResource("cadastro-cidade-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected Button btCadastrar;

    @FXML
    protected TextField tfCidade;

    @FXML
    protected Button btVoltar;

    @FXML
    protected ComboBox<String> cbEstado = new ComboBox<String>();

    private ObservableList<String> all_estados = FXCollections.observableArrayList();

    public void cbAction(){
        Session session = HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
        Transaction transaction = session.beginTransaction();
    
        Query query = session.createQuery("from TableEstado");
        List<TableEstado> select_estados = query.list();
        transaction.commit();

        if (select_estados.size() != all_estados.size()) {
            for (int i = 0; i < select_estados.size();i++) {
                all_estados.add(select_estados.get(i).getEstado());
            }
        }

        System.out.println(all_estados);

        cbEstado.getItems().setAll(all_estados);
    }

    public void cadastrarCidade(ActionEvent e) {
        try {
            String input_cidade = getTfCidade();
        
            
            TableCidade cidade = new TableCidade();
    
            Session session = HibernateUtil
                    .getSessionFactory()
                    .getCurrentSession();
            Transaction transaction = session.beginTransaction();
    
            Query query = session.createQuery("from TableEstado te where te.estado = :nome_estado ");
            query.setParameter("nome_estado", cbEstado.getValue());
            List<TableEstado> found_estado = query.list();
    
            cidade.setEstado(found_estado.get(0));
            
            cidade.setCidade(input_cidade);
            session.save(cidade);
            transaction.commit();
    
            Alert alert = new Alert(
                AlertType.INFORMATION,
                "Cidade adicionada com sucesso!",
                ButtonType.OK);
            alert.showAndWait();
    
            setTfCidade("");
            cbEstado.getItems().clear();
            
        } catch (Exception ey) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "ERRO Inesperado!",
                    ButtonType.OK);
            alert.showAndWait();
            ey.printStackTrace();
            return;
        }
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


    public Button getBtCadastrar() {
        return btCadastrar;
    }

    public void setBtCadastrar(Button btCadastrar) {
        this.btCadastrar = btCadastrar;
    }

    public String getTfCidade() {
        return tfCidade.getText();
    }

    public void setTfCidade(String string) {
        this.tfCidade.setText(string);
    }

    public Button getBtVoltar() {
        return btVoltar;
    }

    public void setBtVoltar(Button btVoltar) {
        this.btVoltar = btVoltar;
    }
}
