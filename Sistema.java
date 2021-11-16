package classes;
import java.util.Scanner;

/**
 * @author Fernando
 */
public class Sistema {

	/*
	 * FUNÇÃO MAIN ÚNICA E EXCLUSIVAMENTE GERENCIA OS OBJETOS PARA OPERAÇÕES
	 * UTILIZEI SOMENTE UM OBJETO SCANNER PASSADO POR REFERÊNCIA ÀS OUTRAS CLASSES
	 * TEREMOS APENAS UM OBJETO DE OPERADOR E APENAS UM OBJETO DE BANCO
	 * VARIÁVEL PARA CONTROLE DAS OPERAÇÕES A SEREM EFETUADAS (opt)
	 * POR FIM, DELETAMOS OS ARRAYS E DEIXAMOS O SISTEMA LIMPO
	 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Operador p1 = new Operador();
		Banco B1 = new Banco();
		int opt;
		int p = 0; //NÃO TEM COMO SER PONTEIRO MAIS
		
		B1.InstanciaRelacoes(scan);
	
	try {
		do
		{
			
				System.out.println("Digite a opção que deseja realizar\n");
				opt = scan.nextInt();
				
				if(opt < 0) {
					//IllegalArgumentException erro = new IllegalArgumentException();
					//ExcecaoPesonalizada e =  new ExcecaoPesonalizada();
					//throw e;
					throw new ExcecaoPesonalizada();
				}
			
		switch(opt)
			{
			case 0:
				
				p1.Somatorio(B1);
				System.out.println("ENCERRANDO SISTEMA");
				break;
			case 1:
				p1.listaClientes(B1);
				break;
			case 2:
				p1.listaContas(B1); 
				break;
			case 3:
				p1.saldoDoCliente(B1, scan);
				break;
			case 4:
				if(B1.transferencia.size() > 0) //remodelar isso, já que não temos vector
				{
					p1.Extrato(B1, scan); 
				}else{
					System.out.println("Não há histórico suficiente para isso\n");
				}
				break;
			case 5:
				p1.realizaTransferencia(B1, p, scan);
				p = p+1;
				break;
			default:
				
				System.out.println("Entrada inválida\n");
				
			}
			
			
		}while(opt != 0);
		
		}catch(ExcecaoPesonalizada e) {
			System.out.println("ERRO: NÚMEROS NEGATIVOS NÃO SÃO PERMITIDOS\n");
		}
	
		scan.close();
		B1.EsvaziaSistema();
	}

}
