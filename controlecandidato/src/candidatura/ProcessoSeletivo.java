package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		
		analisarCandidato(1900.0);
		analisarCandidato(2200.0);
		analisarCandidato(2000.0);
		
		selecaoCandidatos();		
		imprimirSelecionados();
		ligacaoCandidatos();
	}
	
	static void selecaoCandidatos() {
		
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
		
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		
		double salarioBase = 2000.0;
		
		while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {			
			String candidato = candidatos[candidatosAtual];
			double salarioPretendido = valorPretendido();
			
			
			System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + String.format("%.2f", salarioPretendido));
			
			if (salarioBase >= salarioPretendido ) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;				
			}
			candidatosAtual++;
		}				
		
		for ( String candidato : candidatos) {
			System.out.println(candidato);
		}					
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
		
	static void analisarCandidato(Double salarioPretendido) {
		
		double salarioBase = 2000.0;
		
		if (salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");			
		} else if (salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA");			
		} else {
			System.out.println("AGUARDANDO RESULTADO DE DEMAIS CANDIDATOS");			
		}		
	}
	
	static void imprimirSelecionados() {
		
		System.out.println(" ");
		
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		
		System.out.println("Imprimindo a lista de candidatos informando o indice do elemento:");
		
		for (int i = 0; i < candidatos.length; i++) {
			System.out.println("O candidato de nº " + (i + 1) + " é o " + candidatos[i]);			
		}
		
		System.out.println("");
		System.out.println("Forma abreviada de interação for each");
		
		for (String candidato : candidatos) {
			System.out.println("O candidato Selecionado foi " + candidato);
		}
	}
	
	static void ligacaoCandidatos() {
		String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		
		for (String candidato : candidatos) {
			System.out.println("Ligando para o candidato Selecionado: " + candidato);
			entrandoEmContato(candidato);
		}
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			
			if (continuarTentando) {
				tentativasRealizadas++;
			} else {
				System.out.println("CONTATO REALIZADO COM SUCESSO!");
			}		
			
		} while(continuarTentando && tentativasRealizadas < 3);
		
		if (atendeu) {
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "º CHAMADA.");			
		} else {
			System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidato + ", NUMERO MÁXIMO DE " + tentativasRealizadas + " CHAMADAS");
		}
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}	
}
