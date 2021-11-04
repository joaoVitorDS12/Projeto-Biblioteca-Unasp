package MainPack;

import java.util.Scanner;
import java.util.LinkedList;
import java.lang.Math;

/*  Cadastro de Aluno [Feito]
 *  Remoção de Aluno [Feito]
 *  Pesquisar Aluno por nome [Feito]
 *  Listar todos os Alunos [Feito]
 *  
 *  Registro de Livro [Feito]
 *  Remoçao de livro [Feito]
 *  Pesquisar Livro por ISBN [Feito]
 *  Listar todos os Livros [Feito]
 *  
 *  Cadastrar empréstimo [Feito]
 *  ^ Não deixar alunos com empréstimos atrasados cadastrar outro empréstimo [Feito]
 *  Listar todos empréstimos em atraso [Feito]
 *  Listar todos alunos que fizeram um emprestimo de um livro X [Feito]
 *  Remover empréstimo [Feito]
 */


public class Main {
	
	// Criandos as listas para uso futuro	
	static LinkedList<Aluno> listAlunos = new LinkedList<Aluno>();
	static LinkedList<Livro> listLivros = new LinkedList<Livro>();
	static LinkedList<Emprestimo> listEmprestimos = new LinkedList<Emprestimo>();
	
	public static void main(String[] args) {
		
		seedInfo();
		
		// Etiqueta para o nosso loop while, dessa forma é possivel quebrar-lo dentro do nosso switch
		Mainloop: while (true) {
			
			MenuBiblioteca();
			
			int option = FancyInputInt(">> Escolha sua opção baseado no menu acima: ");
			switch(option) {
			case 0:
				System.out.println(">> Saindo do programa.");
				break Mainloop;
			case 1:
				cadastrarAluno();
				break;
			case 2:
				removerAluno();
				break;
			case 3:
				pesquisarAluno();
				break;
			case 4:
				listarAluno();
				break;
			case 5:
				cadastrarLivro();
				break;
			case 6:
				removerLivro();
				break;
			case 7:
				pesquisarLivro();
				break;
			case 8:
				listarLivro();
				break;
			case 9:
				cadastrarEmprestimo();
				break;
			case 10:
				removerEmprestimo();
				break;
			case 11:
				pesquisarEmprestimo();
				break;
			case 12:
				listarEmprestimo();
				break;
			default:
				System.out.println(">> Opção invalida.");
				MenuBiblioteca();
				break;
			}
		}
	}
	
	
	static void MenuBiblioteca() {
		// ──────────────────────────────────
		// ┌ ┐ │ ├ ┤ └ ┘ ─ ┬ ┴ ┼
		
		// System.out.println("│ N — E │");
		
		System.out.println("┌──────────────┬──────┬──────────────┐");
		System.out.println("│              │ MENU │              │");
		System.out.println("├────┬─────────┴──────┴──────────────┤");
		System.out.println("│ 0  │ Sair                          │");
		System.out.println("├────┼───────────────────────────────┤");
		System.out.println("│ 1  │ Cadastrar aluno               │");
		System.out.println("│ 2  │ Remover aluno                 │");
		System.out.println("│ 3  │ Pesquisar aluno por nome      │");
		System.out.println("│ 4  │ Todos alunos cadastrados      │");
		System.out.println("├────┼───────────────────────────────┤");
		System.out.println("│ 5  │ Registar livro                │");
		System.out.println("│ 6  │ Remover livro                 │");
		System.out.println("│ 7  │ Pesquisar livro por titulo    │");
		System.out.println("│ 8  │ Todos livros registrados      │");
		System.out.println("├────┼───────────────────────────────┤");
		System.out.println("│ 9  │ Registar empréstimo           │");
		System.out.println("│ 10 │ Remover empréstimo            │");
		System.out.println("│ 11 │ Listar empréstimos do livro X │");
		System.out.println("│ 12 │ Listar empréstimos atrasados  │");
		System.out.println("└────┴───────────────────────────────┘");
	}
	
	
	// Categoria: Aluno
	
