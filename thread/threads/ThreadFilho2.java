/* ***************************************************************
* Autor............: Breno Bering Silva
* Matricula........: 202110863
* Inicio...........: 19/03/2023
* Ultima alteracao.: 22/02/2023
* Nome.............: Arvore Genealogica
* Funcao...........: Definindo a thread filho 2
*************************************************************** */
package threads;

import control.mainController;
import javafx.application.Platform;

public class ThreadFilho2 extends Thread {
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
    for (int i = 0; i <= 55; i++) {
      if (i == 10) {
        controller.atualizaImagemFilho2("/assets/kid.png");
      }
      if (i == 20) {
        controller.atualizaImagemFilho2("/assets/adult.png");
        controller.nasceuNeto2();
      }
      if (i == 32) {
        controller.atualizaImagemFilho2("/assets/mid-age-adult.png");
      }
      if (i == 54) {
        controller.atualizaImagemFilho2("/assets/aged-man.png");
      }
      idade = i;
      Platform.runLater(() -> controller.atualizaIdadeFilho2(idade));
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    controller.atualizaImagemFilho2("/assets/grave.png");
  }
}
