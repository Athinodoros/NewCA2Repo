package facade;

import entity.CityInfo;
import entity.Company;
import exception.CompanyNotFoundException;
import java.util.List;

/**
 *
 * @author favl
 */
public interface CompanyInterface 
{

    public CityInfo getCityInformation(int zipCode);
    public Company createCompany(Company comp);
    public Company getCompany (int cvr)throws CompanyNotFoundException;
//    public Company deleteCompanyById (long id)throws CompanyNotFoundException;
    public Company updateCompany(Company comp)throws CompanyNotFoundException;
    public Company deleteCompany(long cvr)throws CompanyNotFoundException;
    public List<Company> getCompanies();
}