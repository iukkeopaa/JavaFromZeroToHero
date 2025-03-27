package MyCollections;

import java.util.BitSet;
import java.util.Scanner;

//小红准备买药治病。已知共有
//n
//n种症状和
//m
//m种药，第
//i
//i种药可以治疗一些症状，但可能会导致一些副作用，添加一些新的症状。小红依次服用了一些药，请你告诉小红，当她每次服用一副药时，当前还有多少症状？
public class MedicineSymptomSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取症状数量 n 和药物数量 m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 存储每种药物的治疗症状和副作用症状
        BitSet[] cures = new BitSet[m];
        BitSet[] sideEffects = new BitSet[m];

        // 读取每种药物的信息
        for (int i = 0; i < m; i++) {
            cures[i] = new BitSet(n);
            sideEffects[i] = new BitSet(n);

            // 读取治疗症状数量
            int numCures = scanner.nextInt();
            for (int j = 0; j < numCures; j++) {
                int symptom = scanner.nextInt() - 1;
                cures[i].set(symptom);
            }

            // 读取副作用症状数量
            int numSideEffects = scanner.nextInt();
            for (int j = 0; j < numSideEffects; j++) {
                int symptom = scanner.nextInt() - 1;
                sideEffects[i].set(symptom);
            }
        }

        // 读取小红依次服用的药物数量
        int k = scanner.nextInt();
        BitSet currentSymptoms = new BitSet(n);
        for (int i = 0; i < k; i++) {
            int medicineIndex = scanner.nextInt() - 1;
            // 治疗症状
            currentSymptoms.andNot(cures[medicineIndex]);
            // 添加副作用症状
            currentSymptoms.or(sideEffects[medicineIndex]);
            // 输出当前症状数量
            System.out.println(currentSymptoms.cardinality());
        }

        scanner.close();
    }
}    