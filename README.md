# MarvelApi - App Android

> Projeto voltado para apresentação no curso de Mobile.

O desafio era criar consumir a API da marvel e criar uma interface onde o usuário possa ver seu personagem.
Quando o usuário selecionar um dos personagens mostrará seus detalhes.

## Para Utilizar

Para o funcionamento do projeto é necessário tomar alguns cuidados:

* Colocar o projeto no android para rodar;


* Você terá que criar uma conta na [Marvel](https://www.marvel.com/signin?referer=https://developer.marvel.com/) e pegar sua chave pública e privada.

    1. Deverá trocar na classe AutenticacaoAPI;

    ![](/gif/1.png)


* Assim o projeto estará funcionando;

## Linguagens e Ferramentas Utilizadas

Foi utilizado o site da marvel como apoio [Developer Marvel](https://developer.marvel.com/)
onde foi pesquisado todos seus EndPoints, como montar o url, e como seria o retorno do json.

* Exemplo de uma url: __http://gateway.marvel.com/v1/public/entidade?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150__.

No Mobile foi utilizado:

* o Android Studio como IDE;
* JAVA para criação do aplicativo;
* AsyncTask para consumir;
* GSON para transformar o json em Object;
* A biblioteca Glide para renderizar imagem.

E o resultado foi:

![](/gif/gifApp.gif)

# 

Criado em 29/11/2019.

Jean Cigoli de Almeida