
data class Post (
    val id: Int,
    var text: String
)

object WallService {
    var posts = emptyArray<Post>()
    private var nextId = 1
    fun clear() {
        posts = emptyArray()
        Post(id = 0, text = "")
    }

    fun add(post: Post): Post {
        posts += post.copy(id = nextId++)
        return posts.last()
    }

    fun update(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }

    fun printAll() {
        for (post in posts) {
            println(post)
        }
    }
}

fun main(){
    val post = Post(1, "Hello")
    WallService.add(post)
    WallService.add(post)
    WallService.printAll()
    println(WallService.update(Post(2, "Kotlin")))
    WallService.printAll()
}