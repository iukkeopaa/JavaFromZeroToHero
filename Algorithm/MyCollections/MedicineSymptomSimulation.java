package MyCollections;

import java.util.BitSet;
import java.util.Scanner;

//С��׼����ҩ�β�����֪����
//n
//n��֢״��
//m
//m��ҩ����
//i
//i��ҩ��������һЩ֢״�������ܻᵼ��һЩ�����ã����һЩ�µ�֢״��С�����η�����һЩҩ���������С�죬����ÿ�η���һ��ҩʱ����ǰ���ж���֢״��
public class MedicineSymptomSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ��ȡ֢״���� n ��ҩ������ m
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // �洢ÿ��ҩ�������֢״�͸�����֢״
        BitSet[] cures = new BitSet[m];
        BitSet[] sideEffects = new BitSet[m];

        // ��ȡÿ��ҩ�����Ϣ
        for (int i = 0; i < m; i++) {
            cures[i] = new BitSet(n);
            sideEffects[i] = new BitSet(n);

            // ��ȡ����֢״����
            int numCures = scanner.nextInt();
            for (int j = 0; j < numCures; j++) {
                int symptom = scanner.nextInt() - 1;
                cures[i].set(symptom);
            }

            // ��ȡ������֢״����
            int numSideEffects = scanner.nextInt();
            for (int j = 0; j < numSideEffects; j++) {
                int symptom = scanner.nextInt() - 1;
                sideEffects[i].set(symptom);
            }
        }

        // ��ȡС�����η��õ�ҩ������
        int k = scanner.nextInt();
        BitSet currentSymptoms = new BitSet(n);
        for (int i = 0; i < k; i++) {
            int medicineIndex = scanner.nextInt() - 1;
            // ����֢״
            currentSymptoms.andNot(cures[medicineIndex]);
            // ��Ӹ�����֢״
            currentSymptoms.or(sideEffects[medicineIndex]);
            // �����ǰ֢״����
            System.out.println(currentSymptoms.cardinality());
        }

        scanner.close();
    }
}    