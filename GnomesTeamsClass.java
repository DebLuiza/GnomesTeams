import java.util.*;

public class GnomesTeamsClass {

	static class Gnomio {
		String nome;
		int idade;

		public Gnomio(String nome, int idade) {
			this.nome = nome;
			this.idade = idade;
		}
		
		 public String toString() {
	            return nome + " " + idade;
	     }
	
	}
	
	public static List<Gnomio> ordenarGnomios(List<Gnomio> gnomios) {
		int j = 0;
		Gnomio gnomioAux;
		
		for(int i = 0; i < gnomios.size(); i++) {
			j = i - 1;
			gnomioAux = gnomios.get(i);
			
			while( j >= 0 && (gnomios.get(j).idade < gnomioAux.idade || gnomios.get(j).idade == gnomioAux.idade && gnomios.get(j).nome.compareTo(gnomioAux.nome) > 0)) {
				gnomios.set(j + 1,gnomios.get(j));
				j--;
			}
			
			gnomios.set(j + 1, gnomioAux);
			
		}
		return gnomios;
	}
	
	public static List<List<Gnomio>> organizarGnomios(List<Gnomio> gnomios, int qtdGnomios) {
		ordenarGnomios(gnomios);//ordenando gnomios
		
		List<List<Gnomio>> grupos = new ArrayList<>();
		int diferenca = qtdGnomios/3;
		
		for(int i = 0; i < diferenca; i++) {
			grupos.add(new ArrayList<>());//instanciando grupos
		}
		
		int j = 0;
		for(int i = 0; i < qtdGnomios; i++) {
			grupos.get(j).add(gnomios.get(i));
			j = (j + 1) % diferenca;
		}
		return grupos;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int qtdGnomios = sc.nextInt(), i = 0;
		sc.nextLine();

		if( qtdGnomios % 3 !=0 ) {
			System.out.println("Favor digitar um múltiplo de 3");
		}else {
			List<Gnomio> dadosGnomios = new ArrayList<>();

			while (i < qtdGnomios) {
				String linha = sc.nextLine();
				String[] linhaSeparada = linha.trim().split("\\s+");


				dadosGnomios.add(new Gnomio(linhaSeparada[0], Integer.parseInt(linhaSeparada[1])));
				i++;
			}
			
			List<List<Gnomio>> grupos = organizarGnomios(dadosGnomios, qtdGnomios);
			for(i = 0; i < grupos.size(); i++) {
				System.out.println("Grupo " + (i+1));
				for (Gnomio gnomio : grupos.get(i)) {
                    System.out.println(gnomio); 
                }
			}
			
		}
		
		sc.close();
	}

}
