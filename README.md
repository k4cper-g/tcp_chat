# tcp-chat
TCP multi-user chat with Swing UI written in Java.

PL
----
Projekt wykorzystuje język programowania Java do stworzenia interfejsu za pomocą którego możemy utworzyć serwer, lub dołączyć do już istniejącego.
Implementacja wątków pozwala na obsługę poszczególnych użytkowników.
Serwer jest jednocześnie użytkownikiem. 
Do łączenia użyte zostały gniazda java.net.Socket oraz java.net.ServerSocket.

Zaimplementowane zostały 4 wątki:

1) Wątek serwerowy - pozwala na prace serwera w tle podczas gdy korzystamy z UI.
2) Wątek UserHandler - pozwala na obsługę wielu klientów na raz.
3) Wątek ClientWriter - pozwala na zapis danych klient->serwer.
4) Wątek ClientReader - pozwala na odczyt danych serwer->klient.

ENG
----
This project uses Java to create an interface that allows us to make a server, or join an existing one.
Implementation of threads allows for handling individual users. 
The server is also a user. 
Java.net.Socket and java.net.ServerSocket sockets were used for connection.

There are 4 threads implemented:

1) Server thread - allows the server to work in the background while we use the UI.
2) UserHandler thread - allows for handling multiple clients at once.
3) ClientWriter thread - allows for writing data from client to server.
4) ClientReader thread - allows for reading data from server to client.
