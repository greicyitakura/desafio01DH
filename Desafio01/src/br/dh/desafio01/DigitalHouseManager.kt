package br.dh.desafio01

import br.dh.desafio01.Curso as Curso

class DigitalHouseManager {


    var listaAluno = mutableListOf<Aluno>()
    var listaProfessorTitular = mutableListOf<ProfessorTitular>()
    var listaProfessorAdjunto = mutableListOf<ProfessorAdjunto>()
    var listaCurso = mutableListOf<Curso>()
    var listaMatricula = mutableListOf<Matricula>()
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
        val curso = listaCurso[verificarCodCurso(codCurso)]

        if (curso.vagasNaTurma()) {
        } else {
            println("Não foi possível fazer  matrícula de ${aluno} .Curso com capacidade máxima de alunos")
        }

    }

    fun vagasNaTurma(quantidadeMaxAlunos: Int): Int {
        val quantidadeMaxAlunos: Int.Companion = Int
        if (listaAluno.size < quantidadeMaxAlunos.MAX_VALUE) {
            return listaAluno.size
        } else {
            println("Turma Lotada ${listaAluno.size}. Capacidade máxima de alunos: $quantidadeMaxAlunos")
            return -1
        }
    }

    fun alocarProfessores(codCurso: Int, codProfessorTitular: Int, codProfessorAdjunto: Int) {
        val titular = encontrarProfessor(codProfessorTitular)
        val adjunto = encontrarProfessor(codProfessorAdjunto)
        val curso = encontrarCurso(codCurso)

        if (titular != null && adjunto != null && curso != null) {

            if (curso.professorAdjunto == null && curso.professorTitular == null) {
                curso.professorAdjunto = adjunto as ProfessorAdjunto?
                curso.professorTitular = titular as ProfessorTitular?
                println("Professores ${titular} e ${adjunto} alocados no curso ${curso}")
            } else {
                println("O curso ${curso} já possui os professores ${curso.professorTitular?.nome} e ${curso.professorAdjunto?.nome} alocados")
            }
        } else {
            println("Dados para alocação não encontrados")
        }
    } 
    private fun encontrarProfessor(codProfessorTitular: Int, codProfessorAdjunto: Int): Professor? {
        var professorEncontrado: Professor? = null
        listaProfessor.forEach { professor ->
            if (professor.codProfessor == codProfessorTitular && professor.codProfessor == codProfessorAdjunto) {
                professorEncontrado = professor
            }
        }
            return professorEncontrado
    }


        private fun encontrarCurso(codCurso: Int): Curso? {
            var cursoEncontrado: Curso? = null
            listaCurso.forEach { curso ->
                if (curso.codCurso == codCurso) {
                    cursoEncontrado = curso
                }
            }
            return cursoEncontrado
        }
}
