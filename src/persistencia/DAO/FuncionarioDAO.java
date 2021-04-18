package persistencia.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import entidades.classes.Funcionario;
import java.io.BufferedReader;
import java.io.FileReader;
import persistencia.interfaces.IfuncionarioDAO;

/**
 *
 * @author NetBeans
 */
public class FuncionarioDAO implements IfuncionarioDAO {

    @Override
    public void incluir(Funcionario objetoFuncionario) throws Exception{
        try{
            //cria o arquivo
            FileWriter fw = new FileWriter("Funcionario.txt", true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            //Escreve no arquivo
            bw.write(objetoFuncionario.toString()+"\n");
            //fecha o arquivo
            bw.close();
        }catch(Exception erro){
            throw erro;
      }    
    }

    @Override
    public ArrayList<Funcionario> listagem()throws Exception {
        try {
                ArrayList<Funcionario> listaDeContatos = new ArrayList<Funcionario>();
                FileReader fr = new FileReader ("Funcionario.txt");
                BufferedReader br = new BufferedReader(fr);
                String linha;
                while ((linha = br.readLine()) !=null ){
                        Funcionario objFuncionario = new Funcionario(linha);
                        listaDeContatos.add(objFuncionario);
                }
                br.close();
                return listaDeContatos;
        } catch (Exception erro) {
                throw erro;
        }
    }

    @Override
    public void excluir(Funcionario objetoFuncionario) throws Exception {
        try {
            //Cria um funcionárioDAO
            FuncionarioDAO DadosFuncionarios = new FuncionarioDAO();
            //Cria uma lista Funcionário
            ArrayList<Funcionario> lista;
            //salva na lista
            lista = DadosFuncionarios.listagem();

            
            int position = -1;
            //Procura na lista a matricula
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getMatricula() == objetoFuncionario.getMatricula()) {
                    //devolve a posição na lista
                    position =  i;
                }
            }

            //caso não ache a matricula
            if(position == -1)   throw new Exception ("Matricula Inexistente");

            
            //Cria o arquivo de Leitura
            FileReader fr = new FileReader ("Funcionario.txt");
            //Cria Buffer de Leitura
            BufferedReader br = new BufferedReader(fr);
            //Cria Array de Linhas do Raw Text
            ArrayList<String> Texto = new ArrayList<String>();
            //DEclara Linha Aux
            String linha = null;
            //pega todas as linhas
            while((linha = br.readLine()) != null){
                Texto.add(linha);
            }
            //Fecha Buffer
            br.close();

            //Cria File de Escrita
            FileWriter fw = new FileWriter("Funcionario.txt",false);
            //Cria Buffer de Escrita
            BufferedWriter bw = new BufferedWriter(fw);
            //Rescreve o arquivo sem a linha encontrada
            for(int i = 0 ; i < Texto.size(); i++) {
                if (position != i)  bw.write(Texto.get(i)+"\n");
            }
            
            bw.close();

        } catch (Exception erro) {
                throw erro;
        }
    }

    @Override
    public void alterar(Funcionario objetoFuncionario) throws Exception{
        try{
            FuncionarioDAO DadosFuncionarios = new FuncionarioDAO();
            ArrayList<Funcionario> lista;
            lista = DadosFuncionarios.listagem();

            //pesquisa qual a Matricula
            int position = -1;
            //Procura em List
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getMatricula() == objetoFuncionario.getMatricula()) {
                    //pega a Posição na List
                    position =  i;
                }
            }

            //ERRO caso matricula não exista
            if(position == -1)   throw new Exception ("Matricula Inexistente");

            //alterando os campos
            objetoFuncionario.setMatricula(lista.get(position).getMatricula());
            objetoFuncionario.setNome(lista.get(position).getNome());
            objetoFuncionario.setEmail(lista.get(position).getEmail());
            objetoFuncionario.setTelefone(lista.get(position).getTelefone());
            objetoFuncionario.setSexo(lista.get(position).getSexo());
            objetoFuncionario.setStatus(lista.get(position).getStatus());

        }catch(Exception erro){
            throw erro;
      }    
    }
    
    
}
