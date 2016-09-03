package app.organization;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;

    @Autowired
    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public Organization save(Organization entity) {
        return organizationDao.save(entity);
    }

    @Override
    public Organization findOne(Long id) {
        return organizationDao.findOne(id);
    }

    @Override
    public Iterable<Organization> findAll() {
        return organizationDao.findAll();
    }

    @Override
    public void delete(Long id) {
        organizationDao.delete(id);
    }
}
