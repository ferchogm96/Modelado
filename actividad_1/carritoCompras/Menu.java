import java.awt.Color;
import javax.swing.JOptionPane; 
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField; 
import javax.swing.JPasswordField; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Menu extends JFrame   {

   private String nombreArchivo="almacen.ser";
   private String infoAdmin = "info_admin.ser";
   ArrayList<Producto> almacen = new ArrayList<Producto>();
   Administrador administrador = new Administrador();
   JTabbedPane panelFichas = new JTabbedPane(); 
   

   public Menu() {
 
      super( "Almacen de abarrotes " );
      almacen = leerProductos();
//      administrador = leerInfo();
      ponPestaniaAgregar();
      ponPestaniaVerTodo();
      ponPestaniaBusqueda();
      ponPestaniaBorrar();
      ponPestaniaEditar();
 //    ponPestaniaCambiarInfo();
      ponPestaniaSalir();
      add( panelFichas ); // agrega objeto JTabbedPane al marco
   } // fin del constructor de MarcoJTabbedPane


   public void ponPestaniaAgregar() {

      Icon imagen = new ImageIcon(  "carrito.jpg"  );
      JLabel estampa = new JLabel(imagen);      
      //Etiquetas de los mensajes
      JLabel label0 = new JLabel("Rellena la siguiente información");
      JLabel label1 = new JLabel("Código de barras");
      JLabel label2 = new JLabel("Nombre del producto");
      JLabel label3 = new JLabel("Precio del producto");
      JLabel label4 = new JLabel("Cantidad de piezas");

      //Áreas de texto
      JTextField codigoBarrasProducto = new JTextField();
      JTextField nombreProducto = new JTextField();
      JTextField precioProducto = new JTextField();
      JTextField cantidadProducto = new JTextField();

      //Botón de envío
      JButton boton_registro = new JButton("Aceptar");
     
      JPanel panel1 = new JPanel(new GridLayout(1,2));
      JPanel panel_1 = new JPanel(new GridLayout(6,2,-100,30));
      panel_1.add(label0);
      panel_1.add(new JLabel(""));
      panel_1.add(label1);
      panel_1.add(codigoBarrasProducto);
      panel_1.add(label2);
      panel_1.add(nombreProducto);
      panel_1.add(label3);
      panel_1.add(precioProducto);
      panel_1.add(label4);
      panel_1.add(cantidadProducto);
      panel_1.add(new JLabel(""));
      panel_1.add(boton_registro);
      
      panel1.add(panel_1);
      panel1.add(estampa);

      
      boton_registro.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {                                   
            String codigoB=codigoBarrasProducto.getText();
            String nombre =nombreProducto.getText();
            double precio = Double.parseDouble(precioProducto.getText());
            int cantidad = Integer.parseInt(cantidadProducto.getText());

            if( existeCodigo(codigoB) ){
               JOptionPane.showMessageDialog(null, "El código de barras ya le pertenece a otro producto", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                 boolean se_pudo = agregaNuevoProducto(codigoB, nombre, precio, cantidad);
                 if(se_pudo)
                    JOptionPane.showMessageDialog(null, "Producto agregado exitosamente ", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                 else
                    JOptionPane.showMessageDialog(null, "Ocurrió un error ", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
         }
      });                                     
      panelFichas.addTab( "Agregar Artículo", panel1);
   }

   public void ponPestaniaVerTodo() {
      // PESTAÑA DE VER Todo
      JLabel todo = new JLabel();
      JPanel panel = new JPanel(new GridLayout(1,2)); 
      JButton boton_ver = new JButton("Actualizar inventario y Ver Todo");
      panel.add(boton_ver);
      
      boton_ver.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {                                   
           String respuesta="<html>";
            for(int i=0; i<almacen.size(); i++) {
               respuesta+="<br>"+almacen.get(i);
            } 
            respuesta+="</html>";    
            todo.setText(respuesta); 
         }                       
      });     
       
      panel.add(todo);
      panelFichas.addTab( "Ver todo", null, panel);
   }

   public void ponPestaniaBusqueda() {

      // PESTAÑA DE BUSQUEDA
      Icon imagen = new ImageIcon( "busqueda.jpg"  );
      JLabel estampa = new JLabel(imagen); 

      JPanel panel = new JPanel(new GridLayout(1,2)); 
      JPanel panel_1 = new JPanel(new GridLayout(5,2,-100,30));

      //Etiquetas de los mensajes
      JLabel label_b0 = new JLabel("Llena alguno de los sig. campos");
      JLabel label_b1 = new JLabel("Código de barras");
      JLabel label_b2 = new JLabel("Nombre del producto");
      JLabel label_b3 = new JLabel("Precio del producto");
   
      //Áreas de texto
      JTextField search = new JTextField();
      JTextField search_nombre = new JTextField();
      JTextField search_cb = new JTextField();
      JTextField search_precio = new JTextField();

      //botón
      JButton boton_busqueda = new JButton("Buscar");

      panel_1.add(label_b0);
      panel_1.add(new JLabel(""));
      panel_1.add(label_b2);
      panel_1.add(search_nombre);
      panel_1.add(label_b1);
      panel_1.add(search_cb);
      panel_1.add(label_b3);
      panel_1.add(search_precio);
      panel_1.add(new JLabel(""));
      panel_1.add(boton_busqueda);
      panel.add(panel_1 ); 
      panel.add(estampa);  

      boton_busqueda.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {                                   
            String busqueda_nombre = search_nombre.getText();
            String busqueda_cb = search_cb.getText();
            String busqueda_precio = search_precio.getText();

            if( (busqueda_nombre.equals("")) && (busqueda_cb.equals("")) && (busqueda_precio.equals(""))   ){
                 JOptionPane.showMessageDialog(null, "Debes de rellenar al menos un campo", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            if( !(busqueda_nombre.equals("")) ){
                 String respuesta=buscaProductos(busqueda_nombre);
                 JOptionPane.showMessageDialog(null, respuesta, "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            }
            if ( !(busqueda_cb.equals("")) ){
                 String respuesta=buscaProductos(busqueda_cb);
                 JOptionPane.showMessageDialog(null, respuesta, "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            }
            if ( !(busqueda_precio.equals("")) ){
                 String respuesta=buscaProductos(busqueda_precio);
                 JOptionPane.showMessageDialog(null, respuesta, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
         }                       
      });  
   
      panelFichas.addTab( "Búsqueda de artículos", panel);

   }

   public void ponPestaniaEditar(){
      //Etiquetas de los mensajes para editar
      JLabel label_0 = new JLabel("Rellena la siguiente información");
      JLabel label_1 = new JLabel("Nombre del producto");
      JLabel label_3 = new JLabel("Precio del producto");
      JLabel label_4 = new JLabel("Cantidad de piezas");
      JLabel label_5 = new JLabel("Edita un producto");

      //Áreas de texto para editar
      JTextField nombreProducto = new JTextField();
      JTextField codigoBarras = new JTextField();
      JTextField nombreProd_edi = new JTextField();
      JTextField cb_edi = new JTextField();
      JTextField precio_edi = new JTextField();
      JTextField cantidad_edi = new JTextField();

      //Botón de envío
      JButton boton_envio = new JButton("Aceptar");
      JButton boton_registro = new JButton("Aceptar");
     
      JPanel panel = new JPanel(new GridLayout(1,2));

      JPanel panel_1 = new JPanel(new GridLayout(4,2,-100,30));
      panel_1.add(new JLabel("Rellena la siguiente información"));
      panel_1.add(new JLabel(""));
      panel_1.add(new JLabel("¿Qué producto deseas editar?"));
      panel_1.add(new JLabel(""));
      panel_1.add(new JLabel ("Código de barras"));
      panel_1.add(codigoBarras);
      panel_1.add(new JLabel(""));
      panel_1.add(boton_envio);
      
      JPanel panel_2 = new JPanel(new GridLayout(6,2,-100,30));
      panel_2.add(label_0);
      panel_2.add(new JLabel(""));
      panel_2.add(label_1);
      panel_2.add(nombreProd_edi);
      panel_2.add(label_3);
      panel_2.add(precio_edi);
      panel_2.add(label_4);
      panel_2.add(cantidad_edi);
      panel_2.add(new JLabel(""));
      panel_2.add(boton_registro);
      
      panel.add(panel_1);
      panel.add(panel_2);
      panel_2.setVisible(false);

      boton_envio.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evento) {
            String cb = codigoBarras.getText();                                   
            if( (cb.equals("")) )
                 JOptionPane.showMessageDialog(null, "Debes de llenar la información que se te pide", "ERROR", JOptionPane.ERROR_MESSAGE);
            else if (existeCodigo(cb)){
                 panel_2.setVisible(true);

                 boton_registro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evento) {
                         String nombre_editado = nombreProd_edi.getText();
                         String precio_editado = precio_edi.getText();
                         String piezas_editado = cantidad_edi.getText();
                         if( (nombre_editado.equals("")) && (precio_editado.equals("")) && (piezas_editado.equals("")) )
                              JOptionPane.showMessageDialog(null, "Debes de rellenar al menos un campo", "ERROR", JOptionPane.ERROR_MESSAGE);
                         else
                              if(editaProducto(cb, nombre_editado, precio_editado, piezas_editado)==true)
                              JOptionPane.showMessageDialog(null,"Producto editado","EXITO", JOptionPane.INFORMATION_MESSAGE);
                         else
                              JOptionPane.showMessageDialog(null, "No se pudo editar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);           
                    }
                });

           }else
                 JOptionPane.showMessageDialog(null, "El producto no se encuentra en el almacén", "ERROR", JOptionPane.ERROR_MESSAGE);            
         }                                 
      });

      

      panelFichas.addTab( "Edita artículos", panel);
   }

   public void ponPestaniaBorrar() {

      // PESTAÑA DE BORRADO
      Icon imagen = new ImageIcon("borrar.png");
      JLabel estampa = new JLabel(imagen); 

      JPanel panel = new JPanel(new GridLayout(1,2)); 
      JPanel panel_1 = new JPanel(new GridLayout(3,2,-80,30));
      //panel.setBackground(Color.YELLOW);
      Color mi_color = new Color(120,100,40);
      panel.setBackground(mi_color);

      panel_1.setBackground(Color.YELLOW);

      //Etiquetas de los mensajes
      JLabel label_b0 = new JLabel("Borra un producto");
      JLabel label_b1 = new JLabel("Código de barras");
   
      //Áreas de texto
      JTextField borrar = new JTextField();

      //botón
      JButton boton_borrar = new JButton("Borrar");

      panel_1.add(label_b0);
      panel_1.add(new JLabel(""));
      panel_1.add(label_b1);
      panel_1.add(borrar);
      panel_1.add(new JLabel(""));
      panel_1.add(boton_borrar);
      panel.add(panel_1 ); 
      panel.add(estampa);  

      boton_borrar.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {                                   
            String delete=borrar.getText();
            boolean borrado=borraProducto(delete);
            if(borrado) {
              JOptionPane.showMessageDialog(null,"Artículo borrado","exito", JOptionPane.INFORMATION_MESSAGE);
           } else {
              JOptionPane.showMessageDialog(null,"No se encontró un artículo con ese código de barras", "error", JOptionPane.ERROR_MESSAGE);
           } 
         }                       
      });  
      panelFichas.addTab( "Borra artículos", panel);
   }

   public void ponPestaniaCambiarInfo(){
      JPanel panel = new JPanel(new GridLayout(1,2));
      JPanel panel_1 = new JPanel(new GridLayout(1,2,-100,30));
      JPanel panel_2 = new JPanel(new GridLayout(1,2,-100,30));
      JLabel label_1 = new JLabel("Ingresa tu contraseña:");
      JLabel label_2 = new JLabel("Ingresa tu nueva contraseña:");
      JTextField pass_ant = new JTextField();
      JTextField pass_new = new JTextField();
      JButton acceder = new JButton("Acceder");
      JButton aceptar = new JButton("Aceptar");

      panel_1.add(label_1);
      panel_1.add(pass_ant);
      panel_1.add(new JLabel(""));
      panel_1.add(acceder);

      panel_2.add(label_2);
      panel_2.add(pass_new);
      panel_2.add(new JLabel(""));
      panel_2.add(aceptar);
      panel_2.setVisible(false);
      
      panel.add(panel_1);
      panel.add(panel_2);

      acceder.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {                                   
            String pass = pass_ant.getText();
            if(administrador.getPass().equals(pass)){
               panel_1.setVisible(false);
               panel_2.setVisible(true);
               String n_pass = pass_new.getText();
               
               aceptar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evento){
                         administrador.setPass(n_pass);
                         JOptionPane.showMessageDialog(null, "Contraseña Nueva: "+n_pass,"Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
               });
               
            }else{
               JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

         }
      });
     
     
  
      panelFichas.addTab("Cambiar contraseña", panel);
   }

   public void ponPestaniaSalir() {
      // PESTAÑA DE SALIR
      Icon imagen = new ImageIcon( "salir.jpg" );
      JLabel estampa = new JLabel(imagen); 
      JPanel panel = new JPanel(new GridLayout(1,2)); // crea el segundo panel
      JButton boton_salir = new JButton("Salir");
      panel.add(boton_salir);
      panel.add(estampa);
      boton_salir.addActionListener(new ActionListener() {             
         public void actionPerformed(ActionEvent evento) {                                   
           grabar();
           System.exit(1);
         }                       
      });     
      panelFichas.addTab( "Cerrar sesión", panel); 
   }


   /**
    * Este metodo muestra la ventana de inicio de sesion 
    * y ajusta propiedades como sus dimesiones y 
    * la funcion del boton que cierra la ventana
    */
   public static void muestraInterfaz() {
      Menu m = new Menu();
      m.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      m.setSize( 850, 400 );
      m.setVisible( true );
      m.setResizable(false);
   }

   public boolean agregaNuevoProducto(String cb, String n, double p, int c) {
      boolean b = false;
      Producto nuevo = new Producto(cb, n, p, c);
      almacen.add(nuevo);
      b = true;
      return b;
   }

   public String buscaProductos(String cadena) {
      String res="<html>";
      for(int i=0; i<almacen.size(); i++) {
         String cad = (almacen.get(i)).toString().toLowerCase();
         if(cad.contains(cadena.toLowerCase())) {
            res+="<br>"+cad;
         }
      }
      return res;

   }

   public boolean existeCodigo(String codigo){
      boolean b = false;
          for(int i =0; i<almacen.size(); i++){
               String prod = (almacen.get(i)).toString();
               if(prod.contains(codigo)){
                    b = true;
               }
          }
      return b;     
   }


   public boolean borraProducto(String codigo) {
      boolean borrado=false;
      for(int i=0; i<almacen.size(); i++) {
        String cp=almacen.get(i).daCodigo();
        if(cp.equals(codigo)) {
         almacen.remove(i);
         borrado=true;
        }
      }
      return borrado;
   }

   public boolean editaProducto(String cb, String nombre, String precio, String piezas){
          boolean b = false;
          for(int i = 0; i<almacen.size(); i++){
               Producto prod = almacen.get(i);
               if(prod.daCodigo().equals(cb)){
                    System.out.println("bandera 1");
                    auxEditaProducto(prod, nombre, precio, piezas);
                    b = true;
               }
          }
          return b;
   }

   private void auxEditaProducto(Producto prod, String nombre, String precio, String piezas){
          double p1 = 0;
          int c1 = 0;
          
          if( nombre.equals("") || precio.equals("") || piezas.equals("") ){
               System.out.println("bandera 2");
               if(nombre!=null)
                    prod.ponNombre(nombre);
               if(precio!=null)
                    p1 = Double.parseDouble(precio);
                    prod.ponPrecio(p1);
               if(piezas!=null)
                    c1 = Integer.parseInt(piezas);
                    prod.ponCantidad(c1);
 
          }
          System.out.println("bandera 3");
   }


   /**
    * Metodo leerProductos
    * abre el archivo si este existe y carga la informacion
    * al almacén
    */
   public ArrayList leerProductos(){
      try{
         ObjectInputStream lector=new ObjectInputStream(new FileInputStream(nombreArchivo));
         ArrayList<Producto> productos = (ArrayList<Producto>) lector.readObject();
         lector.close();
         this.almacen=productos;
      }
      catch(IOException e){
         System.out.println("Lectura fallida: "+e);
      }
      catch(ClassNotFoundException e){
         System.out.println("Lectura fallida: "+e);
      }
      return almacen;
   }

    public Administrador leerInfo(){
         try{
            ObjectInputStream lector = new ObjectInputStream( new FileInputStream(infoAdmin) );
            Administrador a = (Administrador) lector.readObject();
            lector.close();
            this.administrador = a;
         }catch (IOException e){
            System.out.println("Lectura fallida: "+e);
         }catch (ClassNotFoundException e){
            System.out.println("Lectura fallida: "+e);
         }
         return this.administrador;
    }

    public void grabarInfo(){
         try{
            ObjectOutputStream a = new ObjectOutputStream( new FileOutputStream(infoAdmin) );
            a.writeObject(administrador);
            a.close();
         }catch(NotSerializableException e){
            System.out.println("Error en la grabacion: "+e+"Objeto no serializable");
         }catch(IOException e){
            System.out.println("Error en la grabacion: "+e);
         }
    }


   /**   
    * Metodo grabar
    * envia a un archivo la informacion contenida en la agenda
    */
   public void grabar(){
      try{
         ObjectOutputStream a= new ObjectOutputStream(new FileOutputStream(nombreArchivo));
         a.writeObject(almacen);
         a.close();
      }
      catch(NotSerializableException e){
         System.out.println("Error en la grabacion: "+e+"Objeto no serializable");
      }
      catch(IOException e){
         System.out.println("Error en la grabacion: "+e);
      }

   }
} // fin de la clase Menu
