package GUIs;

import Entidades.Genero;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

// @author Winicius
public class GUIListagemGenero extends JDialog {
    
    ScrollPane scroll = new ScrollPane();
    
    public GUIListagemGenero(List<Genero> texto) {
        setTitle("Lista de Generos");
        setSize(500, 280);//tamanho da janela
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//libera ao sair (tira da memória a classe
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setModal(true);
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        String[] colunas = {"ID", "Nome"};
        String[][] dados = new String[texto.size()][colunas.length];
        for (int i = 0; i < texto.size(); i++) {
            String a[] = texto.get(i).toString().split("-");
            for (int j = 0; j < colunas.length; j++) {
                dados[i][j] = a[j];
            }
        }
        JTable table = new JTable(dados, colunas);

        scroll.add(table);
        cp.add(table.getTableHeader(), BorderLayout.NORTH);
        cp.add(scroll, BorderLayout.CENTER);
        
        table.setEnabled(false);
        setLocationRelativeTo(null); // posiciona no centro da tela principal
        setVisible(true);//faz a janela ficar visível        
    }
}