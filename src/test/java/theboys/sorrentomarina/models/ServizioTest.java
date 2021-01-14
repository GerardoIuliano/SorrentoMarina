package theboys.sorrentomarina.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServizioTest {

  Servizio servizio;

  /**
   * init servizio
   */
  @BeforeEach
  public void init() {
    servizio = new Servizio(1,true,false,true,false,false,true,false);
  }

  /**
   * test method getId
   */
  @Test
  public void getIdTest(){
    int id = servizio.getId();
    assertEquals(1,id,"Should return 1");
  }

  /**
   * test method isBar
   */
  @Test
  public void isBarTest(){
    assertEquals(servizio.isBar(),true,"Should return true");
  }

  /**
   * test method isRistorante
   */
  @Test
  public void isRistoranteTest(){
    assertEquals(servizio.isRistorante(),false,"Should return false");
  }

  /**
   * test method isAnimazione
   */
  @Test
  public void isAnimazioneTest(){
    assertEquals(servizio.isAnimazione(),true,"Should return true");
  }

  /**
   * test method isWifi
   */
  @Test
  public void isWifiTest(){
    assertEquals(servizio.isWifi(),false,"Should return false");
  }

  /**
   * test method isCabina
   */
  @Test
  public void isCabinaTest(){
    assertEquals(servizio.isCabina(),false,"Should return false");
  }

  /**
   *  test method isBeachVolley
   */
  @Test
  public void isBeachVolleyTest(){
    assertEquals(servizio.isBeach_volley(),true,"Should return true");
  }

  /**
   * test method isCanoa
   */
  @Test
  public void isCanoaTest(){
    assertEquals(servizio.isCanoa(),false,"Should return false");
  }

  /**
   * test method setId
   */
  @Test
  public void setIdTest(){
    servizio.setId(2);
    assertEquals(2, servizio.getId(),"Should return 2");
  }

  /**
   * test method setBar
   */
  @Test
  public void setBarTest(){
    servizio.setBar(false);
    assertEquals(false, servizio.isBar(),"Should return false");
  }

  /**
   * test method setRistorante
   */
  @Test
  public void setRistoranteTest(){
    servizio.setRistorante(true);
    assertEquals(true, servizio.isRistorante(),"Should return true");
  }

  /**
   * test method setAnimazione
   */
  @Test
  public void setAnimazioneTest(){
    servizio.setAnimazione(false);
    assertEquals(false, servizio.isAnimazione(),"Should return false");
  }

  /**
   * test method setWifi
   */
  @Test
  public void setWifiTest(){
    servizio.setWifi(true);
    assertEquals(true, servizio.isWifi(),"Should return true");
  }

  /**
   * test method setCabina
   */
  @Test
  public void setCabinaTest(){
    servizio.setCabina(true);
    assertEquals(true, servizio.isCabina(),"Should return true");
  }

  /**
   * test method setBeach_volley
   */
  @Test
  public void setBeachVolleyTest(){
    servizio.setBeach_volley(false);
    assertEquals(false, servizio.isBeach_volley(),"Should return false");
  }

  /**
   * test method setCanoa
   */
  @Test
  public void setCanoaTest(){
    servizio.setCanoa(true);
    assertEquals(true, servizio.isCanoa(),"Should return true");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest1(){
    Servizio servizio=new Servizio(false,false,false,false,false,false,true);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest2(){
    Servizio servizio=new Servizio(false,false,false,false,false,false,false);
    assertEquals(true, servizio.isAllFalse(),"Should return true");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest3(){
    Servizio servizio=new Servizio(true,true,true,true,true,true,true);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest4(){
    Servizio servizio=new Servizio(false,false,false,false,false,true,false);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest5(){
    Servizio servizio=new Servizio(false,false,false,false,true,false,false);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest6(){
    Servizio servizio=new Servizio(false,false,false,true,false,false,false);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest7(){
    Servizio servizio=new Servizio(false,false,true,false,false,false,false);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest8(){
    Servizio servizio=new Servizio(false,true,false,false,false,false,false);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

  /**
   * test method isAllFalse
   */
  @Test
  public void isAllFalseTest9(){
    Servizio servizio=new Servizio(true,false,false,false,false,false,false);
    assertEquals(false, servizio.isAllFalse(),"Should return false");
  }

}
