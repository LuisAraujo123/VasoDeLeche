$(document).ready(function() {
    $.fn.initBootTable = function() {
        $(this).bootstrapTable('destroy');
        $(this).bootstrapTable().
        unbind('check.bs.table').on('check.bs.table', function (e, row) {
            consUnid([{name : 'codiUnid', value : row.id.trim()}]);
        });
        return false;
    };
    
    $('#modaFormUnid').on('show.bs.modal', function() {
        INIT_OBJE_MODA_UNID();
    });
    
    INIT_OBJE_UNID();
});

function INIT_OBJE_UNID()
{
    $("#tablUnid").initBootTable();
}

function INIT_OBJE_MODA_UNID()
{
    $("#formTest\\:btonElim").confirmation({container: '#formTest'});
}