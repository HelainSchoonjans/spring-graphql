package com.example.graphql.post

import com.example.graphql.author.Author

interface AuthorDao {

    Author get(String id)
}