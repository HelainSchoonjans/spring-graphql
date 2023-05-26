package com.example.graphql.post

import org.springframework.stereotype.Component

@Component
class PostRepository {

    @SuppressWarnings('GrMethodMayBeStatic')
    List<Post> getRecent(int count, int offset) {
        [
                new Post(id: "1",
                        title: "a post",
                        category: "first category", authorId: 1),
                new Post(id: "2",
                        title: "another post",
                        category: "another category",
                        authorId: 1)]
    }

    @SuppressWarnings('GrMethodMayBeStatic')
    Post savePost(Post post) {
        post
    }
}