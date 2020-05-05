package Collections;

public class Main {

    public static void main(String[] args) {

        exampleLinkedHashMap();

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
}

