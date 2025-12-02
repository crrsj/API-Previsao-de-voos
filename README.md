🚀 Backend do Previsor de Atrasos de Voo

Este é o módulo de backend do projeto que utiliza Java 21 e Spring Boot para hospedar uma API RESTful. Ele contém a lógica simulada de um modelo de Machine Learning para estimar a

probabilidade de um voo sair no horário ou ter atraso, baseada em fatores como companhia aérea, origem, destino e horário previsto.

🛠️ Tecnologias Utilizadas
Linguagem: Java 21

Framework: Spring Boot 3.x

Build Tool: Maven (ou Gradle)

Padrão: RESTful API (JSON)

Simulação ML: Lógica implementada diretamente no Controller.

📦 Estrutura do Projeto

O core da aplicação está contido nos seguintes pacotes e classes:

com.flightpredictor.model.FlightRequest: Objeto de requisição (DTO) para os dados de entrada do voo (Origem, Destino, Cia. Aérea, Horário).

com.flightpredictor.controller.PredictionController: Controlador principal que expõe o endpoint da API e contém a lógica de previsão simulada.

🚀 Backend do Previsor de Atrasos de VooEste é o módulo de backend do projeto que utiliza Java 21 e Spring Boot para hospedar uma API RESTful. 

Ele contém a lógica simulada de um modelo de Machine Learning para estimar a probabilidade de um voo sair no horário ou ter atraso, baseada em fatores como companhia aérea, origem, destino e horário previsto.

🛠️ Tecnologias UtilizadasLinguagem: Java 21Framework: Spring Boot 3.xBuild Tool: Maven (ou Gradle)Padrão: RESTful API (JSON)Simulação ML: Lógica implementada diretamente no Controller.

📦 Estrutura do ProjetoO core da aplicação está contido nos seguintes pacotes e classes:com.flightpredictor.model.FlightRequest: 

Objeto de requisição (DTO) para os dados de entrada do voo (Origem, Destino, Cia. Aérea, Horário).com.flightpredictor.controller.PredictionController: 

Controlador principal que expõe o endpoint da API e contém a lógica de previsão simulada.⚙️ Como ExecutarPara rodar o backend localmente, siga estes passos:Pré-requisitos: 

Certifique-se de ter o JDK 21 instalado.Compilação: Navegue até o diretório raiz do projeto backend e compile (usando Maven como exemplo):Bashmvn clean install

Execução: Inicie a aplicação Spring Boot. O comando abaixo irá executar o arquivo .jar gerado na pasta target/:Bashmvn spring-boot:run

O servidor estará disponível em http://localhost:8080.

💻 Endpoint da API, O frontend (ou qualquer cliente) deve enviar uma requisição POST para o seguinte endpoint:MétodoURLDescriçãoPOST/api/v1/predictEstima a chance de atraso de um voo.Exemplo de Requisição 
    (JSON)JSON{
    "airline": "GOL",
    "origin": "GRU",
    "destination": "CGH",
    "scheduledHour": 19
}
Exemplo de Resposta (JSON)JSON{
    "status": "ATRASO PROVÁVEL",
    "probability": "80.00%",
    "message": "Previsão baseada em fatores simulados de congestionamento e horário."
}


![voos1](https://github.com/user-attachments/assets/6182d714-4814-4c28-9563-bc53bbe8a64c)
