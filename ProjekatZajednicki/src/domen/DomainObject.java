package domen;

import java.sql.ResultSet;
import java.util.LinkedList;
public interface DomainObject {
    public String getTableName();

    public boolean isAutoincrement();

    public void setObjectId(long aLong);

    public String getAttributeNamesForInsert();

    public String getAttributeValuesForInsert();

    public long getId();

    public String getIdName();

    public LinkedList<DomainObject> getListFromRs(ResultSet rs)throws Exception;

    public String setQueryForUpdate();

    public String prepareQueryForSelect();

    
}
