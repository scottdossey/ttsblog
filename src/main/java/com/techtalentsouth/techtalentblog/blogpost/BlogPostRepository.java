package com.techtalentsouth.techtalentblog.blogpost;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* The repository represents the database table itself */
/* We are defining an interface not a class */
/* Because JPA is interested in why we want to access that table, and in what ways...
 * It is in charge of figuring out HOW.....
 */

/* In order for something to be a repository, we have to inherit from
 * The Repository interface.......(directly or indirectly)
 * CrudRepository is an interface that inherits from Repository......
 * and specifies basic Crud operations.
 */
@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost,Long> {
	//We can add additional queries that we want to do here...
	//but currently we are going to make do with what is specified in CrudRepository
}
