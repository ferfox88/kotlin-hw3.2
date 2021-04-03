package ru.netology

data class Note(
    var id: Int = 0, //идентификатор заметки
    val title: String, //заголовок заметк
    val text: String, //текст заметки
    val date: Int, //дата создания заметки в формате Unixtime
    val markAsDeleted: Boolean = false,
    val userId: Int
)