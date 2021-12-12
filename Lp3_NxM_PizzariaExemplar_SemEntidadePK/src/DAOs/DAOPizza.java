package DAOs;

import Entidades.Pizza;
import java.util.ArrayList;
import java.util.List;

public class DAOPizza extends DAOGenerico<Pizza> {

    private List<Pizza> lista = new ArrayList<>();

    public DAOPizza() {
        super(Pizza.class);
    }

    public int autoIdPizza() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idPizza) FROM Pizza) e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Pizza> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Pizza e WHERE e.idPizza) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Pizza> listById(int id) {
        return em.createQuery("SELECT e FROM Pizza + e WHERE e.nomePizza= :id").setParameter("id", id).getResultList();
    }

    public List<Pizza> listInOrderNome() {
        return em.createQuery("SELECT e FROM Pizza e ORDER BY e.nomePizza").getResultList();
    }

    public List<Pizza> listInOrderId() {
        return em.createQuery("SELECT e FROM Pizza e ORDER BY e.idPizza").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Pizza> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdPizza() + "-" + lf.get(i).getNomePizza());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOPizza daoPizza = new DAOPizza();
        List<Pizza> listaPizza = daoPizza.list();
        for (Pizza atividade : listaPizza) {
            System.out.println(atividade.getIdPizza() + "-" + atividade.getNomePizza());
        }
    }
}
