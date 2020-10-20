#! /usr/bin/env python
#-*- coding: utf-8 -*-
import sys
import Agenda
import Contacto

a = Agenda.Agenda()
try:
	a.cargarDatosAgenda()
except IOError:
	a = Agenda.Agenda()

'''
* Válida que la estructura del nombre ingresada por el usuario sea válida.
* return True si la longitud del nombre es > 2
* 		 False en otro caso.
'''
def validaNombre(n):
	if len(n) > 2:
		return True
	else:
		return False

'''
* Válida que la estructura del télefono ingresado por el usuario sea válido.
* return True si la longitud télefono tiene 8 dígitos
* 		 False en otro caso.
'''
def validaTel(t):
	if (len(t) == 8):
		return True
	else:
		return False
'''
* Válida que la estructura del celular ingresado por el usuario sea válido.
* return True si la longitud télefono tiene 10 dígitos.
* 		 False en otro caso.
'''
def validaCel(c):
	if (len(c) == 10):
		return True
	else:
		return False
	
'''
* Válida que la estructura del correo ingresado por el usuario sea válido.
* return True si el correo contiene '@'
* 		 False en otro caso.
'''
def validaCorreo(e):
	if (e.find('@', 0, len(e))) > 0:
		return True
	else:
		return False

'''
* Ayudará al usuario a agregar contactos a la agenda.
'''
def auxAgregar():
	n = raw_input("Ingresa el nombre: ")
	t = raw_input("Ingresa teléfono de casa: ")
	c = raw_input("Ingresa celular: ")
	e = raw_input("Ingresa correo: ")
	
	if( validaNombre(n) and validaTel(t) and validaCel(c) and validaCorreo(e)):
		persona = Contacto.Contacto(n, t, c, e)
		a.agregarContacto(persona)
		print "\n¡Agregado con éxito!"
		menu()
	else:
		print "Ingresaste algún/algunos dato(s) de manera incorrecta. Verifícalos."
		menu()

'''
* Ayudará al usuario a buscar contactos a la agenda.
'''
def auxBuscar():
	n = raw_input("Ingresa el nombre que deseas buscar: ")
	buscados = a.buscarContactos(n)
	if ( len(buscados) == 0):
		print "No existen contactos en esta agenda con el nombre que ingresaste.\n"
	else:
		for elem in buscados:
			print elem.toString()+"\n"
	menu()
'''
* Ayudará al usuario a eliminar a algún contacto a la agenda.
'''
def auxEliminar():
	n = raw_input("Ingresa el nombre que deseas eliminar: ")
	
	if (a.existeContacto(n))==True:
		# Se le avisa el usuario que una vez eliminado un elemento, será imposible recuperarlo
		print "¿Estás seguro de querer eliminar este contacto.\nLa decisión es irreversible."
		resp = raw_input("Si/No: ")
		if resp.lower()=="si":
			a.eliminarContacto(n)
	else:
		print "Estás queriendo eliminar un contacto que no existe."
	menu()

'''
* Ayudará al usuario a editar un contacto a la agenda.
'''
def auxEditar():
	p1 = raw_input("Introduce el nombre completo de la persona cuya info quieres cambiar: ")
	
	# Si el nombre que ingreso el usuario se encuentra en la agenda
	# Se procederá con su edición
	if (a.existeContacto(p1))==True:
		p = a.recuperaContacto(p1)
		
		nuevo_nombre = raw_input("Ingresa el nuevo nombre: ")
		# Mientras el nombre no sea válido, se repetirá la pregunta
		while( validaNombre(nuevo_nombre)!=True ):
			print "Nombre inválido (Mínimo 3 carácteres)"
			nuevo_nombre = raw_input("Ingresa el nuevo nombre: ")
			
		nuevo_tel = raw_input("Ingresa el nuevo número teléfonico (De casa): ")
		# Mientras el teléfono no sea válido, se repetirá la pregunta
		while( validaTel(nuevo_tel)!=True ):
			print "Número inválido (Tiene que tener 8 dígitos)"
			nuevo_tel = raw_input("Ingresa el nuevo número teléfonico (De casa): ")
			
		nuevo_cel = raw_input("Ingresa el nuevo número de celular: ")
		# Mientras el celular no sea válido, se repetirá la pregunta
		while( validaCel(nuevo_cel)!=True ):
			print "Número inválido (Tiene que tener 10 dígitos)"
			nuevo_cel = raw_input("Ingresa el nuevo número de celular: ")
			
		nuevo_correo = raw_input("Ingresa el nuevo correo: ")
		# Mientras el correo no sea válido, se repetirá la pregunta
		while( validaCorreo(nuevo_correo)!=True ):
			print "Correo eléctronio inválido"
			nuevo_correo = raw_input("Ingresa el nuevo correo: ")
			
		p2 = Contacto.Contacto(nuevo_nombre, nuevo_tel, nuevo_cel, nuevo_correo )
		a.editarContacto(p, p2)
		
	else:
		print "El contacto que ingresaste no se encuentra en la agenda."
	menu()

'''
* Ayudará al usuario a ver todos los contactos a la agenda.
'''
def auxVerTodos():
	print a.verTodosContactos()
	menu()

'''
* Ayudará al usuario a borrar la agenda.
'''
def auxBorrarTodos():
	try:
		print "¿Estás seguro que quieres eliminar todos los contactos de la agenda?\n"
		print "Está opción es irreversible.\n"
		resp = raw_input("Si/No: ")
		resp = resp.lower()
		if resp == "si":
			a.borrarTodosContactos()
			print "\nLa agenda no tiene ningún contacto."
	except ValueError:
		print "Ingresaste una opción inválida."
	
	menu()

'''
* Dependiendo de la opción del usuario, lo mandará a otro método que lo
* ayudará con su solicitud.
* Si la opción excede el número 6, se le mandará un mensaje de advertencia
* al usuario.
'''
def escogeOpcion(opcion):
	if opcion > 7:
		print "Sólo existen 6 opciones."
	if opcion == 1:
		auxAgregar()
	elif opcion == 2:
		auxBuscar()
	elif opcion == 3:
		auxEliminar()
	elif opcion == 4:
		auxEditar()
	elif opcion == 5:
		auxVerTodos()
	elif opcion == 6:
		auxBorrarTodos()
	else:
		print "¡Hasta luego!"
		sys.exit(1)

'''
* Menú de bienvenida al usuario.
* También, válida la opción ingresada por el usuario una vez que se le presentó el menú.
* Si la opción es distinta a un Integer, lanzará una excepción al usuario.
* La opción ingresada por el usuario forzosamente tiene que ser un Integer.
'''
def menu():
	try:
		print "1. Agregar contacto\n2. Buscar contacto\n3. Eliminar contacto\n4. Editar contacto"
		print "5. Ver todos los contactos\n6. Borrar todos los contactos de la agenda\n7. Salir.\n"
		opcion = input("Por favor, ingresa una opción: ")
		escogeOpcion(opcion)
	except ValueError:
		print "¡OJO! Debes que ingresar una opción númerica."

print "\nBienvenido a esta agenda.\n"
menu()

