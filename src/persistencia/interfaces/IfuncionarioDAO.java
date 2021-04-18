package persistencia.interfaces;

import java.util.ArrayList;
import entidades.classes.Funcionario;

/**
 *
 * @author NetBeans
 */
public interface IfuncionarioDAO {
    ArrayList<Funcionario> listagem()throws Exception;
    void incluir(Funcionario objetoFuncionario)throws Exception;
    void excluir(Funcionario objetoFuncionario)throws Exception;
    void alterar(Funcionario objetoFuncionario)throws Exception;
}
