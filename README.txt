El programa consiste en la simulaci�n de una persona jugando. Nada mas iniciar 
le aparecen sus datos (todo estos simulados)uno de ellos su saldo disponible
para jugar.


La siguiente parte consistir�a en elegir un tiempo de juego, el cual se simula y se 
saca de la lista de juegos, cada juego dispone de una configuraci�n creada 
aleatoriamente.


Una vez en este punto, el jugador apuesta, si gana se le multiplica su saldo por el
premio x*� apostado, si pierde se le resta el dinero apostado. Se va mostrando en todo
momento el saldo y la ganancia o perdida. El juego finaliza cuando el jugador se queda
sin saldo.


**Se genera un archivo .txt en la carpeta transacciones del propio proyecto. Aqu�
se muestra un extracto de la partida, donde se refleja los movimientos de la cuenta.
Para que dicho archivo se cree se debe de cambiar la ubicaci�n dentro del c�digo, 
en el m�todo APUESTA del MenuController.


**Se aconseja abrir el fichero con Notepad++.