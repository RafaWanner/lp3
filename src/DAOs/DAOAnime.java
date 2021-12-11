package DAOs;

import Entidades.Anime;
import daos.DAOGenerico;
import static daos.DAOGenerico.em;
import java.util.ArrayList;
import java.util.List;

public class DAOAnime extends DAOGenerico<Anime> {

    public DAOAnime() {
        super(Anime.class);
    }

    public int autoIdAnime() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idAnime) FROM Anime e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Anime> listAll() {
        return em.createQuery("SELECT e FROM Anime e").getResultList();
    }

    public List<Anime> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Anime e WHERE e.nomeAnime LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Anime> listById(int id) {
        return em.createQuery("SELECT e FROM Anime e WHERE e.idAnime = :id").setParameter("id", id).getResultList();
    }

    public List<Anime> listInOrderNome() {
        return em.createQuery("SELECT e FROM Anime e ORDER BY e.nomeAnime").getResultList();
    }

    public List<Anime> listInOrderId() {
        return em.createQuery("SELECT e FROM Anime e ORDER BY e.idAnime").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Anime> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdAnime() + "-" + lf.get(i).getNomeAnime() + "-" + lf.get(i).getNota());
        }
        return ls;
    }
}
