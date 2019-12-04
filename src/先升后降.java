import java.util.*;

/**
 * Description
 *
 * 从一列不重复的数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的。
 */
public class 先升后降 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.valueOf(sc.nextLine());
        while(numOfCases > 0) {
            String[] temp = sc.nextLine().split(" ");
            int length = temp.length;
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = Integer.valueOf(temp[i]);
            }
            int[] b = new int[length];  //从左到右
            HashMap<Integer, List<List<Integer>>> mapB = new HashMap<>(); //记录从左到右各个位置的LIS
            int[] c = new int[length];  //从右到左
            HashMap<Integer, List<List<Integer>>> mapC = new HashMap<>(); //记录从右到左各个位置的LIS
            for(int i = 0; i < length; i++){
                List<List<Integer>> listB = new ArrayList<>();
                List<List<Integer>> listC = new ArrayList<>();
                mapB.put(i, listB);
                mapC.put(i, listC);
            }
            //初始化mapB
            List<Integer> initializerForB = new ArrayList<>();
            initializerForB.add(array[0]);
            List<List<Integer>> firstOfB = mapB.get(0);
            firstOfB.add(initializerForB);
            mapB.put(0, firstOfB);

            //初始化mapC
            List<Integer> initializerForC = new ArrayList<>();
            initializerForC.add(array[length - 1]);
            List<List<Integer>> firstOfC = mapC.get(length - 1);
            firstOfC.add(initializerForC);
            mapC.put(length - 1, firstOfC);

            Arrays.fill(b, 1);
            Arrays.fill(c, 1);
            //从左到右
            for(int i = 1; i < length; i++){
                List<Integer> positions = new ArrayList<>();
                for(int j = 0; j < i; j++){
                    if(array[i] > array[j]){
                        if(b[j] + 1 > b[i]){
                            b[i] = b[j] + 1;
                            positions.clear();
                            positions.add(j);
                        }else if(b[j] + 1 == b[i]){
                            positions.add(j);
                        }
                    }
                }
                if(positions.size() > 0) {
                    for (Integer integer : positions) {
                        List<List<Integer>> listB = mapB.get(integer);
                        List<List<Integer>> listForI = mapB.get(i);
                        for(List<Integer> element: listB){
                            List<Integer> elementForI = new ArrayList<>(element);
                            elementForI.add(array[i]);
                            listForI.add(elementForI);
                        }
                        mapB.put(i, listForI);
                    }
                }else{
                    List<List<Integer>> listForI = new ArrayList<>();
                    List<Integer> elementForI = new ArrayList<>();
                    elementForI.add(array[i]);
                    listForI.add(elementForI);
                    mapB.put(i, listForI);
                }
            }
            //从右到左
            for(int i = length - 2; i >= 0; i--){
                List<Integer> positions = new ArrayList<>();
                for(int j = length - 1; j > i; j--){
                    if(array[i] > array[j]){
                        if(c[j] + 1 > c[i]){
                            c[i] = c[j] + 1;
                            positions.clear();
                            positions.add(j);
                        }else if(c[j] + 1 == c[i]){
                            positions.add(j);
                        }
                    }
                }
                if(positions.size() > 0) {
                    for (Integer integer : positions) {
                        List<List<Integer>> listC = mapC.get(integer);
                        List<List<Integer>> listForI = mapC.get(i);
                        for(List<Integer> element: listC){
                            List<Integer> elementForI = new ArrayList<>(element);
                            elementForI.add(array[i]);
                            listForI.add(elementForI);
                        }
                        mapC.put(i, listForI);
                    }
                }else{
                    List<List<Integer>> listForI = new ArrayList<>();
                    List<Integer> elementForI = new ArrayList<>();
                    elementForI.add(array[i]);
                    listForI.add(elementForI);
                    mapC.put(i, listForI);
                }
            }
            //寻找最大的b[i] + c[i]
            List<Integer> indices = new ArrayList<>();
            int maxSoFar = 0;
            for(int i = 0; i < length; i++){
                int sum = b[i] + c[i];
                if(sum > maxSoFar){
                    maxSoFar = sum;
                    indices.clear();
                    indices.add(i);
                }else if(sum == maxSoFar){
                    indices.add(i);
                }
            }
            List<List<Integer>> result = new ArrayList<>();
            for(Integer i : indices){
                List<List<Integer>> listFromB = mapB.get(i);
                List<List<Integer>> listFromC = mapC.get(i);
                for(List<Integer> list: listFromC){
                    Collections.reverse(list);
                }
                for(List<Integer> elementFromB: listFromB){
                    for(List<Integer> elementFromC: listFromC){
                        List<Integer> slice = new ArrayList<>(elementFromC.subList(1, elementFromC.size()));
                        List<Integer> origin = new ArrayList<>(elementFromB);
                        origin.addAll(slice);
                        if(!result.contains(origin)){
                            result.add(origin);
                        }

                    }
                }
            }

            Collections.sort(result, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    for(int i = 0; i < o1.size(); i++){
                        String str1 = String.valueOf(o1.get(i));
                        String str2 = String.valueOf(o2.get(i));
                        if(str1.equals(str2)){
                            continue;
                        }
                        String[] compared = new String[]{str1, str2};
                        Arrays.sort(compared);
                        return (compared[0].equals(str2)) ? 1 : -1;
                    }
                    return 0;
                }
            });

            for(int j = 0; j < result.size(); j++){
                List<Integer> list = result.get(j);
                for(int i = 0; i < list.size() - 1; i++){
                    System.out.print(list.get(i));
                    System.out.print(" ");
                }
                System.out.print(list.get(list.size() - 1));
                System.out.println();
            }
            numOfCases -= 1;
        }
    }
}


