/* ***************************************************************
* Autor............: Breno Bering Silva
* Matricula........: 202110863
* Inicio...........: 19/03/2023
* Ultima alteracao.: 22/02/2023
* Nome.............: Arvore Genealogica
* Funcao...........: Definindo a thread neto
*************************************************************** */
package threads;

import control.mainController;
import javafx.application.Platform;

public class ThreadNeto extends Thread {
  mainController controller = new mainController();
  private int idade = 0;

  // Definido o construtor de controle que recebe o controle do maincontroller
  // como parametro
  public void setController(mainController controle) {
    this.controller = controle;
  }

  // Metodo que inicia a thread e faz as verificacoes das idades (a cada sleep, se
  // passa 1 segundo, e se soma 1 ano a idade)
  // Em cada verificacao de idade, a imagem do individuo e alterada para uma que
  // faca sentido
  @Override
  public void run() {
    for (int i = 0; i <= 35; i++) {
      if (i == 10) {
        controller.atualizaImagemNeto("/assets/kid.png");
      }
      if (i == 22) {
        controller.atualizaImagemNeto("/assets/adult.png");
      }
      if (i == 30) {
        controller.atualizaImagemNeto("/assets/mid-age-adult.png");
        controller.nasceuBisneto();
      }
      idade = i;
      Platform.runLater(() -> controller.atualizaIdadeNeto(idade));
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    controller.atualizaImagemNeto("/assets/grave.png");
  }
}
