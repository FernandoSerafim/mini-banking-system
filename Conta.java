package classes;

public class Conta {
	
	private int Saldo; //criei esse atributo Saldo como op��o para as transfer�ncias e a somat�ria final
	private int Numero; //n�mero da conta
	public Cliente cliente;//ISSO SERIA UM PONTEIRO EM C++
	//EM JAVA, APARENTEMENTE A C�PIA DO OBJETO � ALOCADA NA HEAP E PERMITE ALTERA��O
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
