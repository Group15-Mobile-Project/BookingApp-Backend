package airbnb.com.backend1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import airbnb.com.backend1.Entity.City;
import airbnb.com.backend1.Entity.Home;
import airbnb.com.backend1.Entity.HomeCategory;
import airbnb.com.backend1.Entity.Host;
import airbnb.com.backend1.Entity.Request.HomeRequest;
import airbnb.com.backend1.Entity.Response.HomeResponse;

@Repository
public interface HomeRepos extends JpaRepository<Home, Long> {
  List<Home> findByCity(City city);
  List<Home> findByOwner(Host owner);
  List<Home> findByHomeCategory(HomeCategory homeCategory);
  @Query("select COUNT(h) from Home h LEFT JOIN h.owner owner where owner.id = :hostId")
  int findNumberHomesByHost(Long hostId);
}
