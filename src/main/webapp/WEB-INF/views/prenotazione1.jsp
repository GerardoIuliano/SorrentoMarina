<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Lido ${lido.nome}" admin="false">
    <link rel="stylesheet" href="<c:url value="/css/formPrenotazione.css"/>" type="text/css">
    <script src="<c:url value="/js/formPrenotazione.js"/>"></script>
    <sm:header/>
    <div id="wrapper" >
        <sm:sidebarLido/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column ">

            <!-- Main Content -->

            <div id="content">
                <section class="blog_area section-padding">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-8 mb-5 mb-lg-0">
                                <!-- Step  -->
                                <div class="button-group-area mt-40 text-center ">
                                    <div class="text-center">
                                        <div class="progressbar-wrapper">
                                            <ul class="progressbar text-center">
                                                <li id="step1" class="active"></li>
                                                <li id="step2"> </li>
                                                <li id="step3"> </li>
                                                <li id="step4"> </li>
                                                <li id="step5"> </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <div class="blog_center_sidebar">
                                    <article class="blog_item">
                                        <div class="blog_details">

                                            <!-- Contenitore principale -->
                                            <div class="text-center blog_details">
                                                <!-- Form data inzio data fine numero posti -->
                                                <form action="eseguiPrenotazione1">
                                                    <div id="prenotazione1" >
                                                        <h3 class="mb-30">DURATA e POSTI</h3>
                                                        <div class="form-group row">
                                                            <label for="dataInizio" class="col-sm-3 col-form-label">Data Inizio</label>
                                                            <div class="col-sm-8">
                                                                <input type="date" class="form-control" name="dataInizio" id="dataInizio" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label for="dataFine" class="col-sm-3 col-form-label">Data Fine</label>
                                                            <div class="col-sm-8">
                                                                <input type="date" class="form-control" name="dataFine" id="dataFine" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-sm-3 col-form-label" for="numPosti">Numero posti</label>
                                                            <div class="col-sm-8">
                                                                <select class="form-control col-sm-4" id="numPosti" name="numPosti">
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                    <option value="6">6</option>
                                                                    <option value="7">7</option>
                                                                    <option value="8">8</option>
                                                                    <option value="9">9</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <!-- Tasti prec next -->
                                                        <nav class="blog-pagination justify-content-center d-flex">
                                                            <ul class="pagination" width="100%">
                                                                <li class="page-item -align-left">
                                                                    <a href="lido?id=${idLido}" class="page-link" aria-label="Previous">
                                                                        <i class="ti-angle-left"></i>
                                                                    </a>
                                                                </li>
                                                                <li class="page-item -align-right">
                                                                    <a onclick="nextPrenotazione2()" type="submit" class="page-link" aria-label="Next">
                                                                        <i class="ti-angle-right"></i>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </nav>
                                                    </div>
                                                    <div id="prenotazione2" style="display: none">
                                                        <h3 class="mb-30">SCELTA OMBRELLONE</h3>

                                                        <!-- Tasti prec next -->
                                                        <nav class="blog-pagination justify-content-center d-flex">
                                                            <ul class="pagination" >
                                                                <li class="page-item -align-left">
                                                                    <a onclick="prevPrenotazione1()" class="page-link" aria-label="Previous">
                                                                        <i class="ti-angle-left"></i>
                                                                    </a>
                                                                </li>
                                                                <li class="page-item -align-right">
                                                                    <a onclick="nextPrenotazione3()" type="submit" class="page-link" aria-label="Next">
                                                                        <i class="ti-angle-right"></i>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </nav>
                                                    </div>
                                                    <div id="prenotazione3" style="display: none">
                                                        <h3 class="mb-30">DATI PERSONALI</h3>
                                                        <div class="form-group row">
                                                            <label for="nome" class="col-sm-3 col-form-label">Nome</label>
                                                            <div class="col-sm-8">
                                                                <input type="text" class="form-control" name="nome" id="nome" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label for="cognome" class="col-sm-3 col-form-label">Cognome</label>
                                                            <div class="col-sm-8">
                                                                <input type="text" class="form-control" name="cognome" id="cognome" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label for="email" class="col-sm-3 col-form-label">E-mail</label>
                                                            <div class="col-sm-8">
                                                                <input type="email" class="form-control" name="email" id="email" placeholder="">
                                                            </div>
                                                        </div>
                                                        <!-- Tasti prec next -->
                                                        <nav class="blog-pagination justify-content-center d-flex">
                                                            <ul class="pagination" >
                                                                <li class="page-item -align-left">
                                                                    <a onclick="prevPrenotazione2()" class="page-link" aria-label="Previous">
                                                                        <i class="ti-angle-left"></i>
                                                                    </a>
                                                                </li>
                                                                <li class="page-item -align-right">
                                                                    <a onclick="nextPrenotazione4()" type="submit" class="page-link" aria-label="Next">
                                                                        <i class="ti-angle-right"></i>
                                                                    </a>
                                                                </li>
                                                            </ul>
                                                        </nav>
                                                    </div>
                                                    <div id="prenotazione4" style="display: none">
                                                        <h3 class="mb-30">PAGAMENTO</h3>
                                                        <div class="form-group row">
                                                            <label for="intestatario" class="col-sm-3 col-form-label">Intestatario</label>
                                                            <div class="col-sm-8">
                                                                <input type="text" class="form-control" name="intestatario" id="intestatario" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label for="numCarta" class="col-sm-3 col-form-label">N. Carta</label>
                                                            <div class="col-sm-8">
                                                                <input type="text" class="form-control" name="numCarta" id="numCarta" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label for="dataScadenza" class="col-sm-3 col-form-label">Data di scadenza</label>
                                                            <div class="col-sm-8">
                                                                <input type="email" class="form-control" name="dataScadenza" id="dataScadenza" placeholder="">
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label for="cvv" class="col-sm-3 col-form-label">CVV</label>
                                                            <div class="col-sm-8">
                                                                <input type="email" class="form-control" name="cvv" id="cvv" placeholder="">
                                                            </div>
                                                        </div>
                                                        <!-- Tasti prec next -->
                                                        <nav class="blog-pagination justify-content-center d-flex">
                                                            <ul class="pagination" >
                                                                <li class="page-item -align-left">
                                                                    <a onclick="prevPrenotazione3()" class="page-link" aria-label="Previous">
                                                                        <i class="ti-angle-left"></i>
                                                                    </a>
                                                                </li>
                                                                <li class="page-item -align-right">
                                                                    <button type="submit" class="page-link" aria-label="Next">
                                                                        <i class="ti-angle-right"></i>
                                                                    </button>
                                                                </li>
                                                            </ul>
                                                        </nav>
                                                    </div>
                                                </form>
                                            </div>


                                        </div>
                                    </article>

                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
            <sm:footer/>
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->
</sm:layout>