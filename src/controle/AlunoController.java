package controle;

import java.util.List;
import java.util.ArrayList;

import entidade.Aluno;
import entidade.Candidato;
import entidade.Curso;

public class AlunoController {
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private int proximaMatricula = 0;
	
	public void importarCandidatos(List<Candidato> candidatos, int ano) {
		for (Candidato candidato : candidatos) {
			Aluno aluno = (Aluno) candidato;
			aluno.setNome(candidato.getNome());
			aluno.setCpf(candidato.getCpf());
			aluno.setEmail(candidato.getEmail());
			aluno.setNotaEnem(candidato.getNotaEnem());
			aluno.setCurso(candidato.getCurso());
			aluno.setNumeroInscricao(candidato.getNumeroInscricao());
			aluno.setMatricula(aluno.getCurso().getSigla() 
								+ Integer.toString(++proximaMatricula));
			aluno.setAnoIngresso(ano);
			aluno.setEmailInstitucional(aluno.getMatricula() 
								+ "@ifam.edu.br");
			alunos.add(aluno);
		}
	}
	
	public void listarAlunos(Curso curso) {
		System.out.println("");
		for (Aluno aluno : alunos) {
			if(aluno.getCurso().equals(curso)) {
				System.out.println("Matrícula: " + aluno.getMatricula());
				System.out.println("");
			}
		}
	}

}