	public static Aluno existeAluno(int RA) {
		for (Aluno aluno : listAlunos) {
			if (aluno.getRA() == RA) {
				return aluno;
			}
		}
		return null;
	}
	static void cadastrarAluno() {
		Aluno tAluno = new Aluno();
		
		tAluno.setNome(FancyInputString("\n>> Qual é o nome desse aluno? "));
		tAluno.setEmail(FancyInputString("\n>> Qual é o email desse aluno? "));
		tAluno.setRA(FancyInputInt("\n>> Qual sera o RA desse aluno? "));
		tAluno.setCurso(FancyInputString("\n>> Qual curso esse aluno esta cursando? "));
		
		if (existeAluno(tAluno.getRA()) == null) {
			listAlunos.add(tAluno);
			System.out.printf("\n>> %s cadastrado com sucesso no sistema.\n", tAluno.getNome());
		} else {
			System.out.println(">> Aluno ja existe!");
		}
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void removerAluno() {
		int RA = FancyInputInt("\n>> Digite o RA do aluno a ser removido: ");
		
		Aluno delAluno = null;
		for (Aluno aluno : listAlunos) {
			if (aluno.getRA() == RA) {
				delAluno = aluno;
				break;
			}
		}
		
		if (delAluno != null) {
			listAlunos.remove(delAluno);
			System.out.println("\n>> Aluno removido do sistema.");
		} else {
			System.out.println("\n>> RA do aluno não encontrado no sistema");
		}
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void pesquisarAluno() {
		String nome = FancyInputString("\n>> Digite o nome do aluno que você quer pesquisar: ");
		for (Aluno aluno : listAlunos) {
			if (aluno.getNome().equals(nome)) {
				System.out.println("");
				System.out.println("┌───ID───┬─────RA─────┬──────────────────────NOME──────────────────────┬─────────────────────E-MAIL─────────────────────┬─────────────────CURSO─────────────────┐");
				System.out.print(addSpace("│" + aluno.getId(), 9));
				System.out.print(addSpace("│" + aluno.getRA(), 13));
				System.out.print(addSpace("│" + aluno.getNome(), 49));
				System.out.print(addSpace("│" + aluno.getEmail(), 49));
				System.out.print(addSpace("│" + aluno.getCurso(), 40) + "│\n");
				System.out.println("└────────┴────────────┴────────────────────────────────────────────────┴────────────────────────────────────────────────┴───────────────────────────────────────┘");
			}
		}
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void listarAluno() {
		
		
		// ──────────────────────────────────
		// ┌ ┐ │ ├ ┤ └ ┘ ─ ┬ ┴ ┼
		System.out.println("");
		System.out.println("┌───ID───┬─────RA─────┬──────────────────────NOME──────────────────────┬─────────────────────E-MAIL─────────────────────┬─────────────────CURSO─────────────────┐");
		for (Aluno aluno : listAlunos) {
			
			System.out.print(addSpace("│" + aluno.getId(), 9));
			System.out.print(addSpace("│" + aluno.getRA(), 13));
			System.out.print(addSpace("│" + aluno.getNome(), 49));
			System.out.print(addSpace("│" + aluno.getEmail(), 49));
			System.out.print(addSpace("│" + aluno.getCurso(), 40) + "│\n");
		}
		System.out.println("└────────┴────────────┴────────────────────────────────────────────────┴────────────────────────────────────────────────┴───────────────────────────────────────┘");
		FancyInputString(">> Pressione tecla para continuar.");
	}
	
	
	// Categoria: Livro

	public static Livro existeLivro(int ISBN) {
		for (Livro livro : listLivros) {
			if (livro.getISBN() == ISBN) {
				return livro;
			}
		}
		return null;
	}
	static void cadastrarLivro() {
		Livro tLivro = new Livro();
		
		tLivro.setTitulo(FancyInputString("\n>> Qual é o titulo desse livro? "));
		tLivro.setEditora(FancyInputString("\n>> Qual é a editora desse livro? "));
		tLivro.setISBN(FancyInputInt("\n>> Qual é o ISBN desse livro? "));
		tLivro.setAno(FancyInputInt("\n>> Qual ano esse livro foi publicado? "));
		
		if (existeLivro(tLivro.getISBN()) == null) {
			listLivros.add(tLivro);
			System.out.printf("\n>> %s cadastrado com sucesso no sistema.\n", tLivro.getTitulo());
		} else {
			System.out.println("\n>> Livro ja existe!");
		}
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void removerLivro() {
		int ISBN = FancyInputInt("\n>> Digite o ISBN do livro a ser removido: ");
		
		Livro delLivro = null;
		for (Livro livro : listLivros) {
			if (livro.getISBN() == ISBN) {
				delLivro = livro;
				break;
			}
		}
		
		if (delLivro != null) {
			listLivros.remove(delLivro);
			System.out.println("\n>> Livro removido do sistema.");
		} else {
			System.out.println("\n>> ISBN do livro não encontrado no sistema");
		}
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void pesquisarLivro() {
		String titulo = FancyInputString("\n>> Digite o Titulo do livro que você quer pesquisar: ");
		for (Livro livro : listLivros) {
			if (livro.getTitulo().equals(titulo)) {
				System.out.println("");
				System.out.println("┌───ID───┬────ISBN────┬─────────────────────TITULO─────────────────────┬─────────────────────EDITORA─────────────────────┬─────────────────ANO─────────────────┐");
				System.out.print(addSpace("│" + livro.getId(), 9));
				System.out.print(addSpace("│" + livro.getISBN(), 13));
				System.out.print(addSpace("│" + livro.getTitulo(), 49));
				System.out.print(addSpace("│" + livro.getEditora(), 50));
				System.out.print(addSpace("│" + livro.getAno(), 38) + "│\n");
				System.out.println("└────────┴────────────┴────────────────────────────────────────────────┴─────────────────────────────────────────────────┴─────────────────────────────────────┘");
			}
		}
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void listarLivro() {
		
		
		// ──────────────────────────────────
		// ┌ ┐ │ ├ ┤ └ ┘ ─ ┬ ┴ ┼
		System.out.println("");
		System.out.println("┌───ID───┬────ISBN────┬─────────────────────TITULO─────────────────────┬─────────────────────EDITORA─────────────────────┬─────────────────ANO─────────────────┐");
		for (Livro livro : listLivros) {
			
			System.out.print(addSpace("│" + livro.getId(), 9));
			System.out.print(addSpace("│" + livro.getISBN(), 13));
			System.out.print(addSpace("│" + livro.getTitulo(), 49));
			System.out.print(addSpace("│" + livro.getEditora(), 50));
			System.out.print(addSpace("│" + livro.getAno(), 38) + "│\n");
		}
		System.out.println("└────────┴────────────┴────────────────────────────────────────────────┴─────────────────────────────────────────────────┴─────────────────────────────────────┘");
		FancyInputString(">> Pressione tecla para continuar.");
	}
	
	
	// Categoria: Empréstimo
	
	static void cadastrarEmprestimo() {
		Emprestimo tEmprestimo = new Emprestimo();
		
		loopAluno: while (true) {
			int RA = FancyInputInt("\n>> Digite o RA do aluno que requer o empréstimo. (000 = cancelar empréstimo)");
			if (RA == 000) {
				System.out.println("\n>> Ação Cancelada.");
				return;
			}
			
			for (Aluno aluno: listAlunos) {
				if (aluno.getRA() == RA) {
					
					for (Emprestimo emprestimo : listEmprestimos) {
						if (emprestimo.getAluno().equals(aluno)) {
							if (emprestimo.getAtraso() == true) {
								System.out.printf("\n>> Aluno %s tem empréstimos em atraso. Ele não pode requisitar mais empréstimos até o atraso for resolvido.", aluno.getNome());
								break;
							}
						}
					}
					tEmprestimo.setAluno(aluno);
					break loopAluno;
				}
			}
		}
		
		
		loopLivro: while (true) {
			int ISBN = FancyInputInt("\n>> Digite o ISBN do Livro à ser emprestado. (000 = Cancelar empréstimo)");
			if (ISBN == 000) {
				System.out.println("\n>> Ação Cancelada.");
				return;
			}
			for (Livro livro : listLivros) {
				if (livro.getISBN() == ISBN) {
					tEmprestimo.setLivro(livro);
					break loopLivro;
				}
			}	
		}
		
		loopTest: while (true) {
			int atrasoControl = FancyInputInt("\n(TESTE) Marcar empréstimo como atrasado? 1 = Sim; 2 = Não");
			switch (atrasoControl) {
			case 1:
				tEmprestimo.setAtraso(true);
				System.out.println("\nEmpréstimo marcado como atrasado.");
				break loopTest;
			case 2:
				tEmprestimo.setAtraso(false);
				System.out.println("\nEmpréstimo marcado como não atrasado.");
				break loopTest;
			default:
				System.out.println("\nValor inválido.");
			}		
		}
		
		listEmprestimos.add(tEmprestimo);
		System.out.printf("\n>> Empréstimo com id %s do livro \"%s\" para o aluno \"%s\" cadastrado com sucesso no sistema.\n", tEmprestimo.getId(), tEmprestimo.getLivro().getTitulo(), tEmprestimo.getAluno().getNome());
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void removerEmprestimo() {
		
		int id = FancyInputInt("\n>> Digite o ID do empréstimo.");
		
		
		Emprestimo delEmprestimo = null;
		for (Emprestimo emprestimo : listEmprestimos) {
			if (emprestimo.getId() == id) {
				delEmprestimo = emprestimo;
				break;
			}
		}
		
		if (delEmprestimo != null) {
			listEmprestimos.remove(delEmprestimo);
			System.out.println("\n>> Empréstimo removido do sistema.");
		} else {
			System.out.println("\n>> Empréstimo não encontrado no sistema.");
		}
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void pesquisarEmprestimo() {
		int ISBN = FancyInputInt("\n>> Digite o ISBN do livro a ser analisado:");
		
		System.out.println("");
		System.out.println("┌───ID───┬─────RA─────┬──────────────────────NOME──────────────────────┬─────────────────────TITULO─────────────────────┬──ATRASO──┐");
		for (Emprestimo emprestimo : listEmprestimos) {
			if (emprestimo.getLivro().getISBN() == ISBN) {
				System.out.print(addSpace("│" + emprestimo.getId(), 9));
				System.out.print(addSpace("│" + emprestimo.getAluno().getRA(), 13));
				System.out.print(addSpace("│" + emprestimo.getAluno().getNome(), 49));
				System.out.print(addSpace("│" + emprestimo.getLivro().getTitulo(), 49));
				System.out.print(addSpace("│" + String.valueOf(emprestimo.getAtraso()).toUpperCase(), 11) + "│\n");
			}
		}
		System.out.println("└────────┴────────────┴────────────────────────────────────────────────┴────────────────────────────────────────────────┴──────────┘");
		FancyInputString(">> Pressione tecla para continuar.");
	}
	static void listarEmprestimo() {
		
		System.out.println("");
		System.out.println("┌───ID───┬─────RA─────┬──────────────────────NOME──────────────────────┬────ISBN────┬─────────────────────TITULO─────────────────────┐");
		for (Emprestimo emprestimo : listEmprestimos) {
			if (emprestimo.getAtraso() == true) {
				System.out.print(addSpace("│" + emprestimo.getId(), 9));
				System.out.print(addSpace("│" + emprestimo.getAluno().getRA(), 13));
				System.out.print(addSpace("│" + emprestimo.getAluno().getNome(), 49));
				System.out.print(addSpace("│" + emprestimo.getLivro().getISBN(), 13));
				System.out.print(addSpace("│" + emprestimo.getLivro().getTitulo(), 49) + "│\n");
			}
		}
		System.out.println("└────────┴────────────┴────────────────────────────────────────────────┴────────────┴────────────────────────────────────────────────┘");
		FancyInputString(">> Pressione tecla para continuar.");
	}
	
	
	// Categoria: Outros
	// Função generica para input de números porque eu odeio ficar usando o Scanner normalmente.
	static int FancyInputInt(String msg) {
		System.out.println(msg);
		
		// try dentro de um loop para que eu possa forçar o usuário a digitar um valor correto e não apenas deixar o programa se desintegrar...
		// ...caso ele bote uma String por exemplo.
		while (true)  {
			try {
				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();
				
				return num;
			} catch (Exception bruh) {
				System.out.println("Erro. Entre um valor válido.");	
			}
		}
	}
	
	// Função generica para input de texto porque eu odeio ficar usando o Scanner normalmente.
	static String FancyInputString(String msg) {
		System.out.println(msg);
		
		// try dentro de um loop para que eu possa forçar o usuário a digitar um valor correto e não apenas deixar o programa se desintegrar depois...
		// ...caso ele bote apenas um espaço ou nada por exemplo.
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				String txt = sc.nextLine();
				
				// Checando se o esperto não deu um enter sem nada na linha ou apenas espaços.
				if(txt.trim().equals("")) {
					
					// Levantando uma exceção manualmente para apresentar a mensagem de erro.
					throw new Exception("Bruh moment");
				} else {
					return txt;
				}

			} catch (Exception bruh) {
				System.out.println("Erro. Entre um valor válido.");	
			}
		}
	}
	
	// Alinhamento de espaços para a listagem.
	static String addSpace(String txt, int spaces) {
		
		String outTxt = txt;
		for (int i = 0; i < spaces - txt.length(); i++) {
			outTxt += " ";
		}
		return outTxt;
	}
	
	// Gerador de número aleatório.
	public static int generateRandInt(int min,int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
	// Nomes pré-definidos para encher as listas automaticamente.
	static void seedInfo() {
		for (int i = 1; i <= 9; i++) {
			Livro livro = new Livro();
			livro.setTitulo("Titulo " + i);
			livro.setISBN(generateRandInt(10000, 99999));
			livro.setEditora("Editora " + i);
			livro.setAno(Integer.parseInt(String.format("200%s", i)));
			listLivros.add(livro);

			Aluno aluno = new Aluno();
			aluno.setCurso("Curso " + i);
			aluno.setNome("Pessoa " + i);
			aluno.setEmail(aluno.getNome().replaceAll(" ", "") + "@randmail.com");
			aluno.setRA(generateRandInt(10000, 99999));
			listAlunos.add(aluno);
			
			Emprestimo emprestimo = new Emprestimo();
			emprestimo.setAluno(aluno);
			emprestimo.setLivro(livro);
			boolean randBool = (generateRandInt(0, 1) > 0 ? true : false);
			emprestimo.setAtraso(randBool);
			listEmprestimos.add(emprestimo);
		}
	}
	

}
