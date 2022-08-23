package abarrotes;
//Se importan las librerias correspondientes
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Personal {
    JPanel pnlPers = new javax.swing.JPanel();
    JLabel lblNombre = new javax.swing.JLabel();
    JTextField txtNombre = new javax.swing.JTextField();
    JLabel lblEdad = new javax.swing.JLabel();
    JTextField txtEdad = new javax.swing.JTextField();
    JLabel lblTel = new javax.swing.JLabel();
    JTextField txtTel = new javax.swing.JTextField();
    JButton btnGuardar = new javax.swing.JButton();
    JButton btnBuscar = new javax.swing.JButton();
    JButton btnEliminar = new javax.swing.JButton();
    JButton btnRenom = new javax.swing.JButton();
    JButton btnSalir = new javax.swing.JButton();
    JTextArea txtA = new javax.swing.JTextArea();
    JScrollPane scroll = new JScrollPane();
    
    public void aparienciaAltasPersonal(){
         //Configuración de los componentes
        pnlPers.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal-Altas"));
        lblNombre.setText("Ingresa el nombre: ");
        lblEdad.setText("Ingresa la edad: ");
        lblTel.setText("Ingresa el teléfono: ");
        txtA.setBounds(10,50,200,200); // asignacion de tamaño del TextArea
        txtA.setColumns(50);// asignacion del maximo de columnas del TextArea
        txtA.setRows(20);// asignacion del mximo de filas del TextArea
        scroll.setViewportView(txtA);// se añade el TextArea a un scrollPane
        btnGuardar.setText("Guardar");
        //Funcion para el evento Clicked para llamar a la función Guardar
        btnGuardar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    Guardar();
                } catch (IOException ex) {
                    Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnBuscar.setText("Buscar");
        //Funcion para el evento Clicked para llamar a la función Buscar
        btnBuscar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    Buscar();
                } catch (IOException ex) {
                    Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnEliminar.setText("Eliminar");
        //Funcion para el evento Clicked para llamar a la función Eliminar
        btnEliminar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    Eliminar();
                } catch (IOException ex) {
                    Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnRenom.setText("Renombrar");
        //Funcion para el evento Clicked para llamar a la función Renombrar
        btnRenom.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    Renombrar();
                } catch (IOException ex) {
                    Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnSalir.setText("Salir");
        //Funcion para el evento Clicked para llamar a la función Salir
        btnSalir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
        });
        //Acomodo de los componentes en el Panel con GridBagLayaout
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        pnlPers.setLayout(gbl);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,5,0,0);
        gbc.gridwidth = GridBagConstraints.WEST;
        pnlPers.add(lblNombre, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlPers.add(txtNombre, gbc);
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.WEST;
        pnlPers.add(lblEdad, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlPers.add(txtEdad, gbc);
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.WEST;
        pnlPers.add(lblTel, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlPers.add(txtTel, gbc);
        gbc.gridwidth = GridBagConstraints.WEST;
        pnlPers.add(btnGuardar, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlPers.add(btnBuscar, gbc);
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.WEST;
        pnlPers.add(btnEliminar, gbc);
        gbc.gridwidth = GridBagConstraints.CENTER;
        pnlPers.add(btnRenom, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        pnlPers.add(btnSalir, gbc);
        gbc.ipady = 250;
        pnlPers.add(scroll, gbc);
       
    }
    public void Guardar() throws FileNotFoundException, IOException{
        String nombreArchivo = JOptionPane.showInputDialog(pnlPers,"Ingresa el nombre del archivo:","Guardar",1); //Se ventana Emergente para pedir el nombre del archivo
        String carpeta = System.getProperty("user.dir"); //Con esto se pone de ruta en donde se ejecuta el programa
        String url = carpeta + "/" + nombreArchivo + ".txt";
        FileWriter ubicacion = null;
        try {
            ubicacion = new FileWriter(url); //Se realiza un try de la ubicacion del archivo
        }catch (IOException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            BufferedWriter escribir = new BufferedWriter(ubicacion);// se abre el buffer de salida
            escribir.write(txtNombre.getText()+" / "+txtEdad.getText()+" / "+txtTel.getText()); // se escribe en el archivo
            escribir.close(); // se cierra el buffer
        }catch(Exception e){
            
        }
       
    } 
    public void Buscar() throws FileNotFoundException{
        JFileChooser fc = new JFileChooser(); //Creación del objeto FileChooser para seleccionar archivos
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile(); //Creacíon del objeto que guardara el archivo en memoria RAM
        try{    
            FileReader fr = new FileReader(archivo); //Lectura del archivo
            BufferedReader br = new BufferedReader(fr);//Creación del buffer de lectura
            String texto = ""; //Variable que guardara todo el texto
            String linea = ""; //Variale que guardara linea por linea
            while(((linea=br.readLine())!=null)){ //Con esto se ejecutara y se almacenara 
                texto+=linea+"\n";                 //las lineas y posteriormente se agregaran a la variable texto
            }          
            txtA.setText(texto); //Se asigna el texto al textArea
           }
        catch(Exception e){
                
            }  
    }
    public void Eliminar() throws FileNotFoundException{
        JFileChooser fc = new JFileChooser(); //Creación del objeto FileChooser para seleccionar archivos
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile(); //Creacíon del objeto que guardara el archivo en memoria RAM   
        if(JOptionPane.showConfirmDialog(pnlPers,"¿Seguro que quieres eliminar este archivo?","Eliminar",JOptionPane.YES_NO_OPTION)==0){
            if(archivo.delete())
                JOptionPane.showMessageDialog(null,"Se elimino el archivo");
            else
                JOptionPane.showMessageDialog(null,"Ocurrio un error");
        }        
    }
    public void Renombrar() throws FileNotFoundException{
        JFileChooser fc = new JFileChooser(); //Creación del objeto FileChooser para seleccionar archivos
        fc.showOpenDialog(null);
        File archivo = fc.getSelectedFile(); //Creacíon del objeto que guardara el archivo en memoria RAM 
        String nombreArchivo = JOptionPane.showInputDialog(pnlPers,"Ingresa el nuevo nombre del archivo:","Guardar",1); //Se ventana Emergente para pedir el nuevo nombre del archivo
        String nvo = archivo.getParent()+ "\\" + nombreArchivo+ ".txt"; 
        File a2 = new File(nvo); //Se crea un nuevo archivo de tipo File
        if(archivo.renameTo(a2)) //Se Valida que se renombre el archivo por a2
            JOptionPane.showMessageDialog(null,"Se renombro el archivo");
        else
            JOptionPane.showMessageDialog(null,"Ocurrio un error");               
                    
    } 
}
