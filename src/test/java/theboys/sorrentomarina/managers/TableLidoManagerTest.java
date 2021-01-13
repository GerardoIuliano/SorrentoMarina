package theboys.sorrentomarina.managers;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.models.Lido;
import theboys.sorrentomarina.models.Servizio;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Classe di test per il TableLidoManager
 *
 * @author Francesco Pio Covino
 * @version 0.1
 */
public class TableLidoManagerTest extends IntegrationTestCase {

  TableLidoManager manager;

  /**
   * Testa il create inserendo un lido nel database e verificando che
   * sia effettivamente presente
   */
  @Test
  public void createTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    manager.create("Nome5", "Indirizzo5", "Telefono5", "email5", "logo5", 12.5F, 4, 5, 1);
    Lido lido = manager.retriveById(5);
    assertNotNull(lido, "Deve trovare il lido appena inserito");
  }

  /**
   * Metodo che testa il retriveById verificando che
   * uno specifico lido sia presente nel database
   */
  @Test
  public void retriveByIdTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Lido lido = manager.retriveById(1);
    assertNotNull(lido, "Deve trovare il lido");
  }

  /**
   * Testa se il retrieveByName ritorna il nome corretto dal db
   */
  @Test
  public void retriveByNameTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    List<Lido> lido = manager.retriveByName("Nome1");
    assertEquals(1, lido.size(), "Il nome trovare deve coincidere con quello cercato");
  }

  @Test
  public void retriveByServiziTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Servizio servizio = new Servizio(true, false, true, false, true, false, true);
    List<Lido> lidi = manager.retriveByServizi(servizio);
    assertEquals(1, lidi.size(), "Il numero di lidi che offre i seguenti servizi");
  }

  /**
   * Metodo che testa il retriveAll verificando che
   * la lista contenga il giusto numero di elementi
   */
  @Test
  public void retriveAllTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    List<Lido> lista = manager.retriveAll();
    assertEquals(lista.size(), 4, "Deve tornare 4 elementi nella lista");
  }

  /**
   * Metodo che testa l'update verificando che
   * il lido sia stato modificato correttamente
   */
  @Test
  public void updateTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    Lido lido = new Lido(1, "Nome1", "Indirizzo1", "Telefono1", "email1", "logo1", 12.5F, 4, 5, 1);
    lido.setNome("Test1");
    manager.update(lido);
    lido = manager.retriveById(1);
    assertEquals("Test1", lido.getNome(), "Deve tornare il nome modificato");
  }

  /**
   * Metodo che testa il delete verificando che
   * l'annuncio eliminato non sia presente nel database
   */
  @Test
  public void deleteTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    manager.delete(1);
    assertNull(manager.retriveById(1), "Deve tornare null");
  }

  /**
   * Testa il getNumRighe verificando che ritorni il corretto numero
   * di righe
   *
   * @throws SQLException
   */
  @Test
  public void getNumRigheTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    int numRighe = manager.getNumRighe(1);
    assertEquals(4, numRighe, "Deve restituire il corretto numero di righe");
  }

  /**
   * Testa il getNumColonne verificando che ritorni il corretto
   * numero di colonne
   *
   * @throws SQLException
   */
  @Test
  public void getNumColonneTest() throws SQLException {
    manager = new TableLidoManager(mockDb);
    int numColonne = manager.getNumColonne(1);
    assertEquals(5, numColonne, "Deve restituire il corretto numero di colonne");
  }

}