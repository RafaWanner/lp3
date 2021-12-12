package DAOs;

import Entidades.Ingrediente;
import java.util.ArrayList;
import java.util.List;

public class DAOIngrediente extends DAOGenerico<Ingrediente> {

    private List<Ingrediente> lista = new ArrayList<>();

    public DAOIngrediente() {
        super(Ingrediente.class);
    }

    public int autoIdIngrediente() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idIngrediente) FROM Ingrediente) e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Ingrediente> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Ingrediente e WHERE e.idIngrediente) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Ingrediente> listById(int id) {
        return em.createQuery("SELECT e FROM Ingrediente + e WHERE e.nomeIngrediente= :id").setParameter("id", id).getResultList();
    }

    public List<Ingrediente> listInOrderNome() {
        return em.createQuery("SELECT e FROM Ingrediente e ORDER BY e.nomeIngrediente").getResultList();
    }

    public List<Ingrediente> listInOrderId() {
        return em.createQuery("SELECT e FROM Ingrediente e ORDER BY e.idIngrediente").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Ingrediente> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdIngrediente() + "-" + lf.get(i).getNomeIngrediente());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOIngrediente daoIngrediente = new DAOIngrediente();
        List<Ingrediente> listaIngrediente = daoIngrediente.list();
        for (Ingrediente atividade : listaIngrediente) {
            System.out.println(atividade.getIdIngrediente() + "-" + atividade.getNomeIngrediente());
        }
    }
}
