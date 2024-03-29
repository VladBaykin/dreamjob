package dream.model;

import java.util.Objects;

public class Candidate {
    private int id;
    private String name;
    private String city;
    private int photoId;

    public Candidate(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Candidate(int id, String name, int photoId, String city) {
        this.id = id;
        this.name = name;
        this.photoId = photoId;
        this.city = city;
    }

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id && Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}