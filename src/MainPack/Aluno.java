package MainPack;

public class Aluno {
	
	// Inicializando a variavél estatica que será usada para dar um id unico para cada objeto da classe Aluno
	private static int count = 0;
	
	// Inicializando os outros parametros
	private int id;
	private int RA;
	private String Nome;
	private String Email;
	private String Curso;
	
	
	// Construtor
	public Aluno() {
		
		// Var estática 'count' é incrementada então é atribuida para o id
		id = ++count;
	}
	
	
	// Métodos para atribuir e puxar os valores do objeto.
	// Exemplo: getBla() seria para puxar o valor do parametro "Bla", e setBla() seria para atribuir um novo valor para o parametro "Bla".
	
	// RA
	public void setRA(int newRA) {
		RA = newRA;
	}
	public int getRA() {
		return RA;
	}
	
	// Nome
	public void setNome(String newNome) {
		Nome = newNome;
	}
	public String getNome() {
		return Nome;
	}
	
	// Email
	public void setEmail(String newEmail) {
		Email = newEmail;
	}
	public String getEmail() {
		return Email;
	}
	
	// Curso
	public void setCurso(String newCurso) {
		Curso = newCurso;
	}
	public String getCurso() {
		return Curso;
	}
	
	// id
	public int getId() {
		return id;
	}
	
	
	
	
}
