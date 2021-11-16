package classes;

public class Cliente {
	
	private String nome;
	private int cpf;
	
	public Cliente()
	{
		/*EMPTY CONSTRUCTOR*/
	}
	public void setNome(String x)
	{
		this.nome = x;
	}
	public String getNome()
	{
		return nome;
	}
	public void setCPF(int x)
	{
		this.cpf = x;
	}
	public int getCPF()
	{
		return cpf;
	}
}
