class Card implements Comparable<Card> {
    public int rank;
    // 数值
    public String suit;
    // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //返回值等于0 相等
    //返回值大于0 this大
    //返回值小于0 o大
    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }

    @Override
    public boolean equals(Object obj) {
        //引用同一个对象
        if (this == obj) return true;
        //obj instanceof Card obj是否为Card的实例
        //obj可以是Card的子类，也可以是本身
        if (obj == null || !(obj instanceof Card)) return false;
        Card card = (Card) obj;
        if (this.rank == card.rank && this.suit.equals(card.suit)) {
            return true;
        }
        return false;
    }
}
public class TestDemo1 {



    public static void main(String[] args) {
        Card card1 = new Card(1,"♥");
        Card card2 = new Card(5,"♥");
        Card card3 = new Card(1,"♥");
        System.out.println(card1.compareTo(card2));
        System.out.println(card2.compareTo(card1));
        System.out.println(card1.compareTo(card3));
    }
}
