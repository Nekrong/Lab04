package org.dstu.dao;

import org.dstu.domain.Chair;
import org.hibernate.query.Query;

import java.util.List;

public class ChairDao extends BaseDaoImpl<Chair, Integer> {
    public ChairDao() {
        super(Chair.class);
    }

    public List<Chair> getAllByGroup(String groupName) {
        Query q = getSession().createQuery("FROM Chair WHERE Chair.color = \"" + groupName + "\"");
        return q.list();
    }
}
