package MainPack;

public class Emprestimo {
	
	// Inicializando a variavél estatica que será usada para dar um id unico para cada objeto da classe Emprestimo
	private static int count = 0;
	
	// Inicializando os outros parametros
	private int id;
	private Aluno aluno;
	private Livro livro;
	private boolean Atraso;
	
	
	
	// Construtor
	public Emprestimo() {
		
		// Var estática 'count' é incrementada então é atribuida para o id
		id = ++count;
		Atraso = false;
	}
	
	
	// Métodos para atribuir e puxar os valores do objeto.
	// Exemplo: getBla() seria para puxar o valor do parametro "Bla", e setBla() seria para atribuir um novo valor para o parametro "Bla".
	
	// Aluno
	public void setAluno(Aluno newAluno) {
		this.aluno = newAluno;
	}
	public Aluno getAluno() {
		return aluno;
	}
	
	// Livro
	public void setLivro(Livro newLivro) {
		this.livro = newLivro;
	}
	public Livro getLivro() {
		return livro;
	}
	
	// id
	public int getId() {
		return id;
	}
	
	// Atraso
	public boolean getAtraso() {
		return Atraso;
	}
	
	public void setAtraso(boolean newAtraso) {
		Atraso = newAtraso;
	}

}
