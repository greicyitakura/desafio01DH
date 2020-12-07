package br.dh.desafio01

fun main () {
    val digitalHouseManager = DigitalHouseManager()

    //registro de professor titular

    digitalHouseManager.registrarProfessorTitular("Aline", "Barros", 1, 2, "Backend")
    digitalHouseManager.registrarProfessorTitular("Bruno", "Carvalho", 2, 3, "Scrum")

   println(digitalHouseManager.listaProfessorTitular)

    //registro professor adjunto
    digitalHouseManager.registrarProfessorAdjunto("Carmen", "Dorival", 3, 100)
    digitalHouseManager.registrarProfessorAdjunto("Denis", "Ebano", 4, 120)

   println(digitalHouseManager.listaProfessorAdjunto)


    // registro de curso
    digitalHouseManager.registrarCurso("FullStack",20001,3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)

   println(digitalHouseManager.listaCurso)

    // Matricula de Alunos
    digitalHouseManager.matricularAluno("Erica", "Ferreira",12)
    digitalHouseManager.matricularAluno("Fernando", "Guerra",13)
    digitalHouseManager.matricularAluno("Greicy", "Honda",14)
    digitalHouseManager.matricularAluno("Henrique", "Igla",15)
    digitalHouseManager.matricularAluno("Ingrid", "Jacks",16)

    println(digitalHouseManager.listaAluno)

    // Matricular aluno no curso

    digitalHouseManager.matricularAlunoCurso(20001,12)
    digitalHouseManager.matricularAlunoCurso(20001,13)
    digitalHouseManager.matricularAlunoCurso(20001,14)

    println(digitalHouseManager.listaMatricula)

    digitalHouseManager.matricularAlunoCurso(20002,15)
    digitalHouseManager.matricularAlunoCurso(20002,16)

    println(digitalHouseManager.listaMatricula)










}