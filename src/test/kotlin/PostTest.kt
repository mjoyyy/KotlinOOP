import org.junit.Test
import org.junit.Assert.*
import Attachment as Attachment1

class PostTest {
    @Test
    fun testEquals() {
        val post1 = Post(
            ownerId = 1,
            fromId = 2,
            createdBy = 2,
            attachments = arrayOf(Attachment1("image1"), Attachment1("image2")),
            text = "Hello, world!",
            likes = 10,
            reposts = 5,
            postType = "Simple",
            canPin  = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            isFavorite = false,
            id = 1
        )
        val post2 = Post(
            ownerId = 1,
            fromId = 2,
            createdBy = 2,
            attachments = arrayOf(Attachment1("image1"), Attachment1("image2")),
            text = "Hello, world!",
            likes = 10,
            reposts = 5,
            postType = "Simple",
            canPin  = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            isFavorite = false,
            id = 1
        )
        assertEquals(post1, post2)
    }

    @Test
    fun getOwnerId() {
    }
}