#! /usr/bin/env python
#-*- coding: utf-8 -*-

# Clase Contacto
class Contacto:
	
	'''
	* Constructor de la clase Contacto.
	* @param nombre el nombre del contacto.
	* @param telefono el número telefónico de casa del contacto.
	* @param celular el número celular del contaco.
	* @param correo el correo del contacto
	'''
	def __init__(self, nombre, telefono, celular, correo):
		self.nombre = nombre
		self.telefono = telefono
		self.celular = celular
		self.correo = correo
		
	'''
	* @return el nombre del contacto
	'''
	def getNombre(self):
		return self.nombre
	
	'''
	* @return el teléfono de casa del contacto.
	'''
	def getTelefono(self):
		return self.telefono
	
	'''
	* @return el teléfono celular del contacto.
	'''
	def getCelular(self):
		return self.celular
	
	'''
	* @return el correo del contacto.
	'''
	def getCorreo(self):
		return self.correo
	
	'''
	* Modifica el nombre del contacto.
	* @param nombre el nuevo nombre del contacto.
	'''
	def setNombre(self, nombre):
		self.nombre = nombre
	
	'''
	* Modifica el teléfono de casa del contacto.
	* @param telefono el nuevo teléfono de casa del contacto.
	'''
	def setTelefono(self, telefono):
		self.telefono = telefono
	
	'''
	* Modifica el celular del contacto.
	* @param celular el nuevo celular del contacto.
	'''
	def setCelular(self, celular):
		self.celular = celular
	
	'''
	* Modifica el correo del contacto.
	* @param correo el nuevo correo del contacto.
	'''
	def setCorreo(self, correo):
		self.correo = correo
	
	'''
	* Representación en cadena de la información de una persona.
	* @return la información de una persona.
	'''
	def toString(self):
		return "Nombre: "+self.getNombre()+"\nTeléfono: "+self.getTelefono()+"\nCelular: "+self.getCelular()+"\nCorreo: "+self.getCorreo()+"\n"
