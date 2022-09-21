package db.models;

public class Classroom {
    private int id;
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
