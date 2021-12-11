package DAOs;

import Entidades.Staff;
import daos.DAOGenerico;
import static daos.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOStaff extends DAOGenerico<Staff> {

    public DAOStaff() {
        super(Staff.class);
    }

    public int autoIdStaff() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idStaff) FROM Staff e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Staff> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Staff e WHERE e.nomeStaff LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Staff> listById(int id) {
        return em.createQuery("SELECT e FROM Staff e WHERE e.idStaff = :id").setParameter("id", id).getResultList();
    }

    public List<Staff> listInOrderNome() {
        return em.createQuery("SELECT e FROM Staff e ORDER BY e.nomeStaff").getResultList();
    }

    public List<Staff> listInOrderId() {
        return em.createQuery("SELECT e FROM Staff e ORDER BY e.idStaff").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Staff> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdStaff() + "-" + lf.get(i).getNomeStaff());
        }
        return ls;
    }
}
