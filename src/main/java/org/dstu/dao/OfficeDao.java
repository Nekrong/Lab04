package org.dstu.dao;

import org.dstu.domain.Office;

public class OfficeDao extends BaseDaoImpl<Office, Integer> {
    public OfficeDao() {
        super(Office.class);
    }
}
