package com.example.demoextendh2;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.hibernate.query.sqm.NullOrdering;

public class ExtendedH2Dialect extends H2Dialect {
    public ExtendedH2Dialect(DialectResolutionInfo info) {
        super(info);
    }

    @Override
    public NullOrdering getNullOrdering() {
        return NullOrdering.LAST;
    }
}
