public class Song {
    private String list;
    private String name;
    private String time;

    public Song(String list, String name, String time) {
        this.list = list;
        this.name = name;
        this.time = time;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
