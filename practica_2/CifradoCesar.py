#! /usr/bin/env python
# -*- coding: utf-8 -*-

# El abecedario que vamos a utilizar
alfabeto = 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ'
# Los movimientos que vamos a hacer para el cifrado
 
# Pedimos la cadena a cifrar
cadena = str(raw_input("Introduce la cadena a cifrar: ")).upper()
 
clave = input("Introduce el numero de movimientos: ")
 
""" Función que se encarga de realizar el cifrado César
@ param cadena la cadena sobre la que va a actuar
@ param clave El número de movimientos que va a recorrerse la cadena """
def cesar(cadena, clave):
    # Aqui se guardara el resultado final
    cadenaCifrada = ""
    # Recorremos carácter por carácter la cadena que vamos a cifrar
    for caracter in cadena:
        if caracter == " ":
            cadenaCifrada += " "
        else: 
            # Buscamos la posición en el abecedario y le agregamos los movimientos
            pos = alfabeto.find(caracter) + clave
            # Le aplicamos la función mod sobre 26 en caso de que sobrepase el arreglo
            mod = int(pos)%26
            # Con la nueva posición la buscamos en el abecedario y la guardamos
            cadenaCifrada = cadenaCifrada+str(alfabeto[mod])
    return cadenaCifrada
 
c = cesar(cadena, clave)
 
#La cadena cifrada
print c
