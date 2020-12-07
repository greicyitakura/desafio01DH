package br.dh.desafio01

open class Professor(val nome: String, val sobrenome: String, var tempoDeCasa: Int, var codProfessor: Int) {

    override fun toString(): String {
        return "Professor(nome='$nome', " +
                "Sobrenome='$sobrenome', " +
                "tempo de Casa=$tempoDeCasa, " +
                "cod. do Professor=$codProfessor)"
    }
}