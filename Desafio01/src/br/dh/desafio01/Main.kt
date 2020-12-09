package br.dh.desafio01

fun main () {
    val digitalHouseManager = DigitalHouseManager()

    //registro de professor titular

    val profTitular1 = digitalHouseManager.registrarProfessorTitular("Aline", "Barros", 1, 2, "Backend")
    val profTitular2 = digitalHouseManager.registrarProfessorTitular("Bruno", "Carvalho", 2, 3, "Scrum")

    // digitalHouseManager.excluirProfessor("Aline",1)


    //registro professor adjunto
    val profAdjunto1 = digitalHouseManager.registrarProfessorAdjunto("Carmen", "Dorival", 3, 100)
    val profAdjunto2 = digitalHouseManager.registrarProfessorAdjunto("Denis", "Ebano", 4, 120)


    // registro de curso
    val curso1 = digitalHouseManager.registrarCurso("FullStack", 20001, 3)
    val curso2 = digitalHouseManager.registrarCurso("Android", 20002, 2)

    digitalHouseManager.excluirCurso("FullStack",20001)


    // Matricula de Alunos
    val aluno1 = digitalHouseManager.matricularAluno("Erica", "Ferreira", 12)
    val aluno2 = digitalHouseManager.matricularAluno("Fernando", "Guerra", 13)
    val aluno3 = digitalHouseManager.matricularAluno("Greicy", "Honda", 14)
    val aluno4 = digitalHouseManager.matricularAluno("Henrique", "Igla", 15)
    val aluno5 = digitalHouseManager.matricularAluno("Ingrid", "Jacks", 16)

    println(digitalHouseManager.listaAluno.size)

    //Matricular alunos no curso
    digitalHouseManager.matricularAlunoCurso(12, 20001)
    digitalHouseManager.matricularAlunoCurso(13, 20001)
    digitalHouseManager.matricularAlunoCurso(14, 20001)
    // digitalHouseManager.matricularAlunoCurso(16,20001)

    digitalHouseManager.matricularAlunoCurso(16, 20002)
    digitalHouseManager.matricularAlunoCurso(15, 20002)

    println(digitalHouseManager.listaCurso.size)

    //Alocando Prof
    digitalHouseManager.alocarProfessores(20001,1,3)
    digitalHouseManager.alocarProfessores(20002,2,4)



}


