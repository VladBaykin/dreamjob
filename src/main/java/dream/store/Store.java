package dream.store;

import dream.model.City;
import dream.model.Post;
import dream.model.Candidate;
import dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();
    Collection<Candidate> findAllCandidates();
    void savePost(Post post);
    void saveCandidate(Candidate candidate);
    Post findPostById(int id);
    Candidate findCandidateById(int id);
    int addPhoto(int id);
    void saveUser(User user);
    User findUserByEmail(String email);
    Collection<User> findAllUsers();
    Collection<City> findAllCities();
    City findCityByName(String name);
}
