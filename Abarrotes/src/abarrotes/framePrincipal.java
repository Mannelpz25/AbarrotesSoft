package abarrotes;
//Se importan las librerias necesarias
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class framePrincipal {
    static JFrame frame = new JFrame("Abarrotes"); //Creación del frame
    JPanel pnlInicio = new javax.swing.JPanel(); //Creación del panel de inicio
    static Personal p = new Personal(); //Creación del objeto tipo Personal para utilizar las funciones de esta clase
    static Inventario i = new Inventario(); //Creación del objeto tipo Inventario para utilizar las funciones de esta clase 
    
    public void limpiarFrame(){
        frame.remove(p.pnlPers);
        frame.remove(i.pnlInv);
        frame.remove(pnlInicio);
    }
    
    public void aparienciaTotal(){
        //Se inicializan las apariencias        
        p.aparienciaAltasPersonal();
        i.aparienciaAltasInventario();
        //Se inicializan los componentes de el frame
        pnlInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Abarrotes"));    
        JLabel ini = new javax.swing.JLabel();
        ini.setText("Inicio");
        pnlInicio.add(ini);        
        frame.setLocation(400,200);
        frame.setVisible(true);
        frame.setSize(600,500);
        //Funcion para cerrar el programa con el evento WindowClosing
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        }); 
        //Creando el Menu y su menuItem Inicio
        JMenuBar menu = new javax.swing.JMenuBar();
        JMenuItem Inicio = new javax.swing.JMenuItem("Inicio");
        Inicio.addActionListener((ActionEvent e)-> {
            if(e.getSource()==Inicio){  
                frame.setTitle("Abarrotes");
                limpiarFrame();
                frame.add(pnlInicio,BorderLayout.CENTER);
                frame.repaint();
                frame.validate();
            }                
        });
        //Creando el Menu Personal y el MenuItem Altas      
        JMenu Personal = new javax.swing.JMenu("Personal");
        JMenuItem AltasPersonal = new javax.swing.JMenuItem("Altas");
        Personal.add(AltasPersonal);
        AltasPersonal.addActionListener((ActionEvent e) -> {
            if(e.getSource()==AltasPersonal){
                frame.setTitle("Abarrotes - Personal");                
                limpiarFrame();
                frame.add(p.pnlPers,BorderLayout.CENTER);                
                frame.repaint();
                frame.validate();
            }                
        });
        //Creando el Menu Inventario y el MenuItem Altas   
        JMenu Inventario = new javax.swing.JMenu("Inventario");
        JMenuItem AltasInventario = new javax.swing.JMenuItem("Altas");
        Inventario.add(AltasInventario);
        AltasInventario.addActionListener((ActionEvent e) -> {
            if(e.getSource()==AltasInventario){
                frame.setTitle("Abarrotes - Inventario");                
                limpiarFrame();
                frame.add(i.pnlInv,BorderLayout.CENTER);                
                frame.repaint();
                frame.validate();
            }                
        });
        //Se añaden los componentes al menu y a su vez se añade el menu al frame
        menu.add(Inicio);
        menu.add(Personal);
        menu.add(Inventario);
        frame.add(menu, BorderLayout.PAGE_START);
        frame.add(pnlInicio,BorderLayout.CENTER);
        frame.repaint();
        frame.validate();
    }
}
