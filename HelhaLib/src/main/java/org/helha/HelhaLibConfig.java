package org.helha;

import org.helha.models.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;

@Configuration
public class HelhaLibConfig {

    @Bean
    public ArrayList<Book> booksRepository(){
        return new ArrayList<>() {{
            add(new Book(1,"Harry Potter 1","J.K Rowling","9781547904761",new BigDecimal("19.99"),"https://m.media-amazon.com/images/I/91Ad4FyTwHL.jpg"));
            add(new Book(2,"Tintin au Congo","Hergé","9787500760733",new BigDecimal(10),"https://bdi.dlpdomain.com/ecommerce/principal/2201000000009/1/M1600x1600/affiche-tintin-tintin-au-congo.jpg"));
            add(new Book(3,"Le Hobbit","J.R.R Tolkien","9780044403371",new BigDecimal(13),"http://i-exc.ccm2.net/iex/1280/1291710073/750905.jpg"));
            add(new Book(4,"Le trône de fer","Georges R.R. Martin","9780007237500", new BigDecimal("15.99"),"https://m.media-amazon.com/images/I/71xwnDO9PBL.jpg"));
            add(new Book(5,"Le Seigneur des anneaux","J.R.R Tolkien","9780007141326",new BigDecimal("0.3"),"https://m.media-amazon.com/images/I/81ZhkgxEkFL.jpg"));
        }};
    }
}
