/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
Autor....: Breno Bering Silva
Matrícula: 202110863
Inicio...: 23/03/2021
Ultima Alteracao: 23/03/2021
Nome.....: Principal.cpp
Funcao...: Arvore genealogica com fork em C++
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/

#include <unistd.h>
#include <iostream>
#include <time.h>

using namespace std;

int main() {
    pid_t p_id;
    p_id = fork();
    
    switch(p_id){
        case -1:
        cout << "Erro";
        exit(EXIT_FAILURE);
        case 0:
        sleep(22); //22 segundos de execucao, idade do pai, nasce o primeiro filho
        cout << "Nasce o primeiro filho" << "\n";
        cout << "Processo filho: " << getpid() << "\n";
        cout << "Processo pai: " << getppid() << "\n";
        cout << endl;
        p_id = fork();
        switch(p_id){
            case -1: //todos os casos -1 sao erros, significa que o processo nao foi criado
            cout << "Erro";
            exit(1);
            case 0:
            sleep(16); //48 segundos de execucao (idade do pai) nasce o primeiro neto
            cout << "Nasceu o primeiro neto" << "\n";
            cout << "Processo filho: " << getpid() << "\n";
            cout << "Processo pai: " << getppid() << "\n";
            cout << endl;
            p_id = fork();
            switch(p_id){
                case -1:
                cout << "Erro";
                exit(1);
                case 0:
                sleep(30); //68 segundos de execucao (idade do pai) nasce o bisneto
                cout << "Nasceu o bisneto" << "\n";
                cout << "Processo filho: " << getpid() << "\n";
                cout << "Processo pai: " << getppid() << "\n";
                cout << endl;
                sleep(12); //morre o bisneto com 12 segundos de execucao
                cout << "O bisneto faleceu!" << "\n";
                cout << endl;
                exit(0);
            }
            sleep(35); //morre o primeiro neto, com 35 segundos de execucao
            cout << "O primeiro neto morreu!" << "\n";
            cout << endl;
            exit(0);
        }
        sleep(61); //morre o primeiro filho com 61 segundos de execucao
        cout << "Morreu o primeiro filho!" << "\n";
        cout << endl;
        exit(0);
        break;
        default:
        cout << "Nasceu pai: " << getppid() << "\n";
        cout << endl;
        p_id = fork();
        switch(p_id){
          case -1:
          cout << "Erro";
          exit(1);
          case 0:
          sleep(25); //32 segundos de execucao(idade do pai) nasce o terceiro filho
          cout << "Nasceu o segundo filho" << "\n";
          cout << "Processo filho: " << getpid() << "\n";
          cout << "Processo pai: " << getppid() << "\n";
          cout << endl;
          p_id = fork();
          switch(p_id){
              case -1:
              cout << "Erro";
              exit(1);
              case 0:
              sleep(20);//segundo neto nasce com
              cout << "Nasceu o segundo neto" << "\n";
              cout << "Processo filho: " << getpid() << "\n";
              cout << "Processo pai: " << getppid() << "\n";
              cout << endl;
              sleep(33);//morreu segundo neto com 33 segundos de execucao
              cout << "Morreu segundo neto" << "\n";
              cout << endl;
              exit(0);
          }
          sleep(55); //morre o terceiro filho com 55s de execucao
          cout << "Morreu segundo filho!" << "\n";
          exit(1);
        }
        p_id = fork();
        switch(p_id){
            case -1:
            cout << "Erro";
            exit(1);
            case 0:
            sleep(32);//nasceu terceiro filho com 32 segundos de execucao (idade do pai)
            cout << "Nasceu o terceiro filho" << "\n";
            cout << "Processo filho: " << getpid() << "\n";
            cout << "Processo pai: " << getppid() << "\n";
            cout << endl;
            sleep(55);// morreu o terceiro filho com 55 segundos de execucao
            cout << "Morreu terceiro filho" << "\n";
            cout << endl;
            exit(0);
    }
    sleep(90);//morreu pai apos 90 anos (90 segundos de execucao)
    cout << "Todos os filhos e netos ja haviam morrido, agora morre o pai";
    exit(0);
}
}