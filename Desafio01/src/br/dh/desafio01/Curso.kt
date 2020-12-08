package br.dh.desafio01

open class Curso(
        val nome: String,
        val codCurso: Int,
        val quantidadeMaxAlunos: Int,
        var professorTitular: ProfessorTitular? = ProfessorTitular("", "", 0, 0,""),
        var professorAdjunto: ProfessorAdjunto? = ProfessorAdjunto("", "", 0, 0, 0),

) {
    var listaAluno = mutableListOf<Aluno>()

    var alunosMatriculados: MutableList<Aluno> = mutableListOf<Aluno>()

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        if (alunosMatriculados.size <= quantidadeMaxAlunos) {
            alunosMatriculados.add(umAluno)
            println("\nAluno ${umAluno.nome} ${umAluno.sobrenome} adicionado ao curso")
            alunosMatriculados.add(umAluno)
            return true
        } else return false
    }

    fun excluirAluno(umAluno: Aluno){
        alunosMatriculados.remove(umAluno)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codCurso != other.codCurso) return false

        return true
    }

    fun vagasNaTurma(): Boolean {

        if (listaAluno.size < quantidadeMaxAlunos){return true}
        else{
            println("Turma Completa. Capacidade máxima de alunos: ${quantidadeMaxAlunos}")
            return false
        }
    }
}

