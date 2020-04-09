package mack.br.lab_dao.persistencia;

import mack.br.lab_dao.entidades.contas;
import java.util.List;

public interface contasDAO {
    boolean create (contas conta);
    List<contas> read ();
    boolean update(contas conta);
    boolean delete(contas conta);
}

