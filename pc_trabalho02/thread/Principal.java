
/* ***************************************************************
* Autor............: Breno Bering Silva
* Matricula........: 202110863
* Inicio...........: 19/03/2023
* Ultima alteracao.: 22/02/2023
* Nome.............: Arvore Genealogica
* Funcao...........: Uma arvore genealogica que funciona com threads
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import control.*;

public class Principal extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // carrega o fxml usado como base
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/startLayout.fxml"));

    Parent root = loader.load();
    mainController controller = new mainController();

    // manipulando e dando display na cena
    Scene scene = new Scene(root);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Arvore");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}