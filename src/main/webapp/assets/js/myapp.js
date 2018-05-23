
$(document).ready(function() {

    $('#p1').multiselect({
        enableFiltering: true,
        maxHeight: 300,
        includeResetOption: true,
        filterPlaceholder: 'Search ...',
//        templates: {
//            filterClearBtn: '<button style="float:right;" class="btn btn-default multiselect-clear-filter glyphicon glyphicon-remove-circle" type="button"></button>'
//        },
        onChange: function(option, checked, select) {
            if(checked)
                $('#filter_col'+$(option).val()).show();
            else{
                $('#filter_col'+$(option).val()).hide();
            }
        }
    });

    // Initialize Tooltip
      $('[data-toggle="tooltip"]').tooltip();
      // Add smooth scrolling to all links in navbar + footer link
      $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {
        // Prevent default anchor click behavior
        event.preventDefault();
        // Store hash
        var hash = this.hash;
        //Using jQuery's animate() method to add smooth page scroll
        //The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
        $('html, body').animate({
          scrollTop: $(hash).offset().top
        }, 900, function(){
          // Add hash (#) to URL when done scrolling (default click behavior)
          window.location.hash = hash;
          });
        } // End if
      });

});





//code for jQuery tables
var jsolUrl = window.contextRoot+'/json/allGSAData';
var $table = $('#gsadataTable');

//execute the below code only when we have this table
if($table.length){

    // Setup - add a text input to each footer cell
    $('#gsadataTable tfoot th').each( function (i) {
        var title = $('#gsadataTable thead th').eq( $(this).index() ).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" data-index="'+i+'" />' );
    } );

    var gsatable = $table.DataTable({
        lengthMenu: [[10,20,50,-1],['10','20','50','All']],
        pageLength:10,
        scrollX: true,
        scrollY: '430px',
        scrollCollapse: true,
        paging: true,
//        dom: 'Bfrtip',
        ajax:{
            url:jsolUrl,
            dataSrc:''
        },
        columns:[
            {data: 'id'},
            {data: 'cat'},
            {data: 'contract_number_ct'},
            {data: 'gsin'},
            {data: 'product_name_itn'},
            {data: 'modified_date_mdt'},
            {data: 'manu_name_mfr'},
            {data: 'manu_name_mmfr'},
            {data: 'manu_product_no_mmpno'},
            {data: 'manu_product_no_mpno'},
            {data: 'product_desc_name'},
            {data: 'price_pr'},
            {data: 'unspc'},
            {data: 'uom'},
            {data: 'usrc'},
            {data: 'vendor_name_vnd'},
            {data: 'vendor_part_no_vpno'},
            {data: 'cleaned_manu_prod_no_mmpno'},
            {data: 'cleaned_manu_prod_no_mpno'},
            {data: 'cleaned_vendor_part_no'},
            {data: 'file_name'},
            {data: 'added_on'}
        ]
//        columnDefs:[
//            { "width": "60px", "targets": 1 }
//        ],
//        fixedColumns: true
    });

    new $.fn.dataTable.Buttons(gsatable,{
        buttons:
        [
             {
                 extend:    'copy',
                 text:      '<i class="glyphicon glyphicon-paperclip"></i> Copy',
                 titleAttr: 'Copy to clipboard',
                 className: 'btn btn-default'
             },
             {
                 extend:    'csv',
                 text:      '<i class="glyphicon glyphicon-save-file"></i> CSV',
                 titleAttr: 'CSV',
                 className: 'btn btn-default',
                 exportOptions: {
                     columns: ':visible'
                 }
             },
             {
                 extend:    'excel',
                 text:      '<i class="	glyphicon glyphicon-th-list"></i> Excel',
                 titleAttr: 'Excel',
                 className: 'btn btn-default',
                 exportOptions: {
                     columns: ':visible'
                 }
             },
             {
                 extend:    'pdf',
                 text:      '<i class="glyphicon glyphicon-print"></i> PDF',
                 titleAttr: 'PDF',
                 className: 'btn btn-default',
                 exportOptions: {
                     columns: ':visible'
                 }
             },
             {
                 extend:    'print',
                 text:      '<i class="glyphicon glyphicon-print"></i> Print',
                 titleAttr: 'Print',
                 className: 'btn btn-default',
                 exportOptions: {
                     columns: ':visible'
                 }
             },
         ]
    });

    //place the buttons in <div id=modalexport> area
    gsatable.buttons().container().appendTo('#modalexport');


    function filterGlobal () {
        $table.DataTable().search(
            $('#global_filter').val(),
            $('#global_regex').prop('checked'),
            $('#global_smart').prop('checked')
        ).draw();
    }

    function filterColumn ( i ) {
        $table.DataTable().column( i ).search(
            $('#col'+i+'_filter').val(),
            $('#col'+i+'_regex').prop('checked'),
            $('#col'+i+'_smart').prop('checked')
        ).draw();
    }

    $('input.global_filter').on( 'keyup click', function () {
        filterGlobal();
    } );

    $('input.column_filter').on( 'keyup click', function () {
        filterColumn( $(this).parents('tr').attr('data-column') );
    } );


    // Filter event handler
    $( gsatable.table().container() ).on( 'keyup', 'tfoot input', function () {
        $table.DataTable()
            .column( $(this).data('index') )
            .search( this.value )
            .draw();
    });

}