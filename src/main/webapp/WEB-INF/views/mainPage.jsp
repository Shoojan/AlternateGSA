<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title> Codeaxis Technology </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <script>
    window.contextRoot = '${contextRoot}';
  </script>

  <!-- Bootstrap Core CSS -->
  <link rel="stylesheet" href="${css}/bootstrap.min.css" rel="stylesheet">

  <!-- MultiSelect Bootstrap -->
  <link rel="stylesheet" href="${css}/bootstrap-multiselect.css" rel="stylesheet">

  <!-- dataTables Bootstrap CSS -->
  <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">

  <!-- Main Page Style -->
  <link rel="stylesheet" href="${css}/mainPageStyleSheet.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="${css}/myapp.css" rel="stylesheet">


</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${contextRoot}/#showDataTable">Alternate GSA Data</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#showDataTable">Show Table</a></li>
          <li><a href="#search">Advanced Search</a></li>
          <li><a href="#export" data-toggle="modal" data-target="#myModal">Export</a></li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
              <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Codeaxis 1</a></li>
                <li><a href="#">Codeaxis 2</a></li>
                <li><a href="#">Codeaxis 3</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Container (ADVANCED SEARCH Section) -->
    <div id="search" class="bg-1">
      <div class="container">

        <!-- Build your select: -->
        <select id="p1" multiple="multiple">
          <c:forEach items="${ColumnNames}" var="columns">
            <c:forEach items="${columns}" var="column">
              <c:choose>
                <c:when test = "${column == 'cat'}"><c:set var="currentIndex" value="${1}"/></c:when>
                <c:when test = "${column eq 'contract_number_ct'}"><c:set var="currentIndex" value="${2}"/></c:when>
                <c:when test = "${column == 'gsin'}"><c:set var="currentIndex" value="${3}"/></c:when>
                <c:when test = "${column eq 'product_name_itn'}"><c:set var="currentIndex" value="${4}"/></c:when>
                <c:when test = "${column == 'modified_date_mdt'}"><c:set var="currentIndex" value="${5}"/></c:when>
                <c:when test = "${column eq 'manu_name_mfr'}"><c:set var="currentIndex" value="${6}"/></c:when>
                <c:when test = "${column == 'manu_name_mmfr'}"><c:set var="currentIndex" value="${7}"/></c:when>
                <c:when test = "${column eq 'manu_product_no_mmpno'}"><c:set var="currentIndex" value="${8}"/></c:when>
                <c:when test = "${column == 'manu_product_no_mpno'}"><c:set var="currentIndex" value="${9}"/></c:when>
                <c:when test = "${column eq 'product_desc_name'}"><c:set var="currentIndex" value="${10}"/></c:when>
                <c:when test = "${column == 'price_pr'}"><c:set var="currentIndex" value="${11}"/></c:when>
                <c:when test = "${column eq 'unspc'}"><c:set var="currentIndex" value="${12}"/></c:when>
                <c:when test = "${column == 'uom'}"><c:set var="currentIndex" value="${13}"/></c:when>
                <c:when test = "${column eq 'usrc'}"><c:set var="currentIndex" value="${14}"/></c:when>
                <c:when test = "${column eq 'vendor_name_vnd'}"><c:set var="currentIndex" value="${15}"/></c:when>
                <c:when test = "${column == 'vendor_part_no_vpno'}"><c:set var="currentIndex" value="${16}"/></c:when>
                <c:when test = "${column eq 'cleaned_manu_prod_no_mmpno'}"><c:set var="currentIndex" value="${17}"/></c:when>
                <c:when test = "${column eq 'cleaned_manu_prod_no_mpno'}"><c:set var="currentIndex" value="${18}"/></c:when>
                <c:when test = "${column == 'cleaned_vendor_part_no'}"><c:set var="currentIndex" value="${19}"/></c:when>
                <c:when test = "${column eq 'file_name'}"><c:set var="currentIndex" value="${20}"/></c:when>
                <c:when test = "${column eq 'added_on'}"><c:set var="currentIndex" value="${21}"/></c:when>
                <c:otherwise>
                  <h3> Not applicable </h3>
                </c:otherwise>
              </c:choose>
              <option value="${column}" name="${column}">${column}</option>
            </c:forEach>
          </c:forEach>
        </select>

        <table class="table">
          <thead>
            <tr>
              <th>Target</th>
              <th>Search text</th>
              <th>Treat as regex</th>
              <th>Use smart search</th>
            </tr>
          </thead>

          <tbody id="searchItems">
          <!--<tr id="filter_global">
          <td>Global search</td>
          <td align="center"><input type="text" class="global_filter" id="global_filter"></td>
          <td align="center"><input type="checkbox" class="global_filter" id="global_regex"></td>
          <td align="center"><input type="checkbox" class="global_filter" id="global_smart" checked="checked"></td>
          </tr>-->

            <c:forEach items="${ColumnNames}" var="columns">
              <c:forEach items="${columns}" var="column">
                <c:choose>
                  <c:when test = "${column == 'cat'}"><c:set var="currentIndex" value="${1}"/></c:when>
                  <c:when test = "${column eq 'contract_number_ct'}"><c:set var="currentIndex" value="${2}"/></c:when>
                  <c:when test = "${column == 'gsin'}"><c:set var="currentIndex" value="${3}"/></c:when>
                  <c:when test = "${column eq 'product_name_itn'}"><c:set var="currentIndex" value="${4}"/></c:when>
                  <c:when test = "${column == 'modified_date_mdt'}"><c:set var="currentIndex" value="${5}"/></c:when>
                  <c:when test = "${column eq 'manu_name_mfr'}"><c:set var="currentIndex" value="${6}"/></c:when>
                  <c:when test = "${column == 'manu_name_mmfr'}"><c:set var="currentIndex" value="${7}"/></c:when>
                  <c:when test = "${column eq 'manu_product_no_mmpno'}"><c:set var="currentIndex" value="${8}"/></c:when>
                  <c:when test = "${column == 'manu_product_no_mpno'}"><c:set var="currentIndex" value="${9}"/></c:when>
                  <c:when test = "${column eq 'product_desc_name'}"><c:set var="currentIndex" value="${10}"/></c:when>
                  <c:when test = "${column == 'price_pr'}"><c:set var="currentIndex" value="${11}"/></c:when>
                  <c:when test = "${column eq 'unspc'}"><c:set var="currentIndex" value="${12}"/></c:when>
                  <c:when test = "${column == 'uom'}"><c:set var="currentIndex" value="${13}"/></c:when>
                  <c:when test = "${column eq 'usrc'}"><c:set var="currentIndex" value="${14}"/></c:when>
                  <c:when test = "${column eq 'vendor_name_vnd'}"><c:set var="currentIndex" value="${15}"/></c:when>
                  <c:when test = "${column == 'vendor_part_no_vpno'}"><c:set var="currentIndex" value="${16}"/></c:when>
                  <c:when test = "${column eq 'cleaned_manu_prod_no_mmpno'}"><c:set var="currentIndex" value="${17}"/></c:when>
                  <c:when test = "${column eq 'cleaned_manu_prod_no_mpno'}"><c:set var="currentIndex" value="${18}"/></c:when>
                  <c:when test = "${column == 'cleaned_vendor_part_no'}"><c:set var="currentIndex" value="${19}"/></c:when>
                  <c:when test = "${column eq 'file_name'}"><c:set var="currentIndex" value="${20}"/></c:when>
                  <c:when test = "${column eq 'added_on'}"><c:set var="currentIndex" value="${21}"/></c:when>
                  <c:otherwise></c:otherwise>
                </c:choose>
                <tr id="filter_col${column}" style="display: none;" data-column="${currentIndex}">
                  <td>Column - ${column}</td>
                  <td align="center"><input type="text" class="column_filter" id="col${currentIndex}_filter"></td>
                  <td align="center"><input type="checkbox" class="column_filter" id="col${currentIndex}_regex")></td>
                  <td align="center"><input type="checkbox" class="column_filter" id="col${currentIndex}_smart" checked="checked"></td>
                </tr>
              </c:forEach>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>

    <!-- Container (The TABLE Section) -->
    <div id="showDataTable" class="container text-center">
      <table id="gsadataTable" class="table table-striped table-bordered hover" style="width:100%">
        <thead>
            <tr>
                <th>id</th>
                <th>cat</th>
                <th>contract_number_ct</th>
                <th>gsin</th>
                <th>product_name_itn</th>
                <th>modified_date_mdt</th>
                <th>manu_name_mfr</th>
                <th>manu_name_mmfr</th>
                <th>manu_product_no_mmpno</th>
                <th>manu_product_no_mpno</th>
                <th>product_desc_name</th>
                <th>price_pr</th>
                <th>UNSPC</th>
                <th>UOM</th>
                <th>USRC</th>
                <th>vendor_name_vnd</th>
                <th>vendor_part_no_vpno</th>
                <th>cleaned_manu_prod_no_mmpno</th>
                <th>cleaned_manu_prod_no_mpno</th>
                <th>cleaned_vendor_part_no</th>
                <th>file_name</th>
                <th>added_on</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>id</th>
                <th>cat</th>
                <th>contract_number_ct</th>
                <th>gsin</th>
                <th>product_name_itn</th>
                <th>modified_date_mdt</th>
                <th>manu_name_mfr</th>
                <th>manu_name_mmfr</th>
                <th>manu_product_no_mmpno</th>
                <th>manu_product_no_mpno</th>
                <th>product_desc_name</th>
                <th>price_pr</th>
                <th>UNSPC</th>
                <th>UOM</th>
                <th>USRC</th>
                <th>vendor_name_vnd</th>
                <th>vendor_part_no_vpno</th>
                <th>cleaned_manu_prod_no_mmpno</th>
                <th>cleaned_manu_prod_no_mpno</th>
                <th>cleaned_vendor_part_no</th>
                <th>file_name</th>
                <th>added_on</th>
            </tr>
        </tfoot>
      </table>
    </div>

    <!-- Container (Export Section) -->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <h2><span class="glyphicon glyphicon-export"></span> Export</h2>
          </div>
          <div class="modal-body">
            <div id="modalexport" class="modal-body text-center">
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>

    <!-- Footer -->
    <footer class="text-center">
      <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
        <span class="glyphicon glyphicon-chevron-up"></span>
      </a><br><br>
      <p>@Copyright Codeaxis Technology | Sujan | 2018</p>
    </footer>

  <!-- jQuery -->
  <script src="${js}/jquery.min.js"></script>

  <!-- Bootstrap Core JavaScript -->
  <script src="${js}/bootstrap.min.js"></script>

  <!-- MultiSelect Bootstrap JavaScript -->
  <script src="${js}/bootstrap-multiselect.min.js"></script>

  <!-- dataTables Plugin -->
  <script src="${js}/jquery.dataTables.js"></script>
  <script src="${js}/dataTables.buttons.min.js"></script>
  <script src="${js}/buttons.flash.min.js"></script>
  <script src="${js}/jszip.min.js"></script>
  <script src="${js}/buttons.html5.min.js"></script>
  <script src="${js}/buttons.print.min.js"></script>

  <!-- dataTables Bootstrap Script--> 
  <script src="${js}/dataTables.bootstrap.js"></script>

  <!-- Custom codes -->
  <script src="${js}/myapp.js"></script>

  <!-- Animate Smooth Page Scroll -->
  <script>

  </script>

</body>
</html>
