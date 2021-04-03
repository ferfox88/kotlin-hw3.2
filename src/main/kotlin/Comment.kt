package ru.netology

data class Comment(
    var cid: Int = 0,
    val noteId: Int, //	идентификатор заметки.
    val message: String, //текст комментария
    val markAsDeleted: Boolean = false
)
