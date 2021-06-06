package dream.store;

import dream.model.Post;
import dream.model.Candidate;
import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();
    Collection<Candidate> findAllCandidates();
    void savePost(Post post);
    void saveCandidate(Candidate candidate);
    Post findPostById(int id);
    Candidate findCandidateById(int id);
    int addPhoto(int id);
}
