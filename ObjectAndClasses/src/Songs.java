import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numbersOfSongs; i++) {
            String[] read = scanner.nextLine().split("_");
            String list = read[0];
            String name = read[1];
            String time = read[2];
            Song theSong = new Song(list, name, time);
            songs.add(theSong);

        }
        String findList = scanner.nextLine();

        for (Song song : songs) {
            if (findList.equals(song.getList())) {
                System.out.println(song.getName());
            }
            if (findList.equals("all")) {
                System.out.println(song.getName());
            }
        }
    }
}
