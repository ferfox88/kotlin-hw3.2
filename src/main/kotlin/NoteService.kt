import ru.netology.Comment
import ru.netology.CrudService
import ru.netology.Note

class NoteService : CrudService<Note, Comment> {
    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()

    override fun add(note: Note): Note {
        val idNote = if (notes.isNotEmpty()) notes.last().id + 1 else 1
        note.id = idNote
        notes.add(note)
        return notes.last()
    }

    override fun delete(id: Int): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (!note.markAsDeleted) {
                if (id == note.id) {
                    notes[index] = note.copy(
                        id = note.id,
                        markAsDeleted = true
                    )
                    return true
                }
            }
        }
        throw NoteNotFoundException("note not found")
    }

    override fun edit(id: Int, noteEdit: Note): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (!note.markAsDeleted) {
                if (id == note.id) {
                    notes[index] = note.copy(
                        id = note.id,
                        title = noteEdit.title,
                        text = noteEdit.text,
                        date = noteEdit.date,
                        markAsDeleted = note.markAsDeleted,
                        userId = note.userId
                    )
                    return true
                }
            }
        }
        throw NoteNotFoundException("note not found")
    }

    override fun read(userId: Int) {
        for (note in notes) {
            if (!note.markAsDeleted) {
                if (userId == note.userId) {
                    println(note)
                }
            }
        }
    }

    override fun getById(id: Int) {
        for (note in notes) {
            if (!note.markAsDeleted) {
                if (id == note.id) {
                    println(note)
                }
            }
        }
    }

    override fun addComment(id: Int, comment: Comment): Comment {
        for (note in notes) {
            if (!note.markAsDeleted) {
                if (id == note.id) {
                    val newCid = if (comments.isNotEmpty()) comments.last().cid + 1 else 1
                    val addComment = comment.copy(
                        cid = newCid,
                        noteId = note.id,
                        message = comment.message
                    )
                    comment.cid = newCid
                    comments.add(addComment)
                    return addComment
                }
            }
        }
        throw CommentNotFoundException("comment not found")
    }

    override fun deleteComment(id: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (!comment.markAsDeleted) {
                if (id == comment.cid) {
                    comments[index] = comment.copy(cid = comment.cid, markAsDeleted = true)
                    return true
                }
            }
        }
        throw CommentNotFoundException("comment not found")
    }

    override fun editComment(id: Int, commentEdit: Comment): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (!comment.markAsDeleted) {
                if (id == comment.cid) {
                    comments[index] =
                        comment.copy(
                            noteId = comment.noteId,
                            cid = comment.cid,
                            message = commentEdit.message)
                    return true
                }
            }
        }
        throw CommentNotFoundException("comment not found")
    }

    override fun readComment(id: Int) {
        for (comment in comments) {
            if (!comment.markAsDeleted) {
                if (id == comment.noteId) {
                    println(comment.message)
                }
            }
        }
    }

    override fun restoreComment(id: Int): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (id == comment.cid) {
                if (comment.markAsDeleted) {
                    comments[index] = comment.copy(cid = comment.cid, markAsDeleted = false)
                    return true
                }
            }
        }
        throw CommentNotFoundException("comment not found")
    }
}