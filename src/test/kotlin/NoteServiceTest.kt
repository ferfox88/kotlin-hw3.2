//import org.junit.Test
import ru.netology.*
import org.junit.Assert.*
import org.junit.jupiter.api.Test

class NoteServiceTest {
    val service = NoteService()

    @Test
    fun add() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val result = note.id > 0
        assertTrue(result)
    }

    @Test
    fun createCommentTrue() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        val result = service.createComment(comment1)
        assertTrue(result)
    }

    @Test
    fun createCommentFalse() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val comment1 = Comment(noteId = 2, message = "комент1")
        val result = service.createComment(comment1)
        assertFalse(result)
    }

    @Test
    fun notesDelete() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val result = service.notesDelete(note)
        assertTrue(result)
    }

//    @Test(expected = NoteNotFoundException::class)
//    fun notesDeleteFalse() {
//        val note = Note(
//            title = "Привет", text = "текст1", date = 16
//        )
//        service.notesDelete(note)
//        assertTrue(service.notesDelete(note))
//    }

    @Test
    fun notesDeleteComment() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.createComment(comment1)
        val result = service.notesDeleteComment(comment1)
        assertTrue(result)
    }

    @Test
    fun notesEdit() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val result = service.notesEdit(note)
        assertTrue(result)
    }

    @Test
    fun notesEditFalse() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        val result = service.notesEdit(note)
        assertFalse(result)
    }

    @Test
    fun notesEditComment() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.createComment(comment1)
        val result = service.notesEditComment(comment1)
        assertTrue(result)
    }

    @Test
    fun notesEditCommentFalse() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        val result = service.notesEditComment(comment1)
        assertFalse(result)
    }

    @Test
    fun notesGet() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        service.notesGet(note)
    }

    @Test
    fun notesGetById() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        service.notesDelete(note)
        service.notesGetById(1)
    }

    @Test
    fun notesGetComments() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.createComment(comment1)
        service.notesGetComments(comment1)
    }

    @Test
    fun notesRestoreComment() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.createComment(comment1)
        service.notesDeleteComment(comment1)
        val result = service.notesRestoreComment(comment1)
        assertTrue(result)
    }
}