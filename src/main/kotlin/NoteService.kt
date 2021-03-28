import ru.netology.Comment
import ru.netology.Note

class NoteService {
    private var notes = mutableListOf<Note>()
    private var comments = mutableListOf<Comment>()
    private var deletNote = mutableListOf<Note>()
    private var deletComment = mutableListOf<Comment>()

    fun add(note: Note) {
        val idNote = if (notes.isNotEmpty()) notes.last().id + 1 else 1
        note.id = idNote
        notes.add(note)
    }

    fun createComment(comment: Comment): Boolean {
        for (note in notes) {
            if (note.id == comment.noteId) {
                val idComment = if (comments.isNotEmpty()) comments.last().cid + 1 else 1
                comment.cid = idComment
                comments.add(comment)
                return true
            }
        }
        return false
    }

    fun notesDelete(note: Note): Boolean {
        if (notes.contains(note)) {
            deletNote.add(note)
            notes.remove(note)
            return true
        } else throw NoteNotFoundException("note not found")
    }

    fun notesDeleteComment(comment: Comment): Boolean {
        if (comments.contains(comment)) {
            deletComment.add(comment)
            comments.remove(comment)
            return true
        } else throw CommentNotFoundException("comment not found")
    }

    fun notesEdit(note: Note): Boolean {
        for ((index) in notes.withIndex()) {
            if (note.id == notes[index].id) {
                notes[index] = note.copy(
                    id = note.id,
                    title = note.title,
                    text = note.text,
                    date = note.date
                )
                return true
            }
        }
        return false
    }

    fun notesEditComment(comment: Comment): Boolean {
        for ((index) in comments.withIndex()) {
            if (comment.cid == comments[index].cid) {
                comments[index] = comment.copy(
                    cid = comment.cid,
                    noteId = comment.noteId,
                    message = comment.message
                )
                return true
            }
        }
        return false
    }

    fun notesGet(note: Note) {
        if (notes.isNotEmpty()) {
            println(notes)
        } else throw NoteNotFoundException("note not found")
    }

    fun notesGetById(id: Int): Note {
        for (note in deletNote) {
            if (note.id == id) {
                notes.add(note)
                deletNote.remove(note)
                return note
            }
        }
        throw CommentNotFoundException("comment not found")
    }

    fun notesGetComments(comment: Comment) {
        if (comments.isNotEmpty()) {
            println(comments)
        } else throw CommentNotFoundException("comment not found")
    }

    fun notesRestoreComment(comment: Comment): Boolean {
        if (deletComment.contains(comment)) {
            comments.add(comment)
            deletComment.remove(comment)
            return true
        } else throw CommentNotFoundException("comment not found")
    }

}