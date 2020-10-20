#! /usr/bin/env python
# -*- coding: utf-8 -*-
import os

"""
* Función para convertir grados Celcius (°C) a grados Fahrenheit (°F).
* @param grados los °C en los que se aplicará la conversión.
* @return los °C convertido a °F.
"""
def celciusToFahrenheit(grados):
	conversion = (grados*1.8) + 32
	return conversion

"""
* Función para convertir grados Celcius (°F) a grados Fahrenheit (°C).
* @param grados los °F en los que se aplicará la conversión.
* @return los °F convertido a °C.
"""	
def fahrenheitToCelcius(grados):
	conversion = (grados-32)/1.8
	return conversion	

# Mostramos el menú
# Y le solicitamos al usuario que ingrese una opción
opcion = raw_input("Selecciona una opción:\n  1. Pasar de °C a °F\n  2. Pasar de °F a °C\n  3. Salir\nIngresa la opción que deseas realizar: ")

if(opcion == "1"):
	gradosC = input("Ingresa la cifra que deseas convertir: ")
	print str(gradosC)+"°C = " + str(celciusToFahrenheit(gradosC)) + "°F\n"
elif(opcion == "2"):
	gradosF = input("Ingresa la cifra que deseas convertir: ")
	print str(gradosF)+"°F = "+ str(fahrenheitToCelcius(gradosF))+"°C\n"
elif(opcion== "3"):
	print "Gracias por usar este programa. Hasta luego.\n"
else:
	print "Lo siento, has ingresado algo incorrecto.\n"
