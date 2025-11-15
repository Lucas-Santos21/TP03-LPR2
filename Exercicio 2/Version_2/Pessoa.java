public class Pessoa
{
    private static int kp;
    private String nome;
    private char sexo;
    private int idade;

    
    public Pessoa()
    {
        setNome("");
        setSexo(' ');
        setIdade(0); 
    }

    public Pessoa(String nome, char sexo, int idade)
    {
        setKp();
        setNome(nome);
        setSexo(sexo);
        setIdade(idade);
    }

    //Getters e Setters
    public static int getKp()
    {
        return kp;
    }
    
    public static void setKp()
    {
        kp++;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public char getSexo()
    {
        return this.sexo; 
    }

    public void setSexo(char sexo)
    {
        this.sexo = sexo;
    }

    public int getIdade()
    {
        return this.idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }
}