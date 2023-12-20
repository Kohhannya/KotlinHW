package org.kohhannya.repository.Impl

import org.kohhannya.model.Comment
import org.kohhannya.repository.CommentsRepository
import java.time.Instant
import kotlin.random.Random

class DefaultCommentsRepository: CommentsRepository {

    private val comments: MutableSet<Comment> = mutableSetOf()

    override fun getAll(): Collection<Comment> {
        return comments.toList()
    }

    override fun getById(id: Long): Comment? {
        return comments.find { it.id == id }
    }

    override fun createComment(commentText: String): Comment {
        val createdComment = Comment(
            id = Random.nextLong(),
            text = commentText,
            createdAt = Instant.now().toString()
        )
        comments.add(createdComment)
        return createdComment
    }

}