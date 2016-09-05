package app.location;


import app.core.BaseJpaDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDaoImpl extends BaseJpaDaoImpl<Location, Long> implements LocationDao {

    public LocationDaoImpl() {
        super(Location.class);
    }
}
