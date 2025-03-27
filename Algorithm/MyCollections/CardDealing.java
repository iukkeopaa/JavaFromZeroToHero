package MyCollections;

import java.util.LinkedList;

//СA��СB����ֽ�ơ�ÿ�����϶���һ�����������е��ƶ����泯�ϵ��ų�һ���ƶѣ������������о���η��ơ�
//�����о����ķ��Ʋ������£�СAÿ�ν��ƶѶ�����һ���Ʒ�����ÿ�η���ǰ��СB�������һ�����ƣ�����Ŀǰ�ƶ�����n���ƣ���ôСB�Ὣǰ?n/3?���ƴ��ƶѶ����ηŵ��ƶѵף�?x?��ʾ��x����ȡ���������ڸ����ʼ���ƶ��дӶ�����ÿ���Ƶĵ��������ʰ����������Ʋ��ԣ����յõ��ķ��������������ģ�
//�����ʼ�ƶ�Ϊ[4, 5, 2, 3, 1, 2]���������ҷֱ����ƶ��дӶ�����ÿ���Ƶĵ�����������СB��ǰ?6/3?=2���Ʒŵ��ƶѵײ����ƶѱ�Ϊ[2, 3, 1, 2, 4, 5]��Ȼ��СA���ƶѶ���2�������ƶѱ�Ϊ[3, 1, 2, 4, 5]��СB�ٽ�ǰ?5/3?=1���Ʒŵ��ƶѵײ����ƶѱ�Ϊ[1, 2, 4, 5, 3]��Ȼ��СA���Ǹ��ƶѶ���1�������ƶѱ�Ϊ[2, 4, 5, 3]�������շ��Ʋ��Լ��������󣬿��Եõ����յķ���������[2, 1, 4, 3, 2, 5]
public class CardDealing {
    public static int[] dealCards(int[] cards) {
        LinkedList<Integer> cardList = new LinkedList<>();
        for (int card : cards) {
            cardList.add(card);
        }
        int[] result = new int[cards.length];
        int index = 0;
        while (!cardList.isEmpty()) {
            int n = cardList.size();
            int cutCount = (int) Math.floor(n / 3.0);
            for (int i = 0; i < cutCount; i++) {
                int card = cardList.removeFirst();
                cardList.addLast(card);
            }
            result[index++] = cardList.removeFirst();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] cards = {4, 5, 2, 3, 1, 2};
        int[] dealtCards = dealCards(cards);
        for (int card : dealtCards) {
            System.out.print(card + " ");
        }
    }
}    