package classes;

public class Conta {
	
	private int Saldo; //criei esse atributo Saldo como opção para as transferências e a somatória final
	private int Numero; //número da conta
	public Cliente cliente;//ISSO SERIA UM PONTEIRO EM C++
	//EM JAVA, APARENTEMENTE A CÓPIA DO OBJETO É ALOCADA NA HEAP E PERMITE ALTERAÇÃO
	//DOS VALORES
	public Conta()
	{
		/*EMPTY CONSTRUCTOR*/
	}
	
	public Conta(Cliente cliente)
	{
		this.cliente = cliente;
	}

	public void setsaldo(int x)
	{
		this.Saldo = x;
	}
	public void setNumero(int x)
	{
		this.Numero = x;
	}
	public int getsaldo()
	{
		return Saldo;
	}
	public int getnumero()
	{
		return Numero;
	}
}
