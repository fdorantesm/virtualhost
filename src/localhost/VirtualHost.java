package localhost;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class VirtualHost extends JFrame{
  String i;
  String r;
  String s;
  String d;
  JFrame Principal = new JFrame("Principal");
  JDialog Help = new JDialog(this.Principal, "Ayuda");
  JDialog About = new JDialog(this.Principal, "Acerca");
  About about = new About(this.Principal, true);
  Help help = new Help(this.Principal, true);

  CVirtualHost op = new CVirtualHost(this.i, this.r, this.s, this.d);
  Validate is = new Validate();
  Apache apache = new Apache(this.r);

  private JTextField dominio;
  private JTextField ip;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JMenu jMenu1;
  private JMenu jMenu2;
  private JMenuBar jMenuBar1;
  private JMenuItem jMenuItem1;
  private JMenuItem jMenuItem2;
  private JMenuItem jMenuItem3;
  private JMenuItem jMenuItem4;
  private JPanel jPanel1;
  private JLabel mensaje;
  private JTextField ruta;
  private JTextField servidor;
  private JButton submit;

  public VirtualHost(){
    initComponents();
    setLocationRelativeTo(null);
    this.about.setVisible(false);
    this.help.setVisible(false);
    setIconImage(new ImageIcon(getClass().getResource("images/icon.gif")).getImage());
  }

  public boolean listo() {
    if ((this.op.existsHTTPD(this.r)) && (this.op.Domain()) && (this.is.Root(this.r))) {
      if ((this.is.Domain(this.d)) || (this.d == "") || (this.d == null)) {
        if (this.is.Server(this.s)) {
          if (this.is.IP(this.i)) {
            if (this.op.isDomainAvailable(this.s, this.d)) {
              if (this.op.isIPAvailable(this.i)) {
                this.op.HTTPData();
                this.op.Hosts();
                this.op.LMhosts();
                this.op.Domain();
                this.mensaje.setText(this.s + this.d + " ha sido creado."); repaint(); return true;
              }this.mensaje.setText(this.i + " no está disponible."); repaint(); return false;
            }this.mensaje.setText(this.s + this.d + " no está disponible."); repaint(); return false;
          }this.mensaje.setText("La ip no tiene formato válido"); repaint(); return false;
        }this.mensaje.setText("El servidor no tiene formato válido."); repaint(); return false;
      }this.mensaje.setText("El dominio no tiene formato válido."); repaint(); return false;
    }this.mensaje.setText("El directorio de xampp no es el correcto."); repaint(); return false;
  }

  private void initComponents(){
    this.jPanel1 = new JPanel();
    this.ruta = new JTextField();
    this.servidor = new JTextField();
    this.dominio = new JTextField();
    this.ip = new JTextField();
    this.submit = new JButton();
    this.mensaje = new JLabel();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel1 = new JLabel();
    this.jMenuBar1 = new JMenuBar();
    this.jMenu1 = new JMenu();
    this.jMenuItem1 = new JMenuItem();
    this.jMenu2 = new JMenu();
    this.jMenuItem2 = new JMenuItem();
    this.jMenuItem3 = new JMenuItem();
    this.jMenuItem4 = new JMenuItem();

    setDefaultCloseOperation(3);
    setTitle("VirtualHost Wizard");
    setFont(new Font("Tahoma", 0, 12));
    setResizable(false);

    this.jPanel1.setBorder(BorderFactory.createEtchedBorder());

    this.ruta.setFont(new Font("Ubuntu", 0, 13));
    this.ruta.setText("C:/localhost");

    this.servidor.setFont(new Font("Ubuntu", 0, 13));
    this.servidor.setText("wpdesigns");

    this.dominio.setFont(new Font("Ubuntu", 0, 13));
    this.dominio.setText(".com.mx");
    this.dominio.setMaximumSize(new Dimension(6, 20));

    this.ip.setFont(new Font("Ubuntu", 0, 13));
    this.ip.setText("127.0.0.2");

    this.submit.setFont(new Font("Ubuntu", 0, 13));
    this.submit.setText("Finalizar");
    this.submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        VirtualHost.this.submitActionPerformed(evt);
      }
    });

    this.mensaje.setFont(new Font("Ubuntu", 0, 11));

    this.jLabel2.setFont(new Font("Ubuntu", 0, 11));
    this.jLabel2.setText("Nombre del servidor:");
    this.jLabel2.setToolTipText("¿Cúal es el nombre de tu proyecto?");

    this.jLabel3.setFont(new Font("Ubuntu", 0, 11));
    this.jLabel3.setText("Dominio:");
    this.jLabel3.setToolTipText("¿Qué dominio deseas?");

    this.jLabel4.setFont(new Font("Ubuntu", 0, 11));
    this.jLabel4.setText("IP local:");
    this.jLabel4.setToolTipText("¿A qué ip apuntará tu dominio?");

    this.jLabel1.setFont(new Font("Ubuntu", 0, 11));
    this.jLabel1.setText("Directorio de instalación de Xammp:");

    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ruta).addComponent(this.mensaje, -1, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.servidor, -2, 135, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.dominio, -2, 65, -2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.ip, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.submit, -1, 90, 32767)))).addComponent(this.jLabel1))).addContainerGap(-1, 32767)));

    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ruta, -2, 30, -2).addGap(13, 13, 13).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel4))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.servidor, -2, 30, -2).addComponent(this.ip, -2, 30, -2).addComponent(this.submit, -2, 30, -2).addComponent(this.dominio, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.mensaje, -1, 16, 32767).addContainerGap()));

    this.jMenu1.setText("Archivo");
    this.jMenu1.setToolTipText("Archivo");
    this.jMenu1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        VirtualHost.this.jMenu1ActionPerformed(evt);
      }
    });
    this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(115, 8));
    this.jMenuItem1.setFont(new Font("Ubuntu", 0, 12));
    this.jMenuItem1.setText("Salir");
    this.jMenuItem1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        VirtualHost.this.jMenuItem1ActionPerformed(evt);
      }
    });
    this.jMenu1.add(this.jMenuItem1);

    this.jMenuBar1.add(this.jMenu1);

    this.jMenu2.setText("Ayuda");
    this.jMenu2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        VirtualHost.this.jMenu2ActionPerformed(evt);
      }
    });
    this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(112, 0));
    this.jMenuItem2.setFont(new Font("Ubuntu", 0, 12));
    this.jMenuItem2.setText("Ayuda");
    this.jMenuItem2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        VirtualHost.this.jMenuItem2ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem2);

    this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(114, 0));
    this.jMenuItem3.setFont(new Font("Ubuntu", 0, 12));
    this.jMenuItem3.setText("Contacto");
    this.jMenuItem3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        VirtualHost.this.jMenuItem3ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem3);

    this.jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(113, 0));
    this.jMenuItem4.setFont(new Font("Ubuntu", 0, 12));
    this.jMenuItem4.setText("Acerca de VirtualHost");
    this.jMenuItem4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        VirtualHost.this.jMenuItem4ActionPerformed(evt);
      }
    });
    this.jMenu2.add(this.jMenuItem4);

    this.jMenuBar1.add(this.jMenu2);

    setJMenuBar(this.jMenuBar1);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));

    pack();
  }

  private void submitActionPerformed(ActionEvent evt) {
    this.r = this.ruta.getText().toLowerCase();
    this.apache.SetRoot(this.r);
    this.s = this.servidor.getText().toLowerCase();
    this.d = this.dominio.getText().toLowerCase();
    this.i = this.ip.getText();
    this.op.SetRuta(this.r);
    this.op.SetServidor(this.s);
    this.op.SetIP(this.i);
    this.op.SetDominio(this.d);

    if (listo()) {
      this.apache.Start();
      this.op.GoToNewDomain(this.s, this.d);
    }
  }

  private void jMenuItem2ActionPerformed(ActionEvent evt) {
    this.help.setVisible(true);
  }

  private void jMenuItem1ActionPerformed(ActionEvent evt){
    System.exit(0);
  }

  private void jMenu2ActionPerformed(ActionEvent evt){
  }

  private void jMenuItem4ActionPerformed(ActionEvent evt) {
    this.about.setVisible(true);
  }

  private void jMenu1ActionPerformed(ActionEvent evt)
  {
  }

  private void jMenuItem3ActionPerformed(ActionEvent evt) {
    this.op.Contact();
  }

  public static void main(String[] args)
  {
    try
    {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
        if ("Windows".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
    }
    catch (ClassNotFoundException ex) {
      Logger.getLogger(VirtualHost.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(VirtualHost.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(VirtualHost.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(VirtualHost.class.getName()).log(Level.SEVERE, null, ex);
    }

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        new VirtualHost().setVisible(true);
      }
    });
  }
}