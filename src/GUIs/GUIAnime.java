package GUIs;

import DAOs.*;
import Entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import myUtil.JanelaPesquisar;

public class GUIAnime extends JFrame {

    ImageIcon iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
    ImageIcon iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
    ImageIcon iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
    ImageIcon iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
    ImageIcon iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
    ImageIcon iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
    ImageIcon iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));
    JButton btnCreate = new JButton(iconeCreate);
    JButton btnRetrieve = new JButton(iconeRetrieve);
    JButton btnUpdate = new JButton(iconeUpdate);
    JButton btnDelete = new JButton(iconeDelete);
    JButton btnSave = new JButton(iconeSave);
    JButton btnCancel = new JButton(iconeCancel);
    JButton btnList = new JButton(iconeListar);
    JLabel labelId = new JLabel("Id");
    JTextField textFieldId = new JTextField(0);
    JLabel labelNome = new JLabel("Nome");
    JTextField textFieldNome = new JTextField(40);
    JLabel labelNota = new JLabel("Nota");
    JTextField textFieldNota = new JTextField(0);
    JLabel labelEstudio = new JLabel("Id do estudio");
    JTextField textFieldEstudio = new JTextField(40);

    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String acao = "";//variavel para facilitar insert e update
    DAOAnime daoAnime = new DAOAnime();
    Anime anime;
    //Entidade Estudio declaracoes
    DAOEstudio daoEstudio = new DAOEstudio();
    Estudio estudio;

    private void atvBotoes(boolean c, boolean r, boolean u, boolean d) {
        btnCreate.setEnabled(c);
        btnRetrieve.setEnabled(r);
        btnUpdate.setEnabled(u);
        btnDelete.setEnabled(d);
        btnList.setEnabled(r);
    }

    public void mostrarBotoes(boolean visivel) {
        btnCreate.setVisible(visivel);
        btnRetrieve.setVisible(visivel);
        btnUpdate.setVisible(visivel);
        btnDelete.setVisible(visivel);
        btnList.setVisible(visivel);
        btnSave.setVisible(!visivel);
        btnCancel.setVisible(!visivel);
    }

    private void habilitarAtributos(boolean id, boolean nome, boolean nota, boolean estudio) {
        if (id) {
            textFieldId.requestFocus();
            textFieldId.selectAll();
        }
        textFieldId.setEnabled(id);
        textFieldId.setEditable(id);
        textFieldNome.setEditable(nome);
        textFieldNota.setEditable(nota);
        textFieldEstudio.setEditable(estudio);
    }

    public void zerarAtributos() {
        textFieldNome.setText("");
        textFieldNota.setText("");
        textFieldEstudio.setText("");
    }

    public GUIAnime() {
        setTitle("Anime");

        setSize(600, 400);//tamanho da janela
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        atvBotoes(false, true, false, false);
        habilitarAtributos(true, false, false, false);
        btnCreate.setToolTipText("Inserir novo registro");
        btnRetrieve.setToolTipText("Pesquisar por chave");
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        JToolBar Toolbar1 = new JToolBar();
        Toolbar1.add(labelId);
        Toolbar1.add(textFieldId);
        Toolbar1.add(btnRetrieve);
        Toolbar1.add(btnCreate);
        Toolbar1.add(btnUpdate);
        Toolbar1.add(btnDelete);
        Toolbar1.add(btnSave);
        Toolbar1.add(btnCancel);
        Toolbar1.add(btnList);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);  //atributos
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(5, 2));
        centro.add(labelId);
        centro.add(textFieldId);
        centro.add(labelNome);
        centro.add(textFieldNome);
        centro.add(labelNota);
        centro.add(textFieldNota);
        centro.add(labelEstudio);
        centro.add(textFieldEstudio);
        aviso.add(labelAviso);
        aviso.setBackground(Color.yellow);
        cp.add(Toolbar1, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(aviso, BorderLayout.SOUTH);
        textFieldId.requestFocus();
        textFieldId.selectAll();
        textFieldId.setBackground(Color.GREEN);
        labelAviso.setText("Digite uma placa e clic [Pesquisar]");
        setLocationRelativeTo(null);// posiciona no centro da tela principal
        setLocation(300, 200);
        setVisible(true);//faz a janela ficar visível  

// Listeners
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                anime = new Anime();
                textFieldId.setText(textFieldId.getText().trim());//caso tenham sido digitados espaços
                if (textFieldId.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Deve ser informado um valor para esse campo");
                    textFieldId.requestFocus();
                    textFieldId.selectAll();
                } else {
                    anime.setIdAnime(Integer.valueOf(textFieldId.getText()));
                    anime = daoAnime.obter(anime.getIdAnime());
                    if (anime != null) { //se encontrou na lista
                        textFieldNome.setText(anime.getNomeAnime());
                        textFieldNota.setText(String.valueOf(anime.getNota()));
                        textFieldEstudio.setText(String.valueOf(anime.getEstudioIdEstudio()));
                        atvBotoes(false, true, true, true);
                        habilitarAtributos(true, false, false, false);
                        labelAviso.setText("Encontrou - clic [Pesquisar], [Alterar] ou [Excluir]");
                        acao = "encontrou";

                    } else {
                        atvBotoes(true, true, false, false);
                        zerarAtributos();
                        labelAviso.setText("Não cadastrado - clic [Inserir] ou digite outra id [Pesquisar]");
                    }
                }
            }
        }
        );

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                zerarAtributos();
                habilitarAtributos(false, true, true, true);
                textFieldNome.requestFocus();
                mostrarBotoes(false);
                labelAviso.setText("Preencha os campos e clic [Salvar] ou clic [Cancelar]");
                acao = "insert";
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                anime = new Anime();
                estudio = new Estudio();
                String nomeAnime = textFieldNome.getText().trim();
                String nota = textFieldNota.getText().trim();

                int idEstudio = Integer.valueOf(textFieldEstudio.getText().split("-")[0]);
                estudio.setIdEstudio(idEstudio);
                estudio = daoEstudio.obter(estudio.getIdEstudio());

                if (estudio == null) {
                    JOptionPane.showMessageDialog(null, "Estudio Invalido");
                    textFieldEstudio.requestFocus();
                    textFieldEstudio.selectAll();
                } else if (nomeAnime.equals("")) {
                    JOptionPane.showMessageDialog(null, "Deve ser informado um valor para esse campo");
                    textFieldNome.requestFocus();
                    textFieldNome.selectAll();
                } else if (nota.equals("")) {
                    JOptionPane.showMessageDialog(null, "Deve ser informado um valor para esse campo");
                    textFieldNota.requestFocus();
                    textFieldNota.selectAll();
                } else {
                    anime.setIdAnime(Integer.valueOf(textFieldId.getText().split("-")[0]));
                    anime.setNomeAnime(nomeAnime);
                    anime.setNota(Double.valueOf(nota));
                    anime.setEstudioIdEstudio(daoEstudio.obter(idEstudio));
                    habilitarAtributos(true, false, false, false);
                    mostrarBotoes(true);
                    atvBotoes(false, true, false, false);
                    if (acao.equals("insert")) {
                        daoAnime.inserir(anime);
                        labelAviso.setText("Registro inserido...");
                    } else {  //acao = update
                        daoAnime.atualizar(anime);
                        labelAviso.setText("Registro atualizado...");
                    }
                }
            }
        });

        btnCancel.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                zerarAtributos();
                atvBotoes(false, true, false, false);
                habilitarAtributos(true, false, false, false);
                mostrarBotoes(true);
            }
        });

        btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "list";
                GUIListagemAnime guiListagem = new GUIListagemAnime(daoAnime.listAll());
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acao = "update";
                if (anime.getIdAnime() != Integer.valueOf(textFieldId.getText())) {
                    JOptionPane.showMessageDialog(null, "Id diferente do pesquisado");
                } else {
                    mostrarBotoes(false);
                    habilitarAtributos(false, true, true, true);
                }
            }
        });
