package candidatura;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		
		analisarCandidato(1900.0);
		analisarCandidato(2200.0);
		analisarCandidato(2000.0);
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
