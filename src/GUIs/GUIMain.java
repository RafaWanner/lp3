package GUIs;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author radames
 */
public class GUIMain extends JFrame {

    private Container cp;
    private JButton btAnime = new JButton("Anime");
    private JButton btEstudio = new JButton("Estudio");
    private JButton btGenero = new JButton("Genero");
    private JButton btStaff = new JButton("Staff");

    public GUIMain() {
        cp = getContentPane();

        setTitle("CRUD - Anime");

        cp.setLayout(new GridLayout(4, 1));

        cp.add(btAnime);
        cp.add(btEstudio);
        cp.add(btStaff);
        cp.add(btGenero);

        btAnime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIAnime guiAnime = new GUIAnime();
            }
        });
        btStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIStaff guiStaff = new GUIStaff();
            }
        });
        btGenero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIGenero guiGenero = new GUIGenero();
            }
        });

        btEstudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIEstudio guiEstudio = new GUIEstudio();
            }
        });

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //antes de sair do sistema, grava os dados da lista em disco
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                // Sai do sistema  
                System.exit(0);
            }
        });

        setSize(350, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
