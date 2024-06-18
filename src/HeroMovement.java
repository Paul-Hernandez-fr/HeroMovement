import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HeroMovement {

    public static void main(String[] args) {
        try {
            List<String> map = readMap("data/carte.txt");

            List<String> movements = readMovements("data/deplacements.txt");

            for (int i = 0; i < movements.size(); i += 2) {

                String[] initialCoordinates = movements.get(i).split(",");
                int x = Integer.parseInt(initialCoordinates[0]);
                int y = Integer.parseInt(initialCoordinates[1]);

                String directions = movements.get(i + 1);

                for (char direction : directions.toCharArray()) {
                    switch (direction) {
                        case 'N' -> {
                            if (y > 0 && map.get(y - 1).charAt(x) == ' ') {
                                y--;
                            }
                        }
                        case 'S' -> {
                            if (y < map.size() - 1 && map.get(y + 1).charAt(x) == ' ') {
                                y++;
                            }
                        }
                        case 'E' -> {
                            if (x < map.get(0).length() - 1 && map.get(y).charAt(x + 1) == ' ') {
                                x++;
                            }
                        }
                        case 'O' -> {
                            if (x > 0 && map.get(y).charAt(x - 1) == ' ') {
                                x--;
                            }
                        }
                    }
                }

                System.out.println("Position finale pour le test " + (i / 2 + 1) + " : (" + x + "," + y + ")");
            }
        } catch (IOException e) {
        }
    }

    private static List<String> readMap(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
    }

    private static List<String> readMovements(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
    }
}
