import org.dstu.dao.OfficeDao;
import org.dstu.dao.ChairDao;
import org.dstu.dao.Tab1eDao;
import org.dstu.domain.Office;
import org.dstu.domain.Chair;
import org.dstu.domain.Desk;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        ChairDao chairDao = new ChairDao();

        Chair chair = new Chair();
        chair.setMaterial("Дерево");
        chair.setCountry("Россия");
        chair.setManufacturer("Лазурит");
        chair.setColor("Желтый");
        chair.setTranscriptNum(322223);
        chair.setUpholstery("Кожа");
        chairDao.save(chair);

        OfficeDao officeDao = new OfficeDao();

        Office ist = new Office();
        ist.setName("Переговорная");
        ist.setWhole(true);
        int savedId = officeDao.save(ist);
        System.out.println(savedId);

        Tab1eDao tab1eDao = new Tab1eDao();
        Desk desk = new Desk();
        desk.setMaterial("Пластмас");
        desk.setCountry("Китай");
        desk.setLegs(4);
        desk.setForm("Прямоугольный");
        desk.setOffice(ist);

        tab1eDao.save(desk);

        Desk desk2 = new Desk();
        desk2.setMaterial("Металл");
        desk2.setCountry("Германия");
        desk2.setLegs(3);
        desk2.setForm("Круглый");
        desk2.setOffice(ist);
        tab1eDao.save(desk2);


        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}