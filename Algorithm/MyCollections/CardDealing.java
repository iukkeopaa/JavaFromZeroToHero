package MyCollections;

import java.util.LinkedList;

//小A和小B在玩纸牌。每张牌上都有一个点数，所有的牌都背面朝上叠放成一个牌堆，现在他们在研究如何发牌。
//他们研究出的发牌策略如下：小A每次将牌堆顶的那一张牌发出，每次发牌前，小B都会进行一次切牌，假设目前牌堆中有n张牌，那么小B会将前?n/3?张牌从牌堆顶依次放到牌堆底（?x?表示将x向下取整）。现在给你初始的牌堆中从顶到底每张牌的点数，请问按照上述发牌策略，最终得到的发牌序列是怎样的？
//例如初始牌堆为[4, 5, 2, 3, 1, 2]（从左往右分别是牌堆中从顶到底每张牌的点数），首先小B将前?6/3?=2张牌放到牌堆底部，牌堆变为[2, 3, 1, 2, 4, 5]，然后小A将牌堆顶的2发出，牌堆变为[3, 1, 2, 4, 5]。小B再将前?5/3?=1张牌放到牌堆底部，牌堆变为[1, 2, 4, 5, 3]，然后小A及那个牌堆顶的1发出，牌堆变为[2, 4, 5, 3]……按照发牌策略继续操作后，可以得到最终的发牌序列是[2, 1, 4, 3, 2, 5]
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