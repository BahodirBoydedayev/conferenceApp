package app.location;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationDao locationDao;

    @Autowired
    public void setLocationDao(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Transactional
    @Override
    public Location save(Location entity) {
        return locationDao.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Location findOne(Long id) {
        return locationDao.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Location> findAll() {
        return locationDao.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        locationDao.delete(id);
    }
}
