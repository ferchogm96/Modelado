#-*- coding: utf-8 -*-
import random

#Clase creadora de Frutas
class Fruta:
	
	'''
	* Constructor de Fruta.
	* @param tamanho el tamaño de la fruta.
	* @param color el color de la fruta.
	'''
	def __init__(self, tamanho, color):
		self.tamanho = tamanho
		self.color = color
	
	'''
	* @return el tamaño de la fruta.
	'''
	def getTamanho(self):
		return self.tamanho
		
	'''
	* @return el color de la fruta.
	'''
	def getColor(self):
		return self.color

#Clase Fresa hereda de Fruta
class Fresa(Fruta):
	
	'''
	* Constructor de Fresa.
	* @param tamanho el tamaño de la fresa.
	* @param color el color de la fresa.
	* @param sabor el sabor de la fresa
	'''
	def __init__(self, tamanho, color, sabor, conCascara):
		Fruta.__init__(self, tamanho, color)
		self.sabor = sabor
		self.conCascara = conCascara
		
	'''
	* @return el tipo de la fruta.
	'''
	def getTipoFruta(self):
		return "fresa"
	
	'''
	* @return el sabor de la fresa.
	'''
	def getSabor(self):
		return self.sabor
		
	'''
	* Imprime en pantalla la información de la fresa
	'''
	def toString(self):
		return "Fresa "+self.color+" "+self.tamanho+" "+self.sabor+""

#Clase Mango hereda de Fruta
class Mango(Fruta):
	
	'''
	* Constructor de Mango.
	* @param tamanho el tamaño del mango.
	* @param color el color del mango.
	* @param sabor el sabor del mango.
	'''
	def __init__(self, tamanho, color, sabor, conCascara):
		Fruta.__init__(self, tamanho, color)
		self.sabor = sabor
		self.conCascara = conCascara
		
	'''
	* @return el tipo de la fruta.
	'''
	def getTipoFruta(self):
		return "mango"
		
	'''
	* @return el sabor del mango.
	'''
	def getSabor(self):
		return self.sabor
	
	'''
	* Imprime en pantalla la información del mango.
	'''
	def toString(self):
		return "Mango "+self.color+" "+self.tamanho+" "+self.sabor+"."

#Clase Sandia hereda de Fruta
class Sandia(Fruta):
	
	'''
	* Constructor de Sandía.
	* @param tamanho el tamaño de la sandía.
	* @param color el color de la sandía.
	* @param sabor el sabor de la sandía.
	'''
	def __init__(self, tamanho, color, sabor, conCascara):
		Fruta.__init__(self, tamanho, color)
		self.sabor = sabor
		self.conCascara = conCascara
	
	'''
	* @return el tipo de la fruta.
	'''
	def getTipoFruta(self):
		return "sandia"
	
	'''
	* @return el sabor de la sandia.
	'''
	def getSabor(self):
		return self.sabor
	
	'''
	* Imprime en pantalla la información de la sandía.
	'''
	def toString(self):
		return "Sandía "+self.color+" "+self.tamanho+" "+self.sabor+"."

#Clase Toronja hereda de Fruta
class Toronja(Fruta):
	
	'''
	* Constructor de Toronja.
	* @param tamanho el tamaño de la toronja.
	* @param color el color de la toronja.
	* @param sabor el sabor de la toronja.
	'''
	def __init__(self, tamanho, color, sabor, conCascara):
		Fruta.__init__(self, tamanho, color)
		self.sabor = sabor
		self.conCascara = conCascara
	
	'''
	* @return el tipo de la fruta.
	'''
	def getTipoFruta(self):
		return "toronja"
	
	'''
	* @return el sabor de la toronja.
	'''
	def getSabor(self):
		return self.sabor
	
	'''
	* Imprime en pantalla la información de la fresa
	'''
	def toString(self):
		return "Toronja "+self.color+" "+self.tamanho+" "+self.sabor+"."

'''
* Función que asigna el sabor a una fruta.
* @param ran un número que ayudará a asignar el sabor.
* @return el sabor.
'''
def asignaSabor(ran):
	if ran==1:
		return "Dulce"
	if ran==2:
		return "Ácido"
	if ran==3:
		return "Amargo"

'''
* Función que asigna el color a una fruta.
* Sólo hay 6 colores: Amarillo, Rojo, Azul
* 					  Verde, Anaranajdo y Púrpura
* @param ran un número que ayudará a asignar el color.
* @return el color.
'''
def asignaColor(ran):
	if ran==1:
		return "Amarillo"
	if ran==2:
		return "Rojo"
	if ran==3:
		return "Azul"
	if ran==4:
		return "Verde"
	if ran==5:
		return "Anaranjado"
	if ran==6:
		return "Púrpura"
	
'''
* Función que asigna el tamaño a una fruta.
* Sólo hay 3 tamaños: Grande, Mediano y Pequeño
* @param ran un número que ayudará a asignar el tamaño.
* @return el tamaño.
'''
def asignaTamanho(ran):
	if ran==1:
		return "Grande"
	if ran==2:
		return "Mediano"
	if ran==3:
		return "Pequeño"
