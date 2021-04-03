import org.junit.Test
import ru.netology.*
import org.junit.Assert.*

class NoteServiceTest {
    private val service = NoteService()

    @Test
    fun addSuccessful() {
    val note1 = Note(
        title = "Привет", text = "текст1", date = 16, userId = 22
    )
    service.add(note1)
    val result = note1.id > 0
    assertTrue(result)
    }

    @Test
    fun addNoSuccessful() {
        val note1 = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        val result = note1.id > 0
        assertFalse(result)
    }

    @Test
    fun deleteSuccessful() {
        val note1 = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note1)
        val result = service.delete(1)
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteNoSuccessful() {
        service.delete(1)
    }

    @Test
    fun editSuccessful() {
        val note1 = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note1)
        val note2 = Note(
            title = "Привет", text = "новый текст1", date = 26, userId = 22
        )
        val result = service.edit(1, note2)
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editNoSuccessful() {
        val note1 = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note1)
        val note2 = Note(
            title = "Привет", text = "новый текст1", date = 26, userId = 22
        )
        service.edit(2, note2)
    }

    @Test
    fun readSuccessful() {
        val note1 = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note1)
        service.read(22)
    }

    @Test
    fun getByIdSuccessful() {
        val note1 = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note1)
        service.getById(1)
    }

    @Test
    fun addCommentSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(1,comment1)
        val result = comment1.cid > 0
        assertTrue(result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun addCommentNoSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(2,comment1)
    }

    @Test
    fun deleteCommentSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(1,comment1)
        val result = service.delete(1)
        assertTrue(result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun deleteCommentNoSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        service.deleteComment(1)
    }

    @Test
    fun editCommentSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(1,comment1)
        val comment1Edit = Comment(noteId = 1, message = "новый комент1")
        assertTrue(service.editComment(1, comment1Edit))
    }

    @Test(expected = CommentNotFoundException::class)
    fun editCommentNoSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(1,comment1)
        val comment1Edit = Comment(noteId = 1, message = "новый комент1")
        service.editComment(2, comment1Edit)
    }

    @Test
    fun readCommentSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(1,comment1)
        service.readComment(1)
    }

    @Test
    fun restoreCommentSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(1,comment1)
        service.deleteComment(1)
        assertTrue(service.restoreComment(1))
    }

    @Test(expected = CommentNotFoundException::class)
    fun restoreCommentNoSuccessful() {
        val note = Note(
            title = "Привет", text = "текст1", date = 16, userId = 22
        )
        service.add(note)
        val comment1 = Comment(noteId = 1, message = "комент1")
        service.addComment(1,comment1)
        service.restoreComment(1)
    }
}