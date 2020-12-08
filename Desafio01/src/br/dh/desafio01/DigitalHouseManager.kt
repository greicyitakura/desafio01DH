package br.dh.desafio01

import br.dh.desafio01.Curso as Curso

class DigitalHouseManager {


    var listaAluno = mutableListOf<Aluno>()
    var listaProfessorTitular = mutableListOf<ProfessorTitular>()
    var listaProfessorAdjunto = mutableListOf<ProfessorAdjunto>()
    var listaCurso = mutableListOf<Curso>()
    var listaMatricula = mutableListOf<Matricula>()



    fun registrarCurso(nome: String, codCurso: Int, quantidadeMaxAlunos: Int) {
        val curso = Curso(nome, codCurso, quantidadeMaxAlunos)
        listaCurso.add(curso)
        println("Curso $nome adicionado com sucesso")

    }

    fun excluirCurso(nome: String, codCurso: Int) {
        val curso = listaCurso
        if (curso != null) {
            listaCurso.remove(curso)
            println("Curso ${curso} removido com sucesso")
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
        listaProfessorTitular.removeAt(codProfessor)
        println("O(a) professor(a) titular $nome foi removido com sucesso.")
        listaProfessorAdjunto.removeAt(codProfessor)
        println("O(a) professor(a) adjunto $nome foi removido com sucesso.")

    }fun matricularAluno (nome: String, sobrenome: String, codAluno: Int, ){
        val novoAluno = Aluno(nome,sobrenome,codAluno)
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


    fun matricularAlunoCurso(codAluno: Int,codCurso: Int){

        val aluno = listaAluno[verificarCodAluno(codAluno)]
        val curso = listaCurso[verificarCodCurso(codCurso)]
        val matricula = Matricula(aluno, curso)

        if (curso.vagasNaTurma()){
        }else{println("Não foi possível fazer  matrícula de ${aluno.nome} ${aluno.sobrenome}.Curso com capacidade máxima de alunos")}

    }
    fun verificarCodCurso(codCurso: Int): Int {

        for ((index) in listaCurso.withIndex()){if (listaCurso[index].codCurso == codCurso){return index}}
        return -1
    }
    fun vagasNaTurma(): Boolean {
        val quantidadeMaxAlunos: Int.Companion = Int
        if (listaAluno.size < quantidadeMaxAlunos.MAX_VALUE) {
             return true}
        else{
            println("Turma Lotada ${listaAluno.size}. Capacidade máxima de alunos: $quantidadeMaxAlunos")
            return false
        }
    }
}





