package br.dh.desafio01

import br.dh.desafio01.Curso as Curso

class DigitalHouseManager {


    var listaAluno = mutableListOf<Aluno>()
    var listaProfessorTitular = mutableListOf<ProfessorTitular>()
    var listaProfessorAdjunto = mutableListOf<ProfessorAdjunto>()
    var listaCurso = mutableListOf<Curso>()
    var listaProfessor = mutableListOf<Professor>()


    fun registrarCurso(nome: String, codCurso: Int, quantidadeMaxAlunos: Int) {
        val curso = Curso(nome, codCurso, quantidadeMaxAlunos)
        listaCurso.add(curso)
        println("Curso $nome adicionado com sucesso")

    }

    fun excluirCurso(nome: String, codCurso: Int) {
        val curso = listaCurso
        if (curso != null) {
            listaCurso.remove(curso)
            println("Curso $curso removido com sucesso")
        } else {
            println("Curso não encontrado")
        }
    }

    fun registrarProfessorAdjunto(
            nome: String,
            sobrenome: String,
            codProfessor: Int,
            qntHorasMentoria: Int) {

        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codProfessor, qntHorasMentoria)
        listaProfessorAdjunto.add(professorAdjunto)
        println("O professor adjunto $nome foi registrado com sucesso.")

    }

    fun registrarProfessorTitular(
            nome: String,
            sobrenome: String,
            codProfessor: Int,
            tempoDeCasa: Int,
            especialidade: String) {

        val professorTitular = ProfessorTitular(nome, sobrenome, tempoDeCasa, codProfessor, especialidade)
        listaProfessorTitular.add(professorTitular)
        println("O(a) professor(a) titular $nome foi registrado com sucesso.")

    }

    fun excluirProfessor(nome: String, codProfessor: Int) {
        for (professorTitular: Professor in listaProfessorTitular) {
            listaProfessorTitular.removeAt(codProfessor)
            println("O(a) professor(a) titular $nome foi removido com sucesso.")
        }
        for (professorAdjunto: Professor in listaProfessorAdjunto) {
            listaProfessorAdjunto.removeAt(codProfessor)
            println("O(a) professor(a) adjunto $nome foi removido com sucesso.")
        }

    }

    fun matricularAluno(nome: String, sobrenome: String, codAluno: Int, ) {
        val novoAluno = Aluno(nome, sobrenome, codAluno)
        listaAluno.add(novoAluno)
        println("O(a) Aluno(a)  $nome foi matriculado com sucesso.")
    }


    fun verificarCodAluno(codAluno: Int): Int {
        for ((index) in listaAluno.withIndex()) {
            if (listaAluno[index].codAluno == codAluno) {
                return index
            }
        }
        return -1
    }

    fun verificarCodCurso(codCurso: Int): Int {

        for ((index) in listaCurso.withIndex()) {
            if (listaCurso[index].codCurso == codCurso) {
                return index
            }
        }
        return -1
    }


    fun matricularAlunoCurso(codAluno: Int, codCurso: Int) {

        val aluno = listaAluno[verificarCodAluno(codAluno)]
        var curso = listaCurso[verificarCodCurso(codCurso)]

        if (listaCurso.size > 0) {
            for (i in 0..listaCurso.size - 1) {
                if (listaCurso.get(i).codCurso == codCurso) {
                    curso = listaCurso.get(i);
                }
            }
        }
        if (listaCurso == null) {
            println("Não foi possível matricular o aluno! Curso não encontrado.");
            return;
        }
    }


    fun alocarProfessores( codCurso: Int, codProfessorTitular: Int, codProfessorAdjunto: Int) {
        var titular: ProfessorTitular? = null
        var adjunto: ProfessorAdjunto? = null
        var curso: Curso? = null

        if (titular != null && adjunto != null && curso != null) {
            for (professor in listaProfessor) {
                if (professor.codProfessor == codProfessorTitular && professor is ProfessorTitular &&
                        professor.codProfessor == codProfessorAdjunto && professor is ProfessorAdjunto) {
                    titular = titular
                }
                if (titular == null) {
                    println("Não foi possível alocar! Professor titular não encontrado.");
                    return;
                }
            }
        }
    }
}


