package classes;

public class Transferencia {
	
	private int Valor;
	public Conta conta_destino;
	public Conta conta_origem;
	
	public Transferencia(Conta conta_origem, Conta conta_destino)
	{
		this.conta_destino = conta_destino;
		this.conta_origem = conta_origem;
	}	
	
	public void setvalor( int x)
	{
			this.Valor = x;
	}
	
	public int getvalor()
	{
		return Valor;
	}
}