'''
* Dice si una fruta está contenida en una canasta de frutas.
* @param canasta la canasta de frutas donde vamos a buscar.
* @param fruta la fruta que vamos a buscar.
* @return True si la fruta si está contenida.
* 		  False en otro caso.
'''
def contiene(canasta, fruta):
	for i in range(0, len(canasta)):
		elem = canasta[i]
		if elem.getTipoFruta()==fruta:
			return True
		return False
	
'''
* Revuelve las frutas que se encuentre en dos canastas.
* @param canasta1 la primera canasta que vamos a revolver.
* @param canasta2 la segunda canasta que vamos a revolver.
* @return la canasta revuelta con frutas distintas.
'''

def revuelve(canasta1, canasta2):
	canasta_mixta = []
	
	#Vamos agregando 1x1
	i = 0
	j = 0
	
	while i<len(canasta1):
		while j<len(canasta2):
			elem1 = canasta1[i]
			elem2 = canasta2[j]
			canasta_mixta.append(elem1)
			canasta_mixta.append(elem2)
			canasta1.remove(elem1)
			canasta2.remove(elem2)
	
	return canasta_mixta

'''
* Quita las frutas pequeñas o cuyo sabor se amargo o ácido.
* @param canasta la canasta que vamos a 'limpiar'
* @return una nueva canasta con frutas de sabor dulce y tamaño
* grande o mediano.
'''
def limpia(canasta):
	nueva_canasta = []
	for i in range(0, len(canasta)):
		elem = canasta[i]
		if elem.getSabor()=="Dulce":
			if (elem.getTamanho()=="Grande"):
				nueva_canasta.append(elem)
			elif(elem.getTamanho()=="Mediano"):
				nueva_canasta.append(elem)
	return nueva_canasta
		
'''
* Imprime la canasta de frutas en pantalla.
'''
def imprimeCanasta(canasta, fruta):
	cadena = ""
	cadena+= "\nCanasta de "+fruta+":\n"
	for i in range(0, len(canasta)):
		elem = canasta[i]
		cadena+= elem.toString()+" - "
	return cadena

#Nuestras canasta vacías
canasta_fresas = []
canasta_mangos = []
canasta_sandias = []
canasta_toronjas = []

#Comenzamos a llenar la canasta de fresas.
i = 0
while i<6:
	# Número aleatorio para asignar el tamaño
	t = random.randrange(3)+1
	# Número aleatorio para asignar el color
	c = random.randrange(6)+1
	# Número aleatorio para asignar el sabor
	s = random.randrange(3)+1
	
	fresa = Fresa(asignaTamanho(t), asignaColor(c), asignaSabor(s), True)
	canasta_fresas.append(fresa)
	i+=1

#Comenzamos a llenar la canasta de mangos.
i = 0
while i<6:
	t = random.randrange(3)+1
	c = random.randrange(6)+1
	s = random.randrange(3)+1
	
	mango = Mango(asignaTamanho(t), asignaColor(c), asignaSabor(s), False)
	canasta_mangos.append(mango)
	i+=1

#Comenzamos a llenar la canasta de sandías
i = 0
while i<6:
	t = random.randrange(3)+1
	c = random.randrange(6)+1
	s = random.randrange(3)+1
	
	sandia = Sandia(asignaTamanho(t), asignaColor(c), asignaSabor(s), False)
	canasta_sandias.append(sandia)
	i+=1
	
#Comenzamos a llenar la canasta de toronjas
i = 0
while i<6:
	t = random.randrange(3)+1
	c = random.randrange(6)+1
	s = random.randrange(3)+1
	
	toronja = Toronja(asignaTamanho(t), asignaColor(c), asignaSabor(s), False)
	canasta_toronjas.append(toronja)
	i+=1
	
# Imprimimos la canasta de fresas
print (imprimeCanasta(canasta_fresas, "fresas"))
# Imprimos la canasta de fresas limpia
print (imprimeCanasta(limpia(canasta_fresas), "fresas"))

# Imprimimos la canasta de mangos
print (imprimeCanasta(canasta_mangos, "mangos"))
# Imprimos la canasta de mangos limpia
print (imprimeCanasta(limpia(canasta_mangos), "mangos"))


# Preguntamos si la canasta de mangos tiene una fresa
print (contiene(canasta_mangos, "fresa") )
#Revolvemos la canasta de fresas con la canasta de mangos
print ( imprimeCanasta( revuelve(canasta_fresas, canasta_mangos ), "fresas y mangos" ) )

# Imprimimos la canasta de sandias
print (imprimeCanasta(canasta_sandias, "sandias"))
# Imprimos la canasta de sandias limpia
print (imprimeCanasta(limpia(canasta_sandias), "sandias"))

# Imprimimos la canasta de toronjas
print (imprimeCanasta(canasta_toronjas, "toronjas"))
# Imprimos la canasta de toronjas limpia
print (imprimeCanasta(limpia(canasta_toronjas), "toronjas"))
