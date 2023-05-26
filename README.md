# spring graphql demo

A proof of concept of spring with graphql.

Inspiration from articles like:

    https://www.baeldung.com/graphql
    https://www.baeldung.com/spring-graphql


## tools

GraphiQL for api exploration: https://github.com/graphql/graphiql

It is bundled in the spring plugin but requires to be enabled through the application.properties. You can access it through the url http://localhost:8080/graphiql

## queries

Example:

    query {
        recentPosts(count: 10, offset: 0) {
            id
            title
            category
        }
    }

Response

    {
        "data": {
            "recentPosts": [
                {
                    "id": "1",
                    "title": "a post",
                    "category": "first category"
                },
                {
                    "id": "2",
                    "title": "another post",
                    "category": "another category"
                }
            ]
        }
    }

Example fetching the authors along

    query {
        recentPosts(count: 10, offset: 0) {
            id
            title
            category
            author {
                id
                name
                thumbnail
            }
        }
    }

Response

    {
        "data": {
            "recentPosts": [
                {
                    "id": "1",
                    "title": "a post",
                    "category": "first category",
                    "author": {
                        "id": "1",
                        "name": "Stephen",
                        "thumbnail": "image.jpeg"
                    }
                },
                {
                "id": "2",
                "title": "another post",
                "category": "another category",
                "author": {
                    "id": "1",
                    "name": "Stephen",
                    "thumbnail": "image.jpeg"
                    }
                }
            ]
        }
    }