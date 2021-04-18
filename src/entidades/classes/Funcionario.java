package entidades.classes;
import entidades.enumeracoes.Sexo;
import entidades.enumeracoes.Situacao;
/**
 *
 * @author NetBeans
 */
public class Funcionario {
    //Atributos
    private int matricula = 0;
    private String nome = "";
    private String email = "";
    private String telefone = "";
    private Sexo sexo = Sexo.MASCULINO;
    private Situacao status = Situacao.ATIVO;

    public Funcionario() {
    }
    
    public Funcionario (String strDados)throws Exception{
        String vetorString[] = strDados.split(";");
        if(vetorString.length < 6) throw new Exception ("Faltam dados na String");
        matricula = Integer.parseInt(vetorString[0]);
        nome = vetorString[1];
        email = vetorString[2];
        telefone = vetorString[3];
        sexo = Sexo.valueOf(vetorString[4]);
        status = Situacao.valueOf(vetorString[5]);
    }
    
    public Funcionario(int matricula, String nome, String email, String telefone, Sexo sexo, Situacao status){
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.status = status;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Situacao getStatus() {
        return status;
    }

    public void setStatus(Situacao status) {
        this.status = status;
    }
    @Override
    public String toString(){
        String str = matricula + ";" + nome + ";" +
                     email + ";" + telefone + ";" +
                     sexo.toString() + ";"  + 
                    status.toString();
        return str;
    }
}
