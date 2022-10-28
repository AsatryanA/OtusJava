# Arsen Asatryan

# Lesson 2 ( Implement List )
```
Написать свою реализацию ArrayList на основе массива.
class DIYarrayList<T> implements List<T>{...}
Проверить, что на ней работают методы
addAll(Collection<? super T> c, T... elements)
static <T> void copy(List<? super T> dest, List<? extends T> src)
static <T> void sort(List<T> list, Comparator<? super T> c)
из java.util.Collections
1) Проверяйте на коллекциях с 20 и больше элементами.
2) DIYarrayList должен имплементировать ТОЛЬКО ОДИН интерфейс -
List.
3) Если метод не имплементирован, то он должен выбрасывать
исключение UnsupportedOperationException.
```
### Tools
- Java -version 17
- Gradle -version 7.2
- Junit-jupiter 5.9.0

