package classes;
import java.util.Scanner;
import java.util.ArrayList;

public class Banco {

	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public ArrayList<Conta> contas = new ArrayList<Conta>();
	public ArrayList<Transferencia> transferencia = new ArrayList<Transferencia>();

/**
 * @param scan OBJETO PARA LEITURA DE ENTRADAS DE DADOS PASSADO POR REFERÊNCIA*/
	/*
	 * ESSA SERIA A FUNÇÃO DE CADASTRO. FORAM CRIADOS SOMENTE DOIS CLIENTE COM RESPECTIVAS
	 * DUAS CONTAS PARA FACILITAR A VERIFICAÇÃO DA FUNCIONALIDADE DO SISTEMA*/
	public void InstanciaRelacoes(Scanner scan)
	{
		int cpf, numeroConta, aux = 0;
		String nome; 
		
		do
		{
			System.out.println("Nome do cliente \n");		
			nome = scan.next(); 
			
			System.out.println("Numero do CPF \n");
			cpf = scan.nextInt();
			
			clientes.add(new Cliente());
			clientes.get(aux).setNome(nome);
			clientes.get(aux).setCPF(cpf);			
			
			System.out.println("Digite o numero da conta\n");
			numeroConta = scan.nextInt();
			
			contas.add(new Conta(clientes.get(aux))); //talvez passar pelo set?
			contas.get(aux).setNumero(numeroConta);
			contas.get(aux).setsaldo(1000);
			
			aux++;
		}while(aux != 2);
		
}
	
/*FUNÇÃO PARA DELETAR OS ARRAYS DE CLIENTES E DE CONTAS*/	
public void EsvaziaSistema() 
{
		clientes.clear();
		contas.clear();
		System.out.println("SISTEMA LIMPO COM SUCESSO\n");
}
}