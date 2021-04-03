package ru.netology
import NoteService

fun main() {
    val service = NoteService()

    val note1 = Note(
        title = "Привет", text = "текст1", date = 16, userId = 22
    )
    val note2 = Note(
        title = "Привет!!", text = "текст2", date = 26, userId = 22
    )
    val note3 = Note(
        title = "Привет!!!!", text = "текст3", date = 36, userId = 22
    )
    val note4 = Note(
        title = "hi", text = "текст4", date = 46, userId = 22
    )

    service.add(note1)
    service.add(note2)
    service.add(note3)
    service.add(note4)

    service.read(22)

    service.delete(2)
    val note5 = Note(0, "hello", "новый текст3", 33, userId = 223)
    service.edit(3, note5)

    println()
    service.read(22)

    println()
    service.getById(3)
    println()

    val comment1 = Comment(noteId = 1, message = "комент1")
    val comment2 = Comment(noteId = 3, message = "комент2")
    val comment3 = Comment(noteId = 3, message = "комент3")

    println(service.addComment( 1, comment1))
    println(service.addComment(3, comment2))
    println(service.addComment(3, comment3))

    service.deleteComment(1)

    val comment5 = Comment(noteId = 3, message = "новый комент 3")
    service.editComment(3, comment5)

    service.readComment(3)
    service.readComment(1)

    service.restoreComment(1)

    service.readComment(1)

}