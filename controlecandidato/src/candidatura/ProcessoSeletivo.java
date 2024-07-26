package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		
		analisarCandidato(1900.0);
		analisarCandidato(2200.0);
		analisarCandidato(2000.0);
		
		selecaoCandidatos();
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
}
