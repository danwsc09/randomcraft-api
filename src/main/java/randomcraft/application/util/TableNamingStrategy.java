package randomcraft.application.util;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class TableNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    private String PREFIX = "sc_";

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
        Identifier identifier = new Identifier(PREFIX + logicalName.getText().toLowerCase(), logicalName.isQuoted());
        return super.toPhysicalTableName(identifier, context);
    }
}
