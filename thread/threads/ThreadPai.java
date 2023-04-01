/* ***************************************************************
* Autor............: Breno Bering Silva
* Matricula........: 202110863
* Inicio...........: 19/03/2023
* Ultima alteracao.: 22/02/2023
* Nome.............: Arvore Genealogica
* Funcao...........: Definindo a thread pai
*************************************************************** */
package threads;

import control.mainController;
import javafx.application.Platform;

public class ThreadPai extends Thread {
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
  // faca sentido e, por fim, atualiza a idade do individuo utilizando o setText
  // do mainController
  // A verificacao pode ainda startar outra thread, no caso do pai ter 22 anos,
  // que é quando ele tem o primeiro filho, para o i = 22 no ciclo, se starta a
  // thread do primeiro filho
  @Override
  public void run() {
    for (int i = 0; i <= 90; i++) {
      if (i == 10) {
        controller.atualizaImagemPai("/assets/kid.png");
      }
      if (i == 22) {
        controller.atualizaImagemPai("/assets/adult.png");
        controller.nasceuPrimeiroFilho();
      }
      if (i == 25) {
        controller.nasceuSegundoFilho();
      }
      if (i == 32) {
        controller.atualizaImagemPai("/assets/mid-age-adult.png");
        controller.nasceuTerceiroFilho();
      }
      if (i == 60) {
        controller.atualizaImagemPai("/assets/aged-man.png");
      }
      idade = i;
      Platform.runLater(() -> controller.atualizaIdadePai(idade));
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    controller.atualizaImagemPai("/assets/grave.png");
  }
}
