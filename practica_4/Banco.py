#-*- coding: utf-8 -*-
import time
import random

class Ventanilla:
	
	'''
	* Ventanilla vacía
	'''
	def __init__(self):
		self.items = []
	
	'''
	* Una persona ingresa a la ventanilla
	* @param p la persona que ingresa a la ventanilla
	'''
	def ingresaPersona(self, p):
		self.items.append(p)
		
	'''
	* Una persona sale de la ventanilla
	* @param p la persona que sale de la ventanilla
	'''
	def salePersona(self, p):
		self.items.remove(p)
	
	'''
	* Regresa la persona que está en la ventanilla
	'''
	def getPersona(self):
		return self.items[0]
		
	'''
	* Nos dice si una ventanilla está desocupada.
	* @return True si n=1
	* 		  False en otro caso
	'''
	def ventanillaDesocupada(self):
		return self.items == []
		
class Persona:
	
	'''
	* Constructor de Ventanilla
	* @param persona la persona que está en la ventanilla
	* @param solicitud la solicitud de la persona
	* @param el tiempo que se va a tardar en ventanilla
	'''
	def __init__(self, persona, solicitud, tardanza):
		self.persona = persona
		self.solicitud = solicitud
		self.tardanza = tardanza
	
	'''
	* El nombre de la persona
	* @return la persona
	'''
	def getPersona(self):
		return self.persona
	
	'''
	* La solicitud de la personas
	* @return la solicitud
	'''
	def getSolicitud(self):
		return self.solicitud
	
	'''
	* El tiempo que la persona ocupará la ventanilla
	* @return el tiempo de tardanza
	'''
	def getTardanza(self):
		return self.tardanza
	
	'''
	* Modificamos el tiempo que la persona ocupará la ventanilla.
	* @param el nuevo tiempo
	'''
	def setTardanza(self, t):
		self.tardanza = t
		
	'''
	* La representación en cadena de la persona
	'''
	def toString(self):
		return self.getPersona() + " | Solicitud: " + self.getSolicitud() + " Tardará: "+ str(self.getTardanza())+" min. | "

'''
* Función que asigna una solicitud a una persona
* Sólo hay 4 opciones: Transacción, Retiro, Pago
* 					   Creación de cuenta bancaria
* @param ran un número que ayudará a asignar la solicitud.
* @return la solicitud.
'''
def asignarSolicitud(ran):
	if ran==1:
		return "Transacción"
	if ran==2:
		return "Retiro"
	if ran==3:
		return "Pago"
	if ran==4:
		return "Creación de Cuenta Bancaria"

'''
* Ayudará a representar en cadena cuando una ventanilla esté llena.
* @param p la persona que está ocupando la ventanilla.
* @param ventanilla ventanilla donde se encuentra la persona.
* @param n el no. de ventanilla donde se encuentra la persona.
'''
def ventLlena(p, ventanilla, n):
	if p.getPersona()=="":
		return "" 
	if ventanilla.ventanillaDesocupada() == True:
		return ""
	# Si a la persona aún sigue siendo atendida, se imprimirá en pantalla
	if p.getTardanza() > 0:
		return "\t"+p.getPersona() + " en ventanilla " + str(n)
	# Si a la persona ya fue atendida, se imprimirá en pantalla
	elif p.getTardanza() == 0:
		ventanilla.salePersona(p)
		return "\t"+p.getPersona() + " sale de ventanilla "+ str(n)

# Creamos las 3 ventanillas
v1 = Ventanilla()
v2 = Ventanilla()
v3 = Ventanilla()

# En el banco, el máximo no. de personas que serán atendidas serán 3
p1 = Persona("", "", 0)
p2 = Persona("", "", 0)
p3 = Persona("", "", 0)

hora = 11 #Hora del banco
minutos = 0 #Minutos del banco

fila_espera = []

# Como el banco sólo atenderá por hora y media,
# y una persona llega cada 2 minutos, el banco,
# únicamente atenderán a 45 personas.
# Crearemos una lista de espera de 45 personas.
for i in range(1, 46):
	# Asignamos la solicitud de la persona
		s = random.randrange(4)+1
		# Asignamos un tiempo de tardanza
		t = random.randrange(15)+1
		# Creamos una instancia de persona
		p = Persona("Persona"+str(i), asignarSolicitud(s), t)
		# Lo agregamos a la lista de espera
		fila_espera.append(p)

# Mientras haya gente en la fila, el banco seguirá atendiendo.
while ( (minutos<90) or len(fila_espera) != 0) or ( v1.ventanillaDesocupada()==True or v2.ventanillaDesocupada()==True or v3.ventanillaDesocupada()==True ):
	cadena = ""
	
	# Se atenderá mientras haya personas en la fila...
	if(len(fila_espera) != 0):
		# ... Y mientras alguna ventanilla esté desocupada
		if( v1.ventanillaDesocupada()==True or v2.ventanillaDesocupada()==True or v3.ventanillaDesocupada()==True ):
			# La persona siguiente en la fila pasará a...
			# ... la ventanilla 1 si está desocupada, sino, pasará a...
			if v1.ventanillaDesocupada():
				p1 = fila_espera.pop(0)
				v1.ingresaPersona(p1)
				cadena = p1.toString()+" En ventanilla: 1"
			
			# ... la ventanilla 2 si está desocupada, sino, pasará a...
			elif v2.ventanillaDesocupada():
				p2 = fila_espera.pop(0)
				v2.ingresaPersona(p2)
				cadena = "Ingresa: "+p1.toString()+" En ventanilla: 2"
				
			# la ventanilla 3.
			else:
				p3 = fila_espera.pop(0)
				v3.ingresaPersona(p3)
				cadena = p1.toString()+" En ventanilla: 3"
			
	# El reloj del banco
	reloj = ""
	if minutos%60 == 0:
		hora = hora+1
		minutos = 0
	if minutos%60 < 10:
		reloj = str(hora)+":0"+str(minutos)+" -> "
	else:
		reloj = str(hora)+":"+str(minutos)+" -> "
	
	salida = ""
	# Se imprimirá en pantalla lo que sucede en las 3 ventanillas.
	salida = reloj + cadena + "\n" + ventLlena(p1, v1, 1) + "\n" + ventLlena(p2, v2, 2) + "\n" + ventLlena(p3, v3, 3)
	print salida
	
	# Reducimos la tardanza de las 3 personas que están siendo atendidas
	p1.setTardanza( p1.getTardanza()-1 )
	p2.setTardanza( p2.getTardanza()-1 )
	p3.setTardanza( p3.getTardanza()-1 )
	
	# Pausamos el tiempo 1 segundo
	time.sleep(1)
	
	# El reloj del banco sigue su curso
	minutos+=1
