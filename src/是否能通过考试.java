import java.util.ArrayList;
import java.util.Scanner;


/**
 * Description
 *
 * 小张想要通过明天的考试。他知道考题的分值分布，也知道考试中要拿到每一个题目需要耗费的时间。假设考试时长为h，共n个题目，需要拿到p分才能通过考试。现在已知每个考题的得分与耗时，请你判断小张能否通过合理安排时间，而通过考试，并给出通过考试的最短时间。
 */
public class 是否能通过考试 {
    public static void main(String args[]) {
        passTest(new Scanner(System.in));
    }

    public static void passTest(Scanner scanner)
    {
        int testNum = Integer.parseInt(scanner.nextLine());
        while (testNum-- > 0)
        {
            String[] condition = scanner.nextLine().split(" ");
            int wordNum = Integer.parseInt(condition[0]);
            int testTime = Integer.parseInt(condition[1]);
            int passScore = Integer.parseInt(condition[2]);
            ArrayList<Integer> timeList = new ArrayList<>();
            ArrayList<Integer> scoreList = new ArrayList<>();
            for (int i = 0; i < wordNum; i++) {
                String[] input = scanner.nextLine().split(" ");
                timeList.add(Integer.parseInt(input[0]));
                scoreList.add(Integer.parseInt(input[1]));
            }

            int result = calTimeAndScore(wordNum, testTime, passScore, timeList, scoreList);

            if (result < 10000) {
                System.out.println("YES " + result);
            } else {
                System.out.println("NO");
            }
        }

    }

    private static int calTimeAndScore(int num, int time, int score, ArrayList<Integer> timeList, ArrayList<Integer> scoreList)
    {
        if (time < 0 || num < 0)
        {
            return 1000000;
        }

        if (score < 0)
        {
            return 0;
        }

        if (num == 0)
        {
            return 10000;
        }

        int result1 = calTimeAndScore(num - 1, time - timeList.get(num - 1), score - scoreList.get(num - 1), timeList, scoreList) + timeList.get(num - 1);
        int result2 = calTimeAndScore(num - 1, time, score, timeList, scoreList);

        return  Math.min(result1, result2);
    }
}

