package theboys.sorrentomarina.actions.actionsLido;

import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.managers.managersLido.TableLidoManager;
import theboys.sorrentomarina.managers.managersPrenotazione.TablePrenotazioneManager;
import theboys.sorrentomarina.models.modelsLido.Lido;
import theboys.sorrentomarina.models.modelsPrenotazione.Ombrellone;
import theboys.sorrentomarina.models.modelsUtente.ResponsabileLido;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ControllaDisponibilitaAction implements Action {
  /**
   * Controlla e mostra la disponibilit√† attuale del lido
   *
   * @param request  la request
   * @param response la response
   * @return ritorna alla view della disponibilita del responsabile lido
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    TablePrenotazioneManager manager = new TablePrenotazioneManager(getSource(request));
    TableLidoManager lidoManager = new TableLidoManager(getSource(request));

    String dataInizio = request.getParameter("dataInizio");
    String dataFine = request.getParameter("dataFine");
    ResponsabileLido rl = (ResponsabileLido) request.getSession().getAttribute("adminLido");

    try {
      List<Ombrellone> ombrelloniOccupati = manager.ombrelloniListOccupati(dataInizio, dataFine, rl.getId_lido());
      int numOmbrelloni = ombrelloniOccupati.size();
      request.setAttribute("size", numOmbrelloni);
      request.setAttribute("ombrelloni", ombrelloniOccupati);
      Lido lido = lidoManager.retriveById(rl.getId_lido());
      request.setAttribute("lido", lido);

    } catch (SQLException e) {
      e.printStackTrace();
      return view("500");
    }

    return redirect("/SorrentoMarina/mostraDisponibilita");
  }
}

