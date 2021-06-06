package dream.store;

import dream.model.Candidate;
import dream.model.Post;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        store.savePost(new Post(0, "Java Job"));
        store.savePost(new Post(1, "Java Job2"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        store.saveCandidate(new Candidate(0, "Java senior"));
        for (Candidate candidate : store.findAllCandidates()) {
            System.out.printf("%d %s%n", candidate.getId(), candidate.getName());
        }
        System.out.println(store.findCandidateById(1).getName());
        System.out.println(store.findPostById(1).getName());
    }
}
