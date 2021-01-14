package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.managers.*;
import theboys.sorrentomarina.models.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
/**
 * @author theBoys
 */
public class ShowDashboardEnteAction implements Action {

  /**
   * Esegue la request action
   *
   * @param request  the request
   * @param response the response
   * @return ritrona la view respEnteDashboard
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    //mostra la dashboard del responsabile lido
    ResponsabileEnte re = (ResponsabileEnte) request.getSession().getAttribute("adminEnte");
    if (re == null) {
      return view("403");
    }
    try {
      LidoManager lidoManager = new TableLidoManager(this.getSource(request));
      List<Lido> lidi = lidoManager.retriveAll();
      request.setAttribute("lidiEnte", lidi);
      PrenotazioneManager prenotazioneManager = new TablePrenotazioneManager(getSource(request));
      HashMap<String,Integer> mapAffluenza = prenotazioneManager.getAffluenza();
      int lun = mapAffluenza.getOrDefault("Monday",0);
      int mar = mapAffluenza.getOrDefault("Tuesday",0);
      int mer = mapAffluenza.getOrDefault("Wednesday",0);
      int gio = mapAffluenza.getOrDefault("Thursday",0);
      int ven = mapAffluenza.getOrDefault("Friday",0);
      int sab = mapAffluenza.getOrDefault("Saturday",0);
      int dom = mapAffluenza.getOrDefault("Sunday",0);
      int tot=lun+mar+mer+gio+ven+sab+dom;
      request.setAttribute("lun",(100*lun)/tot);
      request.setAttribute("mar",(100*mar)/tot);
      request.setAttribute("mer",(100*mer)/tot);
      request.setAttribute("gio",(100*gio)/tot);
      request.setAttribute("ven",(100*ven)/tot);
      request.setAttribute("sab",(100*sab)/tot);
      request.setAttribute("dom",(100*dom)/tot);
      request.setAttribute("incassoTotale", prenotazioneManager.incassoConsorzio());
      request.setAttribute("numeroPrenotazioni", prenotazioneManager.prenotazioniTotali());
      List<Prenotazione> prenotazioneList = prenotazioneManager.retriveAll();
      HashMap<Prenotazione, String> map = new HashMap<Prenotazione, String>();
      for (Prenotazione p : prenotazioneList) {
        map.put(p, lidoManager.retriveById(p.getId_lido()).getNome());
      }
      request.setAttribute("mapPrenotazioni", map);
      return view("respEnteDashboard");

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return view("500");
    }
  }
}
