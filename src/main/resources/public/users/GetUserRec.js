$(document).ready(function() {
    $("#search-form").submit(function (event) {
        event.preventDefault();
        let url = $(this).attr("action"); //get form action url
        let method = $(this).attr("method"); //get form GET/POST method
        let data = new FormData(this); //Encode form elements for submission

        var str = "";
        data.forEach(function(value, key){
            if(str != "")str += "&";
            str += key + "=" + value;
        });

        url += '?' + str;
        $.ajax({
            url : url,
            type: method,


        }).done(function(response){
            $('.springResponse').html(response[0]);
            console.log(response);
        }).fail(function(er){
            console.log(er);
        });
    });
});
