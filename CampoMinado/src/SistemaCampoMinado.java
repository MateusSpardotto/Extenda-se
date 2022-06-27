import java.util.Scanner;

public class SistemaCampoMinado {
	private CampoMinado campoMinado;

	private Scanner teclado;

	public SistemaCampoMinado() {
		teclado = new Scanner(System.in);
		campoMinado = new CampoMinado();
	}

	public void iniciarSistema() {
		int opcao;
		
		do {
			opcao = MostraMenu();
			
			switch (opcao) {
			case 1: iniciaJogo(); break;
			
			case 2: exibeHistorico(); break;
			
			case 3: limpaHistorico(); break;
			
			case 4: creditos(); break;
			
			case 0: break;
			
			default: System.out.println("Informe uma opção existente!"); break;
			}
		} while (opcao != 0);
	}

	private void creditos() {
		campoMinado.mostraCredito();
	}

	private void limpaHistorico() {
		campoMinado.limpaHistorico();
	}

	private void exibeHistorico() {
		campoMinado.exibeHistorico();
	}

	private void iniciaJogo() {
		int dificuldade = 0;
		boolean informouCorreto = false;
		
		do {
			System.out.println("Escolha o seu nível: ");
			System.out.println("1 - Fácil");
			System.out.println("2 - Médio");
			System.out.println("3 - Difícil");
			System.out.print(">>> ");
			
			dificuldade = teclado.nextInt();
			
			if (dificuldade > 0 && dificuldade <= 3)
				informouCorreto = true;
			else
				System.out.println("Informe uma opção existente!");
		} while (!informouCorreto);
		
		campoMinado.iniciaPartida(dificuldade);
	}

	private int MostraMenu() {
		System.out.println("Menu Principal");
		System.out.println("1 - Novo Jogo");
		System.out.println("2 - Exibir Histórico de Vitórias");
		System.out.println("3 - Limpar Históricos");
		System.out.println("4 - Créditos");
		System.out.println("0 - Sair");
		System.out.print(">>> ");
		return teclado.nextInt();
	}
}
