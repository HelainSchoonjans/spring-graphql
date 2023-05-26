package com.example.graphql.author

import com.example.graphql.post.AuthorDao
import org.springframework.stereotype.Component

@Component
class AuthorRepository implements AuthorDao {

    @SuppressWarnings('GrMethodMayBeStatic')
    Author get(String id) {
        if(id == "1") {
            new Author(id : "1", name: "Stephen", thumbnail: "image.jpeg")
        } else {
            null
        }
    }
}
