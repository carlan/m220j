package mflix.api.daos;

import com.mongodb.client.MongoClient;
import mflix.config.MongoDBConfiguration;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = {MongoDBConfiguration.class})
@EnableConfigurationProperties
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PagingTest extends TicketTest {

  private MovieDao dao;
  private String sortKey;
  @Autowired MongoClient mongoClient;

  @Value("${spring.mongodb.database}")
  String databaseName;

  @Before
  public void setup() {
    this.dao = new MovieDao(mongoClient, databaseName);
    this.sortKey = "tomatoes.viwer.numReviews";
  }

  @Test
  public void testPagingByCast() {
    String cast = "Tom Hanks";
    int skip = 0;
    int countPage1 = 0;
    for (Document d : dao.getMoviesByCast(sortKey, 20, skip, cast)) {
      System.out.println(d);
      countPage1++;
    }
    Assert.assertEquals(
        "Check the query used in getMoviesByCast() in MoviesDao.java", 20, countPage1);

    int countPage2 = 0;
    for (Document d : dao.getMoviesByCast(sortKey, 20, countPage1, cast)) {
      System.out.println(d);
      countPage2++;
    }
    Assert.assertEquals(
        "Incorrect count in page 2. Check your query implementation", 20, countPage2);

    int countPage3 = 0;
    for (Document d : dao.getMoviesByCast(sortKey, 20, countPage1 + countPage2, cast)) {
      System.out.println(d);
      countPage3++;
    }

    Assert.assertEquals("Incorrect count in page 3", 11, countPage3);

    Assert.assertEquals(
        "Total document count does not match", 51, countPage1 + countPage2 + countPage3);
  }

  @Test
  public void testPagingByGenre() {
    String genre = "History";
    int skip = 0;
    int countPage1 = 0;
    int expected = 1503;
    for (Document d : dao.getMoviesByGenre(sortKey, 20, skip, genre)) {
      System.out.println(d);
      countPage1++;
    }
    Assert.assertEquals("Check the query used in () in MoviesDao.java", 20, countPage1);

    Assert.assertEquals(
        "Total document count does not match expected. Review " + "getGenreSearchCount()",
        expected,
        dao.getGenresSearchCount(genre));

    // jump to last page

    int lastPage = expected / 20;
    skip = lastPage * 20;
    int countPageFinal = 0;
    for (Document d : dao.getMoviesByGenre(sortKey, 20, skip, genre)) {
      System.out.println(d);
      countPageFinal++;
    }

    Assert.assertEquals(
        "Last page count does not match expected. Check dataset and getGenreSearchCount()",
        1503 % 20,
        countPageFinal);
  }

  @Test
  public void testPagingByText() {
    String keywords = "bank robbery";
    int count = 0;
    for (Document d : dao.getMoviesByText(20, 0, keywords)) {
      System.out.println(d);
      count++;
    }
    Assert.assertEquals("Check the query used in getMoviesByText() in MoviesDao.java", 20, count);
    Assert.assertEquals("Check your count method", 1084L, dao.getTextSearchCount(keywords));

    int limit = 20;
    int skip = 1080;
    int finalCount = 0;
    for (Document d : dao.getMoviesByText(limit, skip, keywords)) {
      System.out.println(d);
      finalCount++;
    }

    Assert.assertEquals("Check your getMoviesByText method.", 4, finalCount);

    Assert.assertEquals(
        "Check the query used in getMovies() in MoviesDao.java", 1084 % 20, finalCount);
  }
}
