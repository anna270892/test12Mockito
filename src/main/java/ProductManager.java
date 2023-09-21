public class ProductManager {
    private ProductRepository repo; //заведем ячейку

    public ProductManager(ProductRepository repo) { //и будем принимать ее через конструктор
        this.repo = repo;
    }

    public void add(PurchaseItem item) { //метод добавления элемента в корзину
        repo.save(item);
    }

    public PurchaseItem[] getItems() {  //
        PurchaseItem[] all = repo.getItems(); //получим от репозитория массив всех элементов, элементы расположены в том порядке как добавлялись
        PurchaseItem[] reversed = new PurchaseItem[all.length]; //создаем массив чисто для ответа
        for (int i = 0; i < reversed.length; i++) { //пройдемся по новому массиву
            reversed[i] = all[all.length - 1 - i]; //получаем массив наоборот справа на лево
        }
        return reversed; //возвращаем массив
    }

    public int getTotal() { //вернем общую сумму покупок
        int sum = 0;
        for (PurchaseItem item : repo.getItems()) { //пройтись по всему массиву
            sum = sum + item.getCount() * item.getProductPrice(); //количество продукта умножить на цену за 1шт
        }
        return sum;
    }
}
