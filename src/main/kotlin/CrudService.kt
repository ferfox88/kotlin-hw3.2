package ru.netology

interface CrudService<E, C> {

    fun add(entity: E): E
    fun delete(id: Int): Boolean
    fun edit(id: Int, entity: E): Boolean
    fun read(id: Int)
    fun getById(id: Int)

    fun addComment(id: Int, entity: C): C
    fun deleteComment(id: Int): Boolean
    fun editComment(id: Int, entity: C): Boolean
    fun readComment(id: Int)
    fun restoreComment(id: Int): Boolean
}