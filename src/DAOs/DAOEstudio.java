package DAOs;

/**
 *
 * @author Winicius
 */
import Entidades.Estudio;
import daos.DAOGenerico;
import static daos.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOEstudio extends DAOGenerico<Estudio> {

    public DAOEstudio() {
        super(Estudio.class);
    }

    public int autoIdEstudio() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idEstudio) FROM Estudio e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Estudio> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Estudio e WHERE e.nomeEstudio LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Estudio> listById(int id) {
        return em.createQuery("SELECT e FROM Estudio e WHERE e.idEstudio = :id").setParameter("id", id).getResultList();
    }

    public List<Estudio> listInOrderNome() {
        return em.createQuery("SELECT e FROM Estudio e ORDER BY e.nomeEstudio").getResultList();
    }

    public List<Estudio> listInOrderId() {
        return em.createQuery("SELECT e FROM Estudio e ORDER BY e.idEstudio").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Estudio> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdEstudio() + "-" + lf.get(i).getNomeEstudio());
        }
        return ls;
    }
}
