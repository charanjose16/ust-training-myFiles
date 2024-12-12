import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        List<Float> productPriceList2 =productsList.stream()
                .filter(p -> p.price > 30000)// filtering data
                .map(p->p.price)        // fetching price
                .toList(); // collecting as list
        productsList.stream().filter(i->i.price%2==0).map(p->p.price).forEach(System.out::println);
        System.out.println(productsList.stream().map(p->p.price).reduce( 0f,Float::sum));

        System.out.println(productsList.stream().map(p->p.price).min(Float::compare).get());
        System.out.println(productsList.stream().map(p->p.price).max(Float::compare).get());
        System.out.println(productsList.stream().map(p->p.price).filter(p->p<30000).collect(Collectors.toSet()).stream().toList());
        System.out.println(productPriceList2);
        Map<String,Float> map=productsList.stream().collect(Collectors.toMap(p->p.name,p->p.price));
        System.out.println(map);
    }
}  