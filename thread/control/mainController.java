/* ***************************************************************
* Autor............: Breno Bering Silva
* Matricula........: 202110863
* Inicio...........: 19/03/2023
* Ultima alteracao.: 22/02/2023
* Nome.............: Arvore Genealogica
* Funcao...........: Controlador das threads, inicia threads, altera idades em tempo real e altera imagens
*************************************************************** */
package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import threads.*;

public class mainController implements Initializable {

  // Definindo os FXML que serao utilizados no controller
  @FXML
  private ImageView imgFilho2;

  @FXML
  private Text txtFilho2;

  @FXML
  private Button buttonStart;

  @FXML
  private ImageView imgPai;

  @FXML
  private Text txtPai;

  @FXML
  private ImageView imgFilho1;

  @FXML
  private Text txtFilho3;

  @FXML
  private ImageView imgFilho3;

  @FXML
  private Text txtFilho1;

  @FXML
  private ImageView imgNeto;

  @FXML
  private Text txtNeto;

  @FXML
  private ImageView imgNeto2;

  @FXML
  private Text txtNeto2;

  @FXML
  private ImageView imgBisneto;

  @FXML
  private Text txtBisneto;

  @FXML
  private Text nomePai;

  @FXML
  private Text nomeFilho01;

  @FXML
  private Text nomeFilho02;

  @FXML
  private Text nomeFilho03;

  @FXML
  private Text nomeNeto01;

  @FXML
  private Text nomeNeto02;

  @FXML
  private Text nomeBisneto;

  @FXML
  private ImageView imgBackground;

  // Local onde se instanciam as threads que vao ser utilizadas ao iniciar a tela
  // principal
  private ThreadPai pai;

  private ThreadFilho1 filho1;

  private ThreadFilho2 filho2;

  private ThreadFilho3 filho3;

  private ThreadNeto neto;

  private ThreadNeto2 neto2;

  private ThreadBisneto bisneto;

  // Funcao onclick do botao buttonstart
  @FXML
  void clickButtonStart(ActionEvent event) {
    buttonStart.setVisible(false);
    pai.start();
  }

  // Parte onde se iniciam todas as threads a serem utilizadas e se seta os
  // controllers de cada uma
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.pai = new ThreadPai();
    this.filho1 = new ThreadFilho1();
    this.filho2 = new ThreadFilho2();
    this.filho3 = new ThreadFilho3();
    this.neto = new ThreadNeto();
    this.neto2 = new ThreadNeto2();
    this.bisneto = new ThreadBisneto();
    bisneto.setController(this);
    neto2.setController(this);
    neto.setController(this);
    filho3.setController(this);
    filho2.setController(this);
    filho1.setController(this);
    pai.setController(this);
    imgFilho1.setVisible(false);
    txtFilho1.setVisible(false);
    imgFilho2.setVisible(false);
    txtFilho2.setVisible(false);
    imgFilho3.setVisible(false);
    txtFilho3.setVisible(false);
    imgNeto.setVisible(false);
    txtNeto.setVisible(false);
    imgNeto2.setVisible(false);
    txtNeto2.setVisible(false);
    imgBisneto.setVisible(false);
    txtBisneto.setVisible(false);
  }

  // Metodos que atualizam idade e imagem dos individos
  public void atualizaIdadePai(int novaIdade) {
    txtPai.setText(String.valueOf(novaIdade));
  }

  public void atualizaImagemPai(String destino) {
    imgPai.setImage(new Image(destino));
  }

  public void atualizaIdadeFilho(int novaIdade) {
    txtFilho1.setText(String.valueOf(novaIdade));
  }

  public void atualizaImagemFilho(String destino) {
    imgFilho1.setImage(new Image(destino));
  }

  public void atualizaIdadeFilho2(int novaIdade) {
    txtFilho2.setText(String.valueOf(novaIdade));
  }

  public void atualizaImagemFilho2(String destino) {
    imgFilho2.setImage(new Image(destino));
  }

  public void atualizaIdadeFilho3(int novaIdade) {
    txtFilho3.setText(String.valueOf(novaIdade));
  }

  public void atualizaImagemFilho3(String destino) {
    imgFilho3.setImage(new Image(destino));
  }

  public void atualizaIdadeNeto(int novaIdade) {
    txtNeto.setText(String.valueOf(novaIdade));
  }

  public void atualizaImagemNeto(String destino) {
    imgNeto.setImage(new Image(destino));
  }

  public void atualizaIdadeNeto2(int novaIdade) {
    txtNeto2.setText(String.valueOf(novaIdade));
  }

  public void atualizaImagemNeto2(String destino) {
    imgNeto2.setImage(new Image(destino));
  }

  public void atualizaIdadeBisneto(int novaIdade) {
    txtBisneto.setText(String.valueOf(novaIdade));
  }

  public void atualizaImagemBisneto(String destino) {
    imgBisneto.setImage(new Image(destino));
  }

  // Metodos que iniciam as threads
  public void nasceuPrimeiroFilho() {
    imgFilho1.setVisible(true);
    txtFilho1.setVisible(true);
    nomeFilho01.setVisible(true);
    filho1.start();
  }

  public void nasceuSegundoFilho() {
    imgFilho2.setVisible(true);
    txtFilho2.setVisible(true);
    nomeFilho02.setVisible(true);
    filho2.start();
  }

  public void nasceuTerceiroFilho() {
    imgFilho3.setVisible(true);
    txtFilho3.setVisible(true);
    nomeFilho03.setVisible(true);
    filho3.start();
  }

  public void nasceuNeto() {
    imgNeto.setVisible(true);
    txtNeto.setVisible(true);
    nomeNeto01.setVisible(true);
    neto.start();
  }

  public void nasceuNeto2() {
    imgNeto2.setVisible(true);
    txtNeto2.setVisible(true);
    nomeNeto02.setVisible(true);
    neto2.start();
  }

  public void nasceuBisneto() {
    imgBisneto.setVisible(true);
    txtBisneto.setVisible(true);
    nomeBisneto.setVisible(true);
    bisneto.start();
  }
}
