#! /usr/bin/env python
# -*- coding: utf-8 -*-
import sys

"""
* Algoritmo InsertioSort
* Arregla los elementos de una lista de menor a mayor
* @param lista la lista que se va a ordenar
"""
def insertionSort(lista):
   for inicio in range(1, len(lista)):

     valor = alist[inicio]
     position = inicio

     while position>0 and lista[position-1] > valor:
         lista[position] = lista[position-1]
         position = position-1

     lista[position] = valor

#Bienvenida al usuario
print "Bienvenido\nIngresa el arreglo que desees ordenar\n"
print "Una vez que hayas terminado de ingresar tus datos, ingresa un -1"

#Lista donde agregaremos los datos del usuario
lista = []
booleano = True

try:
	while booleano:
		dato = input("Elemento: ")
		#Si el usuario ingresa el -1, comenzamos a ordenar la lista
		if dato==-1:
			print "\nTu lista original: "
			print(lista)
			insertionSort(lista)
			print "\nTu lista ordenada: "
			print(lista)
			sys.exit(0)
		#En caso de que se ingrese un número negativo, saldrá.
		elif dato<(-1):
			"Dato inválido"
			sys.exit(0)
		#Mientras no ingrese un -1, los datos se seguirán ingresando en la lista
		else:
			lista.append(dato)
except:
	print "Ingresaste un dato incorrecto."
