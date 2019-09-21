package Main;

import javax.swing.JOptionPane;

public class Entrada {

    public double lerDouble(String msg) {
        while (true) {
            try {
                double x = Double.parseDouble(JOptionPane.showInputDialog(msg));
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um double....");
            }
        }
    }

    public Integer lerInt(String msg) {
        while (true) {
            try {
                int x = Integer.parseInt(JOptionPane.showInputDialog(msg));
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um inteiro....");
            }
        }
    }
    
    public String lerString(String msg) {
        while (true) {
            try {
                String x = JOptionPane.showInputDialog(msg);
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite uma string valida....");
            }
        }
    }
    
    public char lerChar(String msg) {
        while (true) {
            try {
                char x = JOptionPane.showInputDialog(msg).charAt(0);
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um char valido....");
            }
        }
    }

    public boolean continuar(String msg) {
        while (true) {
            try {
                char x = JOptionPane.showInputDialog(msg + " (S ou N) =>").charAt(0);
                switch (x) {
                    case 's':
                    case 'S':
                        return true;
                    case 'n':
                    case 'N':
                        return false;
                    default:
                        int a = 3 / 0;//provocar um erro propositalmente
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro, sao validas as letras S ou N");
            }
        }
    }
}
