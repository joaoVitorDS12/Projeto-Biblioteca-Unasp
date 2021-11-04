package MainPack;

public class Livro {
	
	// Inicializando a variavél estatica que será usada para dar um id unico para cada objeto da classe Livro
	private static int count = 0;
		
	// Inicializando os outros parametros
	private int id;
	private int ISBN;
	private String Titulo;
	private String Editora;
	private int Ano;
	
	
	// Construtor
	public Livro() {
		
		// Var estática 'count' é incrementada então é atribuida para o id
		id = ++count;
	}
	
	
	// Métodos para atribuir e puxar os valores do objeto.
	// Exemplo: getBla() seria para puxar o valor do parametro "Bla", e setBla() seria para atribuir um novo valor para o parametro "Bla".
	
	// ISBN
	public void setISBN(int newISBN) {
		ISBN = newISBN;
	}
	public int getISBN() {
		return ISBN;
	}
	
	// Titulo
	public void setTitulo(String newTitulo) {
		Titulo = newTitulo;
	}
	public String getTitulo() {
		return Titulo;
	}
	
	// Editora
	public void setEditora(String newEditora) {
		Editora = newEditora;
	}
	public String getEditora() {
		return Editora;
	}
	
	// Ano
	public void setAno(int newAno) {
		Ano = newAno;
	}
	public int getAno() {
		return Ano;
	}
	
	// id
	public int getId() {
		return id;
	}
		
	
	
}
