package Main;

import javax.swing.JOptionPane;

public class Entrada {

    public double lerNumeroDouble(String msg) {
        while (true) {
            try {
                double x = Double.parseDouble(JOptionPane.showInputDialog(msg));
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um double....");
            }
        }
    }

    public Integer lerNumeroInteiro(String msg) {
        while (true) {
            try {
                int x = Integer.parseInt(JOptionPane.showInputDialog(msg));
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um inteiro....");
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
                JOptionPane.showMessageDialog(null,"Erro, são válidas as letras S ou N");
            }
        }
    }
}
