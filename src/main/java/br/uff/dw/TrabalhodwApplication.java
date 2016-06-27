package br.uff.dw;

import br.uff.dw.model.Event;
import br.uff.dw.persistence.EventDAO;
import java.util.Calendar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TrabalhodwApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext config = SpringApplication.run(TrabalhodwApplication.class, args);
        EventDAO eventDAO = config.getBean("eventDAO", EventDAO.class);
        Calendar c1 = Calendar.getInstance();
        c1.set(2016, 6, 28);
        Event e1 = new Event("procurando dolly", "dolly sumiu", "1.jpeg", EventType.MOVIE, 12.0, "Niteroi", 30, c1);
        eventDAO.save(e1);
        Iterable<Event> eventos = eventDAO.findAll();
        for (Event evento : eventos) {
            System.out.println(evento.getAmount());
        }

    }
}
