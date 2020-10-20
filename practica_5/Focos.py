#! /usr/bin/env python
#-*- coding: utf-8 -*-
'''
*** Juego de Mabu ***
Mabu es el encargado de encender y apagar las luces de un pasillo de una Universidad.
Mabu tiene una forma peculiar de encender y apagar las luces.
Si hay n focos en el pasillo, él lo recorre​ n veces.
En el i-­ésimo paseo pulsa únicamente los interruptores cuya posición sea divisible por i.
Al volver a la posición inicial no pulsa ningún interruptor.
El paseo i-­ésimo se define como el trayecto para llegar al final del pasillo (realizando su peculiar actividad) y  
volver al principio
Hay que averiguar si la último foco está encendido o apagado.
'''

# Clase Foco
class Foco:
	
	# Constructor de clase Foco
	# Su único atributo es su encendido y apagado
	def __init__(self):
		self.on = False
	
	'''
	* Nos dice si está encendido o no el foco.
	* @return yes si el foco están encendido.
	* 		  no en caso contrario.
	'''
	def estaEncendido(self):
		if self.on == True:
			return "yes"
		else:
			return "no"
	
	'''
	* Regresa el estado del foco
	* Los estados son: True si está encendido.
	* 				   False si está apagado.
	'''
	def getEncendido(self):
		return self.on
	
	'''
	* Cambia el estado de un foco.
	'''
	def setEncendido(self):
		if self.getEncendido()==True:
			self.on = False
		else:
			self.on = True

'''
* Nos dice si la posición del foco es divisible en
* el número del recorrido.
* @param recorrido el número de recorrido en el pasillo.
* @param pos la posición del foco.
* @return True si la posición del foco si es divisible.
* 		  False si no es divisible.
'''
def esDivisible(recorrido, pos):
		if pos%recorrido==0:
			return True
		else:
			return False

# Interacción con el usuario
num_focos = input("\n¿Cuántos focos se encuentran en el pasillo?: ")

while num_focos >= (2**32)-1:
	# Si se excede el número, se le avisará.
	print "Es imposible que un pasillo tenga "+str(num_focos)+"focos :P"
	num_focos = input("\n¿Cuántos focos se encuentran en el pasillo?: ")

# Si la entrada es un 0, no se procesa.
if num_focos==0:
	print ""
# Si sólo hay un foco, no está encendido.
elif num_focos==1:
	print "El último foco está encendido: no\n"
else:
	
	# Creamos un Foco que es el que se apagará y encenderá.
	foco = Foco()
	# Sabemos que la cantidad de focos en el pasillo será mayor a 2
	# dadas las condiciones que ingresamos antes.
	focos = 2
	# Sabemos que los recorridos serán mayores o iguales a 2.
	recorridos = 2
	
	#Comenzamos el recorrido
	while num_focos >= recorridos:
		# Comenzamos a checar los focos en el recorrido.
		while num_focos >= focos:
			# Si la pos del foco es divisble entre el no. del recorrido...
			if esDivisible(recorridos, focos)==True:
				# Pulsamos el interruptor en el foco.
				foco.setEncendido()
			# Nos pasamos al sig foco en el pasillo
			focos+=1
		# Realizamos otro recorrido.
		recorridos+= 1
	
	# Hacemos el recorrido de vuelta.
	while num_focos < recorridos:
		# Comenzamos a checar los focos en el recorrido.
		# Nos detendremos en el foco inicial
		while 1 < focos:
			# Si la pos del foco es divisble entre el no. del recorrido...
			if esDivisible(recorridos, focos)==True:
				# Pulsamos el interruptor en el foco.
				foco.setEncendido()
			# Nos pasamos al sig foco en el pasillo
			focos-=1
		# Realizamos otro recorrido.
		recorridos-= 1
	
	# Mostramos el resultado en pantalla.
	print "El último foco está encendido: " + foco.estaEncendido()+"\n"
