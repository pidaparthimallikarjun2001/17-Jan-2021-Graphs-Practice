import java.util.*;
public class RottenOranges {

    public static int findTime(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int freshCount = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    freshCount++;
                }
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[][] directions = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

        int time = 0;

        while(!queue.isEmpty() && freshCount > 0) {
            time++;
            int size = queue.size();
            while(size-- > 0) {
                int[] temp = queue.poll();
                for(int[] direction: directions) {
                    int currentI = temp[0] + direction[0];
                    int currentJ = temp[1] + direction[1];

                    if(currentI < 0 || currentI >= grid.length || currentJ < 0 || currentJ >= grid[0].length || grid[currentI][currentJ] != 1) {
                        continue;
                    }

                    queue.add(new int[] {currentI, currentJ});
                    grid[currentI][currentJ] = 2;
                    freshCount--;

                }

            }

        }

        if(freshCount == 0) {
            return time;
        }
        return -1;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(findTime(grid));

    }
}