package app.organization;


import app.core.BaseJpaDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationDaoImpl extends BaseJpaDaoImpl<Organization, Long> implements OrganizationDao {

    public OrganizationDaoImpl() {
        super(Organization.class);
    }


}
