package Collections;

import java.util.Map;
import java.util.WeakHashMap;

public class Main {

    public static void main(String[] args) {

        //exampleLinkedHashMap();

        exampleWeakHashMap();

    }

    public static void exampleLinkedHashMap() {

        // Пример с LRU-cache (LinkedHashMap)
        // В примере видно, что при добавлении в уже "полный" мап - удаляется неиспользуемые элементы

        SimpleLRUCache lruCache = new SimpleLRUCache(2);

        lruCache.put(1, "one");   //{1=one}
        lruCache.put(2, "two");   //{1=one, 2=two}
        lruCache.put(3, "three"); //{2=two, 3=three}

        lruCache.get(2); // "two"

        lruCache.put(9, "nine"); //{2=two, 9=nine}

        System.out.println(lruCache); // {2=two, 9=nine}

    }

    public static void exampleWeakHashMap() {
        // Пример, показывающий как из WeakHashMap удаляются элементы, ссылка на которые имеется в мапе

        Map<Data, String> map = new WeakHashMap<>();
        Data data = new Data(); // какой-то объект

        map.put(data, "information");

        data = null;

        for (int i = 0; i < 1000000; i++) {
            if (map.isEmpty()) {
                System.out.println("Empty");
                break;
            } else {
                System.out.println(i);
            }
        }

    }

    public static class Data {}
}

