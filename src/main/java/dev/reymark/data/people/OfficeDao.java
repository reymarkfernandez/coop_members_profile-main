package dev.reymark.data.people;

import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dev.reymark.App;
import dev.reymark.models.people.Office;
import dev.sol.db.DBService;

public class OfficeDao {

    public static final String TABLE = "office";
    public static final DBService DB = App.DB_COOP;

    public static Office data(CachedRowSet crs) {
        try {

            int officeId = crs.getInt("officeId");
            String officeName = crs.getString("officeName");
            return new Office(officeId, officeName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static List<Office> getMemberList() {
        CachedRowSet crs = DB.select(TABLE);
        List<Office> list = new LinkedList<>();
        try {
            while (crs.next()) {
                Office office = data(crs);
                if (office != null) {
                    list.add(office);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
