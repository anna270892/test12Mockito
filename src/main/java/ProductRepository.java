public class ProductRepository {
    private PurchaseItem[] items = new PurchaseItem[0]; //сохранять будем в массив, будем имитировать новый массив

    public void save(PurchaseItem item) {  //принимает новую покупку (добавление)
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1]; //создаем новый массив
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i]; //скопируем в новый массив все элементы из старого массива
        }
        tmp[tmp.length - 1] = item; //заполнить самую последнюю ячейку новой покупкой
        items = tmp;
    }

    public void removeById(int id) {  //удаляет покупку (удаление)
        PurchaseItem[] tmp = new PurchaseItem[items.length - 1];
        int copyToIndex = 0; //создаем переменную - место куда копировать в новом массиве
        for (PurchaseItem item : items) { //пройдемся по всем item
            if (item.getId() != id) { //если у item id не такое какое мы хоим удалить то тогда мы копируем
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp; //сохраним новый массив в наше поле
    }

    public PurchaseItem[] getItems() {  //посмотреть все элементы в корзине
        return items;
    }
}
