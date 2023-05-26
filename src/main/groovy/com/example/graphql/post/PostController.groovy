package com.example.graphql.post

// todo we can kill this import by using another interface => zero dependencies to the author package
import com.example.graphql.author.Author
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class PostController {

    private PostRepository postRepository
    private AuthorDao authorDao

    PostController(PostRepository postRepository, AuthorDao authorDao) {
        this.postRepository = postRepository
        this.authorDao = authorDao
    }

    @SuppressWarnings('unused')
    @QueryMapping
    List<Post> recentPosts(@Argument int count, @Argument int offset) {
        postRepository.getRecent(count, offset)
    }

    @SuppressWarnings('unused')
    @MutationMapping
    Post createPost(@Argument String title, @Argument String text,
                    @Argument String category, @Argument String authorId) {

        Post post = new Post()
        post.id = UUID.randomUUID().toString()
        post.title = title
        post.text = text
        post.category = category
        post.authorId = authorId

        return postRepository.savePost(post)
    }

    @SuppressWarnings('unused')
    @SchemaMapping
    Author author(Post post) {
        return authorDao.get(post.authorId);
    }

}