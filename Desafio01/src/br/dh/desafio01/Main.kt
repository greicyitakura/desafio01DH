package br.dh.desafio01

fun main () {
    val digitalHouseManager = DigitalHouseManager()

    //registro de professor titular

    digitalHouseManager.registrarProfessorTitular("Aline", "Barros", 1, 2, "Backend")
    digitalHouseManager.registrarProfessorTitular("Bruno", "Carvalho", 2, 3, "Scrum")

    // digitalHouseManager.excluirProfessor("Aline",1)


    //registro professor adjunto
    digitalHouseManager.registrarProfessorAdjunto("Carmen", "Dorival", 3, 100)
    digitalHouseManager.registrarProfessorAdjunto("Denis", "Ebano", 4, 120)

    // registro de curso
    digitalHouseManager.registrarCurso("FullStack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)


    // Matricula de Alunos
    digitalHouseManager.matricularAluno("Erica", "Ferreira", 12)
    digitalHouseManager.matricularAluno("Fernando", "Guerra", 13)
    digitalHouseManager.matricularAluno("Greicy", "Honda", 14)
    digitalHouseManager.matricularAluno("Henrique", "Igla", 15)
    digitalHouseManager.matricularAluno("Ingrid", "Jacks", 16)

    println(digitalHouseManager.listaAluno)


    //Matricular alunos no curso
    digitalHouseManager.matricularAlunoCurso(12, 20001)
    digitalHouseManager.matricularAlunoCurso(13,20001)
    digitalHouseManager.matricularAlunoCurso(14,20001)

    //digitalHouseManager.matricularAlunoCurso(15,20002)
    digitalHouseManager.matricularAlunoCurso(16,20002)

    digitalHouseManager.matricularAlunoCurso(15,20001)

}

