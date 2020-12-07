package br.dh.desafio01

class DigitalHouseManager {


    val listaAluno = mutableListOf<Aluno>()
    val listaProfessorTitular = mutableListOf<ProfessorTitular>()
    val listaProfessorAdjunto = mutableListOf<ProfessorAdjunto>()
    val listaCurso = mutableListOf<Curso>()
    val listaMatricula = mutableListOf<Matricula>()


    fun registrarCurso(nome: String, codCurso: Int, quantidadeMaxAlunos: Int) {
        val curso = Curso(nome, codCurso, quantidadeMaxAlunos)
        listaCurso.add(curso)

    }

    fun excluirCurso(nome: String, codCurso: Int, ) {
        listaCurso.removeAt(codCurso)
    }

    fun registrarProfessorAdjunto(
            nome: String,
            sobrenome: String,
            codProfessor: Int,
            qntHorasMentoria: Int) {

        val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codProfessor, qntHorasMentoria)
        listaProfessorAdjunto.add(professorAdjunto)

    }

    fun registrarProfessorTitular(
            nome: String,
            sobrenome: String,
            codProfessor: Int,
            tempoDeCasa: Int,
            especialidade: String) {

        val professorTitular = ProfessorTitular(nome, sobrenome, tempoDeCasa, codProfessor, especialidade)
        listaProfessorTitular.add(professorTitular)

    }

    fun excluirProfessor(codProfessor: Int) {
        listaProfessorTitular.removeAt(codProfessor)
        listaProfessorAdjunto.removeAt(codProfessor)
    }
    fun matricularAluno (nome: String, sobrenome: String, codAluno: Int){
       val novoaluno = Aluno(nome,sobrenome,codAluno)
        listaAluno.add(novoaluno)

    }
    fun matricularAlunoCurso(codCurso: Int, codAluno: Int) {
        val aluno = encontrarAluno(codAluno)
        val curso = encontrarCurso(codCurso)
        val novaMatricula = Matricula(aluno, curso)

        if (aluno != null && curso != null)

        if (curso.adicionarUmAluno(aluno)) {
            listaMatricula.add(novaMatricula)
                println("Aluno ${aluno.nome} foi matriculado no curso de ${curso.nome} com sucesso! " +
                        "\n Data da matrícula realizada: ${novaMatricula.dataMatricula}")

        } else {
            println("Não foi possível realizar a matrícula! Curso com capacidade máxima de ${curso.quantidadeMaxAlunos}")
        }

    }
    fun encontrarAluno(codAluno: Int): Aluno? {
        var alunoEncontrado: Aluno? = null
        listaAluno.forEach {aluno->
            if(aluno.codAluno == codAluno) {
                alunoEncontrado == aluno
            }
        }
        return alunoEncontrado
    }
     fun encontrarCurso(codCurso: Int): Curso? {
        var cursoEncontrado: Curso? = null
        listaCurso.forEach{curso->
            if(curso.codCurso == codCurso) {
                cursoEncontrado == curso
            }
        }
        return cursoEncontrado
    }
    fun alocarProfessores(codCurso: Int, codProfessor: Int, ){

        var professorTitular: ProfessorTitular? = listaProfessorTitular[codProfessor]
        var professorAdjunto: ProfessorAdjunto? = listaProfessorAdjunto[codProfessor]

        listaCurso[codCurso]?.professorTitular = professorTitular
        listaCurso[codCurso]?.professorAdjunto = professorAdjunto
    }

}




