import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    @Test
    fun testAdd() {
        val post = Post(1,"Test Post")
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

        assertTrue(result)
        assertEquals(updatedPost.text, WallService.posts[0].text)
    }

    @Test
    fun testUpdate_notFound() {
        val post = Post(id = 1, text = "Test Post")
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