$(document).ready(function() {
    $.fn.initBootTable = function() {
        $(this).bootstrapTable('destroy');
        $(this).bootstrapTable().
        unbind('check.bs.table').on('check.bs.table', function (e, row) {
            consUsua([{name : 'codiUsua', value : row.id.trim()}]);
        });
        return false;
    };
    
    $('#modaFormUsua').on('show.bs.modal', function() {
        INIT_OBJE_MODA_USUA();
    });
    
    INIT_OBJE_USUA();
});

function INIT_OBJE_USUA()
{
    $("#tablUsua").initBootTable();
}

function INIT_OBJE_MODA_USUA()
{
    $("#formTest\\:btonElim").confirmation({container: '#formTest'});
}