//---------------------------------------------------------
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + anime.getIdAnime() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");
                    daoAnime.remover(anime);
                    zerarAtributos();
                    textFieldId.requestFocus();
                    textFieldId.selectAll();
                }
            }
        });
//Listener FK
        textFieldEstudio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> listaAuxiliar = daoEstudio.listInOrderNomeStrings("id");
                if (listaAuxiliar.size() > 0) {
                    String selectedItem = new JanelaPesquisar(listaAuxiliar,
                            getBounds().x - getWidth() / 2 + getWidth() + 5,
                            textFieldEstudio.getBounds().y + textFieldEstudio.getHeight()).getValorRetornado();
                    if (!selectedItem.equals("")) {
                        String[] aux = selectedItem.split("-");
                        textFieldEstudio.setText(selectedItem);

                        //preparar para salvar
                        estudio = daoEstudio.obter(Integer.valueOf(aux[0]));

                    } else {
                        textFieldEstudio.requestFocus();
                        textFieldEstudio.selectAll();
                    }
                } else {
                    JOptionPane.showMessageDialog(cp, "Não há nenhum estúdio cadastrado.");
                }
            }
        });
        
//Avisos
        textFieldId.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldId.setBackground(Color.GREEN);
                if (acao != "encontrou") {
                    labelAviso.setText("Digite uma Id e clic [Pesquisar]");
                }
            }

            @Override
            public void focusLost(FocusEvent fe
            ) {
                textFieldId.setBackground(Color.white);
            }
        });

        textFieldId.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldId.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe
            ) { //ao perder o foco, fica branco
                textFieldId.setBackground(Color.white);
            }
        });

        textFieldNome.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldNome.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe
            ) { //ao perder o foco, fica branco
                textFieldNome.setBackground(Color.white);
            }
        });

        textFieldNota.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldNota.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldNota.setBackground(Color.white);
            }
        });

    }

    public static void main(String[] args) {
        new GUIAnime();
    }
}
