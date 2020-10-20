#! /usr/bin/env python
#-*- coding: utf-8 -*-
import Contacto

# Clase Agenda
class Agenda:
	def __init__(self):
		self.contactos = []
	
	'''
	* Agrega a una persona a la agenda.
	* @param contacto el contacto que se agregará a la agenda.
	'''
	def agregarContacto(self, contacto):
		self.contactos.append(contacto)
		self.guardarAgenda()
	
	'''
	* Busca personas a partir de su nombre o un fragmento de éste.
	* @param el nombre a partir del cual vamos a buscar.
	* @return los contactos cuyo nombre tienen el fragmento dado.
	'''
	def buscarContactos(self, nombre):
		contactosBuscados = []
		# Convertimos el nombre o fragemento a minúsculas
		# para que sea más fácil la comparación
		nombre = nombre.lower()
		
		# Buscamos entre los contactos
		for elem in self.contactos:
			# También convertimos los nombre entre los
			# contactos a minúsculas
			n = elem.getNombre().lower()
			
			# Si encontramos una coincidencia...
			if n.find(nombre) >= 0:
				# ... Lo agregamos a la lista de elem que coinciden
				contactosBuscados.append(elem)
		
		return contactosBuscados
		
	'''
	* Elimina una persona de la agenda.
	* Se podrá eliminar con el nombre completo de éste.
	* @param nombre el nombre de la persona que se va a eliminar.
	'''
	def eliminarContacto(self, nombre):
		
		# Convertimos el nombre o fragemento a minúsculas
		# para que sea más fácil la comparación
		nombre = nombre.lower()
		
		for elem in self.contactos:
			# También convertimos los nombre entre los
			# contactos a minúsculas
			e = elem.getNombre().lower() 
			
			# Si encontramos una coincidencia...
			if e == nombre:
				# ... Lo eliminamos
				self.contactos.remove(elem)
		
		# Actualizamos la agenda.
		self.guardarAgenda()
	
	'''
	* Dice si un contacto se encuentra dentro de la agenda dado su nombre.
	* @return True si el contacto si existe
	* 		  False en otro caso.
	'''
	def existeContacto(self, nombre):
		
		# Convertimos el nombre o fragemento a minúsculas
		# para que sea más fácil la comparación
		n = nombre.lower()
		
		for elem in self.contactos:
			# También convertimos los nombre entre los
			# contactos a minúsculas
			e = elem.getNombre().lower()
			
			# Si encontramos una coincidencia...
			if e == n:
				# ... Mandamos True
				return True
		return False
	
	'''
	* Edita la infomación de un contacto en la agenda.
	* Se podrá editar un contacto con el nombre completo de éste.
	* Se podrá editar nombre, teléfonos y/o correo.
	* @param nombre el nombre del contacto que vamos a editar.
	* @param persona la información de la persona cuya info se
	*		 va a editar.
	'''
	def editarContacto(self, p1, p2):
		p1.setNombre( p2.getNombre() )
		p1.setTelefono( p2.getTelefono() )
		p1.setCelular( p2.getCelular() )
		p1.setCorreo( p2.getCorreo() )
		self.guardarAgenda()
		print "¡Editado con éxito!\n"
	
	'''
	* Recupera un contacto dado su nombre.
	* @param el nombre del cuál recuperaremos sun información.
	* @return el contacto
	'''
	def recuperaContacto(self, nombre):
		n2 = nombre.lower()
		c = Contacto.Contacto("","","","")
		for elem in self.contactos:
			n1 = elem.getNombre().lower()
			if n1 == n2:
				c = Contacto.Contacto( elem.getNombre(), elem.getTelefono(), elem.getCelular(), elem.getCorreo() )
		return c
				
	'''
	* Muestra todos los contactos
	'''
	def verTodosContactos(self):
		contacts = ""
		
		# Condición por si la agenda esta vacía.
		if len(self.contactos) == 0:
			contacts= "No existen contactos en esta agenda.\n"
		# Si no está vacía, imprimimos los contactos
		for elem in self.contactos:
			contacts+= elem.toString()+"\n"
			
		return contacts
			
	'''
	* Borra todos los contactos de la agenda.
	'''
	def borrarTodosContactos(self):
		self.contactos = []
		self.guardarAgenda()
		
	'''
	* Guarda los datos de la agenda
	'''
	def guardarAgenda(self):
		f = open("agenda.txt", "w")
		contact = ""
		for c in self.contactos:
			contact+= c.toString()+"\n"
			
		f.write(contact+"#")
		f.close()
	
	'''
	* Carga los contactos que se encuentren en la agenda.
	'''
	def cargarDatosAgenda(self):
		f = open("agenda.txt", "r")
		line = f.readline()
		
		while( line != ""):
			if len(line)<1 or line[0]!="#":
				n = line[0:len(line)-1]
				line = f.readline()
				t = line[0:len(line)-1]
				line = f.readline()
				c = line[0:len(line)-1]
				line = f.readline()
				e = line[0:len(line)-1]
				
				contact = Contacto.Contacto(n, t, c, e)
				self.contactos.append(contact)
			line = f.readline()
		f.close()

a = Agenda()
a.cargarDatosAgenda()
