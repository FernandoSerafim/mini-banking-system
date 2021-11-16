package classes;
import java.util.Scanner;

public class Operador 
{
	/**
	 * @param B1 OBJETO DE BANCO SIMULANDO UMA AG�NCIA PARA CONTROLE DE CONTAS E CLIENTES
	 * @return void RETORNO DO TIPO VOID POIS OS OBJETOS S�O PASSADOS POR REFER�NCIA
	 */
	/*
	 * FUN��O COM OBJETIVO DE APENAS EXIBIR DADOS SIMPLES DO CLIENTE, NO CASO NOME E CPF
	 */
public void listaClientes(Banco B1) 
{
	int i;
	
		for(i=0; i<B1.clientes.size(); i++)
		{
			System.out.println("Nome do cliente " + B1.clientes.get(i).getNome() + "\n");
			System.out.println("CPF do cliente " + B1.clientes.get(i).getCPF() + "\n");
		}
		
}
	
/**
 * @param B1 OBJETO DE BANCO SIMULANDO UMA AG�NCIA PARA CONTROLE DE CONTAS E CLIENTES
 * @return void RETORNO DO TIPO VOID POIS OS OBJETOS S�O PASSADOS POR REFER�NCIA
 */
/*
 * FUN��O COM OBJETIVO DE EXIBIR TODOS OS DADOS CO CLIENTE, INCLUINDO SALDO E N� DA CONTA
 */
public void listaContas(Banco B1)
{
	int i;

	for(i=0; i<B1.contas.size(); i++)
	{
		System.out.println("Nome do cliente " + B1.clientes.get(i).getNome() + "\n");
		System.out.println("CPF do cliente " + B1.clientes.get(i).getCPF() + "\n");
		System.out.println("Numero da conta do cliente " + B1.contas.get(i).getnumero() + "\n");
		System.out.println("Saldo do cliente " + B1.contas.get(i).getsaldo() + "\n");
	}
		
}

/**
 * @param B1 AG�NCIA DO BANCO QUE ESTABELECE AS RELA��ES
 * @param scan OBJETO PARA LEITURA DE ENTRADA DE DADOS PASSADO POR REFER�NCIA
 */
/*
 * FUN��O COM OBJETIVO DE EXIBIR O SALDO DO CLIENTE USANDO CPF COMO CHAVE
 */
public void saldoDoCliente(Banco B1, Scanner scan)
{
		int recebeCpf, i, contador = 0;
		
	try {
			
			System.out.println("Digite seu cpf, por favor\n");
			recebeCpf = scan.nextInt();
			
		for(i=0; i<B1.contas.size(); i++)
		{
			if(recebeCpf == B1.contas.get(i).cliente.getCPF())
			{
				System.out.print("O saldo do senhor(a) " + B1.contas.get(i).cliente.getNome());
				System.out.println("� " + B1.contas.get(i).getsaldo() + "\n");
			}else contador++;
		}
			
		if(contador == B1.contas.size()) throw new ExcecaoPesonalizada();
		
		}catch(ExcecaoPesonalizada e) {
			System.out.println("O CPF DIGITADO N�O EXISTE!\n");
		}
}
/**
 * @param p UTILIZADO COMO VARI�VEL DE CONTROLE PARA GERENCIAR O ARRAY DE TRANSFER�NCIAS
 */
/*FUN��O COM O OBJETIVO DE EFETUAR UMA TRANSFER�NCIA*/
public void realizaTransferencia (Banco B1, int p, Scanner scan)
{
  int numContaOrigem, numContaDestino, valorTransferencia;
  int i, aux1 = 0, aux2 = 0, contadorOrigem = 0, contadorDestino = 0;
		
  try{
	    System.out.println("Digite o valor da transa��o\n");
		valorTransferencia = scan.nextInt();
		System.out.println("Digite o numero da conta de origem\n");
		numContaOrigem = scan.nextInt(); 
					
		System.out.println("Digite o numero da conta de destino\n");
		numContaDestino = scan.nextInt();
		
		//OS DOIS LOOPINGS VERIFICAM SE AS ENTRADAS EXISTEM NO ARRAY
		for(i=0; i < B1.contas.size(); i++) {
			if(numContaOrigem != B1.contas.get(i).getnumero()) contadorOrigem++;
		}
		
		for(i=0; i < B1.contas.size(); i++) {
			if(numContaDestino != B1.contas.get(i).getnumero()) contadorDestino++;
		}
		
		if(contadorOrigem == B1.contas.size()) throw new ExcecaoPesonalizada();
		else 
			if(contadorDestino == B1.contas.size()) {
				IllegalArgumentException erro = new IllegalArgumentException();
				throw erro;
			}
/*
 * OBS: CRIEI DOIS TIPOS DE EXCE��ES PARA EXERCITAR OS CATCH E DIFERENCIAR QUANDO �
 * A CONTA DE ORIGEM QUE N�O EST� CADASTRADA OU A CONTA DE DESTINO
 */					
		
	for(i=0; i < B1.contas.size(); i++) //vai verificar todas as posi��es do vetor
		{
					
		  if( B1.contas.get(i).getnumero() == numContaOrigem )
			{
			  B1.contas.get(i).setsaldo(B1.contas.get(i).getsaldo() - valorTransferencia);
			  aux1 = i;
		    }
					
		  if(numContaDestino == B1.contas.get(i).getnumero())
		    {
			  B1.contas.get(i).setsaldo(B1.contas.get(i).getsaldo() + valorTransferencia);
			  aux2 = i;
		    }
					
		}
										
	   	 B1.transferencia.add(new Transferencia( B1.contas.get(aux1), B1.contas.get(aux2) ));						
	     B1.transferencia.get(p).setvalor(valorTransferencia);
		 System.out.println("Valor da transa��o = "+B1.transferencia.get(p).getvalor()+" ");
	  
  }catch(ExcecaoPesonalizada e){
	  
	    System.out.println("ERRO: A CONTA DE ORIGEM N�O EXISTE\n");
	    
  }catch(IllegalArgumentException erro) {
	  
	  System.out.println("A CONTA DE DESTINO N�O EXISTE!\n");
	  
  }
	
}
/*FUN��O COM OBJETIVO DE OBTER O EXTRATO DE DETERMINADA CONTA UTILIZANDO COMO CHAVE O 
 N�MERO DA CONTA*/
public void Extrato(Banco B1, Scanner scan)
{
		int i, numeroDaConta, NaoExiste = 0;
			
	try{
		
		System.out.println("Digite o numero da sua conta\n");
		numeroDaConta = scan.nextInt();
			
		for(i=0; i < B1.transferencia.size(); i++){
			if(numeroDaConta != B1.transferencia.get(i).conta_origem.getnumero() && numeroDaConta != B1.transferencia.get(i).conta_destino.getnumero()) {
				NaoExiste++;
			}
		}
		
		if(NaoExiste == B1.transferencia.size()) throw new ExcecaoPesonalizada();
			
		for(i=0; i < B1.transferencia.size(); i++)
		{
			if( numeroDaConta == B1.transferencia.get(i).conta_origem.getnumero() )
			{
				System.out.println("Voce enviou " + B1.transferencia.get(i).getvalor());
				System.out.println(" para o cliente " + B1.transferencia.get(i).conta_destino.cliente.getNome() );
			}
		}
		
		for(i=0; i < B1.transferencia.size(); i++)
		{
			if(numeroDaConta == B1.transferencia.get(i).conta_destino.getnumero())
			{
				System.out.print("Voce recebeu " + B1.transferencia.get(i).getvalor() );
				System.out.println(" do cliente " + B1.transferencia.get(i).conta_origem.cliente.getNome() );	
			}
		}
			
		}catch(ExcecaoPesonalizada e) {
			System.out.println("ERRO: N�O � POSS�VEL VERFICAR O EXTRATO POIS A CONTA INEXISTE!");
		}
}

/*FUN��O PARA VERIFICAR SE O BALAN�O DAS CONTAS � MANTIDO*/
public void Somatorio(Banco B1)
	{
		int i, soma = 0;
		
		for(i=0; i < B1.contas.size(); i++)
		{
			soma = B1.contas.get(i).getsaldo() + soma;
		}
		System.out.println("A soma de todas as conta e: " + soma);
	}
}
