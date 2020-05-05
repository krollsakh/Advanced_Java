package Collections;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Собственнфй LRU-Cache
При добавлении нового элемента удаляется редкоиспользуемый элемент (вместо расширения хэш мапа)
 */

public class  SimpleLRUCache<K, V> extends LinkedHashMap <K, V> {
    private final int capacity;

    public SimpleLRUCache(int capacity) {
        // initial cappacity устанавливается с запасом в 1 элеимент
        // load factor больше единицы, чтобы не было увеличение размера
        // access order = true,  чтобы элементы сортировались в порядке частоты использования
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }

}
