import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class ProductDataBase {

    public static List<Product> productList = new ArrayList<Product>() {
        {
            this.add(new Product("пицца", "мясная", 500));
            this.add(new Product("пицца", "4 сыра", 450));
            this.add(new Product("пицца", "мексиканская", 480));
            this.add(new Product("закуски", "фри", 180));
            this.add(new Product("закуски", "наггетсы", 200));
            this.add(new Product("закуски", "крылышки", 250));
            this.add(new Product("десерты", "чизкейк", 150));
            this.add(new Product("десерты", "пирожок", 150));
            this.add(new Product("десерты", "мороженое", 150));
            this.add(new Product("напитки", "кола", 80));
            this.add(new Product("напитки", "кофе", 100));
            this.add(new Product("напитки", "чай", 100));
        }
    };

    //генерируем список из уникальных категорий меню
    private static Set<String> createCategorySet() {
        Set<String> categorySet = new TreeSet<>();
        for (Product list : productList) {
            categorySet.add(list.getCategory());
        }
        return categorySet;
    }

    //знакомимся с предложенным списком категорий путем чтения и выбираем понравившееся
    private static String readCategoryProduct(BufferedReader reader) throws IOException {
        System.out.println("Выберите наименование товара из списка: ");
        System.out.print(createCategorySet() + " - ");
        String category;
        while (true) {
            category = reader.readLine();
            if (createCategorySet().contains(category.toLowerCase())) {
                break;
            } else {
                System.out.print("Ничего не найдено, попробуйте еще раз: ");
            }
        }
        return category;
    }

    //проверка на наличие
    private static List<Product> searchByCategoryProduct(BufferedReader reader) throws IOException {
        String category = readCategoryProduct(reader);
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (category.equalsIgnoreCase(product.getCategory())) {
                products.add(product);
            }
        }
        return products;
    }

    //вводим наименование и проверяем его наличие в списке
    private static String readNameProduct(Set<String> nameSet, BufferedReader reader) throws IOException {
        System.out.println("Выберите наименование блюд из списка: ");
        System.out.print(nameSet + " - ");
        String name;
        while (true) {
            name = reader.readLine();
            if (nameSet.contains(name.toLowerCase())) {

                break;
            } else {
                System.out.print("Ничего не найдено, попробуйте еще раз: ");
            }
        }
        return name;
    }

    //поиск заданного наименования из списка
    public static Product searchProduct(BufferedReader reader) throws IOException {
        Product product = null;
        List<Product> list = searchByCategoryProduct(reader);
        Set<String> nameSet = new TreeSet<>();
        for (Product element : list) {
            nameSet.add(element.getName());
        }
        String name = readNameProduct(nameSet, reader);
        for (Product element : list) {
            if (name.equalsIgnoreCase(element.getName())) {
                product = element;
                break;
            }
        }
        return product;
    }

    //вводим количества товара
    public static int readQuantity(BufferedReader reader) throws IOException {
        System.out.print("Введите количество товара: ");
        int quantity = Integer.parseInt(reader.readLine());
        return quantity;
    }
}