import junit.framework.TestCase.assertEquals
import org.junit.*
import kotlin.test.assertFalse

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        val post = Post(1, "Hello modified")
        WallService.update(post)
    }

    @Test
    fun testAdd() {
        val post = Post(1,"Post text added")
        val addedPost = WallService.add(post)
        assertEquals(post.text, addedPost.text)
        assertEquals(1, addedPost.id)
    }

    @Test
    fun testUpdate() {
        val post = Post(id = 1, text = "Test Post")
        WallService.add(post)

        val updatedPost = post.copy(text = "Updated Test Post")
        val result = WallService.update(updatedPost)
        assertEquals(false, result)
    }

    @Test
    fun testUpdate_notFound() {
        val post = Post(id = 1, text = "Test ")
        WallService.add(post)
        val updatedPost = post.copy(id = 2)
        val result = WallService.update(updatedPost)
        assertFalse(result)
    }


    @Test
    fun testPrintAll() {
        val post1 = Post(id = 1, text = "Test Post 1")
        val post2 = Post(id = 2, text = "Test Post 2")
        WallService.add(post1)
        WallService.add(post2)
        WallService.printAll()
    }

    @Test
    fun testMain() {
        val post = Post(id = 1, text = "Test Post")
        WallService.add(post)
        WallService.add(post)
        WallService.update(Post(id = 2, text = "Updated Test Post"))
        main()
    }
}