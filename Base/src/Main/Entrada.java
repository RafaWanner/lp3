package Main;

import javax.swing.JOptionPane;

public class Entrada {

    private Integer x[];

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
                JOptionPane.showMessageDialog(null, "Erro digite um int valido....");
            }
        }
    }

    public Integer lerIntH(String msg, Integer high) {
        while (true) {
            try {
            	int a;
                int x = Integer.parseInt(JOptionPane.showInputDialog(msg));
                if(x <= high)
                	a = 3/0;
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um int valido....");
            }
        }
    }
    
    public Integer lerIntL(String msg, Integer low) {
        while (true) {
            try {
            	int a;
                int x = Integer.parseInt(JOptionPane.showInputDialog(msg));
                if(x >= low)
                	a = 3/0;
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um int valido....");
            }
        }
    }
    
    public Integer lerIntHL(String msg, Integer high, Integer low) {
        while (true) {
            try {
            	int a;
                int x = Integer.parseInt(JOptionPane.showInputDialog(msg));
                if(x <= high || x >= low)
                	a = 3/0;
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro digite um int valido....");
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
    
    public String lerEscolha(String msg, String[] choices) {
        while (true) {
            try {
                String x = (String) JOptionPane.showInputDialog(null, msg, null, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
                return x;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro escolha uma opção....");
            }
        }
    }
    
    public double[][] lerArray(String msg, int c) {
        while (true) {
        	Integer n1, n2;
        	if(c == 2) {
        		n1 = lerIntH("Digite a ordem da matriz", 0);
        		n2 = n1;
        	} else {
        		n1 = lerIntH("Digite a ordem 1 da matriz", 0);
        		n2 = lerIntH("Digite a ordem 2 da matriz", 0);
        	}
        	double[][] v = new double[n1][n2];
            for(int i = 0; i < n1; i++) {
            	for(int j = 0; j < n2; j++) {
            		try {
                    	v[i][j] = Double.parseDouble(JOptionPane.showInputDialog(msg));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro digite um int....");
                    }
            	}
            }
            return v;
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
