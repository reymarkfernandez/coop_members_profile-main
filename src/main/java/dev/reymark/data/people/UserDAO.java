package dev.reymark.data.people;

import javax.sql.rowset.CachedRowSet;

import dev.reymark.App;
import dev.reymark.models.people.Office;
import dev.sol.db.DBService;

public class UserDAO {
    public static final String TABLE = "user";
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

}
