package classes;
import java.util.Scanner;

/**
 * @author Fernando
 */
public class Sistema {

	/*
	 * FUN��O MAIN �NICA E EXCLUSIVAMENTE GERENCIA OS OBJETOS PARA OPERA��ES
	 * UTILIZEI SOMENTE UM OBJETO SCANNER PASSADO POR REFER�NCIA �S OUTRAS CLASSES
	 * TEREMOS APENAS UM OBJETO DE OPERADOR E APENAS UM OBJETO DE BANCO
	 * VARI�VEL PARA CONTROLE DAS OPERA��ES A SEREM EFETUADAS (opt)
	 * POR FIM, DELETAMOS OS ARRAYS E DEIXAMOS O SISTEMA LIMPO
	 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Operador p1 = new Operador();
		Banco B1 = new Banco();
		int opt;
		int p = 0; //N�O TEM COMO SER PONTEIRO MAIS
		
		B1.InstanciaRelacoes(scan);
	
	try {
		do
		{
			
				System.out.println("Digite a op��o que deseja realizar\n");
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
				if(B1.transferencia.size() > 0) //remodelar isso, j� que n�o temos vector
				{
					p1.Extrato(B1, scan); 
				}else{
					System.out.println("N�o h� hist�rico suficiente para isso\n");
				}
				break;
			case 5:
				p1.realizaTransferencia(B1, p, scan);
				p = p+1;
				break;
			default:
				
				System.out.println("Entrada inv�lida\n");
				
			}
			
			
		}while(opt != 0);
		
		}catch(ExcecaoPesonalizada e) {
			System.out.println("ERRO: N�MEROS NEGATIVOS N�O S�O PERMITIDOS\n");
		}
	
		scan.close();
		B1.EsvaziaSistema();
	}

}
