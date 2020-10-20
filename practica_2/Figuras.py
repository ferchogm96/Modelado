#! /usr/bin/env python
# -*- coding: utf-8 -*-

import math
 
#Clase para crear figuras geométricas
class Figura:
 
    #Constructor de la clase Figura
    def __init__(self, base):
        self.base = base
 
    """
    * Funciones get de la clase Figura
    """
    def getLado(self):
        return self.lado
 
#Clase para crear un triángulo equilátero, hereda de la clase Figura
class Triangulo(Figura):
     
    #Constructor de la clase Triángulo
    def __init__(self, base, altura):
        Figura.__init__(self, base)
        self.altura = altura
 
	"""
	* Función para calcular el perímetro del triángulo
    * El perímetro es la suma de los lados
    * @return peri el perímetro del triángulo.
    """
    def calculaPerimetro(self):
		peri = self.base*3
		return peri
 
    """
    Función para calcular el área de un triángulo
    * A = (b*a)/2
    * b = base
    * a = altura
    * @return area el área del triángulo.
    """
    def calculaArea(self):
        area = (self.base*self.altura)/2
        return area
		
#Clase para crear un Pentágono, hereda de la clase Figura.
class Pentagono(Figura):
 
    #Constructor de la clase Pentágono
    def __init__(self, base, apotema):
        Figura.__init__(self, base)
        self.apotema = apotema
        
    """
    * Función para calcular el perímetro del pentágono
    * El perímetro es la suma de los lados
    * @return peri el perímetro del pentágono.
    """
    def calculaPerimetro(self):
		peri = self.base*5
		return peri
 
    """
    * Función para calcular el área del pentágono
    * A = (P*h)/2
    * P = Perímetro | h = altura
    * @return area el área del pentágono.
    """
    def calculaArea(self):
        area = ((self.base*5)*self.apotema)/2
        return area
 
#Clase para crear un Trapecio, hereda de la clase Figura.
class Trapecio(Figura):
 
    #Constructor de la clase Trapecio
    def __init__(self, base, baseMenor, altura, lado1, lado2):
        Figura.__init__(self, base)
        self.baseMenor = baseMenor
        self.altura = altura
        self.lado1 = lado1
        self.lado2 = lado2
        
    """
    * Función para calcular el perímetro de un trapecio
    * El perímetro es la suma de los lados
    * @return peri el perímetro del trapecio.
    """
    
    def calculaPerimetro(self):
        peri = self.base + self.baseMenor + self.lado1 + self.lado2
        return peri
    """
	* Función para calcular el área de un Trapecio
	* A = ((B+b)*h)/2
	* B = Base mayor
	* b = Base menor
	* h = altura
	* @return area el área del trapecio.
	"""
    def calculaAreaTrapecio(self):
		area = ((self.base + self.baseMenor)*self.altura)/2
		return area
		
# Menú del programa
figura = raw_input("Menú de Figuras:\n  1.Triángulo Equilátero \n  2.Pentágono \n  3.Trapecio \nIntroduce la opción de la cual deseas su información: ").lower()

if(figura == "triangulo equilatero" or figura == "1"):
	base = input("Introduce la base del triángulo: ")
	altura = input("Introduce la altura del triángulo: ")
	triangulo = Triangulo(base, altura)
	print "El Triángulo tiene perímetro de: " + str(triangulo.calculaPerimetro()) + " cm. y área de: " + str(triangulo.calculaArea()) + " cm^2."

elif(figura == "pentagono" or figura == "2"):
	base = input("Introduce la base del pentágono: ")
	apotema = input("Introduce la apotema del pentágono: ")
	pentagono = Pentagono(base, apotema)
	print "El Pentágono tiene perímetro de: " + str(pentagono.calculaPerimetro()) + " cm. y área de: " + str(pentagono.calculaArea()) + " cm^2."

elif(figura == "trapecio"  or figura == "3"):
	baseMayor = input("Introduce la base mayor del trapecio: ")
	baseMenor = input("Introduce la base menor del trapecio: ")
	ladoA = input("Introduce el lado a del trapecio: ")
	ladoB = input("Introduce el lado faltante del trapecio: ")
	altura = input("Introduce la altura del trapecio: ")
	trapecio = Trapecio(baseMayor, baseMenor, altura, ladoA, ladoB)
	print "El Trapecio tiene perímetro de: " + str(trapecio.calculaPerimetro()) + " cm. y área de: " + str(trapecio.calculaAreaTrapecio()) +  " cm^2."    

else:
	print "Lo siento, la figura no se encuentra disponible en este menú."
